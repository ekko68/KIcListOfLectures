<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
     java.util.HashMap mapData=new java.util.HashMap();
     mapData.put("name","홍길동");
     mapData.put("today",new java.util.Date());
     //int [] intArray={1,2,3,4,5};
%>
<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>" />
<c:set var="map"  value="<%=mapData %>" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach태그</title>
</head>
<body>
<%
   /*  int sum=0;
    for(int i=1;i<=100;i+=2){
    	//if(i%2==1)
    	 sum+=i;//sum=sum+i
    }
    out.println(sum); */
%>
<h4>1~100까지의 홀수의 합</h4>
<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="100" step="2">
<c:set var="sum" value="${sum+i}" />
</c:forEach>
결과=${sum}
<hr>
<h4>int형 배열</h4>
<%-- <c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>" /> --%>
<c:forEach var="i" items="${intArray}" begin="2" end="4">
      [${i}]
</c:forEach>
<h4>Map</h4>
<c:forEach var="i" items="${map}">
    ${i.key}=${i.value}<br>
</c:forEach>
</body>
</html>













