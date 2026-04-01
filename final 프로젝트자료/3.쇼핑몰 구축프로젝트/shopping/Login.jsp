<%@ page contentType="text/html;charset=EUC-KR"%>
<%
    String mem_id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>로그인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js">
</script>
</head>
<body bgcolor="#FFFFCC">
<center>
<br><br><br>
<%
	if(mem_id != null){
%>
<b><%=mem_id%></b>님 환영 합니다.<p>
제한된 기능을 사용 할 수가 있습니다.<p>
<a href="Logout.jsp">로그아웃</a>
<%}else{%>
  <table>
    <form name="login" method="post" action="LoginProc.jsp">
      <tr> 
        <td align="center" colspan="2"><h4>로그인</h4></td>
      </tr>
      <tr> 
        <td>아 이 디</td>
        <td><input type="text" name="mem_id"></td>
      </tr>
      <tr> 
        <td>비밀번호 </td>
        <td><input type="password" name="mem_passwd"> </td>
      </tr>
      <tr> 
        <td colspan="2"> <div align="right"> 
            <input type="button" value="로그인" onclick="loginCheck()">
            &nbsp;<input type="button" value="회원가입" onclick="memberReg()"></div></td>			
      </tr>
    </form>
  </table>
<%}%>
</center>
</body>
</html>