import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app 스타일 연습';
  //추가
  attStyle="red";//css파일에 설정된 특정 css의 클래스이름을 저장
  attStyle2="blue";
  //추가2
  result=true; //*ngIf->boolean값을 적용->css의 visibility속성
  result2=false;
  result3=10;
  //추가3
  grade="90";
  //추가4
  items:Object[]=[   //<li *ngFor="let 객체명 of 컬렉션객체명(items)">
      {name:'홍길동',age:20},
      {name:'테스트',age:25},
      {name:'임시',age:32},
      {name:'임시2',age:40}
  ];
  
}
