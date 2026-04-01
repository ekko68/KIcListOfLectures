//1.const kk = new KFoo();//new 클래스명()=>객체생성X =>선언하기전
class KFoo{
    num;
}
//2.const k1 = KFoo(); new연산자를 써야 객체생성이 가능
const kk = new KFoo();
console.log('kk->',kk);
kk.num = 1;
console.log(kk);//KFoo {num:1}

class Bar{
    num:number=3;//초기값 가능
    //constructor(){} 생성자는 한개이상 작성X
    constructor(num){
        this.num=num;
    }
}
