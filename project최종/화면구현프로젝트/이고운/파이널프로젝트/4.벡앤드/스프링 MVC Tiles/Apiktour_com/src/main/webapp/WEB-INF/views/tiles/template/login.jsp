<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<link href="<c:url value='/resources/css/member/login.css?ver=1' />" rel="stylesheet"></link>

<span class="close_btn"><a href="javascript:void(0)" onclick="closePopup()">close</a></span>
<div class="titbox case1">
			<h2>회원계정으로 로그인하기</h2>
</div><!-- //titbox -->

		<div class="contents member">
			<div class="wrap">
				<div class="memberbox">
					<div class="loginbox">
						<p>
							<input type="text" name="" id="" class="icon_id" placeholder="이메일 아이디 입력"  />
						</p>
						<p>
							<input type="text" name="" id="" class="icon_pw" placeholder="비밀번호 입력" />
						</p>
			
						<a href="${pageContext.request.contextPath}/login.do" class="btn1">로그인</a>
			
						<div class="logincheck">
							<input type="checkbox" id="loginck" name="loginck" value="로그인" checked="">
							<label for="loginck">로그인 상태 유지</label>
						</div>

						<div class="login_txt">
							<p>아이디 또는 비밀번호를 잊어버리셨나요?</p>
							<a href="#">아이디 / 비밀번호 찾기</a>
						</div>
						<a href="${pageContext.request.contextPath}/join.do" class="btn1">회원가입</a>
					</div>
				</div>
			</div><!-- //wrap -->
		</div><!-- //contents  -->