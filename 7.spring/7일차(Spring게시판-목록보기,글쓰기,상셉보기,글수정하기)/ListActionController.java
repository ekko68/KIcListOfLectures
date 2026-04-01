package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Controller를 상속받는 이유->요청을 받아서 처리해주는 역할
public class ListActionController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                 HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
