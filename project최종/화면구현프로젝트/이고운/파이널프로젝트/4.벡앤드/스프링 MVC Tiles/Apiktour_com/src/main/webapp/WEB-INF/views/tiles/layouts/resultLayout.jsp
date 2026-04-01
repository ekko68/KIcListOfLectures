<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="css" />
<tiles:insertAttribute name="js" />

<tiles:insertAttribute name="jsSub" />
</head>
  
<body>

<script>

$(document).ready(function(){
    
    var modal = document.getElementById('modal_login');
    
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

});

$(document).ready(function() {         
    $('#wrapBg').click(function(evt) {
        $('#cosInfo').css('left','-28vw')
        $('#wrap').css('marginLeft','0')        
        $('#wrapBg').css('display','none')     
       evt.preventDefault();
    });

});

$('.CosInfo').click(function(){
	var play=$( "#play" ).val();
	var level=$('#level').val();
	var cousnum=$('#cosnum').val();

	$('#parameter').attr('action','/').submit();
	return true;//전송이 가능하게 설정		
})    

</script>

<div id="modal_login">
 	<div id="box_login">
		<tiles:insertAttribute name="login" />
	</div> 
</div><!--modal_login-->

     <nav id="navUl" class="sideNav">
        <tiles:insertAttribute name="sideMenu" />
    </nav>      
	 <span id="navIcn" onclick="openNav()"></span>   


<section id="cosInfo">
<tiles:insertAttribute name="cosInfo" />
</section>
                
	<div id="wrap">
	<div id="wrapBg">우측 사이드바 나올 시 음영처리</div>
		<tiles:insertAttribute name="body2" />
	</div> <!-- wrap-->

</body>
</html>
