<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력받은값을 암호화/복호화</title>
</head>
<jsp:useBean id="enc" class="encrypt.LocalEncrypter" />
<%
   //encrypt.LocalEncrypter enc=new encrypt.LocalEncrypter();
%>
<body>
 <%
    request.setCharacterEncoding("utf-8");//한글처리
    String str=request.getParameter("code");//<,>,(,)
    //암호화
    String encryptocode=enc.returnEncryptCode(str);
 %>
 <h3>입력받은 코드 Encrypt결과(암호화):<%=encryptocode %></h3>
 <%
   String decryptcode=enc.returnDecryptCode(encryptocode);
 %>
 <h3>복호화 문자열을 출력결과:<%=decryptcode %></h3>
</body>
</html>










