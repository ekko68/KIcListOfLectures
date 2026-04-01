/**
 * xhr객체를 생성->요청-->jsp로 요청->응답->콜백함수 출력
 */
var xhrObject //xhr객체를 전역변수로 선언

//1.xhr객체를 생성함수 선언
function createXHR(){
	 if(window.XMLHttpRequest){
		 xhrObject=new XMLHttpRequest()//객체를 생성->반환
		// alert(xhrObject) 
	 }
}

//2.중복id를 입력->처리하는 함수
function idCheck(id){
	if(id==""){
		//var mem_id=document.getElementById("ducheck")
		var mem_id=$("ducheck")
		//alert(mem_id)
		$("ducheck").innerHTML="<font color='red'>아이디를 먼저 입력요망</font>"
		//document.regForm.mem_id.focus()
		$("mem_id").focus()
		return false;
	}
	//입력했다면->Ajax를 이용해서 IdCheck.jsp을 요청
	//1.xhr객체 얻어옴
	createXHR()//->xhrObject
	var url="http://localhost:8090/JspMember/IdCheck.jsp?"+getParameterValues()
	//alert(url)
	//2.콜백함수 지정
	xhrObject.onreadystatechange=resultProcess
	//3.open함수를 서버에 요청준비
	xhrObject.open("Get",url,true);//비동기 방식
	//4.send()요청
	xhrObject.send(null);
}

//3.파라미터값을 처리해주는 함수
function getParameterValues(){
	var mem_id=$("mem_id").value
	//서버캐시에 요청 메모리에 저장하지 않는 방법
	//파라미터값을 하나 전달할때 오늘날짜를 같이 출력시켜주는 매개변수를 첨부
	return "mem_id="+mem_id+"&timestamp="+new Date().getTime()
}
//4.콜백함수
function resultProcess(){
	//alert("resultProcess")//콜백함수 호출이 되는지 확인
	if(xhrObject.readyState==4){//서버가 요청을 다받았다면
		if(xhrObject.status==200){//서버의 결과를 받았다면
		  var result=xhrObject.responseText;//태그+문자열=>문자열	
		  $("ducheck").innerHTML=result;
		}
	}
}











