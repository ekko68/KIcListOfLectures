function loginCheck(){
 if(document.login.id.value==""){
  alert("아이디를를 입력해 주세요.");
  document.login.id.focus();
  return; //return false;
 }
 if(document.login.passwd.value==""){
  alert("비밀번호를 입력해 주세요.");
  document.login.passwd.focus();
  return;
 }
 document.login.submit();
}
 
function memberReg(){
 document.location="Register.jsp";
}
 
function inputCheck(){
 if(document.regForm.id.value==""){
  alert("아이디를 입력해 주세요.");
  document.regForm.id.focus();
  return;
 }
 if(document.regForm.passwd.value==""){
  alert("비밀번호를 입력해 주세요.");
  document.regForm.passwd.focus();
  return;
 }
 if(document.regForm.name.value==""){
  alert("이름을 입력해 주세요.");
  document.regForm.name.focus();
  return;
 }
 if(document.regForm.age.value=="0"){
  alert("나이를 선택해 주세요.");
  document.regForm.age.focus();
  return;
 }
 document.regForm.submit();
}
 
//중복ID체크 해주는 자바스크립트함수 선언
function idCheck(id){ //var idCheck=function(){}
   if(id==""){
    alert("아이디를 입력하세요.");
    document.regForm.id.focus();//document.폼객체명.입력양식.함수명()
   }else{ //window.open(불러올 문서명, 창 제목, 창의 옵션(넓이, 높이));
    //url="IdCheck.jsp";? 정해줄 변수 이름
    url="IdCheck.jsp?id="+id;
    window.open(url,"중복 확인 창","left=850,top=150,width=300,height=150");
    
   }
}