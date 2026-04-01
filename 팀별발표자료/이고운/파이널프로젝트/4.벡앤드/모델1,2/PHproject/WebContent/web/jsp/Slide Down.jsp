<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"> 
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>


     <script>
$(".toggle, main").click(function(){
  $(".flyout, .opener, main").toggleClass("hidden");
  $(".toggle").toggleClass("active");
});
    </script>     
    
    <title>쉴래? 놀래?</title>
    
    <style type="text/css">

        * {
    -webkit-backface-visibility: hidden;
}

html {
  width: 100%;
  height: 100%;
  overflow:hidden;
}

main.hidden {
  transform: translateY(200px);
  transition: ease-in 0.25s;
}

main { 
  background: url(http://vomwege.de/codepen/bg4.png) center center repeat #eee;
  -webkit-backface-visibility: hidden;
  width: 100%;
  height:100%;
  padding: 50px;
  transform: translateY(0px);
  transition: ease-out 0.25s;
  
}

.flyout.hidden {
  transform: translateY(-100%);
  transition: ease-out .25s;  
}

.flyout {
  -webkit-backface-visibility: hidden;
  background: #222;
  height: 200px;
  width: 100%;
  position: absolute;
  left: 0px;
  right: 0px;
  transform: translateY(0%);
  transition: ease-in .25s;
}

.opener.hidden {
  transform: translateY(0px);
  transition: ease-out .25s;
}

.opener {
  -webkit-backface-visibility: hidden;
  height: 15px;
  width: 100%;
  transform: translateY(200px);
  transition: ease-in .25s;
  position: absolute;
  left: 0px;
  right: 0px;
  z-index: 1;
  text-align: center;
}

.toggle {
  -webkit-backface-visibility: hidden;
  background:#222;
  margin-top:-5px;
  padding: 15px;
  display: inline-block;
  vertical-align: middle;
  line-height: 1em;
  color:#ddd;
  cursor: pointer;
  border-radius: 0px 0px 10px 10px;
  transition: ease .25s;
}

.toggle::before {
  transition: ease .25s;
  content: "open \f107";
  font-family: FontAwesome;
  font-style: normal;
  font-weight: normal;
  text-decoration: inherit;
  margin-left:5px;
}

.toggle.active::before {
  transition: ease .25s;
  content: "close \f106";
}


    
    </style>
 </head>
 <body>

<div class="flyout hidden"></div>
<div class="opener hidden">
  <span class="toggle"></span>
</div>
<main>
  <h2>Website Content</h2>
  <p>Useless text ... blablabla ...</p>
</main>

     
     
 </body>
</html>
