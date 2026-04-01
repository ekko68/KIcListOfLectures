//1et,var의 차이점->변수를 선언할때 사용
//var ->전역변수 ,let->block level scope
var foo=123;
console.log(foo);//변수를 선언하지 않고 출력X
{
  var foo=456; //중복선언이 가능하다. 
}
console.log(foo);
//node let1.js
let foo2=789;
console.log(foo2);
{
  let foo2:number=456;//중복선언X
  let bar:number=456;//블럭 범위내에서만 사용
  console.log(bar);//456
}
console.log(foo2);//789->456 변경X(호이스팅문제가 해결)
//console.log(bar); 블럭범위 밖에서는 let 으로 선언된 변수를 참조X