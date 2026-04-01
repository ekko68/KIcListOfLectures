import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //날짜를 출력하기
  currentDate:number=Date.now();//숫자->{{ }}
  currentDate2:Date=new Date();//날짜객체 생성=>값
  currentDate3:string=new Date().toISOString();//ISO방식의 문자열로 출력
}
