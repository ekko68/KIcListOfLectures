<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- enctype->파일 첨부를 하기위해서 필요 
       spring:message 액션태그->code="불러올 키값"
       form:errors 액션태그=>path="적용필드명(DTO중 입력받은 필드명)"
-->
<form action="write.do" enctype="multipart/form-data" method="post">
	<spring:message code="write.form.title"/>
	<input type="text" name="title" value="${command.title}">
	<form:errors path="command.title"/><br>

	<input type="text" name="writer" value="${command.writer }">
	<input type="password" name="pwd">
	<textarea rows="10" cols="50" name="content"></textarea>
	<spring:message code="write.form.upload"/>
	<input type="file" name="upload">
    <p>
	<input type="submit" value="전송">
	<input type="button" value="목록" 
	          onclick="location.href='list.do'">
</form>
















