<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>회원 가입 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>회원 가입 화면</h2>
		<form action="userEntry.html" method="post">
			<spring:bind path="user">
				<font color="red"><c:out value="${status.errorMessage}" /></font>
			</spring:bind>
			<table>
				<tr height="40px">
					<td>회원 ID</td>
					<td><spring:bind path="user.userId">
							<input type="text" class="userId" name="<c:out value='${status.expression}' />" value="<c:out value='${status.value}' />" maxlength="20">
							<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>패쓰워드</td>
					<td><spring:bind path="user.password">
							<input type="password" class="password" name="<c:out value='${status.expression}' />" 
							value="<c:out value='${status.value}' />" maxlength="20">
							<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>이름</td>
					<td><spring:bind path="user.userName">
							<input type="text" class="userName" name="<c:out value='${status.expression}' />" 
							value="<c:out value='${status.value}' />" maxlength="20">
							<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>우편번호</td>
					<td><spring:bind path="user.postCode">
						<input type="text" class="postCode" name="<c:out value='${status.expression}' />" value="<c:out value='${status.value}' />" maxlength="8">
						<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>주소</td>
					<td><spring:bind path="user.address">
						<input type="text" class="address" name="<c:out value='${status.expression}' />" value="<c:out value='${status.value}' />" maxlength="50">
						<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>E-MAIL</td>
					<td><spring:bind path="user.email">
						<input type="text" class="email" name="<c:out value='${status.expression}' />" value="<c:out value='${status.value}' />" maxlength="50">
						<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>직업</td>
					<td><spring:bind path="user.job">
						<select class="jobs" size="1" name="<c:out value='${status.expression}' />">
							<c:forEach items="${jobs}" var="job">
								<option value="<c:out value='${job}' />">
									<c:out value="${job}" />
								</option>
							</c:forEach>
						</select>
						</spring:bind>
					</td>
				</tr>
				<tr height="40px">
					<td>생년월일</td>
					<td><spring:bind path="user.birthDay">
						<input type="text" class="birthDay" name="<c:out value='${status.expression}' />" value="<c:out value='${status.value}' />" maxlength="10">
						<font color="red"><c:out value="${status.errorMessage}" /></font>
						</spring:bind>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td height="40px" align="center"><input type="submit" name="btnSubmit" value="등록"></td>
					<td height="40px" align="center"><input type="reset" name="btnReset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>