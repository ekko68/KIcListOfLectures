import { Component,Input,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-book-image',
  templateUrl: './book-image.component.html',
  styleUrls: ['./book-image.component.css']
})
export class BookImageComponent  {
 //BookComponent에서 보내주는 값을 전달받기위해 변수선언
 @Input() title;//제목
 @Input() path;//이미지파일명
 @Input() width; //넓이
 @Input() height;//높이

 //추가
 @Output() selectBook = new EventEmitter<string>();
 
 selectTitle(name){
   this.selectBook.emit(name);
 }
}
