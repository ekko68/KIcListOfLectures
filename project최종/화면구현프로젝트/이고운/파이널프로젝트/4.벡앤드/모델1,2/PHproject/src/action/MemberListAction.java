package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Admin.*;

public class MemberListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		AdminDAO admin = new AdminDAO();
		List memList = null;
		
		memList = admin.getMemberList();
		
		request.setAttribute("memList", memList); //${memList}
		
		
		
		return "/admin/mbList.jsp";
	}

}
