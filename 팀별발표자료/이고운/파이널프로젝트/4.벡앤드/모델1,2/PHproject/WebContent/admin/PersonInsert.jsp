<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입완료</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="deepskyblue">
 <br>
 <center>
 
 <c:if test="${check == true}">
	 <b>회원등록에 성공했습니다.</b><br>
	 <a href='mbList.do'>회원 등록 페이지로</a>
 </c:if>
 
<c:if test="${check == false}">
	<b>회원등록에 실패했습니다. 다시 입력해주세요.</b><br>
	<a href='Register.do'> 회원 등록 페이지로 </a>
</c:if>
 

 </center> 
 <a href="#" onclick="self.close()">닫기</a> <!-- window.open() <-> self.close() 창 닫기 -->
</body>
</html>