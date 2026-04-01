<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>코스 등록</title>
<script>
	function inputCheck(){
		if(document.getElementsByName("cosnum")[0].value==""){
			alert("아이디를 입력해주세요");
			return false;
		}else if(document.getElementsByName("play")[0].value==""){
			alert("쉴래? 놀래?를 입력해주세요");
			return false;
		}else{
		document.forms.regForm.submit();
		}
	}
</script>
</head>
<body onLoad="regForm.id.focus()">
	<br>
	<br>
	<table class="container">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="insertcourse.do">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#FFFFFF"><b>코스 등록
										페이지</b></font></td>
						</tr>
						<tr>
							<td width="16%">등록할 코스 id 값 (자동 등록)</td>
							<td width="57%"><input type="text" name="cosnum" size="15"
								readonly="true"> <input type="button" value="자동 등록"
								onClick="idCheck(this.form.id.value)"></td>
							<td width="27%">버튼을 눌러 자동 등록 해주세요.</td>
						</tr>
						<tr>
							<td>쉴래? 놀래?</td>
							<td><select name="play">
									<option value="REST">쉴래?</option>
									<option value="PLAY">놀래?</option>
							</select></td>
							<td>쉴래? 놀래? 중에 선택해주세요.</td>
						</tr>
						<tr>
							<td>코스 명 (한글 20글자)</td>
							<td><input type="text" name="cosname" size="15"></td>
							<td>코스 명을 적어주세요.</td>
						</tr>
					<tr>
						<td>level값</td>
						<td><select name="lv">
								<option value="1">1레벨</option>
								<option value="2">2레벨</option>
								<option value="3">3레벨</option>
								<option value="4">4레벨</option>
								<option value="5">5레벨</option>
						</select></td>
						<td>에너지&피로도 level값을 선택해주세요.</td>
					</tr>
					<tr>
						<td>소개글</td>
						<td><textarea name="intro" rows="5" cols="50"></textarea></td>
						<td>장소에대한 간략한 소개글을 작성해주세요</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="button"
							value="장소 등록" onclick="inputCheck()"> &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; <input type="reset" value="다시쓰기"></td>
					</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>