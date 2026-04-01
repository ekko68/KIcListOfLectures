<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.util.*, hewon.*"%>
<jsp:useBean id="memMgr" class="hewon.MemberMgr" />

<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#996600" topmargin="100">

	<%@ include file="Top.jsp" %> 
	<%Vector vResult= memMgr.getMemberAdminList();%>

	<table width="75%" align="center" bgcolor="#FFFF99">
	<tr> 
	<td align="center" bgcolor="#FFFFCC">

		<table width="95%" align="center" bgcolor="#FFFF99" border="1">
		<tr bgcolor="#996600"> 
		<td align="center"><font color="#FFFFFF">회원이름</font></td>
		<td align="center"><font color="#FFFFFF">회원아이디</font></td>
		<td align="center"><font color="#FFFFFF">패스워드</font></td>
		<td align="center"><font color="#FFFFFF">주민번호</font></td>
		<td align="center"><font color="#FFFFFF">전화번호</font></td> 
		<td align="center"><font color="#FFFFFF">이메일</font></td>
		<td align="center"><font color="#FFFFFF">수정</font></td>
		</tr>
		<%
		for(int i=0; i<vResult.size(); i++){
		RegisterBean regBean = (RegisterBean)vResult.get(i);
		%>
		<tr> 
		<td align="center"><%=regBean.getMem_name()%></a></td>
		<td align="center"><%=regBean.getMem_id()%></td>
		<td align="center"><%=regBean.getMem_passwd()%></td>
		<td align="center"><%=regBean.getMem_num1()%>-<%=regBean.getMem_num2()%></td>
		<td align="center"><%=regBean.getMem_phone()%></td>
		<td align="center"><%=regBean.getMem_email()%></td>
		<td align="center"><a href="javascript:Update('<%=regBean.getMem_id()%>')">수정하기</a></td>
		</tr>
		<%}%>
		</table>
	</td>
	</tr>
	</table>

	<%@ include file="Bottom.jsp" %>

	<form name="update" method="post" action="MemberUpdate.jsp">
	<input type=hidden name="mem_id">
	</form>

</body>
</html>
