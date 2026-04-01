<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>a.jsp</title>
</head>
<body bgcolor="yellow">
 <h1>a.jsp로 오신것을 환영합니다.</h1>
 <% int su=200; %>
 자기페이지에서 선언된 변수 su:<%=su %>
 <hr>
 move.jsp에서 공유한 su의 값은?<%=request.getAttribute("total") %>
 
</body>
</html>




