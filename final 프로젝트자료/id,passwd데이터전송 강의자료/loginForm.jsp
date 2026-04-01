<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>

        <!-- script 태그에서 가져오는 자바스크립트 파일의 순서에 주의해야한다! 순서가 틀릴경우 자바스크립트 오류가 발생한다. -->
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/jsbn.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/rsa.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/prng4.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/rng.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
    </head>
    <body>
        <div>
            <label for="username">사용자ID : <input type="text" id="username" size="16"/></label>
            <label for="password">비밀번호 : <input type="password" id="password" size="16" /></label>
            <input type="hidden" id="rsaPublicKeyModulus" value="<%=publicKeyModulus%>" />
            <input type="hidden" id="rsaPublicKeyExponent" value="<%=publicKeyExponent%>" />
            <a href="<%=request.getContextPath()%>/loginFailure.jsp" onclick="validateEncryptedForm(); return false;">로그인</a>
        </div>
        <form id="securedLoginForm" name="securedLoginForm" action="<%=request.getContextPath()%>/login" method="post" style="display: none;">
            <input type="hidden" name="securedUsername" id="securedUsername" value="" />
            <input type="hidden" name="securedPassword" id="securedPassword" value="" />
        </form>
    </body>
</html>
