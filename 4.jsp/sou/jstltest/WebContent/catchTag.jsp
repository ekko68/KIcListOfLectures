<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
  <fmt:requestEncoding value="utf-8" />
  
 <hr>
 <c:catch var="ex">
  name의 매개변수명:<%=request.getParameter("name") %>
 <%  if (request.getParameter("name").equals("test")) { %>
      ${param.name}은 test입니다.
 <% } %>
 </c:catch>
 
 <%-- <c:if test="${ex!=null}"> --%>
 <c:if test="${not empty ex}">
   예외가 발생하였습니다.<br>
   ${ex}
 </c:if>
 
</body>
</html>



