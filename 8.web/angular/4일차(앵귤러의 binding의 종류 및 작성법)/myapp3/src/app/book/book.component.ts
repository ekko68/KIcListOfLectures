import { Component } from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent  {
   //멤버변수,메서드,이벤트 함수
   titleName:string="도서목록" //{{titlename}}
   test:string="이벤트연습";

   setTest(test):void{ //public void setTest(String test){~}
     this.test = test;
   }

   getTest():string{
     return this.test;
   }

   sayEcho(x){
     console.log('x->',x);//$event객체
   }

   //배열명=[{}]->id,name,price,date,imag->경로 저장
   books=[
      {id:'p01',name:'위험한 식탁',price:2000,date:'2017913',img:'a.jpg'},
      {id:'p02',name:'공부의 비결',price:3000,date:'2017911',img:'b.jpg'},
      {id:'p03',name:'오메르타',   price:4500,date:'2017909',img:'c.jpg'},
      {id:'p04',name:'행복한 여행',price:8000,date:'2017912',img:'d.jpg'},
      {id:'p05',name:'해커스 토익',price:5000,date:'2017911',img:'e.jpg'},
      {id:'p06',name:'도로 안내서',price:2600,date:'2017908',img:'f.jpg'}
   ];
}
