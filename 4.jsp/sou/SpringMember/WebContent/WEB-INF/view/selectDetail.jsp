<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>
                
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--  arguments="매개변수전달할값"-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="member.detail.title" 
                                   arguments="${member.id}"/></title>
</head>
<body>
	 아이디:${member.id}<br>
	 비밀번호:${member.passwd}<br>
	 이름:${member.name}<br>
	 날짜:${member.reg_date}<br>
	 <a href="list.do">목록보기</a>
	 <a href="update.do?id=${member.id}">수정</a>
	 <a href="delete.do?id=${member.id}">삭제</a>
</body>
</html>





