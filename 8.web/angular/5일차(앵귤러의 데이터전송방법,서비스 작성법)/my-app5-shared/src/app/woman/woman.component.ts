import { Component, OnInit } from '@angular/core';
//추가
import {SharedSeriveService} from '../shared-serive.service';

@Component({
  selector: 'app-woman',
  templateUrl: './woman.component.html',
  styleUrls: ['./woman.component.css'],
  //추가
  providers:[SharedSeriveService]  //부모와 공유X->서비스는 각자 등록
})
export class WomanComponent {

  mesg;//화면에 출력=>{{mesg}}
  constructor(public service:SharedSeriveService){}
  //웹상에서 호출하는 이벤트메서드
  addName(n){
     this.service.addName(n);
     this.mesg=this.service.names;//서비스배열에 저장된 데이터를 출력
  }
}
