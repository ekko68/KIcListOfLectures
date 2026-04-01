import { Injectable } from '@angular/core';

//@Injectable() ->서비스 클래스를 알려주는 역할(앵글러)

@Injectable()
export class TimeService { //공통적으로 현재 시간을 출력

  constructor() { }
  //추가
  getCurrentTime(){
     //const d=new Date();
     //return d;
    return new Date();
  }
}
