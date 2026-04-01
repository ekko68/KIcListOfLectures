
	function loginCheck(){
		if(document.login.mem_id.value==""){
			alert("아이디를 입력해 주세요.");
			document.login.mem_id.focus();
			return;
		}
		if(document.login.mem_passwd.value==""){
			alert("비밀번호를 입력해 주세요.");
			document.login.mem_passwd.focus();
			return;
		}
		document.login.submit();
	}
	

	function memberReg(){
		document.location="Register.jsp";
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
		if(document.regForm.mem_num1.value==""){
			alert("주민번호을 입력해 주세요.");
			document.regForm.mem_num1.focus();
			return;
		}
		if(document.regForm.mem_num2.value==""){
			alert("주민번호을 입력해 주세요.");
			document.regForm.mem_num2.focus();
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

		var jumin1=regForm.mem_num1.value;
		var jumin2=regForm.mem_num2.value;
		var jumin=jumin1+jumin2;
		var index="234567892345";
		var total=0;
		for(var i=0;i<12;i++)
			total+=parseInt(jumin.charAt(i)*index.charAt(i));

		total=11-total%11;
		if(total==10)
			total=0;
		else if(total==11)
			total=1;

		if(total!=jumin.charAt(12))
		{
			alert("주민번호를 다시 확인하세요.");
			document.regForm.mem_num1.value="";
			document.regForm.mem_num2.value="";
			document.regForm.mem_num1.focus();
			return;
		}

		if(document.regForm.mem_email.value==""){
			alert("이메일을 입력해 주세요.");
			document.regForm.mem_email.focus();
			return;
		}

		var str=document.regForm.mem_email.value;	   
		var atPos = str.indexOf('@');
		var atLastPos = str.lastIndexOf('@');
		var dotPos = str.indexOf('.'); 
		var spacePos = str.indexOf(' ');
		var commaPos = str.indexOf(',');
		var eMailSize = str.length;
		if (atPos > 1 && atPos == atLastPos && 
		   dotPos > 3 && spacePos == -1 && commaPos == -1 
		   && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
		else {
			  alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
			  document.regForm.mem_email.focus();
			  return;
		}

		document.regForm.submit();
	}
	
	function idCheck(id){
		if(id == ""){
			alert("아이디를 입력해 주세요.");
			document.regForm.mem_id.focus();
		}else{
			url="IdCheck.jsp?mem_id=" + id;
			window.open(url,"post","width=300,height=150");
		}
	}
	
	function zipCheck(){
			url="ZipCheck.jsp?check=y";
			window.open(url,"post","toolbar=no ,width=500 ,height=300 ,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	
	function productDetail(no) {
		document.detail.no.value=no;
		document.detail.submit();
	}
	

	function cartUpdate(form){
		form.flag.value="update"
		form.submit();
	}
	
	function cartDelete(form) {
		form.flag.value="del";
		form.submit();
	}