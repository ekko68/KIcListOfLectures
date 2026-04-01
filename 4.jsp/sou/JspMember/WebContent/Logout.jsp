<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //세션연결 상태-->바로 종료
   session.invalidate();
%>
<script>
     alert('정상적으로 로그아웃 되었습니다.')
     location.href="Login.jsp"
</script>