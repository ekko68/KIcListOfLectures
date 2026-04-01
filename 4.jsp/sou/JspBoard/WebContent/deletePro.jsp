<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="lys.board.BoardDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    int num=Integer.parseInt(request.getParameter("num"));
    String passwd=request.getParameter("passwd");
    String pageNum=request.getParameter("pageNum");//필드 X
    System.out.println
    ("num=>"+num+",passwd=>"+passwd+",pageNum="+pageNum);
    
    BoardDAO dbPro=new BoardDAO();
    int check=dbPro.deleteArticle(num,passwd);//암호찾고->웹상의 암호 체크
    if(check==1){//글삭제가 성공했다면
%>
<meta http-equiv="Refresh" 
            content="0;url=list.jsp?pageNum=<%=pageNum%>">
<%}else { %>
   <script>
           alert("비밀번호가 맞지않습니다.\n다시 확인요망!")
           history.go(-1)
   </script>
<%} %>






