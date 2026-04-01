<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<form action="searchperson.do" name="search" method="get">
	<table align="center" width="200" border="0" cellspacing="0" cellpagging="2">
		<tr>
			<td align="center">
				<select name="keyField">
					<option value="id">id</option>
					<option value="name">회원명</option>
					<option value="gender">성별</option>
					<option value="age">연령대</option>
				</select>
			</td>
			<td>
				<input type="text" size="16" name="keyWord">
			</td>
			<td>
				<input type="submit" value="찾기">
			</td>
		</tr>
	</table>
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td align="right" colspan="5" >
			<input type = "button" value="회원 등록" onclick="location.href='05_admin_m_in.do'">
		</td>
	</tr>
	<tr>
		<td>총 회원 수 : ${count}</td>
	</tr>
	
	<tr bgcolor="#F3F3F3">
		<td width="50">아이디</td>
		<td width="70">회원명</td>
		<td width="50">성별</td>		
		<td width="70">연령대</td>
	</tr>
	<!-- 데이터의 유무에 따라서 -->
	<c:if test="${count==0}">
		<tr>
			<td colspan="5" align="center">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="article" items="${listperson}">	
		<tr>
			<td><a href="detailsperson.do?id=${article.id}">${article.id}</a></td>			
			<td>${article.name }</td>
			<td>${article.gender }</td>
			<td>${article.age }</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td align="center" colspan="5"></td>
	</tr>
</table>