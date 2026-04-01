import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
//-------------------------------------------
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    //추가
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
