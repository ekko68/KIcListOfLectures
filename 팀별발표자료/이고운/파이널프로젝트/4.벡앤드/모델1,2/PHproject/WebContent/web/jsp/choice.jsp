<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"> 
 	<link href="${pageContext.request.contextPath}/web/css/choice.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script>
      
    $( function() {
        $( "#slider" ).slider({
            orientation: "horizontal",
            range: "min",
            value:1,
            min: 1,
            max: 5,
            step: 1,
            slide: function( event, ui ) {
                $( "#level" ).val( ui.value );
            }
        });
        
        //var level= $( "#slider" ).slider( "value");
        //$( "#amount" ).value=level;
        $( "#level" ).val($( "#slider" ).slider( "value" ));
        
       /*  var lv=$( "#slider" ).slider( "value" );
        alert(lv);
        $("#level").value=lv;
        alert($("#level").value=lv) */
    	
        
        $('#saveBtn').click(function(){
        	var level=$( "#slider" ).slider( "value" );
			var mode=$('#mode').val()

			$('#costype').attr('action','/PHproject/index.do?CONTROL=palyPro').submit();
			return true;//전송이 가능하게 설정		
		})
    
    
    
    });
    </script>     
    
    <title>쉴래? 놀래?</title>
    <script>

    </script>
    <style type="text/css">
 
    </style>
 </head>
 <body>
   <%
 	String mode=request.getParameter("mode");
   	String level="";
	String type="";
	System.out.println("mode > "+mode);
	
	String m = mode; 
	switch(m) { 
	case "rest": type="피로도"; break; 
	case "play": type="에너지"; break; 
	}
	
	System.out.println("type > "+type); 
		
   %>    
        <div id="container"> 
        <form id="costype" method="post">         
            <p>
                <label for="level">현재 당신의 <b><%=type %></b>를 선택하세요</label>
            </p>
            <p class="mg01">
                <input type="text" name="level" id="level" value="">
            </p>

            <div id="slider"></div>
            
            <button id="saveBtn"> 선택 완료 </button>
            <input type="hidden" name="mode" value="<%=mode %>" id="mode">
        </form> 
        </div> <!-- container -->
         
     
     
 </body>
</html>
