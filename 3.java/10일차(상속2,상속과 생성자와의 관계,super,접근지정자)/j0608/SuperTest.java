package j0608;
//생성자 호출 매카니즘
public class SuperTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            C c=new C("홍길동");//1)8)
	}
}
class A extends Object{
	public A() {
		super();//4)
		System.out.println("난 A의 생성자 호출됨!");//5)
	}
}
class B extends A{
	public B() {
		super();
		System.out.println("난 B의 생성자 호출됨!");
	}
	//인수가 있는 생성자를 선언
	public B(String s) {
		super();//3)
		System.out.println(s);//6)홍길동
	}
}

class C extends B{
	public C() {
		System.out.println("난 C의 생성자 호출됨!");
	}
	public C(String s) {//s="홍길동"
		super(s);//2)super("홍길동");
		System.out.println(s);//7)홍길동
	}
}







