<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 <!Doctype html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="css" />
<tiles:insertAttribute name="js" />
<tiles:insertAttribute name="subRes" />
</head>
  
<body>

<script>

$(document).ready(function(){
    
    var modal = document.getElementById('modal_login');    
    
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

});

</script>

<div id="modal_login">
 	<div id="box_login">
		<tiles:insertAttribute name="login" />
	</div> 
</div><!--modal_login-->

     <nav id="navUl" class="sideNav">
        <tiles:insertAttribute name="sideMenu" />
    </nav>      
	 <span id="navIcn" onclick="openNav()"></span>   
                
	<div id="wrap">
		<tiles:insertAttribute name="body" />
	</div> <!-- wrap-->

</body>
</html>
