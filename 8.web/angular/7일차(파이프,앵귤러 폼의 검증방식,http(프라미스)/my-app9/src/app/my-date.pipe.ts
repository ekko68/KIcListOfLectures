import { Pipe, PipeTransform } from '@angular/core';
//Pipe(파이프 정보) ,PipeTransform=>어떤 데이터를 변화->화면에 출력

@Pipe({
  name: 'myDate' //사용자 정의 파이프명
})
//인터페이스->자바와 동일
export class MyDatePipe implements PipeTransform {
  //변환시켜서 출력할 값(value,args(추가로 값을 전달받는 경우))
  transform(value: any, args?: any): any {
    //20170919
    if(value.length==8){ //4자리(년도), 2자리(월),2자리(일)
      //value->출력할값, args->중간에 출력할 양식(-,/,.)
      console.log('value->',value,'args->',args)
      return value.substring(0,4)+args+value.substring(4,6)+
             args+value.substring(6,8);
    }
    
  }

}
