<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>날짜,시간,숫자출력</title>
</head>
<body><!--ja-JP,en-US(언어-국가명) 다국어지원해 주는 속성 -->
<fmt:setLocale value="ko-KR" />
<h1>
<!--value(출력할값) type(숫자,통화,퍼센트)  -->
number:<fmt:formatNumber value="9876543.61" type="number" />
currency:<fmt:formatNumber value="9876543.61" type="currency" />
percent:<fmt:formatNumber  type="percent" >
                   9876543.61
             </fmt:formatNumber>
<p>
pattern=".000" :<fmt:formatNumber value="9876543.61" 
                            pattern=".000" />
                            
pattern="#,#00.0#":<fmt:formatNumber value="9876543.61" 
                                  pattern="#,#00.0#" />
<hr>
<jsp:useBean id="now" class="java.util.Date" />
<c:out value="${now}"/>

date:<fmt:formatDate value="${now}" type="date" /><br>
time:<fmt:formatDate value="${now}" type="time" /><br>
both:<fmt:formatDate value="${now}" type="both" /><br>
<hr>
<!--dateStyle(날짜만 세부적),timeStyle(시간을 세부적)  -->
default:<fmt:formatDate value="${now}" type="both"
              dateStyle="default" timeStyle="default" /><br>
              
short:<fmt:formatDate value="${now}" type="both"
              dateStyle="short" timeStyle="short" /><br>
              
medium:<fmt:formatDate value="${now}" type="both"
              dateStyle="medium" timeStyle="medium" /><br>   
                    
long:<fmt:formatDate value="${now}" type="both"
              dateStyle="long" timeStyle="long" /><br>
              
full:<fmt:formatDate value="${now}" type="both"
              dateStyle="full" timeStyle="full" /><br>
              
pattern:"yyyy년 MM월 dd일 HH시 mm분 ss초":
      <fmt:formatDate value="${now}" type="both"
              pattern="yyyy년 MM월 dd일 HH시 mm분 ss" /><br>

<fmt:timeZone value="US/Eastern">
<fmt:formatDate value="${now}" type="both"
              pattern="yyyy년 MM월 dd일 HH시 mm분 ss" /><br>
</fmt:timeZone>             
              
              
</h1>
</body>
</html>