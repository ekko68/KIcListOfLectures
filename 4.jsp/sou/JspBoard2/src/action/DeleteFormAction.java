package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 //  /deleteForm.do?pageNum=1&num=2
public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	     //deleteForm.do?num=2&pageNum=1
	     int num=Integer.parseInt(request.getParameter("num"));
	     String pageNum=request.getParameter("pageNum");
	     System.out.println
	      ("deleteForm.do의 num="+num+",pageNum="+pageNum);
	
	    //request.setAttribute("num",new Integer(num)); 옛날방식
	     //Integer num=(Integer)request.getAttribute("num")
	    request.setAttribute("num", num);//int->Integer(자동형변환)
	    request.setAttribute("pageNum", pageNum);
	    
		return "/deleteForm.jsp";
	}
}


