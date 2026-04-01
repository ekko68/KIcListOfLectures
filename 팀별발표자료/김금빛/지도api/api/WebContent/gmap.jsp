<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search for up to 200 places with Radar Search</title>
<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	height: 500px;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsCvBGdPdGKaFym6WNsUUoQoaU0lrGLhw&callback=initMap&libraries=places,visualization"
	async defer></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	var resultlocal; //로컬json파일을 담기위한 전역변수
	var resultgoogle; //구글'자전거'키워드 검색 결과를 담기위한 전역변수
	var markers = [];
    var map;
    var type;
    
function initMap() {
	var loc = {lat:37.4989993, lng:127.0299699}; //지도 위치 초기화
	//참고로 현재위치를 loc값에 저장시키기위해서는 
	//navigator.geolocation.getCurrentPosition) 함수를 사용하면 된다.
	//자세한 내용은 구글참조해서 사용해보세요
    map = new google.maps.Map(document.getElementById('map'), { //지도를 생성과 동시에 map변수에 지도를 담아둠
    zoom: 15,
    center: loc
  });

infowindow = new google.maps.InfoWindow(); //마커클릭시 정보창을 띄우기위한 함수 및 그함수를 변수에 담음

//아래의 소스는
  var script = document.createElement('script');
  script.src = 'test2.js';
  document.getElementsByTagName('head')[0].appendChild(script);
// <script src="test2.js"~  와 같습니다
// 왜 이걸 후에 선언하는 이유는 구글지도맵을 초기화 한후에 값을 불러들여서 오류를 최소화하기위해서입니다.
// 즉, 맵도나오기전에 좌표값들을 불러들이고 뿌려버리면 노출되지 않을수도 있기때문입니다.
  
  icons = {
    normal: {
      name: 'normal', //보관소
      icon: 'https://raw.githubusercontent.com/jmh8025/api/master/ic_blue.png'
    },
    gonggi: {
      name: 'gonggi', //공기주입기
      icon: 'https://raw.githubusercontent.com/jmh8025/api/master/ic_red.png'
    },
    store: {
        name: 'store', //대리점
        icon: 'https://raw.githubusercontent.com/jmh8025/api/master/ic_green.png'
    }
}
  
  var request = { //자전거의 검색값을 널습니다.
		    location: loc,
		    radius: '100',
		    query: '자전거'
		  };
		  var service = new google.maps.places.PlacesService(map); //검색하기위한 객체를 만듭니다.
		service.textSearch(request, searchresult); // 검색값과 요청결과값을 객체에 담아서 전송합니다.
		
		 var centerControlDiv = document.createElement('div');
		 var centerControl = new CenterControl(centerControlDiv, map);

		  centerControlDiv.index = 1;
		  map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);
		
}//initMap()끝

