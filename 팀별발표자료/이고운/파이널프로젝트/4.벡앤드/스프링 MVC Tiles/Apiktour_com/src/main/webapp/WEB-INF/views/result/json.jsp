<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>    
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags" %>               
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAB_ImVdT5sLLK3qg1h7obBSI8hqbvk0ZE"></script>

<script type="text/javascript">
	$(document).ready(function() {

		var test1 =  '${play}';
		alert(test1)
		var test2 =  '${cosMakerList.size()}';
		alert(test2)
		var test3 = '${jsonMap}'
		alert(test3)
			
			/* var list1 = new Array();
				
			<c:forEach items="${cosMakerList }" var="cosMaker">
			list1.push("${cosMaker.locname}");
			list1.push("${cosMaker.locationx}");
			list1.push("${cosMaker.locationy}");	
			</c:forEach>
			for (var i = 0; i < list1.length; i++) {
			    alert(list1[i]);
			}
			alert("${cosMakerList[0].locname}"); */

		
		
		$("#jsonBtn").click(function() {
			$("#showData").text("");
			$.ajax({
				type : "get",
				url : "/json.do",
				datatype : "json",
				success : function(data) {
					alert(data)

				},
				error : function() {
					$("#showData").text("");
				}
			})
		});

	});
</script>

<style>
body{margin:0 auto;}
#map{ width:500px; height:500px;}
</style>


<div id="map"></div>

<h1>json</h1>

<a href="#" id="jsonBtn">json</a>

<div id="showData"></div>

<hr>

    <%-- json용으로 뿌려준다 --%>
        
        [<br>
        <c:forEach items="${cosMakerList }" var="cosMaker" varStatus="i">    <%-- 위에서 만들 list를 뿌려줄 준비 --%>
            <c:if test="${!i.first }">,</c:if>    <%-- 만약 i 가 처음이 아니면 , 을 뿌려준다. --%>
            {<br>
                "코스번호" : "${cosMaker.cosnum }", <br>
                "코스명" : "${cosMaker.cosname }",<br>
                "위치번호" :"${cosMaker.locnum }",<br>
                "locname" :"${cosMaker.locname }",<br>
                "lat" : "${cosMaker.locationx }",<br>
                "lng" :"${cosMaker.locationy }",<br>
                "loctype" :"${cosMaker.loctype }"   <br>              
            }<br>
        </c:forEach>
        ]



<script>   
        var json = '${jsonMap}'
        alert(json)
        function getJSONMarkers() {
            var markers = [
              {
                name:  "Rixos The Palm",
                location: [33.306090, 126.289434]
              },
              {
                name: "Shangri-La Hotel",
                location: [33.389523, 126.239259]
              },
              {
                name: "Grand Hyatt",
                location: [33.459974, 126.831469]
              }
            ];
            return markers;
          }

        
        const mapOptions = {
                center:new google.maps.LatLng(33.306090, 126.289434),
                zoom: 11
              }
              const map = new google.maps.Map(document.getElementById("map"), mapOptions);
      
     // Load JSON Data
        const jejulMarkers = getJSONMarkers();

        // Initialize Google Markers
        for(jeju of jejulMarkers) {
          let marker = new google.maps.Marker({
            map: map,
            position: new google.maps.LatLng(jeju.location[0], jeju.location[1]),
            title: jeju.name
          })
        }
        //marker.setMap(map);
        google.maps.event.addDomListener(window, 'load'); 
    
</script>


