<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%
    String contextPath = request.getContextPath();
%>

<nav id="menu_v" class="menu_v">
	<ul>
		<li class="active"><a href="#"><span>회원 관리 메뉴</span><span class="i"></span></a>
			<ul style="display: block;">
				<li><a href="<%=contextPath %>/admin/05_admin_m_se.do"><span>회원 목록</span></a></li>
				<li><a href="<%=contextPath %>/admin/05_admin_m_in.do"><span>회원 등록</span></a></li>
			</ul>
		</li>
	             <li><a href="#"><span>코스 관리 메뉴</span><span class="i"></span></a>
			<ul style="display: block;">
				<li><a href="<%=contextPath %>/admin/05_admin_cos_se.do"><span>코스 목록</span></a></li>
				<li><a href="<%=contextPath %>/admin/05_admin_cos_in.do"><span>코스 등록</span></a></li>
			</ul>
		</li>
	             <li><a href="#"><span>코스 장소 관리 메뉴</span><span class="i"></span></a>
			<ul style="display: block;">
				<li><a href="<%=contextPath %>/admin/05_admin_cosloc_se.do"><span>코스 장소 목록</span></a></li>
				<li><a href="<%=contextPath %>/admin/05_admin_cosloc_in.do"><span>코스 장소 등록</span></a></li>
			</ul>
		</li>
		<li><a href="#"><span>지도 관리 메뉴</span></a>
			<ul style="display: block;">
				<li><a href="<%=contextPath %>/admin/05_admin_map_se.do"><span>지도 위치 목록</span></a></li>
				<li><a href="<%=contextPath %>/admin/05_admin_map_in.do"><span>지도 위치 등록</span></a></li>
			</ul>
		</li>
		<li><a href="#"><span>장소 아이콘 관리</span><span class="i"></span></a>
			<ul style="display: block;">
				<li><a href="<%=contextPath %>/admin/05_admin_icon_se.do"><span>장소 아이콘 목록</span></a></li>
				<li><a href="<%=contextPath %>/admin/05_admin_icon_in.do"><span>장소 아이콘 등록</span></a></li>
			</ul>
		</li>
	</ul>
</nav>