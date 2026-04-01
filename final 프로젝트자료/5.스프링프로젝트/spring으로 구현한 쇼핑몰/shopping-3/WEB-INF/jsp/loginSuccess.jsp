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
		어서오세요,<c:out value="${loginUser.userName}" /> 씨!
	</div>
</body>
</html>