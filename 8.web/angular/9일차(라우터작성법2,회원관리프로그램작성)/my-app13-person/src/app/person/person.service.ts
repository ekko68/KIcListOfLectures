import { Injectable } from '@angular/core';

//각 컴포넌트에서 공통으로 사용될 메서드를 따로 설정
import {Http} from '@angular/http';
import './rxjs-operator'; //rxjs->서버에 접속->데이터를 가져오기위해서
import {Observable} from 'rxjs/Rx';//예외처리->에러메세지 출력(throw)
import {Person} from './person';//가져온 데이터를 필드별로 담기위해서


@Injectable()
export class PersonService {
 //생성자의 DI
  constructor(private http:Http) { }
 
 //1.회원리스트
 getPersonList(){
   var url="http://localhost:8090/AngularWeb/getPersonList.jsp";
   return this.http.get(url).map(res=>res.json());
   //map(여러개의 데이터를 받아올때->json객체형태로 받아온다)
 }
 //2.회원등록

 //3.회원id에 해당되는 데이터 찾기

 //4.회원수정

 //5.회원삭제

 //6.공통으로 에러메세지 호출
 private handleError(error:Response | any){
   //Observable.throw(에러객체); //에러정보 출력
   return Observable.throw("errorMsg=>"+error);
 }
}
