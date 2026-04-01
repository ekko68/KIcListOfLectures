import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //데이터를 입력(userid,passwd,name,address,age,,,,)
  user={
    userid:"",
    passwd:""
    //name:"",
    //address:"",
  };
}
