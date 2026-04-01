<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
	@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

	body{
		 font-family:'Jeju Gothic', cursive;
		 margin:0;
		 padding:0;
	}
	
	header{
		position:fixed;
		top:0;
		left:0;
		z-index:9999;
		display:block;
		width:100%;
		background:rgb(0,0,0,1); 
		height: 7%;
		border-bottom:1px solid rgba(255,255,255,0.3);
	}
	
	nav > ul{
		list-style:none;
		margin:0;
	}
	
	nav > ul > li{
		position:relative;
		display:block;
		float:left;
		width:20%;
		height:100%;
	}
	nav > ul > li > img{
		display:block;
		margin-bottom:15px;
	}
	nav > ul > li > a{
		display:block;
		color:#eee;
		text-decoration:none;
		padding-top:27px;
		font-weight:bold;
		font-size:1.0em;
		text-align:center;
	}
	.sub-menu{
		display:none; 
		position:absolute; 
		list-style:none;
		top:60px;
		right:80px;
		background: rgb(0,0,0);
		box-shadow: 0 2px 2px 0 #eee;
	}
	
	nav > ul > li:hover .sub-menu,
	nav > ul > li > a:hover .sub-menu{
		display:block;
	}
	
	.sub-menu > li{
		display:inline-block;
		text-align:center;
	}
	section{
		
	}
	
	.img-group {		
		width:100%;
		height:100%;
    	overflow:hidden;
	}
	
	.img-group > img{
		display:block;	
		position:absolute;
		top:0;
		left:0;
		opacity:1;
		width:100%;
		height:120%;
	}
	
	.add{
		display:block;
		position:absolute;
		z-index:99999;
		color:#fff;
		top:25%;
		left:42%;
	}
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	var duration = 20; // duration in seconds
	var fadeAmount = 0.3; // fade duration amount relative to the time the image is visible
	
	$(document).ready(function (){
	  var images = $(".img-group  img");
 	  var numImages =images.length;  
 	 
	  /* var durationMs = duration * 1000; */ //20000
	  var durationMs =20000;/* 20초동안 */ 
	  var imageTime = durationMs / numImages; /* the image is visible 이미지하나당 애니메이션 시간 5000(5s)*/
	  var fadeTime = imageTime * fadeAmount; /*  1500 이미지 하나당 감추는시간 */
	  var visibleTime = imageTime  - (fadeTime * 2);// time the image is visible with opacity == 1  2000 
	  var animDelay = visibleTime * (numImages - 1) + fadeTime * (numImages - 2); // animation delay/offset for a single image 9000
	  
	  images.each( function( index, element ){ //각 이미지별로 설정
	    if(index != 0){
	      $(element).css("opacity","0"); //첫번째 이미지가 아니라면 (2번째 이미지부터) 투명하게 만들고 시작함
	      setTimeout(function(){ //투명도가 적용된 상태에서 애니메이션적용
	        doAnimationLoop(element,fadeTime, visibleTime, fadeTime, animDelay);
	      },visibleTime*index + fadeTime*(index-1)); //2번째이미지부터 보여지는시간 사라지는 시간 위치값별로 구해서 적용
	      //2번째 이미지면  1번째 이미지 애니메이션이 끝나면적용, 3번째 이미지면,  1, 2번째 이미지 애니메이션 끝나면 적용
	    }else{
	      setTimeout(function(){
	        $(element).animate({opacity:0},fadeTime, function(){
	          setTimeout(function(){
	            doAnimationLoop(element,fadeTime, visibleTime, fadeTime, animDelay);
	          },animDelay )
	        });
	      },visibleTime);
	    }
	  });
	});
	
	// creates a animation loop
	function doAnimationLoop(element, fadeInTime, visibleTime, fadeOutTime, pauseTime){
	  fadeInOut(element,fadeInTime, visibleTime, fadeOutTime ,function(){
	    setTimeout(function(){
	      doAnimationLoop(element, fadeInTime, visibleTime, fadeOutTime, pauseTime);
	    },pauseTime);
	  });
	}
	
	// shorthand for in- and out-fading
	function fadeInOut( element, fadeIn, visible, fadeOut, onComplete){
	  return $(element).animate( {opacity:1}, fadeIn ).delay( visible ).animate({opacity:0}, fadeOut, onComplete);
	}
</script>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><img src="Logo.png" width="150" height="100"></li>
				<li><a href="#">About Amigo</a></li>
				<li><a href="#">동호회</a></li>
				<li><a href="#">자유게시판</a>
					<ul class="sub-menu">
						<li><a href="#">자유게시판1</a></li>
						<li><a href="#">자유게시판2</a></li>
					</ul>
				</li>
				<li><a href="#">고객센터</a>
					<ul class="sub-menu">
						<li><a href="#">FAQ</a></li>
						<li><a href="#">1:1 질문</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</header>
	<section>
		<div class="img-group">
			<img src="start.png"><!-- <span class="add">환영합니다</span> -->
			<img src="car.png">
			<img src="ski.png">
			<img src="end.png">
		</div>
		
<!-- 		<article>
			테스트용
		</article> -->
	</section>
	
</body>
</html>