

import java.io.IOException;//입출력시 에러발생시
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;//서블릿의 초기환경설정 할때 파일
import javax.servlet.ServletException;//서블릿의 오류발생시 처리
//import javax.servlet.annotation.WebServlet;//웹상에서 어떻게 접근->정보
import javax.servlet.http.HttpServlet;//상속을 받을 부모클래스
import javax.servlet.http.HttpServletRequest;//요청을 받아서 처리
import javax.servlet.http.HttpServletResponse;//응답을 해주는 것

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/test/Hello")
public class HelloServlet extends HttpServlet {
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿 실행시 제일 먼저 호출되는 메서드");
		System.out.println("생성자와 같은 역할(서블릿의 초기값을 설정)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("서블릿이 종료할때(메모리 해제)");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			                          HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("웹상에서 get방식으로 접속할때마다 자동으로 호출");
		response.setContentType("text/html;charset=utf-8");//한글처리
		//PrintWriter out=new PrintWriter();
		PrintWriter out=response.getWriter();//클라이언트로 전송하기위해서
		out.println("<html><head></head>");
		out.println("<body>");
		//접속할때마다 보여줄 기능을 구현
		out.println("<h2>Hello  Servlet!</h2>");
		//추가
		out.println("<table border=1>");
		for(int i=2;i<=9;i++) {
			 out.println("<tr>");
			   for(int j=1;j<10;j++) {
				   out.println("<td>");
				   out.println(""+i+"*"+j+"="+(i*j));
				   out.println("</td>");
			   }
			 out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			                            HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("웹상에서 post방식으로 접속할때마다 자동으로 호출");
	}

}
