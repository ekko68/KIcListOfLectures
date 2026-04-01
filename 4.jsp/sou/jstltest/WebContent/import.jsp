<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>외부의 자원을 가져다주는 액션태그</title>
</head>
<body>
<%
  //String url="http://www.naver.com"
%>
<%-- <c:set var="url" value="http://www.daum.net" />
<c:import url="${url}" var="u" />
<c:out value="${url}" /> 가져옵니다.
<hr>
<base href="<c:out value="${url}" />">
   <c:out value="${u}" escapeXml="false" />
</base> --%>
<h4>내부자원을 가져오기</h4>
<c:set var="url" value="chooseTag.jsp" />
<c:import url="${url}" var="u" >
  <c:param name="name" value="bk" />
</c:import>
<hr>
<c:out value="${u}" escapeXml="false" />








</body>
</html>