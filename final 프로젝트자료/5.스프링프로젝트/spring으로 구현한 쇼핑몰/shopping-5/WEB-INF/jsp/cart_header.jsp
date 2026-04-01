<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<div align="center">
<table class="header">
	<tr>
		<td width="23%"><a href="index.html">■상품 리스트</a></td>
		<td width="20%"><a href="checkout.html">■정산화면</a></td>
		<td width="20%"><a href="cartConfirm.html">■바구니 확인</a></td>
		<td width="20%"><a href="cartClear.html">■바구니 비움</a></td>
	  <td width="30%">	
		<c:choose>
				<c:when test="${not empty loginUser}">
					<font color="red">어서 오세요,<br>
					<c:out value="${loginUser.userId}" />씨
          </font>
				</c:when>
				<c:when test="${empty loginUser}">
					<font color="red"><a href="login.html">■로그인 페이지</a></font>
				</c:when>
			</c:choose>
		</td>
	</tr>
</table>
</div>
<hr>