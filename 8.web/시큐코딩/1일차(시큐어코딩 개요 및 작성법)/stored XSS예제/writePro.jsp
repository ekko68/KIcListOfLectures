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
   //공통의 메서드를 작성해서 호출하지 않으면 직접 일일이 작성
   String content=request.getParameter("content");
   System.out.println("after content=>"+content);
   //---공통의 메서드로 작성----
   if(content!=null){
		  //문자열 메서드->(1.변경전 문자열->2.변경후 문자열)
		  content=content.replaceAll("<","&lt;");
		  content=content.replaceAll(">","&gt;");
	  }
   //-----------------------------------------------------------------
   Timestamp temp=new Timestamp(System.currentTimeMillis());
   article.setReg_date(temp);
   article.setIp(request.getRemoteAddr());
   //글내용만 다시 수정하는 작업
   article.setContent(content);//이미 수정된 문자열이 저장이된 상태
   //---------------------------------
   BoardDAO dbPro=new BoardDAO();
   dbPro.insertArticle(article);
   response.sendRedirect("list.jsp");
%>








