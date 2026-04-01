//4.arrow.ts(화살표 함수)->자바의 람다함수->

var pow = function(x:number){  //function pow(x){}
  console.log('x=>',x) //출력문자열,출력할변수명
  return x * x;
}

console.log(pow(10));
//형식) const 변수명 = (매개변수명,매개변수명2,,)=> {처리구문;
// 본문내용이 한문장 이상->{} 처리할것               처리구문2;}
//자료형을 쓰지 않으면 any(어떠한 자료형도 수행)=>권장 X 자료형을 반드시쓸것
const pow2 = x => x * x;
console.log(pow2(20));
/*
c:\webtest\8.web\typescript\dist>node 4.arrow.js
x=> 10
100
400
*/