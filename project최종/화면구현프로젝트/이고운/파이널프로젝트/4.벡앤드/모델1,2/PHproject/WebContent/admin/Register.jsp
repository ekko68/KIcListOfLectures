<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원가입</title>
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#996600" onLoad="">
	<br>
	<br>
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="/PHproject/admin/PersonInsert.do">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#FFFFFF"><b>회원 관리
										페이지</b></font></td>
						</tr>
						<tr>
							<td width="16%">아이디(이메일)</td>
							<td width="57%"><input type="text" name="id" size="15">
								<input type="button" value="ID중복확인"
								onClick="idCheck(this.form.id.value)"></td>
							<td width="27%">아이디를 적어 주세요.</td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="text" name="passwd" size="15">
							</td>
							<td>패스워드를 적어주세요.</td>
						</tr>						
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" size="15"></td>
							<td>이름을 적어주세요.(가명도 가능합니다.)</td>
						</tr>
						<tr>
							<td>성별</td>
							<td><select name="gender">
									<option value="M">남자</option>
									<option value="W">여자</option>
							</select></td>
							<td>성별을 선택 하세요.</td>
						</tr>
					<tr>
						<td>나이</td>
						<td><select name="age">
								<option value="0">선택하세요.</option>
								<option value="10">10대</option>
								<option value="20">20대</option>
								<option value="30">30대</option>
								<option value="40">40대</option>
								<option value="50">50대</option>
								<option value="60">60대</option>
								<option value="70">70대</option>
								<option value="80">80대</option>
								<option value="90">90대</option>
						</select></td>
						<td>나이을 선택 하세요.</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<input type="submit" value="회원등록" onclick=""> 
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						<input type="reset" value="다시쓰기"></td>
					</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>