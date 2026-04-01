package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Controller
public class DetailController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	
	//String->페이지만 이동, 페이지가 이동하면서 데이터도 함께 전달(ModelAndView)
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("seq") int seq) {
		//int seq=Integer.parseInt(request.getParameter("seq"));
		//?,?
		if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
			log.debug("seq=>"+seq);//System.out.println("seq=>"+seq);
		}
		//1.조회수 증가
		boardDao.updateHit(seq);
		BoardCommand board=boardDao.selectBoard(seq);
		//글내용에 \r\n  ㅁㅇㅁㅁ\r\n->메서드가 있다.<pre></pre>
		board.setContent(StringUtil.parseBr(board.getContent()));
		/*ModelAndView mav=new ModelAndView("boardView");
		mav.addObject("board",board); 
		return mav;*/ //1.이동할페이지명 2.전달할키명 3.전달할값
		return new ModelAndView("boardView","board",board);//${board}
	}
	
	//추가->다운로드
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("filename") String filename) {
		//다운로드 받을 파일의 위치와 이름
		File downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+filename);
		//AbstractView를 상속받은 뷰클래스에게 전달
		//1.다운로드받을 뷰객체  2.모델객체명(키),3.전달할값(다운로드받을 파일명)
		return new ModelAndView("downloadView","downloadFile",downloadFile);
	}
}







