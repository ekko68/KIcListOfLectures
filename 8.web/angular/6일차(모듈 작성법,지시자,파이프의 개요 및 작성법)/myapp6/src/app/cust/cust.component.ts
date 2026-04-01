import { Component, OnInit } from '@angular/core';

//추가
import { CustService } from './cust.service';
//-------------------------------------------
@Component({
  selector: 'app-cust',
  templateUrl: './cust.component.html',
  styleUrls: ['./cust.component.css'],
  //추가
  providers:[CustService] //필요로하는 서비스가 여러개 존재->,로 나열
})
export class CustComponent  {

  name:string="홍길동";
  age:number=20;
  currentDate; //오늘날짜를 출력할 멤버변수선언
  //생성자를 통해서 의존객체->접근지정자(public) 의존객체명:서비스명
  constructor(public custService:CustService) {
    this.currentDate = custService.currentDate();
   }
}
