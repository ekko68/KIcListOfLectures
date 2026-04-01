<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function inputCheck() {
		if (document.getElementsByName("cosnum")[0].value == "") {
			alert("코스id를 입력해주세요");
			return false;
		} else if (document.getElementsByName("play")[0].value == "") {
			alert("쉴래?놀래?를 입력해주세요");
			return false;
		} else {
			document.forms.regForm.submit();
		}
	}
</script>
<!--게시판의 글쓰기와 동일하다. -->
<form name="regForm" action="updatecourse.do" method="post">
	<table width="600" border="0" cellspacing="0" cellpagging="0"
		align="center">
		<tr>
			<td colspan="2"><h3>코스 수정</h3></td>
		</tr>
		<tr>
			<td>코스 아이디</td>
			<td><input type="text" name="cosnum"
				value="${listcourse.cosnum }" readonly="true"></td>
		</tr>
		<tr>
			<td>쉴래? 놀래?</td>
			<td><input type="text" name="play" value="${listcourse.play }">
			</td>
		</tr>
		<tr>
			<td>코스명</td>
			<td><input type="text" name="cosname"
				value="${listcourse.cosname }"></td>
		</tr>
		<tr>
			<td>에너지 & 피로도 level값</td>
			<td><input type="text" name="lv" value="${listcourse.lv }">
			</td>
		</tr>
		<tr>
			<td>간략한 소개글</td>
			<td><textarea name="intro" rows="5" cols="50">${listcourse.intro }</textarea></td>
		</tr>
		<tr>
			<td align="right" colspan="2"><input type="button" value="수정완료"
				onclick="inputCheck()"> <input type="reset" value="다시쓰기">
				<input type="button" value="목록"
				onclick="location.href='05_admin_cos_se.do'"></td>
		</tr>
	</table>
</form>

