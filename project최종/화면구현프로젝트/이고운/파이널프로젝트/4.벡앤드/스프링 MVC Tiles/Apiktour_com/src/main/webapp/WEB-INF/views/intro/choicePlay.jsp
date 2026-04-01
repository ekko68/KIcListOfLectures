<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script	src='https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.1/lodash.min.js'></script>
	
	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

	<!--  -->
	<script src="<c:url value='/resources/js/intro/jquery-ui-slider-pips.js' />"></script>
	<link href="<c:url value='/resources/css/intro/choicePlay_slider.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/intro/choicePlay.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/intro/jquery_ui.css' />" rel="stylesheet"></link>
	
	<meta charset="UTF-8">
	<title>쉴래? 놀래?</title>
	
	<script type="text/javascript"> <!-- 값을 전달을 위한 명령어 시작  -->
	$(function(){		
		/* 버튼 클릭시 페이지 이동 및 값 전달 */
		$('#saveBtn').click(function(){
			var playLevel=$( "#flat-slider-vertical-1" ).slider( "value" );		
			$('#level').val(playLevel);
			//alert($('#sliderVal').val());	
			return true;
		})
	});	
	</script> <!-- 명령어 끝  -->	
</head>

<body>

<%
 	request.setCharacterEncoding("utf-8");
%>
<div id="wrapp">
	<form method="post" action="playPro.do">
		<div id="container">
			<p>
				<label for="amount">현재,<br> 당신의<br> 에너지을<br>	선택하세요.</label>
			</p>
			<div class="stuff">
				<main><div id="flat-slider-vertical-1"></div></main>
				<input type="hidden" name="mode" id="mode" value="${ mode}">
				<input type="hidden" name="level" value="" id="level">
			</div>

			<!--여기까지-->
			<!--<div id="slider"></div>-->
			<button id="saveBtn" onclick="location.href='playPro.jsp'"><p>다음</p></button>
		</div>
	</form>
		<!-- container -->
</div>	
	<!-- wrap-->
</body>

<!-- 슬라이더 스크립트-->
<script>
    $("#flat-slider-vertical-1")
        .slider({
            max: 5,
            min: 0,
            range: "min",
            value: 3,
            orientation: "vertical"
        });

    $("#flat-slider-vertical-1")
        .slider("pips", {
            first: "pip",
            last: "pip"
        })
    .slider("float");
    $( "#level" ).val($( "#flat-slider-vertical-1" ).slider( "value" ));      
</script>

</html>