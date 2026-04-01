<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/intro/rest.css">

	
	<meta charset="UTF-8">
	<title>쉴래? 놀래?</title>
	
<script type="text/javascript">
$( function() {
    $('#rsBtn').click(function(){
    	var level=$( "#level" ).val();
		var mode=$('#mode').val();
		//var count=$('#count').val();

		$('#parameter').attr('action','${pageContext.request.contextPath}/resultcos.do').submit();
		return true;//전송이 가능하게 설정		
	})
});
</script>
</head>

<body>
<%
 	request.setCharacterEncoding("utf-8");
	String count=request.getParameter("level");
%>
    <div>
		<div class="contain">
			<div class="textOne"><%=count %>...</div>
		</div>

		<form id="parameter"  method="post">
		<div id="container2">
			<span class="textTwo">Level 을</span><br> 
			<span class="textThree">선택하셨습니다.</span>
		</div>
		<!-- container -->
		<button id="rsBtn" onclick="location.href='result.jsp'">다음</button>
		<input type="hidden" name="mode" id="mode" value="${ mode}">
	   <input type="hidden" name="level"  id="level"  value="${ level}">
	   </form>
	</div> <!-- wrap-->
 </body>

</html>