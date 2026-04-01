<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청을 받아서 처리해주는 페이지</title>
</head>
<body>
 <h1>페이지를 이동시키는  페이지역할</h1>
 <%
    int su=100;  //a.jsp이 공유->사용
    System.out.println("su=>"+su);
    Date d=new Date();//b.jsp이 공유->사용
    //서버의 메모리에 저장->객체만 저장이 된다.
    request.setAttribute("total",su);//int->Integer->Object->형변환
    request.setAttribute("cal",d);
    //----------------------------------------
    String move=request.getParameter("move");
    System.out.println("이동할 페이지명(move)=>"+move);
    if(move.equals("a.jsp")){
    	//response.sendRedirect("a.jsp");
 %>
 <jsp:forward page='a.jsp'  /><br>
<%}else if(move.equals("b.jsp")) {%>
 <jsp:forward page='b.jsp'  /><br>
 <%} else {%>
     <script>
        window.alert("당신이 요청하신 페이지는 없습니다.\n확인 다시해보세요!")
        location.href="forward.jsp"
     </script>
 <% } %>
</body>
</html>







