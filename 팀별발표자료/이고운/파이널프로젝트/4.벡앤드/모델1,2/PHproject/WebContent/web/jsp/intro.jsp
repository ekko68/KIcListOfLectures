<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta charset="UTF-8"> 
 <link href="${pageContext.request.contextPath}/web/css/intro.css" type="text/css" rel="stylesheet">
 <script src="http://code.jQuery.com/jquery-1.12.3.js" type="text/javascript"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.1/lodash.min.js'></script>
<script src="${pageContext.request.contextPath}/web/js/ex.js"></script>  
     
  <title>쉴래? 놀래?</title>
  <script>

  </script>
    <style type="text/css">
        
  </style>
 </head>
 <body>
  <%
 	request.setCharacterEncoding("utf-8");
	String CONTROL=request.getParameter("CONTROL");	
	String content="/jsp/"+CONTROL+".jsp"; 
	String mode="";
	//String level="";
	System.out.println("content > "+content);
	
	%>
	   
         
         <div id="container">
            <div id="slide01" class="background">
                <div class="content-wrapper">
                    <h1 class="content-title"> 나는 아무 생각이 없다. </h1>
                    <p class="content-p"> 왜냐하면 로고가 있기 때문이다.</p>
                </div>            
            </div>
             
            <div id="slide02" class="background">
                <div class="content-wrapper2">
                     <section class="flexTxt"> 
                         <p> <a href="/PHproject/index.do?CONTROL=choice&mode=rest"> 쉴래? </a> </p> 
                     </section>
                     <section class="flexTxt"> 
                         <p> <a href="/PHproject/index.do?CONTROL=choice&mode=play"> 놀래? </a> </p> 
                     </section>
                </div>
            </div>
             
         </div> <!-- container -->

     
 </body>
</html>