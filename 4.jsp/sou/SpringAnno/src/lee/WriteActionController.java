package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractCommandController;

//사용자로부터 값을 주로 입력을 받아서 처리해주는 컨트럴러
//public class WriteActionController extends AbstractCommandController {

@Controller
public class WriteActionController {

	@Autowired
	BoardDAO dao; //BoardDAO dao=new BoardDAO();
	//commandClass->사용자로부터 입력받은 값만 따로 저장해주는 메서드
	//<property name="commandClass"  value="lee.BoardCommand" />
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	
    //1.request(요청객체) 2.response(응답) 3.입력받은값을 저장한 객체
	//4.BindException->사용자로부터 값을 입력시 에러발생->처리해주는 객체
	@RequestMapping("/write.do")
	protected ModelAndView test(@RequestParam("title")String title,
			@RequestParam("author")String author,
			@RequestParam("content")String content)
			throws Exception {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
		//BoardCommand data=(BoardCommand)command;
		/*
		String author=request.getParameter("author");
		String content=request.getParamert("content");
		String title=request.getParamert("title");*/
		//최대값 구하기
		int newNum=dao.getNewNum()+1;
		BoardCommand data=new BoardCommand();
		data.setNum(newNum);
		data.setTitle(title);
		data.setAuthor(author);
		data.setContent(content);
		//--------------------------------------
		dao.write(data);
		return new ModelAndView("redirect:/list.do");
	}
}


