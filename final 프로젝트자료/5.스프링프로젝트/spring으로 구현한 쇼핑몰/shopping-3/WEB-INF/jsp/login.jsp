<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>로그인 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>로그인 화면</h2>
		<form action="login.html" method="post">
			<spring:bind path="user">
				<font color="red"><c:out value="${status.errorMessage}" /></font>
			</spring:bind>
			<font color="red"><c:out value="${loginErrorMsg}" /></font><br>
			<table>
				<tr height="40px">
					<td>유저ID</td>
					<td><spring:bind path="user.userId">
							<input type="text" class="userId" name="<c:out value="${status.expression}" />" value="<c:out value='${status.value}' />" maxlength="20">
							<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>패스워드</td>
					<td><spring:bind path="user.password">
							<input type="password" class="password" name="<c:out value="${status.expression}" />" value="<c:out value='${status.value}' />"  maxlength="20">
							<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td align="center"><input type="submit" value="로그인"></td>
					<td align="center"><input type="reset" value="리셋트"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>