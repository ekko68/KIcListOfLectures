/**
  브라우저에서 실행할때 필요로하는 모듈
 */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//컴포넌트를 추가할때마다 자동적으로 등록
import { AppComponent } from './app.component';

@NgModule({
  declarations: [  //현재 추가된 컴포넌트가 클래스로 등록되는 부분
    AppComponent
  ],
  imports: [  //현재 사용하고자하는 모듈을 등록
    BrowserModule
  ],
  providers: [], //서비스(클래스(의존객체))를 불러올때 사용
  bootstrap: [AppComponent] //맨처음 실행시 등록된 컴포넌트를 가지고 실행
})
export class AppModule { }
