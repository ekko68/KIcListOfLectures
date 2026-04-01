/**
 * jquery를 불러오는 경우
 */
$(function(){
	//특정태그를 화면에 보여주고,안보여주기(->hide()<->show())
	$('#id_error').hide()
	$('#age_error1').hide()
	$('#age_error2').hide()
	$('#p_error1').hide()
	$('#p_error2').hide()
	
	//전송버튼을 눌렀다면(input type="submit"->submit(~)
	$('#btnSend').click(function(){
		//1.id입력체크
		var id=$('#userid').val()
		if(id.length < 1){
			$('#id_error').show() //에러메세지를 출력
			return false;
		}else{//한글자라도 입력했다면
			$('#id_error').hide() 
		}
		
		//2.age입력 체크
		var age=$('#age').val()
		if(age.length < 1){
			$('#age_error1').show() //에러메세지를 출력
			return false;
		}else{//한글자라도 입력했다면
			$('#age_error1').hide() 
		}
		
		//3.age이 숫자인지 체크->2a or a,23a->입력받은 문자열의 길이
		// 0~9범위를 벗어나면
		for(var i=0;i<age.length;i++){
			var data=age.charAt(i).charCodeAt(0);//아스키코드값을 반환
			//alert(data) //48~57
			if(data < 48 || data > 57){//문자인지 체크
				$('#age_error2').show()
				return false;
				break;//탈출문
			}else{//숫자를 입력한 경우라면
				$('#age_error2').hide()
			}
		}
		
		//4.pwd입력체크
		var pwd1=$('#pwd1').val()
		if(pwd1.length < 1){
			//$('#p_error1').show() //에러메세지를 출력
			$('#pwd1').next().show()
			return false;
		}else{//한글자라도 입력했다면
			$('#pwd1').next().hide() 
		}
		
		//5.pwd불일치여부 확인
		var pwd2=$('#pwd2').val()
		if(pwd2.length < 1){
			$('#pwd2').next().show()
			return false;
		}else{//한글자라도 입력했다면
			$('#pwd2').next().hide() 
		}
		//불일치 체크
		if(pwd1!=pwd2){
			$('#p_error2').show()
		}
		//다입력했다면 document.form객체명.submit()->action=>'register.jsp'
		$('#signup').attr('action','register.jsp').submit();
		
		return true;//전송이 가능하게 설정
	})
})




