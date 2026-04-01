package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;


public class UpdateActionController extends AbstractCommandController {
   
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
		//게시물번호만 따로 request이용
		//String num=request.getParameter("num");
		//------------------------------------------------
		/*String author=data.getAuthor();
		String content=data.getContent();
		String title=data.getTitle();
		dao.update(num,author, title, content);*/
		
		dao.update(data);
		//list.jsp로 이동
		ModelAndView mav=new ModelAndView();
		//형식)redirect:/요청명령어(~.do,~.mav,~.test,,,)
		mav.setViewName("redirect:/list.do");//ListActionController-> /list.jsp
		//response.sendRedirect(~/list.do")->/list.jsp
		return mav;
	}
}
