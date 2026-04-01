//1.지시자를 만드는 방법->Directive모듈을 불러오기
import { Directive } from '@angular/core';
//추가 import {Renderer,ElementRef,,,} 같은 패키지인 경우
import {Renderer} from '@angular/core';
import {ElementRef} from '@angular/core';
//추가->2번째 이벤트 처리시 사용
import {HostListener,Input} from '@angular/core';

@Directive({
  selector: '[appMyDirective]', //지시자역할[app생성한지시어이름]
  //1.이벤트를 연결->host:{(이벤트종류명):호출할 함수명()}
  /* (1)
  host:{
     '(click)':'clickEvent()',
     '(mouseenter)':'mouseenterEvent()'
  } */
   //(2)
   host:{
    '(click)':'changeColor()'
   }
})
export class MyDirectiveDirective {
  //1.스타일 적용 2.이벤트를 처리=>ElementRef(태그),Renderer(화면에 출력)
  //보안에 취약(직접 태그정보를 얻어오는 구문X)->[ngStyle],[ngClass]
  @Input('appMyDirective') colorName:string;
  //@Input('커서텀지시자') 변수명:자료형
   //renderder:Renderer;
   //el:ElementRef
  /* (1)
  constructor(public el:ElementRef,public renderer:Renderer) {
    console.log('el->',el,'renderer->',renderer);
    //renderer객체명.setElementStyle(적용시킬 태그객체,부여할 속성명,속성값)
    //[ngStyle.color]="red"
    renderer.setElementStyle(el.nativeElement,"color","red");
    renderer.setElementStyle(el.nativeElement,"background","yellow");
   } */
   //(2)
   constructor(public el:ElementRef,public renderer:Renderer) {}
   changeColor(){
      console.log('colorName->',this.colorName);
      this.renderer.setElementStyle
                     (this.el.nativeElement,"color",this.colorName);
   }

   //추가
   clickEvent(){
     alert("이벤트클릭 연습");
     console.log("click 이벤트 발생됨!");
   }

   mouseenterEvent(){
      console.log("mouseenterEvent 이벤트발생");
   }
   //2.이벤트 연결
   //->@HostListener('발생시킬 이벤트종류묭') 호출할함수명(){}
   @HostListener('mouseleave') mouseleaveEvent(){
      console.log('mouseleave 발생!!!');
   }
}
