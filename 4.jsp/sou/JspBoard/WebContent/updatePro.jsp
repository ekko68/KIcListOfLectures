<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="lys.board.BoardDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    //수정할 목적 ->updatePro.jsp?num=?&pageNum=?
     request.setCharacterEncoding("utf-8");		
     //BoardDAO=>updateArticle(article),BoardDTO
%>
<jsp:useBean id="article"   class="lys.board.BoardDTO" />
<jsp:setProperty name="article" property="*" />
<%
    String pageNum=request.getParameter("pageNum");//필드 X
    BoardDAO dbPro=new BoardDAO();
    int check=dbPro.updateArticle(article);//암호찾고->웹상의 암호 체크
    if(check==1){//글수정이 성공했다면
    	//response.sendRedirect("list.jsp?pageNum=?)
%>
<meta http-equiv="Refresh" 
            content="0;url=list.jsp?pageNum=<%=pageNum%>">
<%}else { %>
   <script>
           alert("비밀번호가 맞지않습니다.\n다시 확인요망!")
           history.go(-1)
   </script>
<%} %>






