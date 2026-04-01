import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//추가
import { FormsModule } from '@angular/forms';
//------------------------------------------
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
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
