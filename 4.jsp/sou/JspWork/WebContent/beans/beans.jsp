<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바빈즈가 나온 배경설명</title>
</head>
<body>
<%!
  //입력->매개변수 전달->저장(필드별로 DTO)->테이블에 저장(필드별로)
   String str="선언문";//웹상에서 입력받을 값
   String addr="";
   public void setStr(String s){
	   str=s;
   }
   public void setAddr(String addr){
	   this.addr=addr;
   }
   public String getStr(){
	   return str;
   }
   public String getAddr(){
	   return addr;
   }
%>
 메서드 호출(Setter Method):<% setStr("자바빈즈"); %>
 <p>
 저장된값 출력(Getter Method):<%=getStr() %>

</body>
</html>


