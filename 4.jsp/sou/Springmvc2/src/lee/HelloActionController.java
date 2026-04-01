package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloActionController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HelloAction컨트롤러의 handleRequest()호출됨!");
	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello");//경로X, 파일의 확장자X->파일이름만
		mav.addObject("message", "클릭 하나!");
		return mav;  //return "/hello.jsp";
	}
}



