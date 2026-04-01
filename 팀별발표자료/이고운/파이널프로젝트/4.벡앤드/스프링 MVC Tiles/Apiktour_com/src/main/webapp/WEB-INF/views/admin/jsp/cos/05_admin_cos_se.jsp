<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<form action="searchcourse.do" name="search" method="get">
	<table align="center" width="200" border="0" cellspacing="0" cellpagging="2">
		<tr>
			<td align="center">
				<select name="keyField">
					<option value="cosnum">id</option>
					<option value="paly">쉴래?놀래?</option>
					<option value="cosname">코스명</option>
					<option value="lv">level</option>
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
			<input type = "button" value="코스 등록" onclick="location.href='05_admin_cos_in.do'">
		</td>
	</tr>
	
	<tr bgcolor="#F3F3F3">
		<td width="50">id</td>		
		<td width="100">쉴래? 놀래?</td>
		<td>코스명</td>
		<td width="50">Level</td>
	</tr>
	<!-- 데이터의 유무에 따라서 -->
	<c:if test="${count==0}">
		<tr>
			<td colspan="5" align="center">등록된 코스가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="article" items="${listcourse}">	
		<tr>
			<td><a href="detailscourse.do?cosnum=${article.cosnum }">${article.cosnum }</a></td>
			<td>${article.play }</td>
			<td>${article.cosname }</td>
			<td>${article.lv }</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td align="center" colspan="5"></td>
	</tr>
</table>