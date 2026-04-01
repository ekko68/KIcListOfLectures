<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청을 받아서 처리해주는 페이지</title>
<%!
       String msg;//전달받은 값이 영어->한글로 바꿔서 출력(색깔)
%>
<%
       request.setCharacterEncoding("utf-8");
%>
<%
//요청을 받아서 처리해주는 구문->request 내장객체(매개변수),response(응답객체)
            //한글처리 (post방식)
            //request.setCharacterEncoding("utf-8");
            //---------------------------------------------
            String name=request.getParameter("name");
            String color=request.getParameter("color");
            System.out.println("name=>"+name+",color="+color);
            //equals()->대소문자 구분O
       if(color.equals("blue")){
    	   msg="파란색";
       }else if(color.equals("red")){
    	   msg="붉은색";
       }else if(color.equals("orange")){
    	   msg="오렌지색";
       }else{
    	   color="white";
    	   msg="기타색(흰색)";
       }
%>
</head>
<body bgcolor="<%=color%>">
 <%=name %>님이 좋아하는 색깔은? <%=msg%> 입니다.
</body>
</html>






