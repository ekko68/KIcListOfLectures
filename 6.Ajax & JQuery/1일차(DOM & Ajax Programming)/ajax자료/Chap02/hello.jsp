<%@ page contentType="text/plain; charset=euc-kr" %>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
%>
안녕하세요, <%= name %> 회원님!