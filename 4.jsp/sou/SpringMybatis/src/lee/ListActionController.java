package lee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Controller를 상속받는 이유->요청을 받아서 처리해주는 역할
public class ListActionController implements Controller {

	BoardDAO dao; //BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                 HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ListActionController 실행됨!");
		//ArrayList list=dao.list();
		List list=dao.list();
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("list");//list.jsp
		//request.setAttribute("list",list);
        mav.addObject("list",list); //${list}
		return mav;
	}
}



