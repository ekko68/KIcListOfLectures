package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//spring-webmvc.jar
import org.springframework.web.servlet.mvc.Controller;

//모델2에서의 액션클래스
//public class TestActionController implements CommandAction {
//String(경로명 및 이동할 파일명) requestPro()구현

public class TestActionController implements Controller{
	
	//ModelAndView->이동할 페이지의 경로명및 파일에 정보객체
   @Override
public ModelAndView handleRequest(HttpServletRequest request, 
		                                            HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	 System.out.println("handleRequest()호출됨");
	 //1.페이지를 이동시키기 위해서는 ModelAndView객체 필요
	 ModelAndView mav=new ModelAndView();
	 mav.setViewName("list");//setViewName(이동할파일명)->확장자X, 경로X
	 //request.setAttribute("greeting", "스프링세상");
	 mav.addObject("greeting","스프링세상");
	return mav; //return "/list.jsp";
   }
}


