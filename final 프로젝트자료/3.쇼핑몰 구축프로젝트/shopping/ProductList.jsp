<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, product.*"%>
<jsp:useBean id="proMgr" class="product.ProductMgr" />

<html>
<head>
<title>Simple Shopping Mall</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
 
<body bgcolor="#996600" topmargin="100">

	<%@ include file="Top.jsp" %>
	<%Vector vResult= proMgr.getProductList();%>

	<table width="75%" align="center" bgcolor="#FFFF99">
	<tr> 
	<td align="center" bgcolor="#FFFFCC">

		<table width="95%" align="center" bgcolor="#FFFF99" border="1">
		<tr bgcolor="#996600"> 
		<td align="center"><font color="#FFFFFF">이름</font></td>
		<td align="center"><font color="#FFFFFF">가격</font></td>
		<td align="center"><font color="#FFFFFF">날짜</font></td>
		<td align="center"><font color="#FFFFFF">재고</td>
		<td align="center">&nbsp;</font></td>
		</tr>
		<% 
		for(int i=0; i<vResult.size(); i++){
		ProductBean product = (ProductBean)vResult.get(i);
		%>
		<tr> 
		<td align="center"><%=product.getName()%></td>
		<td align="center"><%=product.getPrice()%></td>
		<td align="center"><%=product.getDate()%></td>
		<td align="center"><%=product.getStock()%></td>
		<td align="center">
		<a href="javascript:productDetail('<%=product.getNo()%>')">상세보기</a>
		</td>
		</tr>
		<%}%>
		</table>
		
	</td>
	</tr>
	</table>

	<%@ include file="Bottom.jsp" %>
	
	<form name="detail" method="post" action="ProductDetail.jsp" >
	<input type="hidden" name="no">
	</form>

</body>
</html>

