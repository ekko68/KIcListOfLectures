package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//public class ListAction implements CommandAction 모델2
public class TestActionController implements Controller {
//경로포함해서 파일명=>ModelAndView
	
//public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestAction컨트롤러의 handleRequest()호출됨!");
		//어떤기능(글쓰기,글수정,,,,)=>결과 존재
		
		ModelAndView mav=new ModelAndView();
		//<property name="viewName" value="list2"></property>
		mav.setViewName("list3");//경로X, 파일의 확장자X->파일이름만
		//request.setAttribute("greeting", "스프링세상!"); 서버의 메모리에 다 저장
		//${greeting}->request.getAttribute("greeting");
		mav.addObject("greeting", "스프링세상!");
		return mav;  //return "/list.jsp";
	}
}



