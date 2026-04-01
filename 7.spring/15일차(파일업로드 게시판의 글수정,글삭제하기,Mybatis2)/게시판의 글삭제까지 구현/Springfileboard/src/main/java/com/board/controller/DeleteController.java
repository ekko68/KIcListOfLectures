package com.board.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardDeleteValidator;
import com.board.validator.BoardValidator;

@Controller
public class DeleteController {
    //Logger객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	
	//1.글삭제 폼으로 이동(Get방식)
	@RequestMapping(value="/board/delete.do",method=RequestMethod.GET)
	public String form() {
		return "boardDelete"; //return "이동할페이지명"; //defintion name과 동일
	}
	
	//에러메세지 출력->다시 초기화가 가능하게 설정->@ModelAttribute("별칭")
	@ModelAttribute("command")
	public BoardCommand forBacking() { //반환형(BoardCommand) 메서드명
		return new BoardCommand();//BoardCommand bc=new BoardCommand();
	}
	//입력해서 유효성검사->에러발생->DB저장후->boardList.jsp로 이동
	//BindingResult->유효성 검사때문에 필요(에러정보 객체)
	@RequestMapping(value="/board/delete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                           BindingResult result) {
		
		//유효성검사->command조사 문제발생->result에 에러정보를 담는다.
	    new BoardDeleteValidator().validate(command,result);
	    //에러정보가 있다면
	    if(result.hasErrors()) {
	    	return form();//"boardDelete"->boardDelete.jsp
	    }
	    
	    BoardCommand board=boardDao.selectBoard(command.getSeq());
	    //DB상의 암호!=웹상의 암호를 확인 절차
	    if (!board.getPwd().equals(command.getPwd())) {
			result.rejectValue("pwd", "invalidPassword");// 적용필드명,에러코드명
			return form();// boardDelete.jsp로 이동
		}else { //암호가 맞는경우
			boardDao.delete(command.getSeq());//DB상의 데이터가 삭제
			//업로드한 파일까지 삭제
			if(board.getFilename()!=null) {//업로드한 파일이 존재한다며 삭제
				FileUtil.removeFile(board.getFilename());
			}
		}
	   
		return "redirect:/board/list.do"; //return "이동할페이지명"; //defintion name과 동일
	}
}




