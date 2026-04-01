package j0608;

//super->부모클래스의 객체를 의미
class Person{
	String name;
	int age=20;
	void print() {
		System.out.println("Person 메서드 호출=>"+name);
	}
}

class Man extends Person{
	//상속을 받은 멤버변수와 같은 이름의 변수를 자식클래스에 또 선언이 가능
	int age=40;
	/*
	 String name;//상속연습
	int age=20;
	void print() {
		System.out.println("Person 메서드 호출=>"+name);
	} 
	 */
	void print() {
		System.out.println("자식클래스의 "+this.age);//40
		System.out.println("부모클래스의 "+super.age);//20
		//super.부모클래스 메서드명()구분
		super.print();
	}
}

public class SuperTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Man m=new Man();
          m.name="상속연습";
          m.print();//오버라이딩한 메서드 print()호출한다.
	}
}




