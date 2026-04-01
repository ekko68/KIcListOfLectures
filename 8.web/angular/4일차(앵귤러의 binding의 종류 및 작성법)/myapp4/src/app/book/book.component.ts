import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent  {
  /*
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
  */
  @Input() str:string; //형식 @Input() 받을 매개변수명:자료형;
  @Input() str2:number;
  @Input() str3:number[];
  @Input() str4:string;
  @Input() str5:string;
}
