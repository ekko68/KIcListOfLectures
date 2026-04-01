package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String CONTROL=null;
		CONTROL=request.getParameter("CONTROL");
		System.out.println("CONTRO > "+CONTROL); 

		    if(CONTROL==null){
		        CONTROL="intro";
		    }
		    
		    String content="/web/jsp/"+CONTROL+".jsp";
		    System.out.println("content > "+content);
		    
		    request.setAttribute("CONTROL", CONTROL); //${CONTROL}
		    request.setAttribute("content", content);
		
		return "/main.jsp";
	}

}
