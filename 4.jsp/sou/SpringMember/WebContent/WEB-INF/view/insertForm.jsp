<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>
                
<%@taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>                
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 
   prefix="spring" ->리소스 번들의 값을 불러올때 사용
           spring:message(액션태그명) code="키값" />
   prefix="form"  ->사용자로부터 값을 입력받을때 관여 액션태그
                           사용시 선언문
   form:form(액션태그명) commandName="DTO클래스명">
   input태그 대용->form:input path="적용필드명"
                         form:errors elements="출력필드명(div)"
                      <div>id값을 입력해야 됩니다.</div>
 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="member.insert.title" /></title>
</head>
<body>
	<h2>레코드 추가</h2>
	<form:form commandName="memberCommand">
	  <form:errors elements="div" />
		아이디 : <form:input path="id"/>
		<font color="red"><form:errors path="id" /></font><br>
		
		비밀번호 : <form:password path="passwd" showPassword="false"/>
		<font color="red"><form:errors path="passwd" /></font>
		<br>
		이름 : <form:input path="name"/> 
		<font color="red"><form:errors path="name" /></font>
		<br>
		<input type="submit" value="보내기">
	</form:form>
</body>
</html>