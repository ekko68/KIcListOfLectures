
package com.board.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//---------로그에 출력할 수있도록 설정(Annotation)--
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//---------메서드호출 및 페이징 처리부분---------------
import com.board.dao.BoardDao;//DB접속
import com.board.domain.BoardCommand;//DTO
import com.board.util.PagingUtil;//페이징처리 정보
//---------------------------------------------------

@Controller
public class ListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//자동으로 Setter Method호출X->의존성객체 넣어줌
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/board/list.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){
		//int currentPage=Integer.parseInt(request.getParameter("pageNum"))
		if(log.isDebugEnabled()){
			System.out.println("여기는 보드 list.do");
			log.debug("currentPage : " + currentPage);
			log.debug("keyField : " + keyField);
			log.debug("keyWord : " + keyWord);
		}
		
		Map<String, Object> map = 
				      new HashMap<String, Object>();
		//추가(검색분야,검색어를 등록)->메서드의 매개변수로 전달
		map.put("keyField", keyField);//검색분야
		map.put("keyWord", keyWord);//검색어
		
		//총글의 갯수 또는 검색된 글의 갯수
		int count = boardDao.getRowCount(map);
	    
		//PagingUtil page = new PagingUtil(currentPage, count, 10,10, "list.do");
		PagingUtil page = new PagingUtil(currentPage, count, 3,3, "list.do");
		
		//start->페이지당 맨 첫번째 나오는 게시물번호
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//마지막게시물번호
		
		List<BoardCommand> list = null;
		if(count > 0){
			System.out.println("여기는 DAO 호출");
			list = boardDao.list(map);
		}else{
			list = Collections.emptyList();
			System.out.println("ListController클래스의 count="+count);
		}
		
		ModelAndView  mav = new ModelAndView();
		mav.setViewName("boardList");//boardList.jsp
		mav.addObject("count", count);//총레코드수
		mav.addObject("list", list);//레코드전체값
		mav.addObject("pagingHtml", page.getPagingHtml());
		//링크문자열을 전달
		return mav;
	}
}























