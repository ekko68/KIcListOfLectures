//서버에서 가져온 데이터의 필드만큼->여기에 맞는 객체
export class Person{
    //id:string,name:string,age:number
    constructor(public id:string,public name:string,public age:number){}
}