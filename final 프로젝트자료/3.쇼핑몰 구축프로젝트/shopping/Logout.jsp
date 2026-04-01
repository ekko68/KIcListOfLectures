<%@ page contentType="text/html;charset=euc-kr" %>
<%
    //session.removeAttribute("idKey");
    session.invalidate();
%>
<script>
   alert('로그아웃 되었습니다.');
   location.href("Login.jsp"); 
</script>
   
