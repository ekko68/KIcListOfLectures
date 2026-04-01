package j0609;

//추가된 문법
import static java.lang.Math.*;//정적클래스 위주로 불러올때 사용

//3.final class 클래스명->상속금지 클래스->중요한 클래스(ex System)
final class Parent{
	//1.final 멤버변수 또는 지역변수=>상수화된 변수를 작성할때 사용(고정)
	//Color public static final Color black
	final int COUNT=1; //read->대문자로 사용하는 것이 관례
	//2.final 메서드=>상속은 허용해주지만 오버라이딩 금지 메서드(내용변경X)
	final void sub() {
		System.out.println("재정의 금지 메서드");
	}
	void sub2() {
		System.out.println("재정의 가능");
	}
}


//public class FinalTest extends Parent{
public class FinalTest {
	/*void sub() {
		System.out.println("변경가능");
	} */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Parent p=new Parent();
          //p.COUNT=5;
          System.out.println("p.count->"+p.COUNT);
          //원의 면적->5*5*3.141592~=>Math
          double area=5*5*PI;
          System.out.println("area=>"+area);
	}
}




