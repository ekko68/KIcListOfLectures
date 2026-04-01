package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;//로그객체

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;//인터페이스 객체
import com.board.domain.BoardCommand;
import com.board.util.PagingUtil;

//1. /board/list.do 요청->처리(페이징처리,검색분야,검색어)
//2. Logger객체를 생성->로그객체를 데이터 처리과정을 출력

@Controller
public class ListController {

	//1)Logger객체를 생성->(Logger.getLogger(오류를 체크해주는 클래스명.class);
	//private Logger log=Logger.getLogger(ListController.class);
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao; //BoardDaoImpl  ->Setter Method X(소스코드줄이기)
	
	//@RequestParam(value="매개변수명",
	// defaultValue="매개변수 전달 못할때 기본으로 설정할값")
	
	@RequestMapping("/board/list.do")
	public ModelAndView process
	     (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
	      @RequestParam(value="keyField",defaultValue="") String keyField,
	      @RequestParam(value="keyWord",defaultValue="") String keyWord) {
		//현재 페이지 0->1,keyField,keyWord이 매개변수로 전달 p294
		//if(request.getParameter(pageNum)==null) pageNum="1"
		//int currentPage=Integer.parseInt(request.getParameter("pageNum"));
		//if(request.getParameter("keyField")==null) keyField="";
		//String keyField=request.getParameter("keyField")
		if(log.isDebugEnabled()) {  //현재 로그객체가 현재 Debug상태라면
			System.out.println("process()호출됨!");
			log.debug("currentPage=>"+currentPage);//내부적인 처리과정확인
			log.debug("keyField=>"+keyField);
			log.debug("keyWord=>"+keyWord);
		}
		//검색분야,검색어를 Map에 담아야 된다.
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("keyField", keyField); //map.get("keyField")
		map.put("keyWord", keyWord);
		//검색분야,검색어에 해당하는 총갯수
		int count=boardDao.getRowCount(map);
		//페이징처리(1.현재페이지 2.갯수,3페이지별로 레코드갯수,4.블럭당보여주는페이지수
		//                 5.요청url
		//list.do로 요청->현재페이지(1) 2개  페이지별로 3개씩,블럭당 3페이지씩 출력
		PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
		//map추가
		map.put("start",page.getStartCount());//시작레코드번호 #{start}
		map.put("end",page.getEndCount()); //#{end}
		List<BoardCommand> list=null;//레코드담을 객체선언
		
		if(count > 0) {
			list=boardDao.list(map);//4개의 키값이 전달
		}else {
			list=Collections.EMPTY_LIST;//상수값을 설정(아무것도 없다)
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("count",count);//갯수
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());//링크문자열(이전,다음)
		return mav;
	}
}






