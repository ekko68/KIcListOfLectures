package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;
import java.sql.Timestamp;//추가(시간)

// ->/writePro.do 데이터 입력->/list.do->/list.jsp로 이동
public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	     //한글처리
	     request.setCharacterEncoding("utf-8");
	     //BoardDTO->SetterMethod 호출(5개)+hidden(4개)
	     //BoardDTO article=new BoardDTO();
	     //property="*" =>매개변수로 전달받은 경우에만 적용이 된다.
       BoardDTO article=new BoardDTO();
       article.setNum(Integer.parseInt(request.getParameter("num")));
       article.setWriter(request.getParameter("writer"));
       article.setEmail(request.getParameter("email"));
       article.setSubject(request.getParameter("subject"));
       article.setPasswd(request.getParameter("passwd"));
       article.setReg_date(new Timestamp(System.currentTimeMillis()));
       article.setRef(Integer.parseInt(request.getParameter("ref")));
       article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
       article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
       article.setContent(request.getParameter("content"));
	   article.setIp(request.getRemoteAddr());
	   
	   BoardDAO dbPro=new BoardDAO();
	   dbPro.insertArticle(article);
	   
		return "/writePro.jsp";
	}
}



