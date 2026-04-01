<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
 <script>
        function test(){
        	//1.불러올 문서명 2타이틀 3.창의옵션(left,top,width,height)
        	window.open('/ServletTest/test/Hello','w','left=300,top=200,width=400,height=200')
        }
 </script>
</head>
<body onload="test()">
   <h2>Welcome to JspStudy Site!</h2>
</body>
</html>


