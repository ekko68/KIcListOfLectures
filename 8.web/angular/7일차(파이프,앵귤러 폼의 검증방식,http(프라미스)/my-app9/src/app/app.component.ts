import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //사용자정의 파이프를 이용해서 출력
  str="20170919"; //2017-09-19, 2017/09/19
  //날짜를 출력하기
  currentDate:number=Date.now();//숫자->{{ }}
  currentDate2:Date=new Date();//날짜객체 생성=>값
  currentDate3:string=new Date().toISOString();//ISO방식의 문자열로 출력
  //key:value
  apple:string='apple';
  //i18nSelectPipe
  fruits:any={
     apple:'사과',
     banana:'바나나',
     grape:'포도',
     orange:'오렌지',
     watermelon:'수박',
     mango:'망고'
  };
  //Json 파이프
  person={
    username:'홍길동',
    age:20,
    address:'서울'
  }
  //json데이터->문자열로 변환->출력
  jsonString=JSON.stringify(this.person);
}
