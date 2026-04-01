<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<table width="600" border="0" cellspacing="0" cellpagging="0" align="center">
	<tr>
		<td colspan="2"><h3>회원 정보 </h3></td>	
	</tr>
	<tr>
		<td>아이디</td>				
		<td>${listperson.id }</td>		
	</tr>
	<tr>
		<td>비밀번호</td>		
		<td>${listperson.passwd }</td>		
	</tr>
	<tr>
		<td>회원명</td>
		<td>${listperson.name }</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${listperson.gender }</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${listperson.age }</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="수정" 
			   onclick="location.href='updateperson.do?id=${listperson.id}'">
			<input type="button" value="삭제" 
			   onclick="location.href='deleteperson.do?id=${listperson.id}'">
			<input type="button" value="목록" onclick="location.href='05_admin_m_se.do'">
		</td>
	</tr>
</table>