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


@Controller
public class SelectController  {

	//로그 설정
	//형식)Logger 로그객체명=Logger.getLogger(디버깅할 클래스명.class);
	private Logger log=Logger.getLogger(this.getClass());//SelectListController
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("setMemberDao()호출됨!");
	}

	//~/detail.do?id=kkkk
	@RequestMapping("/detail.do")
	public ModelAndView process
	           (@RequestParam("id")String id){
		
		//String id=request.getParameter("id");
		
		if(log.isDebugEnabled()){ //로그객체의 정보를 출력할 준비(=디버깅모드)
		   log.debug("id:"+id);//log.debug("출력할 정보~)
		}
		
		MemberCommand member=memberDao.getMember(id);
		//처리한 결과->selectDetail.jsp에 전달하면 끝
		/*ModelAndView mav=new ModelAndView();
		mav.setViewName("selectDetail");
		mav.addObject("member",member); 
		return mav;*/
		//1.이동할 페이지명 2키값 3.전달할값
		return new ModelAndView
				("selectDetail","member",member);
	}
}




