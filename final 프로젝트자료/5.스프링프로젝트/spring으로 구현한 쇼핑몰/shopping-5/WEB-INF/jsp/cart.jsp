<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>바구니 확인 화면</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<div align="center" class="body">
	<h2>바구니 확인 화면</h2>
	<div class="cart">
	<c:set var="cart" value="${cart}" />
	<table style="font-size: 10pt;">
		<tr><td colspan="2"><font color="green">바구니에는 다음의 상품이 들어있다.</font></td></tr>
		<c:forEach items="${cart.itemList}" var="itemSet">
			<tr>
				<td><c:out value="${itemSet.item.itemName}"/></td>
				<td><c:out value="${itemSet.quantity}"/>개</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<br>
	
	<c:out value="${message}" /><br><br>
	<a href="index.html">■장보기를 계속함</a><br>
	<a href="checkout.html">■정산화면으로 이동</a>
	</div>
</body>
</html>