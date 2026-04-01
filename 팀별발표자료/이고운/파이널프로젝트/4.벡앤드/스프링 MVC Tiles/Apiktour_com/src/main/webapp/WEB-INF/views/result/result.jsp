<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>    
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags" %>               
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>  
<script>
//alert('hello')

$(function(){
     var aa='제이쿼리 작동';
   //alert(aa)
    var mode = '${play}';
    var level = '${lv}'
    //alert(mode);
   //alert(level); 
    
    $('#mode option').each(function(){
        if($(this).val()==mode){
          $(this).attr("selected","selected"); // attr적용안될경우 prop으로
        }
      });
    
    $('#level option').each(function(){
        if($(this).val()==level){
          $(this).attr("selected","selected"); // attr적용안될경우 prop으로
        }
      });
    
    var text = $('select[name=level]')[0].options[0].innerHTML;
    //alert(text)
    
    if(mode=='play'){
    	$('select[name=level]')[0].options[0].innerHTML = "에너지 선택"
    }

    if(mode=='rest'){
    	$('select[name=level]')[0].options[0].innerHTML = "피로도 선택"
    }

    
});




</script>

         <style type="text/css">
         .slider { /*background-color: coral;*/
            width: 100%;
            margin: 0 auto;
        }

        .slick-slide { background-color: #fff;
          height: 70px; /*width: 300px !important;*/
          margin: 0px 3px;
          border: 2px solid #ccc;
          border-radius: 3px;
        }

        </style>

    <div id="container">
      <div id="filter">
      	<form id="choi" method="post">
      	  <select name="mode" id="mode">
         <option>유형 선택</option>
         <option value="rest">쉴래</option>
         <option value="play">놀래</option>
        </select>
        <select name="level" id="level">
         <option>레벨 선택</option>
         <option value="1">1Lv</option>
         <option value="2">2Lv</option>
         <option value="3">3Lv</option>
         <option value="4">4Lv</option>
         <option value="5">5Lv</option>
        </select>

      		<button id="redi">선택</button>
      	</form>
		<a href="${pageContext.request.contextPath}/json.do">json 테스트</a>
     </div>
     
      <div id="cosListContainer">
          <div id="cosList" class="cos slider">
    			<c:if test="${count==0}">
				<div> 검색된 정보가 없습니다.</div>
			</c:if>
			
				<c:forEach var="cos" items="${cosList }">  
					<div>
				   	<a class="flexCol CosInfo" href="javascript:void(0)" onclick="openCosInfo()">
				   		${ cos.getCosname() }<br>			
				   	</a>
				   	</div>
				</c:forEach>
          </div> <!-- cosList -->
      </div> <!-- cosListContainer -->
      <div id="map"></div>
    </div>
    <!-- container -->





<script>   
var initloc = {lat: 33.306090, lng: 126.289434};
var mapContainer = document.getElementById('map'), 
mapOption = {zoom: 12, center: initloc, mapTypeId: 'roadmap'};
var map = new google.maps.Map(mapContainer, mapOption);

var icons = {
    offmarker: {
    icon: '../../images/icon/icn_maker_off.png'
    },
    onmarker: {
    icon: '${pageContext.request.contextPath}/web/images/icon/icn_maker_on.png'
    }  
};


var features = [
{ position: new google.maps.LatLng(33.306090, 126.289434),
  type: 'offmarker' }, 
{ position: new google.maps.LatLng(33.389523, 126.239259),
  type: 'offmarker' }, 
{ position: new google.maps.LatLng(33.459974, 126.831469),
  type: 'offmarker' }, 
{ position: new google.maps.LatLng(33.262067, 126.275559),
  type: 'offmarker' },
{ position: new google.maps.LatLng(33.254923, 126.408718),
  type: 'onmarker' }
    ];
// Create markers.
 features.forEach(function(feature) {
          var marker = new google.maps.Marker({
            position: feature.position,
            map: map
          });
        });
//marker.setMap(map);
google.maps.event.addDomListener(window, 'load');
    

</script>

<script type="text/javascript">
    $(document).on('ready', function() {
      $("#cosList").slick({
        infinite: true,
        centerMode: false,
        slidesToShow: 5,
        slidesToScroll: 5,
        speed: 2000
      });
    });
</script> 

