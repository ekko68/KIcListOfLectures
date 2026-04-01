import { Component } from '@angular/core';
//추가
import { FormControl,Validators,FormGroup } from '@angular/forms';
//FormControl->입력받는 부분(input에 연결시킬 객체)
//Validators->유효성검사를 위해서 필요
//FormGroup->폼태그와 연결->폼그룹과 연결 [FormGroup]="폼그룹객체명"
//새로 만든 커스텀클래스를 불러온다.
import { CustomValidator } from './CustomValidator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  //폼그룹에 대한 객체를 생성->입력받을 값에 대한 유효성을 설정
  form = new FormGroup({
     //소문자->폼콘트롤이름:new FormControl(입력,유효성항목,세부항목(정규표현식))
     //유효성 검사항목을 하나이상 compose()를 이용
     lowerCase:new FormControl('',Validators.required),//한글자이상
     upperCase:new FormControl('',
                Validators.compose([Validators.required,
                                   Validators.pattern("[A-Z]{3}")])),
      //대문자를 세번반복해서 입력을 했는지 체크하면서 한글자이상 입력
      //새로 작성한 유효성검사 항목을 불러오기(클래스명.정적메서드명)
      gt100Case:new FormControl('',CustomValidator.gt100)
  });
  //이벤트 발생호출하는 함수
  setValue(){
     this.form.setValue({lowerCase:'abc',upperCase:'ABC',gt100Case:200})
  }
  reset(){
     this.form.setValue({lowerCase:'',upperCase:'',gt100Case:''})
  }
  handleSubmit(e){
    console.log("handleSubmit호출됨!",e)
    console.log('this.form->',this.form);
    //this.form.value.폼컨트롤이름
    console.log('this.form.value.lowerCase=>',this.form.value.lowerCase);
    console.log('this.form.value.upperCase=>',this.form.value.upperCase);
    console.log('this.form.valid->',this.form.valid);
  }
}
