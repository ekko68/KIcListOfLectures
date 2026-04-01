<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- tilesdef.xml에서의
	<put-attribute name="title" value="메인페이지">
 -->
<title><tiles:getAsString name="title"/></title>
<tiles:insertAttribute name="css"/>
<tiles:insertAttribute name="js"/>
</head>
<body>
	<table class="table" border="1" cellpadding="0" cellspacing="1" bgcolor="#a0a0a0" width="100%" top="0px">
		<tr height="100" valign="middle" bgcolor="#ccffcc" top="0px">
			<td colspan="2">
				<tiles:insertAttribute name="header"/>
			</td>
		</tr>
		
		<tr height="100%" valign="middle" bgcolor="#FFF">
			<td width="15%" valign="top" bgcolor="#fafafa">
				<tiles:insertAttribute name="menu"/>
			</td>
			<td width="85%" valign="top" class="content">
				<tiles:insertAttribute name="content"/>
			</td>
		</tr>
		
		<tr height="100" valign="middle" bgcolor="#FFF" class="footer" width="100%">
			<td colspan="2" bgcolor="#008000">
				<tiles:insertAttribute name="footer"/>
			</td>
		</tr>
	</table>
</body>
</html>