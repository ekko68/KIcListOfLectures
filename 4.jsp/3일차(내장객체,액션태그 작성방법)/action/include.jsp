<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청을 받아서 처리해주는 페이지1</title>
</head>
<body>
 <h1>포함을 하는 페이지</h1>
 <%
    request.setCharacterEncoding("utf-8");//한글처리
 %>
 <!-- sub.jsp에서 처리한 결과  -->
 <hr>
 <jsp:include page="sub.jsp"  flush="false" /><br>
 
 나머지는 sub.jsp가 알아서 해줄거예요!!
</body>
</html>







