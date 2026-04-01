//CustomValidator.ts
//새로 컨트롤러의 기능을 작성할 클래스를 작성

import {FormControl} from '@angular/forms';

export class CustomValidator{
    //숫자를 입력하는데 100이상을 입력하는 경우에만 정상적으로 입력하게
    //메서드를 작성할때(매개변수:FormControl객체를 적용)
    static gt100(control:FormControl){//FormControl를 이용=>입력받은값체크
        if(control.value < 100){
            console.log('control.value->',control.value);
            return {gt100:true} //반환값은 {메서드명:true} 형식을 사용
        }
      return null;
    }
}
