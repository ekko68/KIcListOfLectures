<%@ page contentType="text/html;charset=EUC-KR" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<html:html>
<head>
  <title><bean:message key="itemDelete.title" /></title>
</head>
<body>
<html:form action="/deleteExecute">
  <div align="center" class="body">  
  <h2><font color="gray"><bean:message key="itemDelete.title" /></font></h2>
    <font color="red"><b><html:errors /></b></font>
    <html:hidden name="itemEditForm" property="item.itemId" />
  <table>
    <tr height="40px">
      <td>상품명</td>
      <td>
        <html:text name="itemEditForm" property="item.itemName" 
          styleClass="itemName" disabled="true"/>
      </td>
    </tr>
    <tr height="40px">
      <td>가격</td>
      <td>
        <html:text name="itemEditForm" property="item.price" 
          styleClass="price" disabled="true"/>&nbsp;엔
      </td>
    </tr>
    <tr height="40px">
      <td>파일명</td>
      <td>
        <html:text name="itemEditForm" property="item.pictureUrl" 
          styleClass="pictureUrl" disabled="true"/>
      </td>
    </tr>
    <tr height="40px">
      <td>개요</td>
      <td>
        <html:textarea name="itemEditForm" property="item.description"         
          styleClass="description" disabled="true"/>
      </td>
    </tr>
  </table>
  <br>
  <html:submit value="삭제" /><br>
  <br>
  <html:link action="/findAll" >돌아감</html:link>
  </div>
</html:form>
</body>
</html:html>
