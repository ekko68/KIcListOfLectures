//3.map함수->콜백함수
//map함수는 기존의 배열의 요소들을 하나씩 읽어들여서 계산후->길이가 같은
//새로운 배열을 하나 만들때 사용하는 함수

var arr2 = [1,2,3];
var pow3 = arr2.map(function(x){
    //배열의 들어있는 요소를 하나씩 읽어들여서 함수의 내용수행->결과배열리턴
    return x + x;
});
console.log(pow3);//[1,2,3]->[2,4,6]
const arr3 = [6,7,8];//->[12,14,16]
const pow4 = arr3.map(x=>x + x);
console.log(pow4);

var a=[3,4,5,6,7];
/*
var c = a.map(function(v,i){ //v의 배열의 항목, i의 인덱스번호
    console.log(v);
    return v+1;
});*/
var c = a.map((v,i)=>{
    console.log(v);
    return v+1;
});
console.log('c=>',c)
//4.배열->reduce함수->콜백함수->(앞의 매개변수,뒤의 매개변수 연산)->배열리턴
function addRounded(pre,current){ //(1,2)=>함수의 결과값을 매개변수로 전달 
                                  //(3,3)->3+3=6
    return pre+current;
}
var numbers = [1,2,3,4];
//형식)var 변수(새로운배열)=기존배열명.reduce(함수명) or (함수명,매개변수)
var result=numbers.reduce(addRounded);//(f)
var result2=numbers.reduce(addRounded,1);//(f,n)->n이 첫번째 매개변수항목이 된다.
//(1+1)=(2,2)=>(4,3)=>(7,4)=11
console.log('result->',result,'result2->',result2)//6
//5.forEach함수를 사용->for문 대신에 성능향상(거의 차이가 없다)
var array=[1,2,3]
array.forEach(function(v,i){//항목,i 인덱스
   if(v === 3){
      console.log(v+":"+i); //3(항목):2(인덱스)
   }
});