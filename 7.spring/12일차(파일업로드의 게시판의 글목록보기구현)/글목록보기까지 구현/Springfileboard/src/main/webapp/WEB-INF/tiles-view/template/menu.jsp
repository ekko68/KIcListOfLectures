<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //현재 실행중인 http://localhost:8090/Springfileboard/board/list.do
	String contextPath = request.getContextPath();
%>
<ul>
	<li><a href="<%=contextPath%>/board/list.do">목록</a></li>
	<li><a href="<%=contextPath%>/board/write.do">글쓰기</a></li>
</ul>