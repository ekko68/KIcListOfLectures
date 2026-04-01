<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   //response.sendRedirect("http://www.naver.com"); 외부사이트로 이동
   //response.sendRedirect("chooseTag.jsp?name=bk")//특정 jsp로 이동
%>
<%-- <c:redirect url="http://www.naver.com" />
   c:param name="전달할 매개변수명" value="전달할값" />
   c:param name="전달할 매개변수명2" value="전달할값" />
 --%>
<c:redirect url="chooseTag.jsp" >
  <c:param name="name" value="bk" />
</c:redirect>







