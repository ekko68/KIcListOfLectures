<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<head>
  <title>관리자 로그인화면</title>
</head>
<body>
  <div align="center" class="body">  
    <h2>관리자 로그인화면</h2>
    <c:choose>
      <c:when test="${not empty param.login_error}">
        <font color="red">
          입력된 유저ID, 패스워드는 부정한다.<br>
        </font>
      </c:when>
    </c:choose>
    <form action="acegiSecurity" method="post">
      <table>
        <tr height="40px">
          <td>유저ID</td>
          <td>
          <input class="userId" type="text" 
                 class="text" name="j_username" size="20">
          </td>
        </tr>
        <tr height="40px">
          <td>패스워드</td>
          <td>
            <input class="password" type="password" 
                   class="text" name="j_password" size="20">
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center"></td>
        </tr>
      </table>
      <table>
        <tr>
          <td align="center"><input type="submit" value="전송"></td>
        </tr>
      </table>
    </form>
    <br>
  </div>
</body>
</html>
