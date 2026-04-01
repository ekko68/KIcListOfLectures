package dr.mini.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;//@Controller 어노테이션
import org.springframework.web.bind.annotation.RequestMapping;//@RequestMapping
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dr.mini.dao.MemberDao;
import dr.mini.domain.MemberCommand;
import dr.mini.util.PagingUtil;

//POJO클래스로 작성->어떠한 인터페이스또는 클래스를 상속받지 않고 단독적으로 자유롭게
// 웹상에서 요청을 받아서 처리해주는 클래스 ->implements Controller (상속 X)
//요청을 받아서 처리해주는 메서드(자유롭게)->클래스명 위에 @Controller
//System.out.println(e.toString())->대신에 로그를 설정하는 방법

@Controller
public class SelectListController  {

	//로그 설정
	//형식)Logger 로그객체명=Logger.getLogger(디버깅할 클래스명.class);
	private Logger log=Logger.getLogger(this.getClass());//SelectListController
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("setMemberDao()호출됨!");
	}

	//요청을 받아서 처리해주는 메서드(/list.do=>process()호출하라->설정)
	//형식)@RequestMapping("요청명령어~")
	
	@RequestMapping("/list.do")
	public ModelAndView process
	           (@RequestParam(value="pageNum",defaultValue="1")int currentPage){
		//list.jsp->int currentPage=Integer.parseInt(request.getParameter("pageNum"));
		//if(pageNum==null) pageNum=1; //default값을 넣어줘라
		//형식)@RequestParam(value="매개변수명",defaultValue="초기값")자료형 변수명)
		if(log.isDebugEnabled()){ //로그객체의 정보를 출력할 준비(=디버깅모드)
			//System.out.println(memberDao);
		   log.debug("memberDao="+memberDao);//log.debug("출력할 정보~)
		}
		//총갯수
		int count=memberDao.getMemberCount();
		System.out.println("count="+count);
		//페이징처리->PagingUtil클래스(현재페이지,총갯수,블럭당페이지수,페이지당레코드수,,,
		PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
		List<MemberCommand> list=null;
		//레코드가 한개이상이라면
		if(count > 0){ //페이지당 시작게시물번호->start, 마지막게시물번호 end
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("start",page.getStartCount());
			map.put("end", page.getEndCount());
			list=memberDao.getMemberList(map);
		}else{//아무것도 없는경우
			list=Collections.EMPTY_LIST;//정적상수
		}
		//처리한 결과->selectList.jsp에 전달하면 끝
		ModelAndView mav=new ModelAndView();
		mav.setViewName("selectList");//selectList.jsp
		mav.addObject("count",count); //request.setAttribute("count",count); ${count}
		mav.addObject("list",list);//List객체->forEach로 실행->화면에 출력
		//이전(링크),다음(링크)문자열->반환시켜준다.
		mav.addObject("pagingHtml",page.getPagingHtml());//${pagingHtml}
		return mav;
	}
}




