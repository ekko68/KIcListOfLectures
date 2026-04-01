<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags" %>               
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>  
 <!Doctype html> 
 
<script>
 // 현재 스크롤바의 위치를 저장하는 변수 (px)
        var currentScrollTop = 0;
        //var lastScrollTop = 0;
             
        // 비동기식 jQuery이므로 window load 후 jQuery를 실행해야 함
        window.onload = function() {
            // 새로고침 했을 경우를 대비한 메소드 실행
            scrollController();
             
            // 스크롤을 하는 경우에만 실행됨
            $(window).on('scroll', function() {
               scrollController();
           });
       }
        
      function scrollController() {
          //var st = $(this).scrollTop();
          var headerHeight = $('.hd_default').outerHeight();
          currentScrollTop = $(this).scrollTop();
          var hd = (headerHeight-10);
          
          
          if ( currentScrollTop > headerHeight ) {
              $('#head').removeClass('hd_default').addClass('hd_scroll');
        }
        else {            $('#head').removeClass('hd_scroll').addClass('hd_default');
        }          
      }  
    
      
      
</script>

<header>
<span class="back"><a href="javascript:history.back()">◀</a></span>
<div id="head" class="hd_default">    
    <div class="img_wrap"><img class="blur" src="${pageContext.request.contextPath}/resources/upload/img/123.jpg" alt="img"></div>  	
    <div class="title flexCenter">
    <span class="">${type } Lv.${level}</span>
    <h1>${cosname }</h1>
    </div>
</div>
</header>
<div class="content_wrap flexCenter">

	<div class="sumery">
	<span>여행지1</span>
	<span class="line"></span>
	<span>여행지2</span>
	<span  class="line"></span>
	<span>여행지1</span>
	</div>

	
<c:if test="${count==0}">
	<article class="felxCenter">
        <h3>여행지명이 없습니다.</h3>
        <p class="sumery_memo flexCenter">여행지 정보가 없습니다.</p>
        <p class="atc_img mgauto flexCenter">이미지가 없습니다.</p>
        <div class="atc_api">         
			여행지 정보가 없습니다.
		</div>
	</article>
	</c:if>
	
<c:forEach var="cosinfo" items="${cosnumList }">
	<article class="felxCenter">
        <h3>${cosinfo.getLocname() }</h3>
        <p class="sumery_memo flexCenter">${cosinfo.getContents() }</p>
        <p class="atc_img mgauto flexCenter">
        	<img  src="${pageContext.request.contextPath}/resources/upload/img/${cosinfo.getImgname()}" alt="img">
        </p>
        <div class="atc_api">
        <table class="api_summery">
			<tr>
				<th class="api_th">주소</th>
				<td class="api_td">${cosinfo.getAddress()}</td>
			</tr>
			<tr>
				<th class="api_th">연락처</th>
				<td class="api_td">${cosinfo.getTel()}</td>
			</tr>
			<tr>
				<th class="api_th">운영시간</th>
				<td class="api_td">${cosinfo.getTime()}</td>
			</tr>
		</table>
		</div>
        <hr>
	</article>
</c:forEach>
    
</div>




 
