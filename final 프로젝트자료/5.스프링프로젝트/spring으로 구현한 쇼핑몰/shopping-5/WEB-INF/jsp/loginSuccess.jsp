<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>로그인 화면</title>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<div align="center" class="body">
		<h2>로그인 화면</h2>
		어서오세요,<c:out value="${loginUser.userName}" /> 씨!
		<br><br>
		<a href="index.html">■상품 리스트 화면으로 돌아감</a><br>
		<a href="checkout.html">■정산화면으로 이동</a>
	</div>
</body>
</html>