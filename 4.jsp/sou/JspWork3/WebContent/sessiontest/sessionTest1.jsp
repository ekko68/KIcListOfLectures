<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파라미터값 처리</title>
</head>
<body>
 <%
  //인증성공
  String id=request.getParameter("id");
  String passwd=request.getParameter("passwd");
  System.out.println("id=>"+id+",passwd=>"+passwd);
  //오라클->member 조회->true or false
  session.setAttribute("idKey",id);//default->30분
  session.setMaxInactiveInterval(60);//60초->1분(세션유지시간을 설정)
 
 %>
 <form method="post" action="sessionTest2.jsp">
   <h2>가장 좋아하는 스포츠를 선택하세요</h2><br>
   <input type="radio" name="sports" value="농구">농구
   <input type="radio" name="sports" value="유도">유도
   <input type="radio" name="sports" value="야구">야구
   <input type="radio" name="sports" value="이종격투기">이종격투기<p>
   
   <h2>가장 좋아하는 계절를 선택하세요</h2><br>
   <select name="season">
     <option value="봄">봄</option>
     <option value="여름">여름</option>
     <option value="가을">가을</option>
     <option value="겨울">겨울</option>
   </select>
   <input type="submit" value="전송">
  </form>
</body>
</html>