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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Controller
public class UpdateController {
	// Logger객체
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private BoardDao boardDao;

	// 1.글수정폼으로 이동(Get방식)
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam("seq") int seq) {
		// int seq=Integer.parseInt(request.getParameter("seq"))
		BoardCommand boardCommand = boardDao.selectBoard(seq);
		return new ModelAndView("boardModify", "command", boardCommand);
		// boardModify.jsp
	}

	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("BoardCommand=>" + command);// 수정한값을 출력
		}
		// 유효성검사->command조사 문제발생->result에 에러정보를 담는다.
		new BoardValidator().validate(command, result);
		// 에러정보가 있다면
		if (result.hasErrors()) {
			return "boardModify"; // boardModify.jsp로 이동
		}
		// 변경전의 데이터를 불러오기->board(비밀번호)=웹상에서의 입력비밀번호
		BoardCommand board = null;
		String oldFileName = "";//
		board = boardDao.selectBoard(command.getSeq());
		// 비밀번호 체크(DB상의 암호!=웹상에서 입력한 암호)
		if (!board.getPwd().equals(command.getPwd())) {
			result.rejectValue("pwd", "invalidPassword");// 적용필드명,에러코드명
			return "boardModify";// boardModify.jsp로 이동
		} else { // 비밀번호가 일치한다면
			// 기본파일명->업로드 된 파일이 존재->기존파일 삭제->새로운파일 세팅
			// 업로드 된 파일이 없으면 기존파일은 덮어쓰기
			// 업로드되어있다면
			oldFileName = board.getFilename();// DB상의 원래 기존파일명
			if (!command.getUpload().isEmpty()) {
				try {
				command.setFilename(FileUtil.rename(command.getUpload().getOriginalFilename()));// 12344.txt
				}catch(Exception e) {e.printStackTrace();}
			} else { // 기존파일은 덮어쓰기
				command.setFilename(oldFileName);
			}

			// 글수정메서드 호출
			boardDao.update(command);
			// 실제로새로 바뀐 파일을 upload폴더로 전송
			if (!command.getUpload().isEmpty()) {
				try {
					File file = new File(FileUtil.UPLOAD_PATH + "/" + command.getFilename());
					// 물리적으로 데이터 전송(파일 전송)
					command.getUpload().transferTo(file);// 실제 upload에 등록
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// aaa.txt 새로 업로드한 파일 bbb.jpg ->전의 데이터가 존재하면 삭제
				if (oldFileName != null) {
					// 이전파일 삭제
					FileUtil.removeFile(oldFileName);
				}
			} // if(!command.getUpload().isEmpty()) {
		}//else
		// return "redirect:요청명령어"
		return "redirect:/board/list.do"; // return "이동할페이지명"; //defintion name과 동일
	}
}
