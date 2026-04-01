<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page isELIgnored="false"%>

<link rel="stylesheet" type="text/css" href="css/shopping-6.css">
<html:html>
<head>
  <title><bean:message key="itemMenu.title" /></title>
</head>
<body>
  <div align="center" class="body">
  <h2><bean:message key="itemMenu.title" /></h2>
  <table border="1">
    <tr class="header">
      <th align="center" width="80">상품ID</th>
      <th align="center" width="320">상품명</th>
      <th align="center" width="100">가격</th>
    </tr>
    <logic:iterate id="item" name="itemMenuForm" property="itemList">
      <tr class="record">
        <td align="center">
          <bean:write name="item" property="itemId" />
        </td>
        <td align="left">
          <bean:write name="item" property="itemName" />
        </td>
        <td align="right">
          <bean:write name="item" property="price" />원
        </td>
      </tr>
    </logic:iterate>
  </table>
  </div>
</body>
</html:html>
