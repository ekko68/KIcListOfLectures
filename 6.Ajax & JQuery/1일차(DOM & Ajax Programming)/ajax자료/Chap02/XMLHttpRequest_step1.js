<script type="txt/javascript">
	var httpRequest = null;
	// 객체를 생성을 위한 전역 변수 선언

	function getXMLHttpRequest()
	{
		// MS IE는 ActiveX 형태로 XMLHttpRequest 객체 제공
		if(window.ActiveXObject)
		{
			// 최근 version
			try	{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e){
				// 과거 version
				try	{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
				// MS 계열에서 ActiveX 객체를 생성하지 못한 경우
				catch (e1)	{
					return null;
				} // end of catch e1
			} // end of catch e
		} // end of if block
		// MS IE가 아닌 경우 객체 생성
		else if(window.XMLHttpRequest)
		{
			return new XMLHttpRequest();
		} // end of else-if block
		// XMLHttpRequest를 지원하지 않는 경우
		else
		{
			return null;
		} // end of last else, if
	} // end of function
</script>