package lee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//spring-webmvc.jar
import org.springframework.web.servlet.mvc.Controller;

//액션클래스=>컨트롤러 클래스
//POJO클래스->웹상에서 요청을 받아서 처리해주는 클래스(클래스나 인터페이스를 
//                   상속받지 않고 자유롭게 요청을 처리해주는 클래스

public class ListActionController implements Controller{
	
	BoardDAO dao;
	
   public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("ListAction의 setDao()호출됨!");
	}

@Override
public ModelAndView handleRequest(HttpServletRequest request, 
		                                            HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	 System.out.println("ListActionController() 적용됨");
	 //DB에 접속->게시물10개를 구해와서 전달
	 //BoardDAO dao=new BoardDAO();
	 //ArrayList list=dao.list();
	 List list=dao.list();
	 //----------------------------------------------
	 ModelAndView mav=new ModelAndView();
	 mav.setViewName("list");
	 mav.addObject("list",list);
	return mav; 
   }
}


