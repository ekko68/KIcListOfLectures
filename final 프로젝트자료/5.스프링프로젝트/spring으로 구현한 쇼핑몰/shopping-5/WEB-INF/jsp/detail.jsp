<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<title>상품상세화면</title>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<div align="center" class="body">	
		<h2>상품상세화면</h2>
		<table>
			<tr>
				<td>
					<img src="img/<c:out value="${item.pictureUrl}" />">
				</td>
				<td align="center">
					<table>
						<tr height="50">
							<td width="80">상품명</td>
 							<td width="160"><c:out value="${item.itemName}" /></td>
						</tr>
						<tr height="50">
							<td width="80">가격</td>
							<td width="160"><c:out value="${item.price}" /> 원</td>
						</tr>
						<tr height="50">
							<td width="80">설명 </td>
							<td width="160"><c:out value="${item.description}" /><br><br></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center" width="230">
							<form action="cartAdd.html">
								<input type="hidden" name="itemId" value="<c:out value="${item.itemId}" />">
								<table>
									<tr>
										<td>
											<select name="quantity">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
												<option>9</option>
											</select>&nbsp;개
										</td>
										<td>
											<input type="submit" value="바구니에 넣음" >
										</td>
									</tr>
								</table>
							</form>
							</td>
						</tr>									
						
						<tr>
							<td colspan="2" align="center" width="300">
							<a href="index.html">
							■상품 리스트 화면으로 돌아감
							</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>