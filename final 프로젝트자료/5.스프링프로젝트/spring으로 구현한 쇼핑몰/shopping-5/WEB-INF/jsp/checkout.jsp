<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>정산화면</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<div align="center" class="body">	
		<h2>정산화면</h2>
		<font color="red"><b>회원 정보</b></font>
		<table>
			<tr><td>사용자ID:</td><td><c:out value="${loginUser.userId}" /></td></tr>
			<tr><td>이름:</td><td><c:out value="${loginUser.userName}" />귀하</td></tr>
			<tr><td>우편번호:</td><td><c:out value="${loginUser.postCode}" /></td></tr>
			<tr><td>주소:</td><td><c:out value="${loginUser.address}" /></td></tr>
			<tr><td>E-MAIL:</td><td><c:out value="${loginUser.email}" /></td></tr>
		</table>
		<br><br>
		<font color="red"><b>구입 리스트</b></font>
		<table border="1">
			<tr><th width="200">상품명</th><th width="150">가격</th><th width="50">개수</th><th width="150">소계</th></tr>
			<c:forEach items="${itemList}" var="itemSet">
			<tr>
				<td align="left"><c:out value="${itemSet.item.itemName}" /></td>
				<td align="right"><c:out value="${itemSet.item.price}" /> 원</td>
				<td align="right"><c:out value="${itemSet.quantity}" /> 개</td>
				<td align="right"><c:out value="${itemSet.quantity * itemSet.item.price}" /> 원</td>
			</tr>
			</c:forEach>
		</table>
		<br>
			<b>합계 금액 : <c:out value="${totalAmount}" /> 원</b>
		<br>
		<br>
		<form action="end.html">
			<input type="submit" name="btn1" value="확정">
		</form>
		<a href="index.html">■상품 리스트 화면으로 돌아감</a><br>
	</div>
</body>
</html>