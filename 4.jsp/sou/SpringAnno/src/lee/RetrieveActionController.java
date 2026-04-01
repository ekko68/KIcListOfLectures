package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Controller를 상속받는 이유->요청을 받아서 처리해주는 역할
public class RetrieveActionController implements Controller {

	BoardDAO dao; //BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                 HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RetrieveActionController 실행됨!");
		String num=request.getParameter("num");
		System.out.println("num=>"+num);
		//레코드 한개를 담을 객체 필요
		//Board data=dao.retrieve(num); before
		//after
		dao.updateReadcnt(num);//reacnt=readcnt+1
		BoardCommand data=dao.retrieve(num);
		//----------------------------------
		ModelAndView mav=new ModelAndView("retrieve");//이동할 페이지명
		//mav.setViewName("retrieve");//list.jsp
        mav.addObject("data",data); //${data} request.getAttribute("data");
		return mav;
	}
}



