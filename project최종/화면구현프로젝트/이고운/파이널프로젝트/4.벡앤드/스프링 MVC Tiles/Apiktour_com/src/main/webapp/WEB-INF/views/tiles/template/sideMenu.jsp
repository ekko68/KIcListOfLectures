<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="gnb">
            <span class="login"><a href="javascript:void(0)" onclick="loginPopup()">로그인</a></span> 
            <span class="closebtn"> <a href="javascript:void(0)" onclick="closeNav()">&times;</a>
            </span>                 
        </div>       
         
        <ul class="menu">
            <li> <a href="${pageContext.request.contextPath}/index.do">홈으로가기</a></li>
            <li> <a href="#">나의 위시 리스트</a> </li>
            <li> <a href="#">회원수정</a> </li>
            <li> <a href="#">회원탈퇴</a> </li>        
        </ul>  
        
        <div id="admin"><a href="${pageContext.request.contextPath}/admin/admin_main.do"> admin </a></div> 