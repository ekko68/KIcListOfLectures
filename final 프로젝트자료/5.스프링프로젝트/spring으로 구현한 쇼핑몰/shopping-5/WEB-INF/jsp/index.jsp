<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>상품 리스트 화면</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<div align="center" class="body">
	<h2>상품 리스트 화면</h2>
	<table border="1">
		<tr class="header">
      <th width="80">상품ID</th>
	  	<th width="320">상품명</th>
		  <th width="100">가격</th>
		</tr>
	<c:forEach items="${itemList}" var="item">
		<tr class="record">
			<td align="center">
				<c:out value="${item.itemId}" /></td>
			<td align="left">
				<a href="detail.html?itemId=<c:out value="${item.itemId}" />"><c:out value="${item.itemName}" /></a><br>
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