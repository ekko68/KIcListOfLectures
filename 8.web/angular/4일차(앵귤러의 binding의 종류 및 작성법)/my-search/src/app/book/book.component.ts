import { Component} from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent  {

  titleName = "도서 목록";

  getTitleName(){
    return this.titleName;
  }
  //배열명=[{}]->id,name,price,date,imag->경로 저장
  books=[
    {id:'p01',name:'위험한 식탁',price:2000,date:'2017913',img:'a.jpg'},
    {id:'p02',name:'공부의 비결',price:3000,date:'2017911',img:'b.jpg'},
    {id:'p03',name:'오메르타',   price:4500,date:'2017909',img:'c.jpg'},
    {id:'p04',name:'행복한 여행',price:8000,date:'2017912',img:'d.jpg'},
    {id:'p05',name:'해커스 토익',price:5000,date:'2017911',img:'e.jpg'},
    {id:'p06',name:'도로 안내서',price:2600,date:'2017908',img:'f.jpg'}
 ];
  constructor(){ //처음 실행될때 초기화->booksResult=>무조건 books와 동일
     for(var book of this.books){
       this.booksResult.push(book);
     }
  }
  //검색한 책만 따로 저장할 배열
  booksResult = [];
  //입력한 책의 이름을 $event를 통해서 전달받아서 처리
  searchName($event){
    var searchName = $event.target.value;//검색한 책이름
    console.log('searchName=>',searchName);
    this.booksResult=[];
    if(searchName == ''){//검색어가 없다면
      for(var book of this.books){
         this.booksResult.push(book);
      }
    }else{//검색어가 존재->books->검색된 책만 찾아서 booksResult에 담기
      for(var book of this.books){
        if(book.name.indexOf(searchName)!=-1){//찾았다면
           this.booksResult.push(book);
        }
     }//for
    }//else
  }//searchName

}
