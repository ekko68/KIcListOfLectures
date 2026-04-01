<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
        request.setCharacterEncoding("utf-8");
        //java.util.HashMap map=new java.util.HashMap();
        //map.put("name","홍길동");  map.get("키명(name)")
%>
<c:set var="map" value="<%=new java.util.HashMap() %>"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>set태그의 2번째 예제</title>
</head>
<body>
<!-- target(객체명) property(속성명(멤버변수)),value(저장할값) 
      ${객체명.속성명}  ${객체명['속성명']}   ${객체명["속성명"]}
-->

 <c:set target="${map}" property="name"  value="홍길동" />
 
 변수 map에 저장된 name값:${map.name}<br>
 변수 map에 저장된 name값2:${map['name']}<br>
 변수 map에 저장된 name값3:${map["name"]}<br>
 
<form method="post"  action="setTag2.jsp">
 이름:<input type="text" name="name">
  <input type="submit" value="전송">
</form>
<hr>
이름은 ${param.name} 입니다.

</body>
</html>


