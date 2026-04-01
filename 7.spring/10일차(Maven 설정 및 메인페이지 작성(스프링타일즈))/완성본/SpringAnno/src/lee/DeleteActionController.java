package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Controller를 상속받는 이유->요청을 받아서 처리해주는 역할
public class DeleteActionController implements Controller {

	BoardDAO dao; //BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                 HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteActionController 실행됨!");
		String num=request.getParameter("num");//삭제시킬 게시물번호
		System.out.println("num=>"+num);
		dao.delete(num);
		//----------------------------------
		ModelAndView mav=new ModelAndView();//이동할 페이지명
		mav.setViewName("redirect:/list.do");//->list.jsp
		return mav;
	}
}



