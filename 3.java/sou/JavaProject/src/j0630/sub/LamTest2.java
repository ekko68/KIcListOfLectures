package j0630.sub;

//인터페이스에서 추상메서드가 하나만 존재할때 람다표현식을 사용할 수가 있다
interface Xyz{ //인터페이스에서 람다식을 사용할때의 주의할점,매개변수 있는경우
	public void a(int x,int y);
	//public void b();
}

public class LamTest2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //2.방법2->익명클래스로 작성->추상메서드를 오버라이딩해서 호출
         //형식) 인터페이스형 객체명=new 인터페이스형(){메서드 선언 및 내용}
         Xyz abc=new Xyz() {
        	 public void a(int x,int y) {
        		 System.out.println("익명클래스를 이용한 메서드호출방법"+(x*y));
        	 }
        	 public void b() {
        		 System.out.println("오버라이딩 순서가 중요하지 않는다.");
        	 }
         };
         abc.a(6,5);//abc.b()
         //방법3->람다표현식이 추가->반환형 메서드명을 생략
         Xyz abc2=(x,y)->System.out.println("람다를 이용함"+(x+y));
         abc2.a(6,5);
	}
}







