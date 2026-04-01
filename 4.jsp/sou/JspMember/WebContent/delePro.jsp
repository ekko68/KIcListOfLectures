<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.MemberDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
   //<%-- action="deletePro.jsp?mem_id=?
   String mem_id=request.getParameter("mem_id");
   String passwd=request.getParameter("passwd");
   System.out.println("deleteProc.jsp의 mem_id=>"+mem_id);
   System.out.println("deleteProc.jsp의 passwd=>"+passwd);
   
   MemberDAO memMgr=new MemberDAO();//삭제시켜주는 메서드를 호출
   int check=memMgr.deleteMember(mem_id,passwd);
   System.out.println("deletePro.jsp의 회원삭제유무(check)=>"+check);
%>
<%
   if(check==1){ //삭제에 성공했다면
	    session.invalidate();//세션해제
%>
     <script>
         alert('<%=mem_id%>님 성공적으로 탈퇴처리 되었습니다.')
         location.href="Login.jsp"
     </script>   
  <% }else{ %>
	   <script>
         alert("비밀번호가 틀립니다.\n 다시 한번 확인하시기바랍니다.")
         history.go(-1);//history.back();
     </script>
<%    }  %>










