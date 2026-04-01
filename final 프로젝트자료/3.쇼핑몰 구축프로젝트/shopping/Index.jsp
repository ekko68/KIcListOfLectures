<%@ page contentType="text/html;charset=EUC-KR"%>

<html>
<head>
<title>Simple Shopping Mall </title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>

<body bgcolor="#996600" topmargin="100">

	<%@ include file="Top.jsp" %>

	<table width="75%" align="center" bgcolor="#FFFF99" height="100%">
	<%
	if(mem_id != null){
	%>
	<tr> 
	<td align="center"><%=mem_id%>님 방문해 주셔서 감사합니다.</a></td>
	</tr>
	<%}else{%>
	<tr>
	<td align="center">로그인 하신 후 이용해 주세요</a></td>
	</tr>
	<%}%>
	</table>

	<%@ include file="Bottom.jsp" %>

</body>
</html>  
  