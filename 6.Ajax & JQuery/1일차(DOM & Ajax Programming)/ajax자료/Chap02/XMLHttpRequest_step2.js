<script type="txt/javascript">
	var httpRequest = null;
	// 객체를 생성을 위한 전역 변수 선언
	
	function processEvent()
	{
		httpRequest = getXMLHttpRequest();
		//
		httpRequest.onreadystatechange=callbackFunction;
		// Step 3을 진행하기 위한 문장
		// 응답이 오면 지정된 함수를 실행하도록 한다.
		//
		httpRequest.open("GET", "/test.txt", true);
		// 첫 번째 인자 : GET, POST 지정
		// 두 번째 인자 : 접속할 URL, 
		//				  현재 페이지와 같은 도메인에 있어야 한다.
		//		GET 방식 : "GET", "/test.jsp?id=uid&pwd=1234"
		//		POST방식 : "POST", "/test.jsp"
		// 세 번째 인자 : 동기(sync)/비동기(Async) 지정

		httpRequest.send(null);
		//		GET 방식 : send(null);
		//		POST방식 : send("id=uid&pwd=1234");
	}
</script>