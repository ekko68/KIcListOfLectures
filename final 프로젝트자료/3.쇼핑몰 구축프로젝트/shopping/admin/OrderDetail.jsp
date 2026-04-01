<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, product.*,order.*"%>
<jsp:useBean id="orderMgr" class="order.OrderMgr" />
<jsp:useBean id="proMgr" class="product.ProductMgr" />

<%
//상세보기를 선택하게 되면 주문번호를 넘겨받게 된다.따라서
//해당 주문번호에 대한 상세한 정보를 가져올 수 있다.
OrderBean order = orderMgr.getOrderDetail(request.getParameter("no"));

//해당 주문에 대한 상품정보를 가져온다.주문내역에는 주문한 상품번호가
//담겨져 있으므로 어떤 상품을 주문했는지 알 수 있다.
ProductBean product = proMgr.getProduct(order.getProduct_no());
%>

<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
 
<body bgcolor="#996600" topmargin="100">

	<%@ include file="Top.jsp" %>
 
	<table width="75%" align="center" bgcolor="#FFFF99">
	<tr> 
	<td align="center" bgcolor="#FFFFCC">

		<form method=post name="order" action="OrderProc.jsp">
		<table width="95%" align="center" bgcolor="#FFFF99" border="1">
		<tr bgcolor="#996600"> 
		<td colspan="2" align="center"><font color="#FFFFFF">주문 상세내역</font></td>
		</tr>
		<tr> 
		<td align="center">고객아이디</td>
		<td align="center"><%=order.getId()%></td>
		</tr>
		<tr> 
		<td align="center">주문번호</td>
		<td align="center"><%=order.getNo()%></td>
		</tr>
		<tr> 
		<td align="center">제품번호</td>
		<td align="center"><%=product.getNo()%></td>
		</tr>				
		<tr> 
		<td align="center">제품이름</td>
		<td align="center"><%=product.getName()%></td>
		</tr>
		<tr> 
		<td align="center">제품가격</td>
		<td align="center"><%=product.getPrice()%>원</td>
		</tr>
		<tr> 
		<td align="center">주문수량</td>
		<td align="center"><%=order.getQuantity()+""%>개</td>
		</tr>
		<tr> 
		<td align="center">재고수량</td>
		<td align="center"><%=product.getStock()%>개</td>
		</tr>		
		<tr> 
		<td align="center">주문날짜</td>
		<td align="center"><%=order.getDate()%></td>
		</tr>
		<tr> 
		<td align="center">금액</td>
		<% //주문한 상품수량과 상품의 가격을 곱하여 총 금액을 구하게 된다.  %>
		<td align="center"><%=order.getQuantity()*Integer.parseInt(product.getPrice())%>원</td>
		</tr>
		<tr> 
		<td align="center">주문상태</td>
		<td align="center">
		<select name="state">
		<option value="1">접수중</option>
		<option value="2">접수</option>
		<option value="3">입금확인</option>
		<option value="4">배송준비</option>
		<option value="5">배송중</option>
		<option value="6">완료</option>
		</select>
		<% //스크립트를 이용해 현재 주문한 상품에 대한 처리상태를 보여주게 된다. %>
		<script>document.order.state.value=<%=order.getState()%></script>
		</td>
		</tr>
		<tr> 
		<td colspan="2" align="center">
		<% //주문처리 상태를 수정하거나 주문을 삭제한다.%>
		<input type="botton" value="수정" size="3" onclick="javascript:orderUpdate(this.form)"> / 
		<input type="botton" value="삭제" size="3" onclick="javascript:orderDelete(this.form)">
		</td>
		</tr>
		</table>
		<% //수정/삭제를 위해서는 주문번호가 필요하다.%>
		<input type="hidden" name="no" value="<%=order.getNo()%>">

		<% //flag값을 통해 주문에 대한 수정/삭제처리를 결정하게 된다.
		   //flag값은 수정 혹은 삭제 버튼을 누름과 동시에 스크립트를 통해
		   //결정되어 진다.
		%>
		<input type="hidden" name="flag">
		</form>		
			
	</td>
	</tr>
	</table>
	
	<%@ include file="Bottom.jsp" %>	
	
</body>
</html>

