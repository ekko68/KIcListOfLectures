//형식) import {불러올 클래스,상수,함수} from '상대경로 및 불러올파일명';
//import {pi,square,Person} from './10.lib';  //확장자는 생략

import * as lib from './10.lib' //별칭명.불러올 상수,함수,클래스,,,,
//형식) import * as 별칭명 from '상대경로 및 불러올파일명';

console.log(lib.pi);//console.log(pi);
console.log(lib.square(10));//console.log(square(10));
console.log(new lib.Person('Lee'));//const 객체명=new 클래스명(매개변수)
//console.log(new Person('Lee'));
//dist>node 10.main.js