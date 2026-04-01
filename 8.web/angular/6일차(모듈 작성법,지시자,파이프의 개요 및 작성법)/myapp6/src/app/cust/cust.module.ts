import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//모듈에 추가된 컴포넌트가 자동적으로 등록
import { CustComponent } from './cust.component';

@NgModule({
  imports: [ //필요로하는 모듈을 등록하는 부분
    CommonModule //파이프,구조 지시자,속성지시자에 대한 정보 모듈(화면에 출력)
  ],
  declarations: [CustComponent] , //사용할 컴포넌트를 등록하는 부분
  //CustComponent은 현재 CustModule만 사용이 가능->AppMoudle도 사용이 가능
  exports:[CustComponent] //다른 모듈에서 사용이 가능하도록 exports이용
})
export class CustModule { }
