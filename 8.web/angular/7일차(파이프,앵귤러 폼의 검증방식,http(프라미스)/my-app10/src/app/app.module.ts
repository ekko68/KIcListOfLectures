import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//양방향
import {FormsModule} from '@angular/forms';
//--------------------------------------------
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent //컴포넌트,파이프,,,,
  ],
  imports: [
    BrowserModule,
    //추가
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
