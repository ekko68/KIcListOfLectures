import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//서비스를 불러오기 위해서는 import
import { HelloService } from './hello.service';
//---------------------------------------------
import { AppComponent ;
import { FirstComponent } from './first/first.component'} from './app.component';

@NgModule({
  declarat,
    FirstComponentions: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [HelloService], //app.moudule.ts의 providers->클래스이름선언
  bootstrap: [AppComponent]
})
export class AppModule { }
