function loginCheck(){
	if(document.login.mem_id.value==""){
		alert("아이디를 입력해 주세요.");
		document.login.mem_id.focus();
		return; //return false;
	}
	if(document.login.mem_passwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.login.mem_passwd.focus();
		return;
	}
	//document.폼객체명.submit()
	document.login.submit();
}

//회원가입버튼을 눌렀을때 Register.jsp로 이동
function memberReg(){
	//document.location="Register.jsp"
	document.location="agreement.jsp" //->Register.jsp
   //response.sendRedirect(~) X
}
function inputCheck(){
	if(document.regForm.mem_id.value==""){
		alert("아이디를 입력해 주세요.");
		document.regForm.mem_id.focus();
		return;
	}
	if(document.regForm.mem_passwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.regForm.mem_passwd.focus();
		return;
	}
	if(document.regForm.mem_repasswd.value==""){
		alert("비밀번호를 확인해 주세요");
		document.regForm.mem_repasswd.focus();
		return;
	}
	if(document.regForm.mem_name.value==""){
		alert("이름을 입력해 주세요.");
		document.regForm.mem_name.focus();
		return;
	}
	
	if(document.regForm.mem_email.value==""){
		alert("이메일을 입력해 주세요.");
		document.regForm.mem_email.focus();
		return;
	}
	if(document.regForm.mem_phone.value==""){
		alert("연락처를 입력해 주세요.");
		document.regForm.mem_phone.focus();
		return;
	}
	if(document.regForm.mem_job.value=="0"){
		alert("직업을 선택해 주세요.");
		document.regForm.mem_job.focus();
		return;
	}
	
	if(document.regForm.mem_passwd.value != document.regForm.mem_repasswd.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.mem_repasswd.focus();
		return;
	}
	document.regForm.submit();//RegisterProc.jsp
}

//중복ID체크 해주는 자바스크립트함수 선언
/*
function idCheck(id){  //var idCheck=function(){}
   if(id==""){
	   alert("아이디를 먼저 입력하세요")
	   document.regForm.mem_id.focus() //document.폼객체명.입력양식.함수명()
   }else{ //=>window.open(불러올 문서명(jsp),창제목,창의옵션(넓이,높이,,,)
	   //url="IdCheck.jsp"  IdCheck.jsp를 불러올 뿐 매개변수 전달 X
	   url="IdCheck.jsp?mem_id="+id
	   window.open(url,"post","left=450,top=150,width=300,height=150")
   }
}
*/
//우편번호를 검색해주는 함수선언->ZipCheck.jsp?check=y
//check=y->검색전의 창의 모습을 구분하는 인자(매개변수로 지정하기위해서)
//scrollbars=yes|no, status=yes|no
function zipCheck(){
    url="ZipCheck.jsp?check=y"
    window.open(url,"post","left=400,top=220,toolbar=no,width=500,height=300," +
    		"menubar=no,status=yes,scrollbars=yes")
}










