<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

%>
<head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>indexControl</title>
        <script>
        </script>
        <style type="text/css">        
        </style>
    </head>
    <body>    

    <jsp:forward page="/main.do">
		<jsp:param name="CONTROL" value="${CONTROL}" />
	</jsp:forward>
    </body>
</html>