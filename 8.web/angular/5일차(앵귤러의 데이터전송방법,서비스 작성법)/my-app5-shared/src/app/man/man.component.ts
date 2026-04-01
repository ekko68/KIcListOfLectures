import { Component } from '@angular/core';
//추가
import {SharedSeriveService} from '../shared-serive.service';
//
@Component({
  selector: 'app-man',
  templateUrl: './man.component.html',
  styleUrls: ['./man.component.css']
  //providers 서비스명 사용X-->공유
})
export class ManComponent {

  mesg;//화면에 출력=>{{mesg}}
  constructor(public service:SharedSeriveService){}
  //웹상에서 호출하는 이벤트메서드
  addName(n){
     this.service.addName(n);
     this.mesg=this.service.names;//서비스배열에 저장된 데이터를 출력
  }
}
