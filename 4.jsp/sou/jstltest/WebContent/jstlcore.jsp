<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>변수(객체)의 사용범위와 out태그</title>
</head>
<body>
<h3>출력문</h3>
<%-- 
<c:out value="${1+2}(출력할값)${변수명}" /> 
--%>
${1+2}  <c:out value="${1+2}" /><p>
<%
   out.println(1+2);
%>
<%=1+2%>
${ 1 > 3 } <c:out value="${1 > 3}" />
${ 1 gt 3 } <c:out value="${1 gt 3}" />
<hr>
형식:session.setAttribute("key",value);<p>
<%
   //String name="hello";session.setAttribute("name","하늘");=>scope="session"
   //session.getAttribute("name")
   //request.setAttribute("name","하늘"); =>scope="request"
%>
<c:set var="name"  value="하늘"  scope="session" />
c:out name:<c:out value="${name}" /><p>
expression name:<%=session.getAttribute("name") %><p>
<hr>
set page scope var "name":
<c:set var="name">
     hello
</c:set>
<!--  같은 변수의 값을 출력(저장영역을 표시.출력변수명)-->
c:out name: <c:out value="${name}" /><br>
c:out name: <c:out value="${pageScope.name}" /><br>
session의 값 name:<c:out value="${sessionScope.name}"/><br>
<hr>
remove session scope var "name":<c:remove var="name" scope="session" /><p>
session의 값 name2:<c:out value="${sessionScope.name}"/><br>

</body>
</html>




















