import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';//{{title}}=>선언적 프로그래밍방식

  getTitle():string{ //{{getTitle()}}
    return this.title;
  }
  result = false;//스타일 적용 default
  //이벤트처리
  handleEvent(mesg){
    this.result=mesg;//focus->true ,blue=>false
  }
}
