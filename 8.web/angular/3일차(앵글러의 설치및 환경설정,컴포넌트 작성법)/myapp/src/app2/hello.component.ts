//1.컴포넌트->화면에 보여줄 수있도록 설계된 Template(html)과 연관된 클래스
//import  ->@angular/core->컴포넌트
import { Component } from '@angular/core';

//장식자(@Component->이 클래스가 컴포넌트 역할을 하는 클래스라고 지정)
/*
 1.selector:'태그이름' =>app-로 시작->html파일에 써주면 바로 반영(동적 DOM)
 2.templateUrl:화면에 보여줄 html파일의 상대적인위치및 파일명
   template->직접 html 직접
 3.styleUrls->화면에 보여줄 html과 연관된 스타일시트파일의 상대경로 []표시
*/
@Component({
  selector: 'app-root',
  //templateUrl: './hello.component.html',
  template:`<h1>Hello Testing</h1>
            <p>template연습중</p>
  `,
  //styleUrls: ['./hell.component.css']
  styles:[`
        p{
           color:blue;
           background:yellow;
        } 
  `]
})
export class AppComponent {
  title = '두번째 컴포넌트를 선택함!!'; //멤버변수 선언, 메서드작성(Setter,Getter),이벤트처리 메서드
}
