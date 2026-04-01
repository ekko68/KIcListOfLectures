import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //자식(book)컴포넌트에게 전달할 값->변수로 선언
  mesg="hello";
  mesg2=200;
  mesg3=[10,20,30];//배열
  static mesg4="world";//정적 변수
  //set 메서드명(~) {this.멤버변수=값}
  get getMesg(){
    return AppComponent.mesg4; //return this.mesg;
  }
  //자식으로부터 전달받는 매개변수를 받아서 처리해주는 함수
  //함수(매개변수명:상대방의 보내준데이터의 자료형)
  ppp(name:string){
    this.mesg=name;//name->"안녕하세요"
  }
}
