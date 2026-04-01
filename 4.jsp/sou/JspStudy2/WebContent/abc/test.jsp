<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.Date" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
      String name="홍길동";
      
      public String getName(){
    	  return name;
      }
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP페이지 3번째(표현식)</title>
</head>
<body>

  <%
        float f=2.3f;
        int i=Math.round(f);//클래스명.정적메서드명(~)
        //날짜->Date
        //외부의 클래스를 불러오는 방법
        //->1.import (권장) 2.상위패키지명.하위패키지명...참조할 클래스명~
        //java.util.Date d=new java.util.Date();
        Date d=new Date();
        out.println("d의 값=>"+d);//d.toString()
  %>
  <hr><p>
  정수 f의 반올림값은 ?<%=i %><p>
  현재의 날짜와 시간은? <%=d.toString() %><br>
  선언문의 메서드를 호출:<%=getName()%>
  
</body>
</html>






