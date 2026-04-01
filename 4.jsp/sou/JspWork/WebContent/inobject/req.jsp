<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request객체</title>
</head>
<body>

1.서버의 도메인 이름을 반환 <%=request.getServerName() %><br>
2.서버의 포트 번호를 반환 <%=request.getServerPort() %><br>

3.요청된 URL에서 경로를 반환<%=request.getRequestURL() %><br>
4.요청된 URI에서 경로를 반환<%=request.getRequestURI() %><br>
5.String getRemoteAddr()(원격ip 주소) <%=request.getRemoteAddr() %><br>

6.클라이언트가 요청한 프로토콜을 반환 <%=request.getProtocol() %><br>
7.요청 방식(GET, POST)을 반환 <%=request.getMethod() %><br>

</body>
</html>


