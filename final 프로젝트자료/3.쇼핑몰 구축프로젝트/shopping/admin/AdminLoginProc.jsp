<%@ page contentType="text/html;charset=EUC-KR" %>
<jsp:useBean id="memMgr" class="hewon.MemberMgr" />
<%
	String admin_id = request.getParameter("admin_id");
	String admin_passwd = request.getParameter("admin_passwd");
	boolean adminCheck = memMgr.adminCheck(admin_id, admin_passwd);
    if(adminCheck) {
	    session.setAttribute("adminKey", admin_id);
%>

   <script>
   location.href="Index.jsp";
   </script>

<%}else{%>

   <script>
   alert("입력한 정보가 정확하지 않습니다.");
   location.href="AdminLogin.jsp";
   </script>

<%}%>