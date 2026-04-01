import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
//자동으로 컴포넌트를 추가
import { BookComponent } from './book/book.component';

@NgModule({
  declarations: [  //현재 사용중인 컴포넌트 자동으로 등록
    AppComponent,
    BookComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
