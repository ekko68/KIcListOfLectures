import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //추가
  curVal = 0;//현재값
  manualVal = 0;//강제로 저장할값을 입력시 저장
  static LIMIT_CNT = 100;//지정한 최대값을 설정
  //static 메서드명()->정적메서드->클래스명.정적메서드명()

  colorByValue(){ //현재값에 따른 색깔의 변화
    if(this.curVal > 0) return 'green';
    else if(this.curVal < 0) return 'red';
    else return 'grey';
  }

  inc(){ //증가->curVal+1
    const tempVal = this.curVal+1;
    if(this.checkLimitCnt(tempVal)){
      this.curVal = tempVal;//100보다 작은경우
    }
  }
  
  dec(){ //감소
    const tempVal = this.curVal-1;
    if(this.checkLimitCnt(tempVal)){
      this.curVal = tempVal;//100보다 작은경우
    }
  }

  setValue(){//강제저장
    if(this.checkLimitCnt(this.manualVal)){ //100보다 적다면
        this.curVal = this.manualVal;//최대값보다 적으면 현재값에 출력
    }
        this.manualVal = 0;//초기화(다시 입력받은값을 반영)
  }
  //입력받은 값이 지정한 최대값보다 큰지 작은지를 체크->true or false
  checkLimitCnt(val){  //5 or -5->5 (클래스명.정적상수명)
     if(Math.abs(val) < AppComponent.LIMIT_CNT){
       return true;
     }
     //삼항연산자-> 조건식?참인값:거짓인값
     const target = val > 0? '증가': '감소';
     alert(`더 이상 ${target} 시킬수 없습니다.`);
     return false;
  }
}
