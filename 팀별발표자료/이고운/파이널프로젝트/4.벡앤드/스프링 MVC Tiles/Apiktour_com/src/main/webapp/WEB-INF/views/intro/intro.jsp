<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<script>

$(document).ready(function() {
	alert('hihi')
	$(document).bind('touchstart', function(e) {

		//alert('터치가 시작되었어요');

		e.preventDefault();	//	이벤트취소

	});

	$(document).bind('touchmove', function(e) {

		//	jQuery 이벤트 객체를 자바스크립트 표준 이벤트 객체로 바꾸기

		//	이유는 jQuery 에서 자바 스크립트

		var event = e.originalEvent;

		alert('touch 이벤트 중입니다.'); 

		//	div에 터치한 좌표값 넣기
		parallaxScroll(event);
		nextItem()
		event.preventDefault();

	});

	$(document).bind('touchend', function(e) {
		alert("터치이벤트가 종료되었어요"); 

	});

	
});

</script>


<body>

<%
 	request.setCharacterEncoding("utf-8");
%>
	<div id="wrap">
		<div id="container">
			<!-- 1번째 인트로 부분 -->
			<div id="slide01" class="background">
				<div class="content-wrapper">
					<h1 class="content-title">
						<p class="bgimg">
							<img src="${pageContext.request.contextPath}/resources/images/icon/balloon.png">
						</p>
						<p class="textTitle">
							나는<br>아무것도<br>하기싫다...
						</p>
					</h1>
					<p class="content-p"></p>
				</div>
			</div>

			<!-- 2번째 인트로 부분 -->
			<div id="slide02" class="background">
				<div class="content-wrapper2">
					<section class="flexTxt"> 
						<figure class="reatSection">
							<img src="${pageContext.request.contextPath}/resources/images/icon/rest_ring.png" class="restRing" alt="restRing" /> 
							<img src="${pageContext.request.contextPath}/resources/images/icon/rest.png" class="rest" alt="rest" /> 
						</figure> 
						<figure class="restafter"> 
							<a href="choiceRest.do" class="clickRest"></a> 
							<img src="${pageContext.request.contextPath}/resources/images/bg/rest_change.jpg" class="change" alt="change" />
						</figure> 
					</section>

					<section class="flexTxt"> 
						<figure class="playSection">
							<img src="${pageContext.request.contextPath}/resources/images/icon/play_ring.png" class="playRing" alt="playRing" /> 
							<img src="${pageContext.request.contextPath}/resources/images/icon/play.png"	class="play" alt="play" /> 
						</figure> 
						<figure class="playafter"> 
							<a href="choicePlay.do" class="clickPlay"></a> 
							<img	src="${pageContext.request.contextPath}/resources/images/bg/play_change.jpg" class="change" alt="change" />
						</figure> 
					</section>
				</div>
			</div>
		</div>
		<!-- container -->
	</div>
</body>

<script>    
	$(".reatSection").mousemove(function(){
	    setTimeout(function(){
	        $(".restRing").hide();
	        $(".restSelect").hide();
	        $(".restafter").css("display","block");
	    },1050);
	});
	$("section:nth-child(2)").mousemove(function(){
	    $(".restafter").hide();
	    $(".restRing").show();
	});
    
	$(".playSection").mousemove(function(){
	    setTimeout(function(){
	        $(".playRing").hide();
	        $(".playSelect").hide();
	        $(".playafter").css("display","block");
	    },1050);    
	}); 
	
	$("section:first-child").mousemove(function(){
	    $(".playafter").hide();
	    $(".playRing").show();
	});    
</script>

</html>