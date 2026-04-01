<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실제로 처리</title>
</head>
<body>
<%
      request.setCharacterEncoding("utf-8");
      String sports=request.getParameter("sports");
      String season=request.getParameter("season");
      //서버->접속한 클라이언트구분(세션id)->번호표
      //session.setAttribute("idKey",id);->session.getAttribute(idKey(키명))
      String id=(String)session.getAttribute("idKey");//Object->String(계정id)
      String sessionid=session.getId();//브라우저 확인
      int interval=session.getMaxInactiveInterval();//유지시간
      if(id!=null){ //현재 계정으로 로그인했다면
%>
      <b><%=id%></b>님이 좋아하시는 스포츠와 계절은<p>
      <b><%=sports %></b>과<b><%=season%></b>입니다.<p>
      세션 id:<%=sessionid%><p>
      세션유지시간:<%=interval%>초<p>
     <%
            session.invalidate();//연결해제(세션객체 정보를 자동으로 삭제)
      }else{  //id==null(즉 로그인 한적없거나 연결시간이 초과된 경우)
    	  out.println("세션의 연결시간이 초과되었습니다.다시 로그인해주세요");
      }
     %>
</body>
</html>







