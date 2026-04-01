<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  String CONTROL=request.getParameter("CONTROL");
  String PAGENUM=request.getParameter("PAGENUM");
  //왼쪽 메뉴
  String left="/module/"+CONTROL+"Left.jsp";// /module/introLeft.jsp
  //본문 내용
  String content="/view/"+CONTROL+"_"+PAGENUM+".jsp";// /view/intro_01.jsp
  System.out.println("left=>"+left+",content=>"+content);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>간단하게 정리</title>
</head>
<body>
<center>
 <table width="800" height="600" border="1" cellpadding="2" cellspacing="0">
 <!-- 상단메뉴(top.jsp) -->
    <tr height="50">
      <td colspan="2">
      <jsp:include page="/module/top.jsp" flush="false" />
      </td>
    </tr>
   <!-- 왼쪽메뉴,가운데 -->
   <tr height="500">
   <td width="150" valign="top">
      <jsp:include page="<%=left%>" flush="false" />
   </td>
   <td width="650" valign="top">
     <jsp:include page="<%=content%>" flush="false" />
   </td>
   </tr>
   <!-- 하단메뉴 -->
   <tr height="50">
      <td colspan="2">
      <jsp:include page="/module/bottom.jsp" flush="false" />
      </td>
    </tr>
 </table>
 </center>
</body>
</html>





