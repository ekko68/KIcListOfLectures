<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 리스트
<a id="mem" href='Register.do'>회원 등록</a>
<table>
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>성별</th>
		<th>연령층</th>
	</tr>
	</thead>
	<tbody>
	 <c:forEach var="memList"  items="${memList}">
		<tr>
			<td>1</td>
			<td>${memList.id }</td>
			<td>${memList.passwd }</td>
			<td>${memList.name }</td>
			<td>${memList.gender }</td>
			<td>${memList.age }대</td>
		</tr>
	</c:forEach>
	</tbody>

</table>
</body>
</html>