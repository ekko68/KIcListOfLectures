import { Component, OnInit } from '@angular/core';
//추가
import {TimeService} from '../time.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent {

  constructor(public second:TimeService) { 
    console.log(second.getCurrentTime());
  }

  

}
