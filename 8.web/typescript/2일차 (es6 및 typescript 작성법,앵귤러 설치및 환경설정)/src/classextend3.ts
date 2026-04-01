class Animal{
    _weight:any;
    constructor(weight){
        this._weight=weight;
    }
    weight(){
        console.log(this._weight);
    }
    eat(){
        console.log('Animal eat');
    }
}
class Human extends Animal{
    _language:string;
    constructor(weight,language){
        super(weight);//weight->부모클래스의 생성자를 통해서 값을 저장
        this._language=language;
    }
    //오버라이딩->자식에서 부모클래스의 메서드 내용을 수정
    eat(){
        console.log('Human eat');
    }
    speak(){
        console.log(`koreans speak ${this._language}`);
    }
}
const korean = new Human(70,'Korean');//new 클래스명(인수1,인수2,,,)
korean.weight();//70
korean.eat();//Human eat
korean.speak();//koreans speak Korean
//객체명 instanceof 클래스명=true or false
console.log(korean instanceof Human) //true
console.log(korean instanceof Animal) //true
//node classextend3.js
