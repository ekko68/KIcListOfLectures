<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*, product.*,order.*" %>
<jsp:useBean id="proMgr" class="product.ProductMgr" />
<jsp:useBean id="orderMgr" class="order.OrderMgr" />
<%
    //사용자의 로그인여부를 체크
	if(session.getAttribute("idKey") == null) {
		response.sendRedirect("Login.jsp");
	}else{
%>

<html>
<head>
<title>Simple Shopping Mall</title>
<link href="style.css" rel="stylesheet" type="text/css">
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
		<td align="center"><font color="#FFFFFF">제품</font></td>
		<td align="center"><font color="#FFFFFF">주문수량</font></td>
		<td align="center"><font color="#FFFFFF">주문날짜</font></td>
		<td align="center"><font color="#FFFFFF">주문상태</font></td>
		</tr>
		<%
		 //사용자의 ID로 해당 사용자의 주문내역을 읽어옵니다.
		Vector vResult = orderMgr.getOrder(mem_id);
		if(vResult.size() ==0){
		%>
		<tr> 
		<td align="center" colspan="5">주문하신 물품이 없습니다.</td>
		</tr>		
		<%}else{

			//Vector에 담겨진 사용자의 주문내역의 정보를 루프로 돌리면서
			//하나씩 불러내어 출력
			for(int i=0; i< vResult.size(); i++){
			OrderBean order = (OrderBean)vResult.get(i);
			ProductBean product = proMgr.getProduct(order.getProduct_no());
		%>
		<tr> 
		<td align="center"><%=order.getNo()%></td>
		<td align="center"><a href="javascript:productDetail('<%=order.getProduct_no()%>')"><%=product.getName()%></a></td>
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
		}
		%> 
		</td>
		</tr>
		<%}
		}%>
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
<%}%>


