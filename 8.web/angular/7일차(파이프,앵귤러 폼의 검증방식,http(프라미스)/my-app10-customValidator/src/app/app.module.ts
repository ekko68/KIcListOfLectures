import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//폼그룹을 이용해서 모델로 유효성검사-
import {FormsModule } from '@angular/forms';
import {ReactiveFormsModule } from '@angular/forms';
//---------------------------------------------------
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    //추가
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
