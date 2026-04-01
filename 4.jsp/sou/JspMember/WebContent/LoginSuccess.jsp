<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
     //인증 받은 사람인지를 체크
     String mem_id=(String)session.getAttribute("idKey"); //idkey
     System.out.println("mem_id="+mem_id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인증성공 페이지</title>
</head>
<body bgcolor="#FFFFCC">
<center>
    <%
          if(mem_id!=null){ //인증된 사람이라면
    %>
    <b><%=mem_id %></b>님 환영합니다.<p>
      당신은 제한된 기능을 사용할 수가 있습니다.<p>
      <a href="Logout.jsp">로그아웃</a>
    <% } %>
</center>
</body>
</html>







