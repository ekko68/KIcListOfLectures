<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>
                
<%@taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>                
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="member.update.title" /></title>
</head>
<body>
	<h2>member1 테이블에 레코드 수정하기</h2>
	<form:form commandName="memberCommand">
	  <form:errors elements="div" />
		아이디 : ${memberCommand.id}<br>
		비밀번호 : <form:password path="passwd" />
		<font color="red"><form:errors path="passwd" /></font>
		<br>
		이름 : <form:input path="name"/> 
		<font color="red"><form:errors path="name" /></font>
		<br>
		<input type="submit" value="보내기">
	</form:form>
</body>
</html>
