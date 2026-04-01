"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
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
var pi = Math.PI; //export const 선언부분
exports.pi = pi;
function square(x) {
    return x + x;
}
exports.square = square;
console.log(square(10));
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    return Person;
}());
exports.Person = Person;
//형식) export { pi,square,Person };  export{ 상수,함수,클래스를 ,나열 }; 

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIjEwLmxpYi50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOztBQUFBLFdBQVc7QUFDWCwwQkFBMEI7QUFDMUIsbUNBQW1DO0FBQ25DOzs7Ozs7Ozs7Ozs7Ozs7RUFlRTtBQUNGLGdDQUFnQztBQUNoQyxJQUFNLEVBQUUsR0FBRyxJQUFJLENBQUMsRUFBRSxDQUFDLENBQUUsbUJBQW1CO0FBY2hDLGdCQUFFO0FBWlYsZ0JBQWdCLENBQUM7SUFDYixNQUFNLENBQUMsQ0FBQyxHQUFHLENBQUMsQ0FBQztBQUNqQixDQUFDO0FBVVUsd0JBQU07QUFSakIsT0FBTyxDQUFDLEdBQUcsQ0FBQyxNQUFNLENBQUMsRUFBRSxDQUFDLENBQUMsQ0FBQztBQUV4QjtJQUVJLGdCQUFZLElBQUk7UUFDWixJQUFJLENBQUMsSUFBSSxHQUFDLElBQUksQ0FBQztJQUNuQixDQUFDO0lBQ0wsYUFBQztBQUFELENBTEEsQUFLQyxJQUFBO0FBQ2lCLHdCQUFNO0FBQ3hCLDZEQUE2RCIsImZpbGUiOiIxMC5saWIuanMiLCJzb3VyY2VzQ29udGVudCI6WyIvLzEwLmxpYi50c1xyXG4vL+2VqOyImCxjb25zdCjsg4HsiJgpLO2BtOuemOyKpOuPhCDsnpHshLHsnbQg6rCA64qlXHJcbi8vMS7tlajsiJgs7IOB7IiYLO2BtOuemOyKpOuqhSDslZ7sl5Ag7J287J287J20IGV4cG9ydOulvCDsk7DripQg67Cp67KVXHJcbi8qXHJcbmV4cG9ydCBjb25zdCBwaSA9IE1hdGguUEk7ICAvL2V4cG9ydCBjb25zdCDshKDslrjrtoDrtoRcclxuXHJcbmV4cG9ydCBmdW5jdGlvbiBzcXVhcmUoeCl7XHJcbiAgICByZXR1cm4geCArIHg7XHJcbn1cclxuXHJcbmNvbnNvbGUubG9nKHNxdWFyZSgxMCkpO1xyXG5cclxuZXhwb3J0IGNsYXNzIFBlcnNvbntcclxuICAgIG5hbWU6c3RyaW5nOy8vZXM27JeQ7ISc64qUIOuppOuyhOuzgOyImC0+7IOd7ISx7J6Q66W8IO2Gte2VtOyEnCDstIjquLDtmZRcclxuICAgIGNvbnN0cnVjdG9yKG5hbWUpe1xyXG4gICAgICAgIHRoaXMubmFtZT1uYW1lO1xyXG4gICAgfVxyXG59XHJcbiovXHJcbi8vMi50c+2MjOydvCDrsJHsl5Ag7ZWc6rq867KI7JeQIGV4cG9ydOulvCDsp4DsoJXtlZjripQg67Cp67KVXHJcbmNvbnN0IHBpID0gTWF0aC5QSTsgIC8vZXhwb3J0IGNvbnN0IOyEoOyWuOu2gOu2hFxyXG5cclxuZnVuY3Rpb24gc3F1YXJlKHgpe1xyXG4gICAgcmV0dXJuIHggKyB4O1xyXG59XHJcblxyXG5jb25zb2xlLmxvZyhzcXVhcmUoMTApKTtcclxuXHJcbmNsYXNzIFBlcnNvbntcclxuICAgIG5hbWU6c3RyaW5nOy8vZXM27JeQ7ISc64qUIOuppOuyhOuzgOyImC0+7IOd7ISx7J6Q66W8IO2Gte2VtOyEnCDstIjquLDtmZRcclxuICAgIGNvbnN0cnVjdG9yKG5hbWUpe1xyXG4gICAgICAgIHRoaXMubmFtZT1uYW1lO1xyXG4gICAgfVxyXG59XHJcbmV4cG9ydCB7cGksc3F1YXJlLFBlcnNvbn07XHJcbi8v7ZiV7IudKSBleHBvcnQgeyBwaSxzcXVhcmUsUGVyc29uIH07ICBleHBvcnR7IOyDgeyImCztlajsiJgs7YG0656Y7Iqk66W8ICzrgpjsl7QgfTsiXX0=
