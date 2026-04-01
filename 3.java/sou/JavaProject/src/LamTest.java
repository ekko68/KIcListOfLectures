//package j1228;

interface Xyz{
	int x=8;//public static final int x=8;
	public void a();
}
public class LamTest implements Xyz{

	public void a(){
		System.out.println("일반적인 방법1");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//방법1->클래스이름이 존재
        LamTest lt=new LamTest();
        lt.a();
        //방법2->익명클래스로 작성->추상메서드를 오버라이딩해서 호출
        //형식) 인터페이스형 객체명=new 인터페이스형(){ 메서드선언 및 내용};
        Xyz abc=new Xyz(){
        	public void a(){
        		System.out.println("익명클래스를 이용한 메서드호출방법");
        	}
        };
        //호출->객체명.메서드명(~)
        abc.a();
        //방법3->람다표현식->메서드명을 생략
        //형식) 인터페이스형 객체명=()->메서드를 호출했을때 실행할 문장
        Xyz abc2=()->System.out.println("람다를 이용함");
        abc2.a();
	}
}





