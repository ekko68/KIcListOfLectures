<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>장소 Type 관리</title>

</head>
<body onLoad="regForm.id.focus()">
	<br>
	<br>
	<table class="container">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="iconInsert.jsp">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#FFFFFF"><b>장소 Type 등록
										페이지</b></font></td>
						</tr>
						<tr>
							<td width="16%">등록할 장소 Type 값</td>
							<td width="57%"><input type="text" name="loctype" size="15">
								<input type="button" value="중복 체크 "
								onClick="idCheck(this.form.id.value)"></td>
							<td width="27%">장소 Type (ex) "A001", "A002")</td>
						</tr>					
						<tr>
							<td>장소 정보</td>
							<td><input type="text" name="type" size="15"></td>
							<td>장소 정보 (ex)카페, 박물관, 산) </td>
						</tr>						
					<tr>
						<td colspan="3" align="center"><input type="button"
							value="장소 Type 등록" onclick="inputCheck()"> &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; <input type="reset" value="다시쓰기"></td>
					</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>