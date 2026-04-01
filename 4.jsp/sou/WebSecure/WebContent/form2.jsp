<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자로부터 값을 입력</title>
</head>
<body>
 <h1>2.DOM XSS</h1>
 <form method="post" action="test2.jsp">
   이름:<input type="text" name="name">
   <input type="submit" value="보내기">
 </form>
</body>
</html>


