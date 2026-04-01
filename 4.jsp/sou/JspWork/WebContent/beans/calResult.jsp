<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="calc.CalcBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청을 받아서 처리해주는 페이지</title>
</head>
<body>
<%
   //방법1->매개변수 전달받아=>계산 ->출력
   /*
   CalcBean ca=new CalcBean();
   ca.setNum1(Integer.parseInt(request.getParameter("num1")));  //"5"->5
   ca.setOperator(request.getParameter("operator"));//+
   ca.setNum2(Integer.parseInt(request.getParameter("num2"))); //"3"->3
   ca.calculate();*/
   //result->num+num2
%>
<!-- 방법2  -->
<jsp:useBean id="ca" class="calc.CalcBean" scope="page" />
<jsp:setProperty name="ca" property="*"  />
<%  ca.calculate();  %>
<hr>
계산결과:<%=ca.getResult() %><br>
계산결과2:<jsp:getProperty name="ca" property="result" />
</body>
</html>










