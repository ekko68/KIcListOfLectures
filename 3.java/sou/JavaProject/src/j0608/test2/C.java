package j0608.test2;

import j0608.test.*;//A,B

//public class C {
public class C extends A {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
        //a.i=20;//Setter,Getter를 이용하면 가능
        //a.print();
		System.out.println("====외부패키지의 default권한 접근불가====");
        //a.j=200;
        //a.print2();
	    //C c=new C();
		//c.j=300;
		//c.print2();
		System.out.println("====외부패키지의 protected 권한 접근불가====");
        //a.k=300;
        //a.print3();
		//예외) 다른 패키지에 있다 할지라도 C클래스(자식클래스) 가능
		C c=new C();
		c.k=400;
		c.print3();
		
		System.out.println("====public 권한(같은 패키지)====");
        a.m=400;
        a.print4();
	}
}









