import { Injectable } from '@angular/core';

//서비스 ->공유할 목적,중복된 구문->따로 서비스를 작성->관리
@Injectable()
export class CustService {

  constructor() { }
   //추가
   currentDate(){
     //const d=new Date();
     //return d;
     return new Date();//현재 시간을  출력시켜주는 기능
   }
}
