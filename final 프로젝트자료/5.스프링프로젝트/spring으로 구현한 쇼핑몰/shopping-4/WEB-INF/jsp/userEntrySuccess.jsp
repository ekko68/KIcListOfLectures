<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>회원 가입 완료 화면</title>
</head>
<body>
	<div align="center" class="body">
	<h2>회원 가입 완료 화면</h2>
	<b><font color="red">회원 가입이 완료되었다.</font></b><br>
	<table>
		<tr height="40px">
			<td>회원 ID</td>
			<td><c:out value="${user.userId}" /></td>
		</tr>
		<tr height="40px">
			<td>패스워드</td>
			<td><c:out value="${user.password}" /></td>
		</tr>
		<tr height="40px">
			<td>이름</td>
			<td><c:out value="${user.userName}" /></td>
		</tr>
		<tr height="40px">
			<td>우편번호</td>
			<td><c:out value="${user.postCode}" /></td>
		</tr>
		<tr height="40px">
			<td>주소</td>
			<td><c:out value="${user.address}" /></td>
		</tr>
		<tr height="40px">
			<td>E-MAIL</td>
			<td><c:out value="${user.email}" /></td>
		</tr>
		<tr height="40px">
			<td>직업</td>
			<td><c:out value="${user.job}" /></td>
		</tr>
		<tr height="40px">
			<td>생년월일</td>
			<td><c:out value="${user.birthDay}" /></td>
		</tr>
	</table>
	</div>
</body>
</html>