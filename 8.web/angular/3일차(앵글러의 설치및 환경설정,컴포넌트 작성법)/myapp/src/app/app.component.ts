//1.컴포넌트->화면에 보여줄 수있도록 설계된 Template(html)과 연관된 클래스
//import  ->@angular/core->컴포넌트
import { Component } from '@angular/core';

//장식자(@Component->이 클래스가 컴포넌트 역할을 하는 클래스라고 지정)
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular4 프로그램 연습'; //멤버변수 선언, 메서드작성(Setter,Getter),이벤트처리 메서드
}
