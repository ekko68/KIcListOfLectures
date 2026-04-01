import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //추가
  handleEvent(){
    //var 객체명=new Promise(콜백함수성공,콜백함수실패) 
    //객체명.then(){ 성공},function(){ 실패} 
    var promise = new Promise(function(resolve,reject){
       console.log("1");
       //resolve(100);//숫자전달
       reject(200);
       console.log("2");
    });  
       console.log("3");
       //객체명.then(~,)
       promise.then(function(x){ //resolve
         console.log("resolve",x);//resolve,100
       },function(y){ //reject
        console.log("reject",y);//reject,200
       })
        console.log("end");
  }
}
