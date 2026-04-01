import { Component, OnInit } from '@angular/core';
//추가
import './rxjs-operator'; //rxjs->서버에 접속->데이터를 가져오기위해서
import {Observable} from 'rxjs/Rx';//예외처리->에러메세지 출력(throw)
import {Person} from './person';
//서비스 추가
import {PersonService} from './person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css'],
  //추가
  providers:[PersonService]
})
export class PersonComponent implements OnInit {
   //생성자 DI
  constructor(private service:PersonService) {
    this.getPersonList(); //생성자에서 따로 getPersonList()을 호출하기때문에
   }
  personList;//서버로부터 가져온 데이터를 저장할 변수선언
  //회원리스트
  getPersonList(){
    //promise객체->비동기처리를 하기위해서 사용되는 객체->1.성공(데이터를 가진 promise객체
  //                                             2.실패(실패한 정보를 가진 promise객체))
  //res=>this.personList=res->personList에 받아온 데이터를 저장
    this.service.getPersonList().toPromise().then(res=>this.personList=res);
  }
  ngOnInit() {}

}
