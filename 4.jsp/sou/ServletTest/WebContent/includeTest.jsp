<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IncludeTest.jsp</title>
</head>
<body><!--  .현재폴더, .. 상위폴더 -->
<%@include file="./sub/JspModule.java" %>
 이 페이지는 include지시어를 연습하기위해서 
 만들어진 페이지입니다.
 테스트중입니다.<br>
 테스트중입니다.<br>
 
 테스트중입니다.<br>
 테스트중입니다.<br>
 테스트중입니다.<br>
 <%=getString() %><br>
 테스트중입니다.<br>
 테스트중입니다.<br>
 <%=getString() %><br>
 테스트중입니다.<br>
 테스트중입니다.<br>
 테스트중입니다.<br>
 테스트중입니다.<br>
 테스트중입니다.<br>
</body>
</html>