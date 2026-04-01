<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hewon.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Id중복 체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<br>
<%
  //searchWord.js=>IdCheck.jsp?mem_id='kkk'&timestamp=~;
  //xhr객체가 받을 xml형태로 받을 수 있도록 text/xml형태로 전환(태그+문자열)
  response.setContentType("text/xml;charset=utf-8");
  String outString="";//xhr객체에게 전달할 내용을 담을 변수 선언(태그+문자열)
  String mem_id=request.getParameter("mem_id");
  System.out.println("IdCheck.jsp의 mem_id=>"+mem_id);
   //DB접속->MemberDAO의 checkId(mem_id)
   MemberDAO memMgr=new MemberDAO();
   boolean check=memMgr.checkId(mem_id);
   System.out.println("check="+check);
   
   if(check==true){//이미 사용중인 아이디가 존재한다면
  outString="<font color='red'><b>이미 사용중인 아이디입니다.</b></font>";   
   }else{//사용이 가능한 경우
  outString="<font color='blue'><b>사용이 가능한 아이디입니다.</b></font>";	   
   }
   //xhr객체가 받을 수있도록 전송
   out.println(outString);
   System.out.println(outString);//콘솔에 출력
%>
</body>
</html>








