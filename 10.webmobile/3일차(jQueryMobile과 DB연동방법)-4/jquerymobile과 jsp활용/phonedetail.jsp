<%@ page language = "java" contentType = "text/html; charset=UTF-8"  pageEncoding = "UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name = "viewport" content = "width=device-width, initial-scale=1.0,
 								 maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>데이터베이스 상세</title>
<link rel = "stylesheet" href = "../mobile/jquery.mobile-1.4.5.min.css">
<style type="text/css">
	.img_phone{
		width:100;
		margin:0 15px 0 0;
		float:left;
	}
	.content_phone{
		font-size:13pt;
	}
</style>
<script type="text/javascript" src = "../mobile/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src = "../mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<%

	int pno=Integer.parseInt(request.getParameter("pno"));
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/* String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
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
		String sql = "select * from phone where productnum=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, pno);
		
		rs = pstmt.executeQuery();
	
%>
<div data-role = "page">
	<div data-role = "header">
		<h1>휴대폰 상세</h1>
	</div>
	<div data-role = "content">
<%
	if(rs.next()){
		int productnum = rs.getInt("productnum");//상품번호
		String model = rs.getString("model");//모델명
		String company = rs.getString("company");//회사
		int price = rs.getInt("price");//가격
		String color = rs.getString("color");//색깔
		String image = rs.getString("image");//폰의 이미지
%>
	<div class = "image_phone">
		<img src = "../image/<%=image%>">
	</div>
	<div class = "content_phone">
		<p>모델명 : <%=model %> </p>
		<p>제조사 : <%=company %> </p>
		<p>상품가격 : <%=price %> </p>
		<p>색상 : <%=color %> </p>
	</div>
<%
	}
%>
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

































