import { Component, OnInit } from '@angular/core';
//추가
import { TimeService } from '../time.service';
//
@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
  //providers:[]
})
export class FirstComponent  {
   //DI
   //TimeService서비스 자료형의 객체를 받아온다.first
  constructor(public first:TimeService) { }

  
}
