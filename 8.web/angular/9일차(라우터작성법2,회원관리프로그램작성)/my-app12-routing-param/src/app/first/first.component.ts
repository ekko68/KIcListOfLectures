import { Component, OnInit } from '@angular/core';
//매개변수를 전달받아서 ->화면에 출력
import {Router,ActivatedRoute,Params} from '@angular/router';
//Router->페이지 이동, 
//ActivatedRoute->현재 선택되어서 화면에 보여주는 라우터정보
//Params->페이지 이동시 매개변수를 전달받는 경우

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  //DI방식->현재 선택되어진 라우터정보 객체
  constructor(private route:ActivatedRoute) { }
  params;//매개변수를 저장
  //컴포넌트의 초기값을 설정
  ngOnInit() {
    //매개변수를 받는지 체크->subscribe()
    this.route.params.subscribe(params=>{console.log(params);
      //if(request.getParameter("data")!=null)
       if(params['data']!=null)
         this.params=params['data']
         console.log('this.params=>',this.params);
    })
  }
}
