import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//1.링크시켜서 연결할 컴포넌트 정보,RouterModule,Routes
import {FirstComponent} from '../first/first.component';
import {SecondComponent} from '../second/second.component';
import {ThirdComponent} from '../third/third.component';
//추가
import { RouterModule,Routes} from '@angular/router';

//2.요청경로->컴포넌트정보->배열 저장(Routes)
const appRoutes:Routes=[
  {
    //path:'',  /* 요청 경로*/
    //component:FirstComponent /* 연결시킬 컴포넌트 명 */
    path:'',
    redirectTo:'/firstView/100',pathMatch:'full'
  },
  {
    //request.getParameter("data") ->/요청경로/:전달받을 매개변수명
    path:'firstView/:data', component:FirstComponent
  },
  {
    path:'secondView', component:SecondComponent
  },
  {
    path:'thirdView', component:ThirdComponent
  }
];

@NgModule({
  imports: [
    CommonModule,//화면에 출력에 관련된 정보(컴포넌트,파이프,,,)
    //초기화
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule], /* 다른 모듈에서도 참조할 수있도록 설정 */
  declarations: []
})
export class AppRoutingModule { }
