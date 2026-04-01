var karr = ['a','b','c']
var one = karr[0]
console.log(one,karr[1],karr[2])
//배열 디스트럭처링->배열의 각 요소를 분리->다른 변수에 저장시키는 방법

const karr2 = ['d','e','f']
/*
 var one1=karr2[0];
 var two2=karr2[1];
 var three3=karr2[2];
*/
//형식) const [변수1,변수2,변수3,,,] = 배열명
const [one1,two2,three3] = karr2;
console.log(one1,two2,three3);

let a2,b2,c2;
[a2,b2,c2]=[4,5,6];//1;1 대응관계->각각의 배열의값을 각각 다른 변수에 저장
console.log('a2->',a2,'b2->',b2,'c2->',c2)
console.log( `a2값 ${a2} b2값 ${b2} c2값 ${c2}`)

