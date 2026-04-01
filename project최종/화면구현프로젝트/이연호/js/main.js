/**
 * @author Timothy Lee
 * @date 17.05.26
 * main용 js
 */
jQuery(function(){
	/*
	jQuery('body').mousewheel(function(event) {
	    console.log(event.deltaX, event.deltaY, event.deltaFactor);
	    event.preventDefault();
	    // pc화면 동작
	    if(event.deltaY > 0){ // 상단 방향 스크롤
	    	if(jQuery(window).scrollTop() <=889){
	    		scrollMnu(".board");
	    	} else if(jQuery(window).scrollTop() <=547){
	    		scrollMnu("#mfmContent");
	    	}
	    } else { // 하단방향 스크롤
	    	if(jQuery(window).scrollTop() >=889){
	    		scrollMnu(".products");
	    	} else if(jQuery(window).scrollTop() >=547){
	    		scrollMnu(".board");
	    	}	    	
	    }
	});
	*/
	
	// mouse wheel 동작시 페이지 블록 이동
	jQuery('body').on('mousewheel',function(event,delta){
		if($('html').is(':animated') || $('body').is(':animated')) return false;
		/*
		if(jQuery(window).width() > 1024){ // 일반 PC해상도
			if(event.deltaY < 0){ // 하단방향 스크롤
		    	if(jQuery(window).scrollTop() < 547){
		    		scrollMnu(".board");
		    		event.preventDefault();
		    	} else if((jQuery(window).scrollTop() >= 547) && (jQuery(window).scrollTop() < 889)){
		    		scrollMnu(".products");
		    		event.preventDefault();
		    	} else {
		    		scrollMnu("footer");
		    		event.preventDefault(); // 화면 떨림 방지
		    	}
		    } else { // 상단방향 스크롤
		    	if(jQuery(window).scrollTop() > 889){
		    		scrollMnu(".products");
		    		event.preventDefault();
		    	} else if((jQuery(window).scrollTop() > 547) && (jQuery(window).scrollTop() <= 889)){
		    		scrollMnu(".board");
		    		event.preventDefault();
		    	} else {
		    		scrollMnu("#mfmContent");
		    		event.preventDefault(); // 화면 떨림 방지
		    	}
		    }		
		}
		*/
//	    event.preventDefault();
//	    console.log(event.deltaX, event.deltaY, event.deltaFactor);
//	    jQuery("body").off('mousewheel', false);
	});
	
//	console.log((jQuery("#main_morning").bind("networkState")).networkState);
	
	/* 메뉴 이동 */
	function scrollMnu(obj){
		var nMoreScroll = (jQuery(window).width() < 760) ? 150 : 80; // 모바일 or tab/pc 해당도에 따른 메뉴이동정도
		jQuery("html, body").stop(true).animate({ scrollTop: jQuery(obj).offset().top - nMoreScroll }, 500,'swing');		
	}
	
	// 메뉴 핸들러
	jQuery("#mfmHead").on('click', '.mnuHome', function(){
		scrollMnu("#mfmContent");
	}).on('click', '.mnuBoard', function(){
		scrollMnu(".board");
	}).on('click', '.mnuOrder', function(){
		scrollMnu(".products");
	}).on('click', '.mnuBasket', function(){
		console.log('4');
	}).on('click', '.mnuLogin', function(){
		console.log('5');		
	}).on('click', '.mnuJoin', function(){
		console.log('6');
	});
		
	// mobile 해상도
	if(jQuery(window).width() < 760){
		jQuery("#mfmHead").on("click", "li", function(){
			jQuery("#mfmGnb").hide();
			jQuery("#mnuMobile").removeClass("mnuMobileClose");
			jQuery("#mnuMobile").addClass("mnuMobileOpen");
		});
	}
	
	jQuery("#mfmHead").on("click", "#mnuMobile", function(){
		if(jQuery("#mfmGnb").css("display") == "none"){
			jQuery("#mfmGnb").slideDown();
		}else{
			jQuery("#mfmGnb").slideUp();
		}
		if(jQuery(this).hasClass("mnuMobileOpen")){
			jQuery(this).removeClass("mnuMobileOpen");
			jQuery(this).addClass("mnuMobileClose");
		} else {
			jQuery(this).removeClass("mnuMobileClose");
			jQuery(this).addClass("mnuMobileOpen");
		}		
	});
	
	// 모바일 화면에서 동영상 재생 안함
	jQuery(window).resize(function(){
		if(jQuery(window).width() < 760){
			$("#main_morning")[0].pause();
			// 화면 리사이징될 때, 메뉴 숨김 방지
			if(jQuery("#mfmGnb").css("display") == "none"){
				jQuery("#mfmGnb").hide();
				jQuery(this).removeClass("mnuMobileClose");
				jQuery(this).addClass("mnuMobileOpen");
			}
			if(jQuery(this).hasClass("mnuMobileOpen")){
				jQuery(this).removeClass("mnuMobileOpen");
				jQuery(this).addClass("mnuMobileClose");
			} else {
				jQuery(this).removeClass("mnuMobileClose");
				jQuery(this).addClass("mnuMobileOpen");
			}
		} else {
			// tab/pc에서 동영상 재생
			$("#main_morning")[0].play();
			// 화면 리사이징될 때, 메뉴 숨김 방지
			jQuery("#mfmGnb").show();
		}
		// 동영상 재생여부 체크
//		console.log(jQuery("#main_morning").get(0).paused);
	});
});