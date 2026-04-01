import { Component, OnInit } from '@angular/core';
//추가
import {Router,ActivatedRoute,Params } from '@angular/router';
//-------------------------------------------------------------
@Component({
  selector: 'app-third',
  templateUrl: './third.component.html',
  styleUrls: ['./third.component.css']
})
export class ThirdComponent implements OnInit {

  constructor(private route:ActivatedRoute) { }
  params;//매개변수를 저장
  //컴포넌트의 초기값을 설정
  ngOnInit() {
    //매개변수를 받는지 체크->subscribe()
    this.route.params.subscribe(params=>{console.log(params);
      //if(request.getParameter("data")!=null)
       if(params['xxx']!=null && params['yyy']!=null){
         this.params=params['xxx']
         this.params+=params['yyy']
         console.log('third의 this.params=>',this.params);
       }
    })
  }
}
