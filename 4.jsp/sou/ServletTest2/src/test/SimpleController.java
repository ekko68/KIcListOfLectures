package test;


import java.io.*;
import javax.servlet.*;//서블릿
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class SimpleController
 */
@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	//외부에서 직접 호출X 내부에서 처리하는 메서드->private
	//type 매개변수를 이용
	private void processRequest(HttpServletRequest request,
			                                     HttpServletResponse response) 
			                                     throws ServletException, IOException {
		//1.요청명령어를 분석
		String type=request.getParameter("type");
		System.out.println("type="+type);
		//2.greeting->안녕하세요,date->오늘날짜 객체(date)->출력
		//x->invalid Type 화면에 출력
		//2.요청명령어에 따른 요청기능을 구현->요청처리 클래스객체를 생성
		Object resultObject=null; //String or Date도 저장이 가능
		
		if(type==null || type.equals("greeting")) {
			resultObject="안녕하세요!";
		}else if(type.equals("date")) {
			resultObject=new java.util.Date();
		}else {
			resultObject="Invalid Type";
		}
	   //3.처리결과->simpleview.jsp로 전송->화면에 전송
		request.setAttribute("result",resultObject);//데이터를 공유(forward)
		
		//4.forward액션태그를 사용X->forward시켜주는 객체가 필요(페이지정보)
		RequestDispatcher dispatcher=
				                 request.getRequestDispatcher("/simpleview.jsp");
		//5.forward->데이터를 공유시키면서 페이지이동
		dispatcher.forward(request, response);
				 
	}
}






