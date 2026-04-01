import { Component, Input,Output,EventEmitter } from '@angular/core';

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
  //추가 string,number,boolean,
  @Output() kkk=new EventEmitter<string>(); //<전달할 값의 자료형>()
  xyz(){
    console.log("xyz");
    //this.전달할변수명.emit("전달할값") //(200) or (true|false)
    this.kkk.emit("안녕하세요");//this.kkk.emit(this.str);
  }
  //도서의 정보=>book-image->이미지의 이름,책의이름
  titleName="도서 목록";
  getTitleName(){
    return this.titleName;
  }
  books=[
    {id:'p01',name:'위험한 식탁',price:2000,date:'2017913',img:'a.jpg'},
    {id:'p02',name:'공부의 비결',price:3000,date:'2017911',img:'b.jpg'},
    {id:'p03',name:'오메르타',   price:4500,date:'2017909',img:'c.jpg'},
    {id:'p04',name:'행복한 여행',price:8000,date:'2017912',img:'d.jpg'},
    {id:'p05',name:'해커스 토익',price:5000,date:'2017911',img:'e.jpg'},
    {id:'p06',name:'도로 안내서',price:2600,date:'2017908',img:'f.jpg'}
 ];
 //추가
  bookName;
  sBook(name){
    this.bookName=name;
  }
}
