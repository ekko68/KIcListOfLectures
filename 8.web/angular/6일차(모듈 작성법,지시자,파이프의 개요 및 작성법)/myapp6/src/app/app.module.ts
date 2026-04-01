import { BrowserModule } from '@angular/platform-browser';
// /platform-browser->common 모듈을 포함하고 있다

import { NgModule } from '@angular/core';
//따로 컴포넌트를 직접 등록X->따로 모듈로 만들어서 ->컴포넌트 정보->모듈만 추가
import {CustModule} from './cust/cust.module';
//---------------------------------------------
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    //추가
    CustModule //custComponent->Cust.component.html
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
