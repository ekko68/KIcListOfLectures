import { Injectable } from '@angular/core';

//의존성 객체를 생성해서 원하는 컴포넌트에게 객체를 줄 수있는 클래스
//서비스명.service.ts
//<bean id="helloService " class="app.HelloService" />

@Injectable()
export class HelloService {

  constructor() { }
  //공통으로 사용하는 기능
  sayHello(){
    return "Hello 서비스(모든 컴포넌트가 사용이 가능함)";
  }
}
