//10.lib.ts
//함수,const(상수),클래스도 작성이 가능
//1.함수,상수,클래스명 앞에 일일이 export를 쓰는 방법
/*
export const pi = Math.PI;  //export const 선언부분

export function square(x){
    return x + x;
}

console.log(square(10));

export class Person{
    name:string;//es6에서는 멤버변수->생성자를 통해서 초기화
    constructor(name){
        this.name=name;
    }
}
*/
//2.ts파일 밑에 한꺼번에 export를 지정하는 방법
const pi = Math.PI;  //export const 선언부분

function square(x){
    return x + x;
}

console.log(square(10));

class Person{
    name:string;//es6에서는 멤버변수->생성자를 통해서 초기화
    constructor(name){
        this.name=name;
    }
}
export {pi,square,Person};
//형식) export { pi,square,Person };  export{ 상수,함수,클래스를 ,나열 };