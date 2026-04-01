<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.MemberDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
         request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mem" class="hewon.MemberDTO" />
<jsp:setProperty name="mem" property="*" />
<%
   String mem_id=request.getParameter("mem_id");
   System.out.println("MemberUpdateProc.jsp의 mem_id=>"+mem_id);
   
   MemberDAO memMgr=new MemberDAO();//수정해주는 메서드를 호출
   boolean check=memMgr.memberUpdate(mem);
   System.out.println("MemberUpdate.jsp의 회원수정유무(check)=>"+check);
%>
<%
   if(check){ //수정에 성공했다면
%>
     <script>
         alert("성공적으로 수정되었습니다.")
         location.href="Login.jsp"
     </script>   
  <% }else{ %>
	   <script>
         alert("수정도중 에러가 발생되었습니다.")
         history.back();
     </script>
<%    }  %>










