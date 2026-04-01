package j0619;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//외부에서 접근이 불가->객체생성 X->생성자 호출 X
        //Singleton ob1=new Singleton();
		//정적 메서드를 이용->객체를 대여
		Singleton ob1=Singleton.getInstance();
		Singleton ob2=Singleton.getInstance();
		Singleton ob3=Singleton.getInstance();
		
		//객체명은 다르지만 주소값은 하나->하나의 객체임을 증명
		System.out.println("ob1=>"+ob1);
		System.out.println("ob2=>"+ob2);
		System.out.println("ob3=>"+ob3);
		if(ob1==ob2)  //주소값을 비교->같다면, 일반변수라면 내용을 비교
			System.out.println("ob1==ob2");
		else
			System.out.println("ob1!=ob2");
	}
}






