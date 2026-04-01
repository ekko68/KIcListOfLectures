

import java.io.*;
//날짜
import java.util.*;//Calendar
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			                            HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//한글처리
		//PrintWriter out=new PrintWriter();
		PrintWriter out=response.getWriter();//클라이언트로 전송하기위해서
		out.println("<html><head><title>공지사항</title></head>");
		out.println("<body>");
		//접속할때마다 보여줄 기능을 구현
		out.println("<h2>오늘의 공지사항</h2>");
		// /notice/201777.txt
		String fileName="";//불러올 파일명을 저장
		Calendar cal=Calendar.getInstance();
		fileName+=cal.get(Calendar.YEAR);//2017
		fileName+=cal.get(Calendar.MONTH)+1;//20177
		fileName+=cal.get(Calendar.DATE);//201777
		fileName+=".txt";//201777.txt
		
		//경로명+파일명
		String realPath="C:/webtest/4.jsp/sou/ServletTest/WebContent/notice/"+fileName;
		System.out.println("realPath=>"+realPath);
		try {
			//FileInputStream(영문) or FileReader(한글)
			BufferedReader br=new BufferedReader
					                        (new FileReader(realPath));
			String line="";//한줄씩 읽어들여서 저장할 변수
			while((line=br.readLine())!=null) {
				out.println(line+"<br>");//클라이언트의 브라우저로 전송
			}
			br.close();
		}catch(IOException  e) {
			System.out.println("불러올 파일의 경로와 파일명을 확인요망!"+e);
		}catch(Exception e) {
			System.out.println("오늘 공지사항이 없습니다."+e);
		}
		out.println("<p align=center>");
		out.println("<hr>");
		out.println("<input type='submit' value='창닫기' onclick='window.close()'> ");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}



