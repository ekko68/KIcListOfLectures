<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문자열,숫자를 입력받아 처리</title>
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
   //내장객체->request(요청),response(처리->재전송),,,8개
   String msg=request.getParameter("msg");//"안녕하세요?"
   int number=Integer.parseInt(request.getParameter("number"));//"3"->3
   //Integer.parseInt("3")->3=>"3"->String.valueOf(3)
   //Double.parseDouble("3.5")->3.5
    System.out.println("msg="+msg+",number=>"+number);
   int count=0;//반복할 횟수 저장
   while(number>count) {   //3>1,2,3
%>
 <b><%=msg%></b><br>
 <% 
        count++;
   }
 %>
</body>
</html>



