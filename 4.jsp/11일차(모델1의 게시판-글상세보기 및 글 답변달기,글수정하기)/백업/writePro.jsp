<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Timestamp,lys.board.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
     //한글처리
     request.setCharacterEncoding("utf-8");
     //BoardDTO->SetterMethod 호출(5개)+hidden(4개)
     //BoardDTO article=new BoardDTO();
     //property="*" =>매개변수로 전달받은 경우에만 적용이 된다.
%>
<jsp:useBean id="article" class="lys.board.BoardDTO" />
<jsp:setProperty name="article" property="*" />
<%
   //BoardDAO 객체->insertArticle(article) =>9개 --->10개->12개(조회수,num)
   Timestamp temp=new Timestamp(System.currentTimeMillis());
   article.setReg_date(temp);
   article.setIp(request.getRemoteAddr());
   BoardDAO dbPro=new BoardDAO();
   dbPro.insertArticle(article);
   response.sendRedirect("list.jsp");
%>








