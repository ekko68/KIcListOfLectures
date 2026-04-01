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
		
		
		//3.age이 숫자인지 체크
		
		
		//4.pwd입력체크
		
		
		//5.pwd불일치여부 확인
		return true;//전송이 가능하게 설정
	})
})


