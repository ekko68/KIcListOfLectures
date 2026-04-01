//객체=>{ 키:변수명,키2:변수명2~} ={ 키:값,키2:값2}
const {prop1:p1,prop2:p2} = { prop1:'a',prop2:'b'}
//객체명.키명=저장할값 var obj={ name:'Lee'}  obj.name='kim'
console.log({prop1:p1,prop2:p2})
//node 6.des3.js

//객체리터럴->default value값을 설정이 가능
//const {prop1,prop2,prop3} = { prop1:'ab',prop2:'bb',prop3:'cc'}
const {prop1,prop2,prop3='ccc'} = { prop1:'ab',prop2:'bb'}
//객체명.키명=저장할값 var obj={ name:'Lee'}  obj.name='kim'
console.log({prop1,prop2,prop3})

//함수를 이용해서 값을 저장
function margin(){
    //left,right,top,bottom->값이 저장
    const left=1,right=2,top=3,bottom=4;
    return {left,right,top,bottom};//객체
}
const {left,bottom} = margin();//={left,right,top,bottom};
console.log(left,bottom)//1,4