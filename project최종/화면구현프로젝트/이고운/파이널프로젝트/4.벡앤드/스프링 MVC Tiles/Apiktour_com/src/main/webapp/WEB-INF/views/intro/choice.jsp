<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link href="<c:url value='/resources/css/intro/choice.css' />" rel="stylesheet"></link>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     
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
        

        $( "#level" ).val($( "#slider" ).slider( "value" ));
    	
        
        $('#saveBtn').click(function(){
        	var level=$( "#slider" ).slider( "value" );
			var mode=$('#mode').val()

			$('#costype').attr('action','${pageContext.request.contextPath}/choicePro.do').submit();
			return true;//전송이 가능하게 설정		
		})
    
    });
    </script>     
    

        <div id="container"> 
        <form id="costype" method="post">         
            <p>
                <label for="level">현재 당신의 <b>${type}</b>를 선택하세요</label>
            </p>
            <p class="mg01">
                <input type="text" name="level" id="level" value="">
            </p>

            <div id="slider"></div>
            
            <button id="saveBtn"> 선택 완료 </button>
            <input type="hidden" name="mode" value="${mode }" id="mode">
        </form> 
        </div> <!-- container -->
         