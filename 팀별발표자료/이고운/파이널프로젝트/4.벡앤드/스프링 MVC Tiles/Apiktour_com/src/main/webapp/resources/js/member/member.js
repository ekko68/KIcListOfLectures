

/*$(document).ready(function(){
	$('#email').on('blur', function(){
		var MsgId = $('MsgId')
		var id = $('#email').val();		
		alert(id)				
		$.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/join/checked.do',
                data: {
                    "id" : $('#email').val()
                },
                success: function(data){
                    if($.trim(data) == 0){
                        $('#MsgId').addClass('vaild');
                        $('#MsgId').text('사용가능');
                    }
                    else{
                    	//$('#MsgId').removeClass('vaild');
                    	$('#MsgId').addClass('error');
                        $('#MsgId').text('사용할 수 없는 이메일');
                    }
                }
            });    //end ajax   
	});
	
});
*/

function ck_email(){
        var email = document.getElementById("email")
        var MsgId = document.getElementById("MsgId")
        var isEmail = /([\w\-]+\@[\w\-]+\.[\w\-]+)/
        
        
        if(!isEmail.test(email.value)){
            //alert(email.value+'는 안됨!')
            MsgId.style.display="block";
            MsgId.className='error'
            MsgId.innerHTML="이메일 형식을 확인하세요"
            //email.focus()
            return false;
        } else{
            MsgId.className='vaild'
            MsgId.innerHTML="ok"
        }   
}

function ck_pwd(){
        var pwd = document.getElementById("pwd")
        var MsgPw = document.getElementById("MsgPw")
        var isPwd = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
        
        if(!isPwd.test(pwd.value)){
            MsgPw.style.display="block";
            MsgPw.className='error'
            MsgPw.innerHTML="숫자포함 최소 6자리 이상"
           // pwd.focus()
            return false;
        } else{
            MsgPw.className='vaild'
            MsgPw.innerHTML="ok"
        }   
}


function ck_pwd2(){
        var pwd_ck = document.getElementById("pwd_ck")
        var pwd = document.getElementById("pwd").value
        var MsgPwck = document.getElementById("MsgPwck")
        
        if(pwd_ck.value!=pwd){
            MsgPwck.style.display="block";
            MsgPwck.className='error'
            MsgPwck.innerHTML="비밀번호가 일치하지 않습니다."
            pwd_ck.focus()
            return false;
        } else{
            MsgPwck.className='vaild'
            MsgPwck.innerHTML="ok"
        }   
}


function ck_name(){
        var name = document.getElementById("name")
        var MsgName = document.getElementById("MsgName")
        
        if(name.value==''){
            MsgName.style.display="block";
            MsgName.className='error'
            MsgName.innerHTML="2자 이상 입력하세요."
            //name.focus()
            return false;
        } else{
            MsgName.className='vaild'
            MsgName.innerHTML="ok"
        }   
}


function ck_gender(){
    var wrap_gender = document.getElementById("wrap_gender")
    var man = document.getElementById("man")
    var woman = document.getElementById("woman")
    var MsgGender = document.getElementById("MsgGender")

    
    if(man.checked){
        document.getElementById("wrap_man").className='gender_act';
        document.getElementById("wrap_woman").className='gender';
    }
    
    if(woman.checked){
        document.getElementById("wrap_woman").className='gender_act';
        document.getElementById("wrap_man").className='gender';
    }
    
    
}


/*    
    if(man.checked == false && woman.checked == false){
        MsgGender.style.display="block";
        MsgGender.className='error'
        MsgGender.innerHTML="필수 정보입니다."        wrap_gender.style.borderColor="red";
        return false;
    }
    */


/*
id 중복 체크
   idFlag = false;
    try {
        var xmlhttp = getXmlHttp();
        xmlhttp.open("GET", "/user2/joinAjax.nhn?m=checkId&id=" + id);
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4) {
                var result = xmlhttp.responseText.substr(4, 999);
                if (result == "Y") {
                    if (event == "first") {
                        oMsg.style.display = "block";
                        oMsg.className = "error gm";
                        oMsg.innerHTML = "멋진 아이디네요!";
                    } else {
                        oMsg.style.display = "none";
                    }
                    idFlag = true;
                    return true;
                } else {
                    oMsg.style.display = "block";
                    oMsg.className = "error";
                    oMsg.innerHTML = "이미 사용중이거나 탈퇴한 아이디입니다.";

                    lua_do('join_kr'+document.getElementById("platform").value,'',ERROR_FORMAT_ID, document.getElementById("token_sjoin").value, true,'');
                    return false;
                }
            }
        };
        xmlhttp.send(null);
    } catch (e) {
        if (window.bridgeGotTime) {
            throw e;
        }
    }

    return true;
*/



