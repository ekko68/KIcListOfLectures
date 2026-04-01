<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쉴래? 놀래? - ApikTour</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link href="/PHproject/web/css/common.css" type="text/css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/web/js/nav.js"></script>

</head>
<body>
<%

%>
     <nav id="navUl" class="sideNav">
        <div class="gnb">
            <span class="login"><a href="#">로그인</a></span> 
            <span class="closebtn"> <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
            </span>                 
        </div>         
         
        <ul class="menu">
            <li> <a href="#">홈으로가기</a></li>
            <li> <a href="#">나의 위시 리스트</a> </li>
            <li> <a href="#">회원수정</a> </li>
            <li> <a href="#">회원탈퇴</a> </li>        
        </ul>  
        
        <div id="admin"><a href="/PHproject/admin/AdminMain.do"> admin </a></div> 
    </nav>
        <span id="navIcn" onclick="openNav()"> &#9776; </span>
<div id="wrap">
         
	
	<%-- <jsp:include page="/web/jsp/intro.jsp" flush="false" /> --%>
	<jsp:include page="${content}" flush="false" />

</div> <!-- wrap-->


</body>
</html>