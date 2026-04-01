var test=1234;
var test=7890; //중복선언

let test3=1234;
//let test3=7890; 중복선언 X

var funcs:number[]=[]; //배열생성

//var i는 for문에서만 사용을 하고 for문 밖에서 참조 O

for(var i=0;i<3;i++){
    funcs.push(i);
}
/*  for문 안에 let을 선언하는 경우의 변수는 for문밖에서 참조X
for(let i=0;i<3;i++){
    funcs.push(i);
}
*/
console.log(i);
//이미 저장된 배열의 값을 출력
for(var j=0;j<3;j++){
    //console.log(j);
    console.log(funcs[j]);
}

