package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

//AbstractCommandController->사용자로부터 값을 입력을 받을때 처리해주는 컨트럴러클래스
public class WriteActionController extends AbstractCommandController {
     //commandClass멤버변수->setCommmandClass(~)
	//1.request(요청) 2.response(응답) 
	//3.사용자로부터 입력받은값만 따로 저장하는 객체(어떠한 자료형도 다 입력->Object)
	//4.입력을 제대로 받지 못했을 경우 에러발생시 처리해주는 객체
	BoardDAO dao;
	
	public void setDao(BoardDAO dao){
		this.dao=dao;
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, 
			                                       HttpServletResponse response, 
			                                       Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//<jsp:setProperty id=" "  property="*" />
		BoardCommand data=(BoardCommand)command;
		//String author=request.getParameter("author");
		String author=data.getAuthor();
		String content=data.getContent();
		String title=data.getTitle();
		//BoardDAO->write()를 호출
		dao.write(author, title, content);
		//list.jsp로 이동
		ModelAndView mav=new ModelAndView();
		//형식)redirect:/요청명령어(~.do,~.mav,~.test,,,)
		mav.setViewName("redirect:/list.do");//ListActionController-> /list.jsp
		//response.sendRedirect(~/list.do")->/list.jsp
		return mav;
	}
}
