<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.MemberDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
  //scripts.js=>IdCheck.jsp?mem_id='kkk';
  String mem_id=request.getParameter("mem_id");
  System.out.println("IdCheck.jsp의 mem_id=>"+mem_id);
   //DB접속->MemberDAO의 checkId(mem_id)
   MemberDAO memMgr=new MemberDAO();
   boolean check=memMgr.checkId(mem_id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Id중복 체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<br>
<center>
<b><%=mem_id %></b>
<%
   if(check){ //이미 아이디가 존재한 아이디라면
        out.println("는 이미 존재하는 아이디입니다.<p>");
   }else{
	   out.println("는 사용가능한 아이디입니다.<p>");
   }
%>

<a href="#" onclick="self.close()">닫기</a><!-- window.open()(self.close()) -->
</center>
</body>
</html>








