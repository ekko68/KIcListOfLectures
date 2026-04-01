package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Admin.*;

public class PersonInsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		PersonDTO person = new PersonDTO();
		person.setId(request.getParameter("id"));
		person.setPasswd(request.getParameter("passwd"));
		person.setName(request.getParameter("name"));
		person.setGender(request.getParameter("gender"));
		person.setAge(request.getParameter("age"));
		

		 AdminDAO perMgr= new AdminDAO();
		 boolean check = perMgr.PersonInsert(person);
		 System.out.println("PersonInsert.jsp¿« check : "+check);

		 request.setAttribute("check", check);
		 
		return "/admin/PersonInsert.jsp";
	}

}
