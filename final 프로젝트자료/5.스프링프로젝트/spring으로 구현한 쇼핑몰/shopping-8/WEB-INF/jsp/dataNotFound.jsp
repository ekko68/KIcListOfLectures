<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html:html>
<head>
  <title><bean:message key="errors.dataNotFound" /></title>
</head>
<body>
  <div align="center" class="body">
  <h2><font color="red"><bean:message key="errors.dataNotFound" /></font></h2>
  <a href="findAll.do">■리스트로 돌아감</a>
  </div>
</body>
</html:html>

