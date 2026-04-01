import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
//추가
import { TimeService } from './time.service';
//-----------------------------------------------

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [TimeService],  //서비스를 등록->providers:[서비스 등록]
  bootstrap: [AppComponent]
})
export class AppModule { }
