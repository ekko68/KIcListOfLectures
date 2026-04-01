<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring"  uri="http://www.springframework.org/tags" %>               
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>     


<%-- <link href="<c:url value='/resources/css/member/member.css?ver=1' />" rel="stylesheet"></link>
<script type="text/javascript" src="<c:url value='/resources/js/member/member.js?ver=1' />"></script> --%>
<script>
$(document).ready(function(){
	$('#email').on('blur', function(){
		var MsgId = $('MsgId')
		var id = $('#email').val();		
		//alert(id)				
		$.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/join/checked.do',
                data: {
                    "id" : $('#email').val()
                },
                error : function() {
                    alert('통신실패!!');
                },
                success: function(data){
                	alert('데이터 전송 성공')
                    if($.trim(data) == 0){
                        $('#MsgId').addClass('vaild');
                        $('#MsgId').text('사용가능');
                    }
                    else{
                    	$('#MsgId').removeClass('vaild');
                    	$('#MsgId').addClass('error');
                        $('#MsgId').text('사용할 수 없는 이메일');
                    }
                }
            });    //end ajax  id 중복체크
	});
	
});
</script>

<div class="container">
		<div class="main">
			<h4>회원가입</h4>
			<div>
				<form:form commandName="personCommand">
                    <fieldset>
                        <div>
                            <label for="email"></label> 
                            <form:input path="id" id="email"
                                name="firstname" placeholder="이메일 ( ex@apiktour.com)" onkeyup="ck_email()"/> 
                            <span id="MsgId" class="none">aa</span>
                        </div>
                        <div>
                            <label for="pwd"></label> 
                            <form:password path="passwd" id="pwd"
                                name="lastname" placeholder="비밀번호" onblur="ck_pwd()" /> 
                            <span id="MsgPw" class="none">유효성체크</span>
                        </div>  
                         <div>   
                            <label for="pwd_ck"></label> 
                            <input type="password"  id="pwd_ck"
                            name="lastname" placeholder="비밀번호 확인" onblur="ck_pwd2()" />
                             <span id="MsgPwck" class="none">유효성체크</span>
                        </div>    
                        <div>    
				            <label for="name"></label> 
				            <form:input path="name" id="name"
						name="lastname" placeholder="이름" onblur="ck_name()" /> 
                            <span id="MsgName" class="none">유효성체크</span>
                        </div>    
                        <div id="wrap_gender"> 
                            <span id="wrap_man" class="gender">
                            <form:radiobutton path="gender" id="man" name="gender" onclick="ck_gender()"  value="M" /> <label for="man"> 남자 </label>
                            </span>
                            <span id="wrap_woman" class="gender no_line">
						    <form:radiobutton path="gender" id="woman" name="gender" onclick="ck_gender()"  value="W"/> <label for="woman" onclick="ck_gender()"> 여자 </label>
                            </span>
                         </div> 
                        <span id="MsgGender" class="none">유효성체크</span>
                        <div> 
                        	<form:select path="age" id="age">
                                <form:option value="20">20대</form:option>
                                <form:option value="30">30대</form:option>
                                <form:option value="40">40대</form:option>
                            </form:select> 
                        </div>

                        <input type="submit" value="Submit">
                    </fieldset>
				</form:form>
			</div>
		</div>
	</div>
	
