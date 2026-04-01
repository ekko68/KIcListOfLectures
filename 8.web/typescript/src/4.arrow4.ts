//객체를 생성해서 메서드를 작성하는 경우->arrow()함수 작성X
//${this}=>현재 객체가 아니다.(obj)
const obj={
    name:'Lee',
    //sayHi:()=> console.log(`Hi ${this.name}`)
    
    sayHi(){  //function 생략 가능
       console.log(`Hi ${this.name}`);
    }
}
obj.name='Kim';//객체명.키명=새로운값
//메서드호출
obj.sayHi();