import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//자동적으로 컴포넌트가 등록
import { AppComponent } from './app.component';
import { PersonComponent } from './person/person.component';
import { ItemEditComponent } from './item-edit/item-edit.component';
//추가2
import { FormsModule} from '@angular/forms';
import { HttpModule} from '@angular/http';
//---------------------------------------
@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    ItemEditComponent
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
