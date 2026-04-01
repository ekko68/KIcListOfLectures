
import java.io.*;//입출력
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class GetData
 */
@WebServlet("/test/GetData")
public class GetData extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
			                            HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//한글처리
		//PrintWriter out=new PrintWriter();
		PrintWriter out=response.getWriter();//클라이언트로 전송하기위해서
		out.println("<html><head></head>");
		out.println("<body>");
		//접속할때마다 보여줄 기능을 구현
		out.println("<h2>입력받아 재 전송</h2>");
		//추가
		request.setCharacterEncoding("utf-8");
		//
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		out.println("이름=>"+name+"<br>");
	    out.println("주소=>"+addr);
	    
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}




