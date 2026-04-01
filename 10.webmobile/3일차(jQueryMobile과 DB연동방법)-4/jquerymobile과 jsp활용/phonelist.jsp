<%@ page language = "java" contentType = "text/html; charset=UTF-8"  pageEncoding = "UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name = "viewport" content = "width=device-width, initial-scale=1.0,
 								 maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>데이터베이스 연동</title>
<link rel = "stylesheet" href = "../mobile/jquery.mobile-1.4.5.min.css">
<script type="text/javascript" src = "../mobile/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src = "../mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	/*
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbId = "scott";
	String dbPass = "tiger"; 
	*/
	
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
	String dbId = "root";
	String dbPass = "1234";
	
	try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("org.gjt.mm.mysql.Driver");
		con = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		String sql = "select * from phone order by productnum desc";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>
<div data-role = "page">
	<div data-role = "header">
		<h1>휴대폰 목록</h1>
	</div>
	<div data-role = "content">
		<ul data-role = "listview">
			<%
				while(rs.next()){
					int productnum = rs.getInt("productnum");
					String company = rs.getString("company");
					int price = rs.getInt("price");
					String image = rs.getString("image");
			%>
			<li>
				<a href = "phonedetail.jsp?pno=<%=productnum%>">
					<img src = "../image/<%=image %>" width = "80" height = "80">
					<h1><%=company %></h1>
				</a>
			</li>			
			<%
				}
			%>
		</ul>
	</div>
	<div data-role = "footer">
		<h1>footer</h1>
	</div>
</div>
<%		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!= null){try{rs.close();}catch(SQLException e){};}
		if(pstmt!= null){try{pstmt.close();}catch(SQLException e){};}
		if(con!= null){try{con.close();}catch(SQLException e){};}
	}
%>
</body>
</html>

































