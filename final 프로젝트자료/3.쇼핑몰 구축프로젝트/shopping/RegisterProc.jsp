<%@ page contentType="text/html;charset=euc-kr"%>
<% 
    request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="regBean" class="hewon.RegisterBean"/>
  <jsp:setProperty name="regBean" property="*" />

<html>
<head>
<title>회원가입 확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#996600">
<br>
<table align="center" border="0" cellspacing="0" cellpadding="5" >
  <tr> 
    <td align="center" valign="middle" bgcolor="#FFFFCC"> 
	<table border="1" cellspacing="0" cellpadding="2"  align="center">
        <form name="regForm" method="post" action="MemberInsert.jsp">
          <tr align="center" bgcolor="#996600"> 
            <td colspan="3"><font color="#FFFFFF"><b> 
              <jsp:getProperty name="regBean" property="mem_name" />
              회원님이 작성하신 내용입니다. 확인해 주세요</b></font> </td>
          </tr>
          <tr> 
            <td>아이디</td>
            <td><input type="text" name="mem_id" 
			           value="<jsp:getProperty name="regBean" property="mem_id" />"></td>
          </tr>
          <tr> 
            <td>패스워드</td>
            <td><input type="text" name="mem_passwd" 
			           value="<jsp:getProperty name="regBean" property="mem_passwd" />"></td>
          </tr>
          <tr> 
            <td>이름</td>
            <td><input type="text" name="mem_name" 
			           value="<jsp:getProperty name="regBean" property="mem_name" />"></td>
          </tr>
		  <tr> 
            <td>주민등록번호</td>
            <td><input type="text" name="mem_num1" 
			           value="<jsp:getProperty name="regBean" property="mem_num1" />"> -
			    <input type="text" name="mem_num2" 
				       value="<jsp:getProperty name="regBean" property="mem_num2" />"></td>
          </tr>
          <tr> 
            <td>이메일</td>
           <td><input type="text" name="mem_email"  size="30" 
		              value="<jsp:getProperty name="regBean" property="mem_email" />"></td>
          </tr>
          <tr> 
            <td>전화번호</td>
            <td><input type="text" name="mem_phone" 
			           value="<jsp:getProperty name="regBean" property="mem_phone" />"></td>
          </tr>
		  <tr> 
            <td>우편번호</td>
            <td><input type="text" name="mem_zipcode" 
			           value="<jsp:getProperty name="regBean" property="mem_zipcode" />"></td>
          </tr>
		  <tr> 
            <td>주소</td>
           <td><input type="text" name="mem_address" size="50" 
		              value="<jsp:getProperty name="regBean" property="mem_address" />"></td>
          </tr>
		  <tr> 
            <td>직업</td>
            <td><input type="text" name="mem_job" 
			           value="<jsp:getProperty name="regBean" property="mem_job" />"></td>
          </tr>
          <tr> 
            <td colspan="2" align="center"><input type="submit" value="확인완료"> 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
            <input type="button" value="다시쓰기" onClick="history.back()"> 
            </td>
          </tr>
        </form>
      </table>
 </td>
  </tr>
</table>
</body>
</html>