function CenterControl(controlDiv, map) {

	  // Set CSS for the control border.
	  var controlUI = document.createElement('div');
	  controlUI.style.backgroundColor = '#fff';
	  controlUI.style.border = '2px solid #fff';
	  controlUI.style.borderRadius = '3px';
	  controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
	  controlUI.style.cursor = 'pointer';
	  controlUI.style.marginBottom = '22px';
	  controlUI.style.textAlign = 'center';
	  controlUI.title = 'Click to recenter the map';
	  controlDiv.appendChild(controlUI);

	  // Set CSS for the control interior.
	  var controlText = document.createElement('div');
	  controlText.style.color = 'rgb(25,25,25)';
	  controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
	  controlText.style.fontSize = '16px';
	  controlText.style.lineHeight = '38px';
	  controlText.style.paddingLeft = '5px';
	  controlText.style.paddingRight = '5px';
	  controlText.innerHTML = "";
	  controlText.innerHTML = "";
	  controlText.innerHTML += "<a onMouseOver='alarm();'>";
	  controlText.innerHTML += "ALARM";
	  controlText.innerHTML += "</a>";
	  controlUI.appendChild(controlText);

	  // Setup the click event listeners: simply set the map to Chicago.
	  controlUI.addEventListener('click', function() {
	    type='gonggi'
	    searchsort(type);
	  });
}
//1.로컬js먼저읽고
window.eqfeed_callback = function(results) {
	alert (results);
	resultlocal=results; //객체담기
}
//2.구글꺼읽음
function searchresult(results, status) {
	  if (status === google.maps.places.PlacesServiceStatus.OK) {
		resultgoogle=results; //객체담기
		
		searchsort() //resultlocal과 resultgoogle을 읽어들인뒤 searchsort로 이동
		}
}
function searchsort(type) {
	if(type==null){
		type='all';
	}
	clearMarkers() //마커 초기화작업 (왜 초기화하는지 궁금하신분은 지워서 실행해보시면 알듯!)
/* 	var type; //고객이 뭘선택했는지 알아내기위한 라디오버튼값
	for (var i = 0; i < document.controls.type.length; i++) { //라디오 버튼값 읽어오기
		if (document.controls.type[i].checked) {
			type = document.controls.type[i].value;
		}
	} */
	
	if(type=='all'){//타입이 전부보여주세요이면
		addmarkergoogle(resultgoogle); //구글값보내버리기 아오졸려
		for (var i = 0, result; result = resultlocal[i]; i++) { //local값전부보내버렷
			addmarkerlocal(result);
		}  
	}else if((type=='normal')||(type=='gonggi')){//타입이 일반이거나 공기이면
		for (var i = 0, result; result = resultlocal[i]; i++) { 
			if(type==result.service){ //선택한값과 맵의서비스가같을때만 즉, 노말과 공기를 솎아보냄
				addmarkerlocal(result);				
			}
		}  
	}else if(type=='store'){//타입이 대리점이면
		addmarkergoogle(resultgoogle);
	}
}

function addmarkerlocal(result){ //로컬값의 마커추가
	var lat = result.lat;
	var lon = result.lon;
	var latLng = new google.maps.LatLng(lat,lon);
	marker = new google.maps.Marker({
		position: latLng,
	    map: map,
	    icon: {
	    	url: icons[result.service].icon, //service값과 일치하는 이미지읽어오기
	        anchor: new google.maps.Point(10, 10),
	        scaledSize: new google.maps.Size(30, 30)
	}
	});
	markers.push(marker); //마커를 배열에 삽입 (나중에 지우기위해서)
	var content = "이름은"+result.name+"<br>번호는"+result.tel; //콘텐츠 새성
	google.maps.event.addListener(marker,'click', (function(marker,content,infowindow){ //마커 클릭시 이벤트(click->mouseover(?),over)등으로 변경가능 
		return function(){
			infowindow.setContent(content); //정보창의 컨텐츠(내용)  
	  		infowindow.open(map,marker); //정보창의 오픈 위치
	  		};
	  		})(marker,content,infowindow));
}

function addmarkergoogle(results){//구글검색의 마커추가
	for (var i = 0, result; result = results[i]; i++) {
	    marker = new google.maps.Marker({
	        position: result.geometry.location,
	        map: map,
	  	   icon: {
	              url: icons.store.icon, //service값과 일치하는 이미지읽어오기
	              anchor: new google.maps.Point(10, 10),
	              scaledSize: new google.maps.Size(30, 30)
	            }
	  	});
	  	markers.push(marker); //마커를 배열에 삽입 (나중에 지우기위해서)
	  	var content = "이름은"+result.name+"<br>번호는";
	  	google.maps.event.addListener(marker, 'click', function() {
		    infowindow.setContent(content); //정보창의 내용
		    infowindow.open(map, this);//정보창의 오픈위치
		});
	}
}

function clearMarkers() {  //배열에 담았던 마커들을 지우는 함수
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
   markers = [];
}


    </script>
</head>
<body>
	<div id="map"></div>
	<form name="controls">
		<input type="radio" name="type" value="all" onclick="searchsort()"
			checked="checked" />모두 <br /> <input type="radio" name="type"
			value="normal" onclick="searchsort()" />보관소 <br /> <input
			type="radio" name="type" value="gonggi" onclick="searchsort()" />공기주입기
		<br /> <input type="radio" name="type" value="store" onclick="searchsort()" />대리점 <input onclick="clearMarkers();"
			type=button value="Hide Markers"></input>
	</form>
</body>
</html>