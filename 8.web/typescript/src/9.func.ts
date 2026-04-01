//src/9.func.ts
/*
  함수의 매개변수뒤에 ?을 주면 함수의 실행을 위해서 매개변수를 강제로
  전달하지 않아도 될때 사용한다.
  전달할 값이 있으면 전달하고 전달할 값이 없을 경우 전달하지 않을때
  에러가 나지 않도록 해주는 옵션(선택적)
*/
function display_detail(id:number,name:string,mail_id?:string){
    console.log("id=>",id);
    console.log("Name=>",name);
    if(mail_id!=undefined){
        console.log("email_id",mail_id);
    }
}
display_detail(123,"John");
display_detail(111,"Mary","mary@xyz.com");

//형식->유니언->나열하는 자료형의 목록중에서 해당하는 자료형을 선택해서 값을 저장
//             시켜주는 예약어(ex or연산자) 타입1 | 타입2 | 타입3

var valu:string | number //선언
valu=12; //숫자저장
console.log('숫자 valu=>',valu);
console.log(typeof valu,valu);//number

//함수->문자열 or 문자열배열
//반환값->유니언을 사용이 가능하다. 함수명(~):타입 | 타입2 
function disp2(name:string | string[]):string | string[]{
    if(typeof name=="string"){
        console.log('name->',name);
    }else{
        var i;
        for(i=0;i<name.length;i++){
            console.log(name[i]);
        }
    }
    return name;//return 반환할 값
}
console.log(disp2("Mark"));
console.log(disp2(["Mark","Tom","Mary","John"]));
//dist/node 9.func.js