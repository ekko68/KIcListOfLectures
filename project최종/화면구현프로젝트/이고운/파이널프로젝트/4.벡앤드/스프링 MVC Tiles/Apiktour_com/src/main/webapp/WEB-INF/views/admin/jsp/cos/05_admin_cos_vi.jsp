<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<table width="600" border="0" cellspacing="0" cellpagging="0" align="center">
	<tr>
		<td colspan="2"><h3>회원 정보 </h3></td>	
	</tr>
	<tr>
		<td>코스 아이디</td>				
		<td>${listcourse.cosnum }</td>		
	</tr>
	<tr>
		<td>쉴래? 놀래?</td>		
		<td>${listcourse.play }</td>		
	</tr>
	<tr>
		<td>코스명</td>
		<td>${listcourse.cosname }</td>
	</tr>
	<tr>
		<td>에너지 & 피로도 level값</td>
		<td>${listcourse.lv }</td>
	</tr>
	<tr>
		<td>간략한 소개글</td>
		<td><textarea name="intro" rows="5" cols="50" readonly
					style="background-color:#d1d1e0">${listcourse.intro }</textarea></td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="수정" 
			   onclick="location.href='updatecourse.do?cosnum=${listcourse.cosnum}'">
			<input type="button" value="삭제" 
			   onclick="location.href='deletecourse.do?cosnum=${listcourse.cosnum}'">
			<input type="button" value="목록" onclick="location.href='05_admin_cos_se.do'">
		</td>
	</tr>
</table>