<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="lys.board.*,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userid를 받아서 처리</title>
</head>
<body>
<%

     request.setCharacterEncoding("utf-8");//한글데이터라면 필수
     String userid=request.getParameter("userid");
     System.out.println("userid=>"+userid);
     
     //단순히 검색한 결과(테스트목적)
     BoardDAO dbPro=new BoardDAO();
     List<String> name=dbPro.getArticleId(userid);
     //검색된 갯수만큼에 li태그에 저장->전송
     for(int i=0;i<name.size();i++){
    	 String sname=name.get(i);//0~
    	 out.println("<li>"+sname+"</li>");
     }
     /*
     out.println("<li>testkim</li>");
     out.println("<li>test</li>");
     out.println("<li>test2</li>");
     out.println("<li>test3</li>"); */
%>
</body>
</html>






