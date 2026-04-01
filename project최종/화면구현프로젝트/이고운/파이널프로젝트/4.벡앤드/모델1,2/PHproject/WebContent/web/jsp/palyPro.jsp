<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Admin.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"> 
    <link href="${pageContext.request.contextPath}/web/css/play_pro.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

     <script>

    </script>     
    
    <title>쉴래? 놀래?</title>
    <script>
    $( function() {
	    $('#rsBtn').click(function(){
	    	var level=$( "#level" ).val();
			var mode=$('#mode').val();
			var count=$('#count').val();
	
			$('#parameter').attr('action','/PHproject/index.do?CONTROL=result_2').submit();
			return true;//전송이 가능하게 설정		
		})
    });
    </script>
    <style type="text/css">
       

    </style>
 </head>
 <body>
      <%
	request.setCharacterEncoding("utf-8");
    String mode=request.getParameter("mode");
	String level=request.getParameter("level");
	String type="";
	
	
	System.out.println("level > "+level);	
	System.out.println("mode > "+mode);
	
	String m = mode; 
	switch(m) { 
	case "rest": type="피로도"; break; 
	case "play": type="에너지"; break; 
	}
	
	System.out.println("type > "+type);
	
	int lv=Integer.parseInt(level);
	String play=mode;
	
	
	//DB조회
	CourseDAO course = new CourseDAO();
	int count=0;		
	count = course.getCourseCount(play, lv);
	
	System.out.println("play:"+play+" , lv:"+lv+", count :"+count);	
	
   %>               
        <div id="container">           
            <p>
               <%=type%> 레벨값 <%=level %>
            </p>
            <p class="mg01">
               <b>(<%=count %>)</b>개의 검색 결과가 있습니다.
            </p>
            <form id="parameter"  method="post">
	            <input type="hidden" name="mode" id="mode" value="<%=mode%>">
	            <input type="hidden" name="level"  id="level"  value="<%=level%>">
	            <input type="hidden" name="count"  id="count"  value="<%=count%>">
	            <button id="rsBtn"> 결과 보기 </button>
            </form>
            
            
        </div> <!-- container -->
     
     
 </body>
</html>
