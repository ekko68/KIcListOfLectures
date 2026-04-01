<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, product.*"%>
<jsp:useBean id="proMgr" class="product.ProductMgr" />

<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>

<body bgcolor="#996600" topmargin="100">

	<%@ include file="Top.jsp" %>
	
	<%ProductBean product= proMgr.getProduct(request.getParameter("no"));%>

	<table width="75%" align="center" bgcolor="#FFFF99">
	<tr> 
	<td align="center" bgcolor="#FFFFCC">

		<form method="post" action="ProductProc.jsp?flag=update" enctype="multipart/form-data">
		<table width="95%" align="center" bgcolor="#FFFF99" border="1">
		<tr bgcolor="#996600"> 
		<td colspan="2" align="center"><font color="#FFFFFF">상품등록</font></td>
		</tr>
		<tr> 
		<td width="31%" align="center">상품이름</td>
		<td width="69%" align="left"> 
		<input type="text" name="name" value="<%=product.getName()%>">
		</td>
		</tr>
		<tr> 
		<td height="21" align="center">상품가격</td>
		<td align="left"> 
		<input type="text" name="price" size="20" value="<%=product.getPrice()%>">원</td>
		</tr>
		<tr> 
		<td align="center">상품내용</td>
		<td><textarea rows="10" cols="45" name="detail"><%=product.getDetail()%></textarea>
		</td>
		</tr>
		<tr> 
		<td align="center">상품입고수량</td>
		<td align="left"> 
		<input type="text" name="stock" size="10" value="<%=product.getStock()%>">개</td>
		</tr>
		<tr> 
		<td align="center">상품이미지</td>
		<td align="left"><img src="../data/<%=product.getImage()%>">
		<input type="file" name="image"></td>
		</tr>
		<tr> 
		<td colspan="2" align="center"> 
		<input type="submit" value="제품수정">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="다시쓰기">
		</td>
		</tr>
		</table>
		<input type=hidden name="no" value="<%=product.getNo()%>">
		</form>

	</td>
	</tr>
	</table>

	<%@ include file="Bottom.jsp" %>


</body>
</html>