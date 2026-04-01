<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>
               
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="member.delete.title" /></title>
</head>
<body>
	<form action="deletePro.do">
	  <input type="hidden" name="id" value="${param.id}">
	  <input type="submit" value="삭제할까요?">
	  <input type="button" value="취소"
	             onclick="location.href='list.do'">
	</form>
</body>
</html>


