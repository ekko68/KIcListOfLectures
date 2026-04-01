import { Component } from '@angular/core';
//추가
import { HelloService} from './hello.service';
//
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //컴포넌트에서 서비스객체를 불러올때 ->생성자를 통해서 불러온다.
  //consturctor(서비스객체명(임의):서비스클래스 자료형) {처리구문}
  constructor(hello:HelloService){
    this.title = hello.sayHello();
  }
}
