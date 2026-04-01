<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,hewon.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="memMgr"  class="hewon.MemberDAO" />
<%
   request.setCharacterEncoding("utf-8");
   //
   String check=request.getParameter("check");//y->n
   String area3=request.getParameter("area3");
   System.out.println("check="+check+",area3="+area3);
   //MemberDAO memMgr=new MemberDAO();
   Vector<ZipcodeDTO> zipcodeList=memMgr.zipcodeRead(area3);
   int totalList=zipcodeList.size();
   System.out.println("검색된 총레코드수(totalList)=>"+totalList);

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호 검색</title>
<link href="style.css" rel="stylesheet"  type="text/css">
<script>
//동이름을 체크할 함수선언
  function dongCheck(){
	  if(document.zipForm.area3.value==""){
		  alert("동이름을 먼저 입력하세요!");
		  document.zipForm.area3.focus();
		  return;
	  }
	  document.zipForm.submit();//ZipCheck.jsp로 전송(area3='수유3동'&check=n)
  }
  //검색된 레코드중에서 내 주소와 가장 가까운 주소를 링크클릭
  //->Register.jsp넣어주는함수->자식창->부모창을 가리킬때 opener
  //opener.document.폼객체명.입력양식.속성=값
  function sendAddress(zipcode,area1,area2,area3,area4){
	  var address=area1+" "+area2+" "+area3+" "+area4
	  opener.document.regForm.mem_zipcode.value=zipcode;
	  opener.document.regForm.mem_address.value=address;
	  self.close();//self->ZipCheck.jsp창(자식창)
  }
</script>
</head>
<body bgcolor="#FFFFCC">

  <center>
    <b>우편번호 찾기</b>
    <table>
  <!--ZipCheck.jsp?area3='수유3동'&check=n -->
   <form name="zipForm" method="post"   action="ZipCheck.jsp">
        <tr>
        <td><br>
        동이름 입력:<input type="text"   name="area3">
        <input type="button" value="검색"  onclick="dongCheck()">
        </td>
        </tr>    
        <input type="hidden" name="check"  value="n">
   </form>
 <%
   //검색어를 입력하고 검색버튼을 눌렀다면
   //if(zipcodeList.size()==0){ //검색된 레코드가 없다면
   if(check.equals("n")){
	   if(zipcodeList.isEmpty()){  %>
		    <tr><td align="center"><br>검색된 레코드가 없습니다.</td></tr>  
<% }else{ %>
	<tr><td align="center"><br>
	   *검색후 ,아래 우편번호를 클릭하면 자동으로
	     입력됩니다</td></tr>
	 <%
	    for(int i=0;i<totalList;i++){
	      ZipcodeDTO zipBean=zipcodeList.elementAt(i);//zipcodeList.get(i);
	      String tempZipcode=zipBean.getZipcode();//우편번호
	      String tempArea1=zipBean.getArea1().trim();//시->"서울      "->"서울"
	      String tempArea2=zipBean.getArea2().trim();//구
	      String tempArea3=zipBean.getArea3().trim();//동
	      String tempArea4=zipBean.getArea4().trim();//나머지
	 %>  
	  <tr><td>
	  <a href="JavaScript:sendAddress('<%=tempZipcode%>',
	                                                        '<%=tempArea1%>',
	                                                        '<%=tempArea2%>',
	                                                        '<%=tempArea3%>',
	                                                        '<%=tempArea4%>')">
	<%=tempZipcode%>&nbsp;<%=tempArea1%>&nbsp;<%=tempArea2%>
	&nbsp; <%=tempArea3%>&nbsp;<%=tempArea4%> </a><br> 
<%	 
	    }//for
     }//else
   }//outer if
 %>  
    </td></tr>
    <tr><td align="center"><br>
<a href="JavaScript:this.close()">닫기</a>                      
    </table>
  </center>
</body>
</html>