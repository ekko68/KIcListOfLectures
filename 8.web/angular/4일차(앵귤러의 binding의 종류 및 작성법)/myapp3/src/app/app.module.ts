import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//추가
import { FormsModule} from '@angular/forms'; //폼
import { HttpModule } from '@angular/http';  //외부와의 통신
//-------------------------------------------
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent
  ],
  imports: [  //현재 사용중인 모듈을 불러오는 장소
    BrowserModule,//브라우저에서 실행할때 필요로 하는 모듈
    FormsModule, //폼(ngModel)
    HttpModule //접속
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
