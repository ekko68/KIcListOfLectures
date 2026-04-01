package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//spring-webmvc.jar
import org.springframework.web.servlet.mvc.Controller;

public class RetrieveActionController implements Controller{
	
	BoardDAO dao;
	
   public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("RetrieveAction의 setDao()호출됨!");
	}

@Override
public ModelAndView handleRequest(HttpServletRequest request, 
		                                            HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	 System.out.println("RetrieveActionController() 적용됨");
	 String num=request.getParameter("num");
	 System.out.println("num="+num);
	 Board data=dao.retrieve(num);
	 //----------------------------------------------
	 ModelAndView mav=new ModelAndView();
	 mav.setViewName("retrieve");
	 mav.addObject("data",data);// ${data}
	return mav; 
   }
}


