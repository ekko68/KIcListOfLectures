import { Injectable } from '@angular/core';

@Injectable()
export class SharedSeriveService {

  //constructor() { }
  //추가
  public names:string[]=[];
  //중복된 코딩
  addName(n){
    this.names.push(n);
  }
}
