<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html>
<head>
  <title><bean:message key="itemMenu.title" /></title>
</head>
<body>
<html:form action="/findByItemName">
  <div align="center" class="body">
  <h2><bean:message key="itemMenu.title" /></h2>
  상품명검색<html:text property="searchItemName" />
  <html:submit property="searchBtn" value="검색" />
  
  <html:link action="/createEdit">상품등록</html:link>
  <br>
  <br>
  <table border="1">
    <tr class="header">
      <th align="center" width="80">상품ID</th>
      <th align="center" width="320">상품명</th>
      <th align="center" width="100">가격</th>
      <th align="center" width="80">편집</th>
      <th align="center" width="80">삭제</th>
    </tr>
    <logic:iterate id="item" name="itemMenuForm" 
        property="itemList" type="logic.Item">
      <tr class="record">
        <td align="center"><bean:write name="item" property="itemId" /></td>
        <td align="left" ><bean:write name="item" property="itemName" /></td>
        <td align="right"><bean:write name="item" property="price" />원</td>
        <td align="center"><html:link action="/updateEdit" paramId="selectItemId"
             paramName="item" paramProperty="itemId">
           상품편집</html:link></td>
        <td align="center"><html:link action="/deleteEdit" paramId="selectItemId" 
             paramName="item" paramProperty="itemId">
           상품삭제</html:link></td>
      </tr>
    </logic:iterate>
  </table>
  <br>
  </div>
</html:form>
</body>
</html>
