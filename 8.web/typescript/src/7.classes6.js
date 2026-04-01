class Person {
    //생성자->클래스명도 동일하다.(자바)->constructor() or (,,,)
    //생성자는 절대로 한개이상 생성X(자바와 다른점)
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}
class Person2 {
    //접근지정자를 주는 경우의 생성자가 있고 없는 경우
    //Person2(String name,int age){} 자바의 경우
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}
