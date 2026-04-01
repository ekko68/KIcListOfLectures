//const 상수화 시킬때 사용(react)
const TOO = 123;
//const TOO2;//1.const를 사용할때에는 반드시 상수화된 변수에 초기값을 설정
//TOO = 456; 2.중간에 값을 변경할 수가 없다.(불가능)

{
    const TOO = 10;
    console.log(TOO);//10
    const TOO2 = 45;
}
console.log(TOO);
//console.log(TOO2); 블럭 밖에서 TOO2를 참조 X