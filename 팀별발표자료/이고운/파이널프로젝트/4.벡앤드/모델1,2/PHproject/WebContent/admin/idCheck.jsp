<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Admin.AdminDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 //scripts.js -> IdCheck.jsp?id=?; 로 인해 이곳 jsp에서 값을 가져와야 된다.
 String id=request.getParameter("id");
 System.out.println("IdCheck.jsp의 id : "+id);
 //DB접속 -> AdminDAO의 checkId(id)객체가 필요
 AdminDAO perMgr= new AdminDAO();
 boolean check = perMgr.checkId(id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복 체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="deepskyblue">
 <br>
 <center>
 <b><%=id %></b>
 <%
  if(check){// 이미 아이디가 존재하는 아이디라면
   out.println(" 해당 아이디는 이미 존재하는 아이디 입니다.<br>");
  }else{ out.println(" 는 사용 가능한 아이디 입니다.<br>");}
 %>
 </center> 
 <a href="#" onclick="self.close()">닫기</a> <!-- window.open() <-> self.close() 창 닫기 -->
</body>
</html>