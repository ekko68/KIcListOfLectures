<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹상에서의 연결방법</title>
</head>
<body>
   <h3>JDBC_Oracle 접속방법</h3>
   <%
      String url="jdbc:oracle:thin:@localhost:1521:orcl";
      Connection con=null;
      Statement stmt=null;
      PreparedStatement pstmt=null;
      Statement stmt2=null;
      ResultSet rs=null;//select
      String sql="";//SQL구문을 저장
      
      try{
    	  //1.드라이버 메모리에 로드
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	  //2.Connection객체를 얻어오기
    	  con=DriverManager.getConnection(url,"test1","t1234");//scott,tiger
    	  System.out.println("con=>"+con);
    	  //3.테이블을 생성->create table->stmt
    	  stmt=con.createStatement();//반환형
    	  sql="create table MyTest(name varchar2(20),age number)";
    	  stmt.executeUpdate(sql);
    	  System.out.println("MyTest 테이블 생성 OK!");
    	  //2.insert->pstmt
    	  pstmt=con.prepareStatement("insert into MyTest values(?,?)");
    	  //setString,setInt,setDouble,,,(?의순서,입력할값)
    	  pstmt.setString(1,"Lee");//request.getParameter("name");
    	  pstmt.setInt(2,34);
    	  pstmt.execute();//executeUpdate()
    	  //3.select->필드별로 출력하자
    	  stmt2=con.createStatement();
    	  String sql2="select * from MyTest";
    	  //4.ResultSet 객체 필요
    	  rs=stmt2.executeQuery(sql2);
   %>
    <table border="1" cellspacing="0" cellpadding="0">
       <tr bgcolor="pink">
          <th>name</th>
          <th>age</th>
       </tr>
       <%
            while(rs.next()){ //이동시킬 레코드가 존재한다면
       %>
       <tr>
           <td><%=rs.getString(1) %></td>
           <td><%=rs.getInt(2) %></td>
       </tr>
   <%
            }
         rs.close(); //con->stmt,pstmt,stmt2,rs
         stmt2.close();
         pstmt.close();
         stmt.close();
         con.close();
      }catch(Exception e){
    	  System.out.println("DB연결실패=>"+e);
      }
   %>
    </table>
</body>
</html>



