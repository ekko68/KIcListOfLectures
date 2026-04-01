<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.BeanTest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력받은 값을 저장,출력</title>
</head>
<body>
     <%-- <jsp:useBean id="bt" class="test.BeanTest" scope="page" /> --%>
<%
          request.setCharacterEncoding("utf-8");
          String str=request.getParameter("str");
          String addr=request.getParameter("addr");
          System.out.println("str=>"+str+",addr=>"+addr);
          //1.객체 생성
          //BeanTest bt=new BeanTest();
          //2.입력받은 갯수만큼 Setter Method호출
          //bt.setStr(str);
          //bt.setAddr(addr);
          //3.Getter Method으로 값을 불러온다.->테이블의 필드로 저장
          //out.println("입력받은 이름은?"+bt.getStr()+"<br>");
          //out.println("입력받은 주소은?"+bt.getAddr()+"<br>");
%>
<jsp:useBean id="bt" class="test.BeanTest" scope="page" />
<%-- <jsp:setProperty name="bt" property="str" value="<%=str%>" />
<jsp:setProperty name="bt" property="addr" value="<%=addr%>" /> --%>
<jsp:setProperty name="bt" property="*" />
<hr>
액션태그를 통한 Getter Method호출하는 경우
<jsp:getProperty name="bt" property="str" /><br>
<jsp:getProperty name="bt" property="addr" /><br>

<b><%=bt.getStr() %></b>님! 오셨군요! <br>
<b>주소는 <%=bt.getAddr() %></b> 입니다.
</body>
</html>






