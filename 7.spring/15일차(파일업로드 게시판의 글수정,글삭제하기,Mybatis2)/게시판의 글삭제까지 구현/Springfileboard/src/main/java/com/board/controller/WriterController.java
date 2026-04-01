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
import com.board.validator.BoardValidator;

@Controller
public class WriterController {
    //Logger객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	
	//하나의 요청명령어->하나의 컨트롤러만 사용X 
	//하나의 컨트롤러->여러개의 요청명령어를 등록해서 사용이 가능
	//method=RequestMethod.GET) or method=RequestMethod.POST)
	//1.글쓰기 폼으로 이동(Get방식)
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form() {
		System.out.println("다시 처음부터 입력받기위함 form()호출됨!");
		return "boardWrite"; //return "이동할페이지명"; //defintion name과 동일
	}
	
	//에러메세지 출력->다시 초기화가 가능하게 설정->@ModelAttribute("별칭")
	@ModelAttribute("command")
	public BoardCommand forBacking() { //반환형(BoardCommand) 메서드명
		System.out.println("forBacking()호출됨!");
		return new BoardCommand();//BoardCommand bc=new BoardCommand();
	}
	//입력해서 유효성검사->에러발생->DB저장후->boardList.jsp로 이동
	//BindingResult->유효성 검사때문에 필요(에러정보 객체)
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                           BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//입력받은값을 출력
		}
		//유효성검사->command조사 문제발생->result에 에러정보를 담는다.
	    new BoardValidator().validate(command,result);
	    //에러정보가 있다면
	    if(result.hasErrors()) {
	    	return form();//"boardWrite"->boardWrite.jsp
	    }
	    //업로드->입출력->예외처리
	    try {
	    	String newName="";//업로드한 파일의 변경된 파일명을 저장
	    	//업로드되어있다면
	    	if(!command.getUpload().isEmpty()) {
	    		//탐색기에서 선택한 파일이름->getOriginalFilename()  /aaa.txt->12222.txt
	    		newName=FileUtil.rename(command.getUpload().getOriginalFilename());
	    		System.out.println("newName=>"+newName);
	    		command.setFilename(newName);//12344.txt
	    	}
	    	//최대값을 구해서+1
	    	int newSeq=boardDao.getNewSeq()+1;
	    	System.out.println("newSeq=>"+newSeq);
	    	//추가
	    	command.setSeq(newSeq);//새로운 seq번호가 적용이 안돼서 에러유발
	    	//글쓰기 호출
	    	boardDao.insert(command);//DB상에 aaa.txt 업로드
	    	//실제로 upload폴더로 전송
	    	if(!command.getUpload().isEmpty()) {
	    		File file=new File(FileUtil.UPLOAD_PATH+"/"+newName);
	    		//물리적으로 데이터 전송(파일 전송)
	    		command.getUpload().transferTo(file);//실제 upload에 등록
	    	}
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    //return "redirect:요청명령어"
		return "redirect:/board/list.do"; //return "이동할페이지명"; //defintion name과 동일
	}
}




