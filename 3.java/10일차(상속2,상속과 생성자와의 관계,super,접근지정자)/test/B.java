package j0608.test;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
        //a.i=20;//Setter,Getter를 이용하면 가능
        //a.print();
		System.out.println("====default권한(같은 패키지에 있는 경우 접근)====");
        a.j=300;
        a.print2();
        System.out.println("====protected 권한(같은 패키지)====");
        a.k=400;
        a.print3();
        System.out.println("====public 권한(같은 패키지)====");
        a.m=400;
        a.print4();
	}
}


