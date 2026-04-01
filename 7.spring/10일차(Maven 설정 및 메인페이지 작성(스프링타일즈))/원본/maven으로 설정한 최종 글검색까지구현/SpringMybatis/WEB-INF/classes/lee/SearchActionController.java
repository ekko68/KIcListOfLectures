package lee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//spring-webmvc.jar
import org.springframework.web.servlet.mvc.Controller;


public class SearchActionController implements Controller{
	
	BoardDAO dao;
	
   public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("ListAction의 setDao()호출됨!");
	}

@Override
public ModelAndView handleRequest(HttpServletRequest request, 
		                                            HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	 System.out.println("SearchActionController() 적용됨");
	 //검색분야,검색어를 매개변수로 전달
	 String searchName=request.getParameter("searchName");
	 String searchValue=request.getParameter("searchValue");
	 System.out.println("searchName="+searchName);
	 System.out.println("searchValue="+searchValue);
	 
	 //DB에 접속->검색된 갯수만큼 구해와서 전달
	 //ArrayList list=dao.search(searchName,searchValue);
	 BoardCommand com=new BoardCommand();
	 com.setSearchName(searchName);
	 com.setSearchValue(searchValue);
	 /*
	  * 참조(입력받은 매개변수가 테이블의 필드와 연관이 없는 경우)
	  * HashMap hash=new HashMap();
	  * hash.put("searchName",searchName);
	  * hash.put("searchValue",searchValue);
	  * List list=dao.search(hash);
	  * Board.xml->parameterType="java.util.Map"
	  */
	 List list=dao.search(com);
	 //----------------------------------------------
	 ModelAndView mav=new ModelAndView();
	 mav.setViewName("list");// list.jsp
	 mav.addObject("list",list);
	return mav; 
   }
}


