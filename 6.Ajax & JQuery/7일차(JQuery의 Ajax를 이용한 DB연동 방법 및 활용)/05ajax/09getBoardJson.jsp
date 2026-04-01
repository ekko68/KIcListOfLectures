<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*,lys.board.*" %>
[
 <%
   Connection con=null;
   PreparedStatement pstmt=null;
   ResultSet rs=null;
   DBConnectionMgr pool=null;
   String sql="";
   
   try{
	   pool=DBConnectionMgr.getInstance();
	   System.out.println("pool=>"+pool);
	   con=pool.getConnection();
	   System.out.println("con=>"+con);
	   sql="select * from board order by num asc";
	   pstmt=con.prepareStatement(sql);
	   rs=pstmt.executeQuery();
	   while(rs.next()){
		   int num=rs.getInt("num");
		   String writer=rs.getString("writer");
		   String subject=rs.getString("subject");
		   String content=rs.getString("content");
		   //[ {num:1,writer:'홍길동',~  },{num:2,writer:'임시']
		   if(rs.getRow()>1) {//한개이상이라면
			   out.print(",");
		   }%>
		 {
		  "num":<%=num%>,
		  "writer":<%=writer%>,
		  "subject":<%=subject%>,
		  "content":<%=content%>
		 }  
 <%	      
	   }//while
   }catch(Exception e){System.out.println("getBoardJson.jsp에러유발="+e);
   }finally{
	   pool.freeConnection(con, pstmt, rs);
   }
 %>
]







