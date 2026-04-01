package url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;//ArrayList

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	//외부에서 상단메뉴,좌측메뉴에서 클릭->임의의 불법적인 사이트로 이동X
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			                           HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RedirectServlet?url=http://www.daum.net
		//String url=request.getParameter("url");
		String query=request.getQueryString();//쿼리문자열
		System.out.println("query="+query);
		/* (1)
		if(query.contains("url")) { //url매개변수가 존재한다면
			String url=request.getParameter("url");
			response.sendRedirect(url);
		}//if
		*/
		//(2)화이트 리스트->지정한 사이트외에는 무조건 이동X
		//간단한 화이트리스트->배열,ArrayList->항목이 많아지면 Properties를 이용
		String allowURL[]= {"http://www.naver.com",
				                       "http://www.daum.net",
				                       "http://www.empas.com"};
		//외부에서 이동할 항목과 비교하기위해서 
		ArrayList arr=new ArrayList();
		for(int i=0;i<allowURL.length;i++)
			arr.add(allowURL[i]);
	    
		if(query.contains("url")) { //url매개변수가 존재한다면
			String url=request.getParameter("url");
			//검증하는 절차
			//url=http://www.daum.net
			//url값이 들어있으면서 http://항목이 들어있는 url값이라면
			if(url!=null && url.indexOf("http://")!=-1) {
			   if(!arr.contains(url))  //화이트리스트 항목에 없다면
				  throw new ServletException("불법적인 사이트는 이동금지!!");
			     response.sendRedirect(url);
			}//if(url!=null && url.indexOf("http://")!=-1)
		}//if(query.contains("url")) { 
	}
}




