import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ManComponent } from './man/man.component';
import { WomanComponent } from './woman/woman.component';


@NgModule({
  declarations: [
    AppComponent,
    ManComponent,
    WomanComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
