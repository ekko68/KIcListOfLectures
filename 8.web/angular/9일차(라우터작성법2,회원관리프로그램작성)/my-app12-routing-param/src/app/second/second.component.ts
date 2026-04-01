import { Component, OnInit } from '@angular/core';

import {Router,ActivatedRoute,Params} from '@angular/router';
//router객체명.navigate('이동할 path')
@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  constructor(private router:Router) { }
  ngOnInit() {}
  goFirst(){
    //router객체명.navigate('이동할 path')
    //router객체명.navigate(['이동할 path',전달할 매개변수값,,,])
    this.router.navigate(['firstView','200'])
  }
}
