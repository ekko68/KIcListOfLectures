<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="lys.board.*,java.util.*,java.text.SimpleDateFormat" %>
<%!
      int pageSize=10;//numPerPage->페이지당 보여주는 게시물수
      int blockSize=10;//pagePerBlock->블럭당 보여주는 페이지수
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
   //게시판을 맨 처음 실행시키면 무조건 1페이지 부터 출력
   String pageNum=request.getParameter("pageNum");
   if(pageNum==null){
	   pageNum=" ";//default
   }
   int currentPage=Integer.parseInt(pageNum);//현재페이지(정수)->계산
   //시작레코드번호->limit ?,?
    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
   int startRow=(currentPage-1)*pageSize+1;
   int endRow=currentPage*pageSize;//1*10,2*10=20,3*10=30(레코드갯수 X)
   int count=0;//총레코드수
   int number=0;//beginPerPage->페이지별 시작하는 맨 처음에 나오는 게시물번호
   List articleList=null;//화면에 출력할 레코드데이터
   
   BoardDAO dbPro=new BoardDAO();
   count=dbPro.getArticleCount();
   System.out.println("현재 레코드수(count)=>"+count);
   if(count > 0){
	   articleList=dbPro.getArticles(startRow, pageSize);//10개씩
   }
   //            122-(1-1)*10=122,121,120,119
   //            122-(2-1)*10=110,109,108,,,
   number=count-(currentPage-1)*pageSize;
   System.out.println("페이지별 number=>"+number);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#e0ffff">
<center><b>글목록(전체 글:<%=count%>)</b>
<table width="700">
<tr>
    <td align="right" bgcolor="#b0e0e6">
    <a href="writeForm.jsp">글쓰기</a>
    </td>
</table>
<%
   if(count==0){
%>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
<tr>
       <td align="center">게시판에 저장된 글이 없습니다.</td>
</tr>
</table>
<%}else { %>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="#b0e0e6"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
    <!-- 실제적으로 레코드를 출력시켜주는 부분 -->
    <%
       for(int i=0;i<articleList.size();i++){
          BoardDTO article=(BoardDTO)articleList.get(i);//vecList.elementAt(i) ,vecList.get(i);
    %>
   <tr height="30"><!-- 하나씩 감소하면서 출력하는 게시물번호 -->
    <td align="center"  width="50" ><%=number-- %></td>
    <td  width="250" >
	<!-- 답변글인 경우 먼저 답변이미지를 부착시키는 부분 -->
	<%
	     int wid=0;//공백을 계산하기위한 변수선언
	     if(article.getRe_level() >0){ //답변글이라면
	       	 wid=7*(article.getRe_level());
	%>
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	  <img src="images/re.gif">
	  <%}else{ %>
	  <img src="images/level.gif" width="<%=wid%>" height="16">    
	  <%} %>
	        
      <a href="content.jsp?num=3&pageNum=1">
           게시판연습</a> 
         <img src="images/hot.gif" border="0"  height="16"> </td>
    <td align="center"  width="100"> 
       <a href="mailto:nup49rok1@empal.com">이연수</a></td>
    <td align="center"  width="150">2006/12/26</td>
    <td align="center"  width="50">3</td>
    <td align="center" width="100" >127.0.0.1</td>
  </tr>
      <%  } //for %>
</table>
<% } //else %>
<%
    //페이징 처리

%>
</center>
</body>
</html>






