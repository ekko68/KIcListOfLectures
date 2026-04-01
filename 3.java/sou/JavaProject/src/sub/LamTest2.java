package sub;

//인터페이스에서 추상메서드가 하나만 존재할때 람다표현식을 사용할 수가 있다.
interface Xyz{
	public void a(int x,int y);//매개변수 2개를 선언
	//public void b();
}
public class LamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //방법2->익명클래스로 작성->추상메서드를 오버라이딩해서 호출
        //형식) 인터페이스형 객체명=new 인터페이스형(){ 메서드선언 및 내용};
        Xyz abc=new Xyz(){
        	public void a(int x,int y){
        		System.out.println("익명클래스를 이용한 계산="+(x*y));
        	}
        	/*@Override
        	public void b() {
        		// TODO Auto-generated method stub
        		System.out.println("오버라이딩 순서중요하지 않음!");
        	}*/
        };
        //호출->객체명.메서드명(~)
        abc.a(6,5);
        //방법3->람다표현식->메서드명을 생략
        //형식) 인터페이스형 객체명=(~)->메서드를 호출했을때 실행할 문장
        //람다표현식->짧게 표현할때 사용=>메서드는 하나만 작성
        Xyz abc2=(x,y)->System.out.println("람다를 이용함"+(x+y));
        abc2.a(6,5);
	}
}





