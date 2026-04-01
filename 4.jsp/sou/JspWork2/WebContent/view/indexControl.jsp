<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    String CONTROL=null;
    String PAGENUM=null;
    
    try{
    	CONTROL=request.getParameter("CONTROL");
    	PAGENUM=request.getParameter("PAGENUM");
    	System.out.println("CONTROL="+CONTROL+",PAGENUM="+PAGENUM);
    	
    	//만약에 중간에 전달 못받는 상태가 발생->기본적인 파일을 불러오게 하기위해서
    	if(CONTROL.equals(null)){
    		CONTROL="intro";
    	}
    	
    	if(PAGENUM.equals(null)){
    		PAGENUM="01";
    	}
    }catch(Exception e){
    	e.printStackTrace();
    }
 %>
<jsp:forward page="/template/template.jsp" >
   <jsp:param name="CONTROL" value="<%=CONTROL %>" />
   <jsp:param name="PAGENUM" value="<%=PAGENUM %>" />
</jsp:forward>






