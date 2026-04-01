<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false"%>

<link rel="stylesheet" type="text/css" href="css/shopping-1.css">
<html>
<head>
	<title>상품 리스트 화면</title>
</head>
<body>
	<div align="center" class="body">
	<h2>상품 리스트 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="100">상품 ID</th>
			<th align="center" width="320">상품 명</th>
			<th align="center" width="100">가격</th>
		</tr>

		<c:forEach var="item" items="${itemList}">
			<tr class="record">
			<td align="center">
				<c:out value="${item.itemId}" />
			</td>
			<td align="left">
				<c:out value="${item.itemName}" />
			</td>
			<td align="right">
				<c:out value="${item.price}" />원
			</td>
			</tr>		
		</c:forEach>
	</table>
	</div>
</body>
</html>
