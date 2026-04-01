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
  ppp(){
    this.mesg="world";
  }
}
