<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 2번째 예제</title>
</head>
<body>
<%
     //int count=3;
%>

  <%
      //int count=3;
      for(int i=0;i<count;i++){
    	  out.println("<h1>JSP 테스트"+i+"!<br>");//document.write("JSP테스트")
      }
      //out.println("count=>"+count); 표현식이 불가능
  %>
  출력할 변수 count:<%=count%>
  <%!
          //선언문태그=>현재 페이지의 위치에 상관없이 다 불러다 사용이 가능
      int count=3;
  %>
</body>
</html>





