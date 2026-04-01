<%@ page contentType="text/html;charset=EUC-KR"%>
<%@ page import="java.util.*, product.*,order.*" %>
<jsp:useBean id="cartMgr" class="product.CartMgr" scope="session"/>
<jsp:useBean id="orderMgr" class="order.OrderMgr" />
<jsp:useBean id="proMgr" class="product.ProductMgr" />

<%  
    //장바구니를 가져온다.
	Hashtable hCart = cartMgr.getCartList();
	Enumeration hCartKey=hCart.keys();//장바구니를 읽어옴

	//장바구니가 비었는지를 조사
	if(hCart.size() !=0){

		//장바구니의 목록이 있다면 while구문을 돌면서 주문처리를 한다.
		while(hCartKey.hasMoreElements()){

		//장바구니의 주문내역을 읽어온다.
		OrderBean order = (OrderBean)hCart.get(hCartKey.nextElement());
		orderMgr.insertOrder(order);//주문을 한다.
		proMgr.reduceProduct(order);//상품재고를 줄인다.		
		cartMgr.deleteCart(order);//주문처리된 장바구니 내역을 삭제한다.
		}
%>
	<script>
	   alert("주문처리 하였습니다");
	   location.href="OrderList.jsp";
	</script>
<%}else{ %>
	<script>
		alert("장바구니가 비어있습니다.");
		location.href="OrderList.jsp";
	</script>
<%}%>

