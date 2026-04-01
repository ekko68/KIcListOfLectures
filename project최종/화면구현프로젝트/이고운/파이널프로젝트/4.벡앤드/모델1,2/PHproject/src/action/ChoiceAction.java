package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoiceAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String mode=request.getParameter("mode");
	   	String level="";
		String type="";
		System.out.println("mode > "+mode);
		
		String m = mode; 
		switch(m) { 
		case "rest": type="피로도"; break; 
		case "play": type="에너지"; break; 
		}
		
		System.out.println("type > "+type);
		    
		    request.setAttribute("type", type); //${CONTROL}
		    request.setAttribute("mode", mode);
		
		
		return "/index.do?CONTROL=choice&mode=rest";
	}

}
