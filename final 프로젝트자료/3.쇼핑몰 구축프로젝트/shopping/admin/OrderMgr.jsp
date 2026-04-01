<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, product.*,order.*"%>
<jsp:useBean id="orderMgr" class="order.OrderMgr" />
<jsp:useBean id="proMgr" class="product.ProductMgr" />

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

		<table width="95%" align="center" bgcolor="#FFFF99" border="1">
		<tr bgcolor="#996600"> 
		<td align="center"><font color="#FFFFFF">주문번호</font></td>
		<td align="center"><font color="#FFFFFF">주문자</font></td>
		<td align="center"><font color="#FFFFFF">제품</font></td>
		<td align="center"><font color="#FFFFFF">주문수량</font></td>
		<td align="center"><font color="#FFFFFF">주문날짜</font></td>
		<td align="center"><font color="#FFFFFF">주문상태</font></td>
		<td>&nbsp;</td>
		</tr>

		<%
		//주문내역을 Vector에 담아 가져온다.
		Vector vResult = orderMgr.getOrderList();
		if(vResult.size() ==0){ //주문내역이 없으면 주문내역이 없다고 출력
		%>
		<tr> 
		<td align="center" colspan="7">주문 내역이 없습니다</td>
		</tr>
		<%}else{

			//주문내역이 있다면 Vector에 저장된 주문내역을 for루프를 돌면서 
			//하나씩 가져온다.

			for(int i=0; i< vResult.size(); i++){
			OrderBean order = (OrderBean)vResult.get(i);

			//주문내역에 있는 상품정보를 가져온다.
			ProductBean product = proMgr.getProduct(order.getProduct_no());
		%>
		<tr> 
		<td align="center"><%=order.getNo()%></td>
		<td align="center"><%=order.getId()%></td>
		<td align="center"><%=product.getName()%></td>
		<td align="center"><%=order.getQuantity()%></td>
		<td align="center"><%=order.getDate()%></td>
		<td align="center">
		<%
		switch(Integer.parseInt(order.getState())){
		case 1 : out.println("접수중");
		break;
		case 2 : out.println("접수");
		break;
		case 3 : out.println("입금확인");
		break;
		case 4 : out.println("배송준비");
		break;
		case 5 : out.println("배송중");
		break;
		default : out.println("완료");
		}%>
		</td>
		<%
            //해당주문에 대한 상세내역을 조회한다.상세보기를 위해 주문번호를 함께 전송
			%>
		<td align="center"><a href="javascript:orderDetail('<%=order.getNo()%>')">상세보기</a></td>
		</tr>
		<%}
		}%>
		</table>
	
	</td>
	</tr>
	</table>
	
	<%@ include file="Bottom.jsp" %>
    <% //주문상세내역을 보기 위해 필요한 폼  %>
	<form name="detail" method="post" action="OrderDetail.jsp" >
	<input type="hidden" name="no">
	</form>

</body>
</html>
