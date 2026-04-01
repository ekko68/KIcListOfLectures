<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="memMgr" class="hewon.MemberDAO" />
<%
         String mem_id=request.getParameter("mem_id");
         String mem_passwd=request.getParameter("mem_passwd");
         System.out.println("mem_id=>"+mem_id
        		                      +",mem_passwd=>"+mem_passwd);
         //MemberDAO memMgr=new MemberDAO();
         //인증 메서드호출(loginCheck)
         boolean check=memMgr.loginCheck(mem_id, mem_passwd);
%>
<%
      //check->LoginSuccess.jsp(인증화면) ,LogError.jsp(에러메세지)
      if(check){//인증성공
    	  session.setAttribute("idKey",mem_id);//"idkey"
          //response.sendRedirect("LoginSuccess.jsp");
    	  response.sendRedirect("Login.jsp");
      }else{
    	  response.sendRedirect("LogError.jsp");
      }
%>







