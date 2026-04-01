<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>배열의 값을 출력</title>
 <%!
       String keyword[]={"Expression","ScriptLet","Declaration","comment"};
 %>
</head>
<body>
<center>
<table border="1" width="200">
<%
        for(int i=0;i<keyword.length;i++){ %>
        	<tr><td><%=i%></td>
        	       <td><%=keyword[i]%></td>
        	</tr>
<%  }  %>
</table>
</center>
</body>
</html>






