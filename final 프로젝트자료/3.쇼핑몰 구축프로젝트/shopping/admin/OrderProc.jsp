<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, product.*,order.*"%>
<jsp:useBean id="orderMgr" class="order.OrderMgr" />

<%
    //수정/삭제를 구분하기 위해 flag값을 읽어온다.
	String flag = request.getParameter("flag");
    String no = request.getParameter("no");//주문번호를 읽어온다.
	String state = request.getParameter("state");
	boolean result = false;
	
	if(flag.equals("update")){
    	result=orderMgr.updateOrder(no, state);//주문 처리상태를 수정
    }else if(flag.equals("delete")){
		result=orderMgr.deleteOrder(no);//주문삭제
	}else{
		response.sendRedirect("OrderMgr.jsp");
	}

    if(result){//처리결과에 따라 적절한 메시지를 출력
%>
	<script>
		alert("정상적으로 처리하였습니다.");
		location.href="OrderMgr.jsp";
	</script>
<%
	}else{
%>
	<script>
		alert("오류가 발생하였습니다.");
		location.href="OrderMgr.jsp";
	</script>
<%
	}
%>

