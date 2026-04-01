<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function inputCheck() {
		if (document.getElementsByName("id")[0].value == "") {
			alert("아이디를 입력해주세요");
			return false;
		} else if (document.getElementsByName("passwd")[0].value == "") {
			alert("비밀번호를 입력해주세요");
			return false;
		} else {
			document.forms.regForm.submit();
		}
	}
</script>
<!--게시판의 글쓰기와 동일하다. -->
<form name="regForm" action="updateperson.do" method="post">
	<table width="600" border="0" cellspacing="0" cellpagging="0"
		align="center">
		<tr>
			<td colspan="2"><h3>스프링 게시판</h3></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${listperson.id }" readonly="true"> </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="text" name="passwd" value="${listperson.passwd }"> </td>
		</tr>
		<tr>
			<td>회원명</td>
			<td> <input type="text" name="name" value="${listperson.name }"> </td>
		</tr>
		<tr>
			<td>성별</td>
			<td> <input type="text" name="gender" value="${listperson.gender }"> </td>
		</tr>
		<tr>
			<td>나이</td>
			<td> <input type="text" name="age" value="${listperson.age }"> </td>			
		</tr>
		<tr>
			<td align="right" colspan="2"><input type="button" value="수정완료"
				onclick="inputCheck()"> <input type="reset" value="다시쓰기">
				<input type="button" value="목록"
				onclick="location.href='05_admin_m_se.do'"></td>
		</tr>
	</table>
</form>

