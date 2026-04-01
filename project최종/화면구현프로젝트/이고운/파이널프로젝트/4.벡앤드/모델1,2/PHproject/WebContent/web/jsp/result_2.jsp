<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>    
 <%@ page import="Admin.*, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">   
      <link href="${pageContext.request.contextPath}/web/css/result.css" type="text/css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/web/css/slick.css" type="text/css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/web/css/slick-theme.css" type="text/css" rel="stylesheet">
	 <link href="${pageContext.request.contextPath}/web/css/cos_Info.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
       <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAB_ImVdT5sLLK3qg1h7obBSI8hqbvk0ZE"></script>
      <script src="${pageContext.request.contextPath}/web/js/slick.js"></script>
      <script src="${pageContext.request.contextPath}/web/js/cos_info.js"></script>
      
          <title>쉴래? 놀래?</title>
         <script>
        $(document).ready(function() {
            $("#cosInfo").load("/PHproject/web/jsp/cos_info.jsp");            
            $('#wrapBg').click(function(evt) {
                $('#cosInfo').css('left','-28vw')
                $('#wrap').css('marginLeft','0')        
                $('#wrapBg').css('display','none')     
               evt.preventDefault();
            });
        
        });
      </script>
         <style type="text/css">
         .slider { /*background-color: coral;*/
            width: 100%;
            margin: 0 auto;
        }

        .slick-list{/*background-color: cadetblue;*/}

        .slick-slide { background-color: #fff;
          height: 70px; /*width: 300px !important;*/
          margin: 0px 3px;
          border: 2px solid #ccc;
          border-radius: 3px;
        }

        </style>
        </head>
   <body>
<%
	request.setCharacterEncoding("utf-8");
   String mode=request.getParameter("mode");
	String level=request.getParameter("level");
	//String type="";	
	
	//System.out.println("level > "+level);	
	//System.out.println("mode > "+mode);

	int lv=Integer.parseInt(level);
	String play=mode;
	int count=Integer.parseInt(request.getParameter("count"));
	System.out.println("play:"+play+" , lv:"+lv+", count :"+count);	
	
	//DB조회
	CourseDAO course = new CourseDAO();
	//int count=0;	
	List cosList = null;
	//count = course.getCourseCount(play, lv);
	cosList = course.getCourseList(play, lv);
	
   %>
   
   
<section id="cosInfo">
<%-- <jsp:include page="/web/jsp/cos_info.jsp" flush="false" />  --%>
    </section>

  <div id="wrap">
    <div id="wrapBg">우측 사이드바 나올 시 음영처리</div>
    <div id="container">
      <div id="filter">
        <select>
         <option>유형선택</option>
         <option>쉴래</option>
         <option>놀래</option>
        </select>
        <select>
         <option>레벨선택</option>
         <option>1Lv</option>
         <option>2Lv</option>
         <option>3Lv</option>
         <option>4Lv</option>
         <option>5Lv</option>
        </select>        
     </div>
      <div id="cosListContainer">
          <div id="cosList" class="cos slider">
		<%
   if(count==0){
%>
<div> 검색된 정보가 없습니다.</div>
<%}else { 

       for(int i=0;i<cosList.size();i++){
          CourseDTO cos=(CourseDTO)cosList.get(i);//vecList.elementAt(i) ,vecList.get(i);
    %>
   <div>
   	<a class="flexCol" href="javascript:void(0)" onclick="openCosInfo()">
   		<%=cos.getCosname() %> <br>
   		코스번호 : <%=cos.getCosnum() %>
   	</a>
   </div>
      <%  } //for %>
<% } //else %>
              
          </div>
      </div> <!-- cosListContainer -->
      <div id="map"></div>
    </div>
    <!-- container -->
  </div>
  <!-- wrap-->

<script>   
var initloc = {lat: 33.306090, lng: 126.289434};
var mapContainer = document.getElementById('map'), 
mapOption = {zoom: 12, center: initloc, mapTypeId: 'roadmap'};
var map = new google.maps.Map(mapContainer, mapOption);

var icons = {
    offmarker: {
    icon: '/PHproject/web/image/icon/icn_maker_off.png'
    },
    onmarker: {
    icon: '/PHproject/web/image/icon/icn_maker_on.png'
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
            icon: icons[feature.type].icon,
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

        </body>
      </html>
