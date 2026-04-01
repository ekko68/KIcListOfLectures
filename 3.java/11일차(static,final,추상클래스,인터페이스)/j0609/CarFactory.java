package j0609;

class Car{
	String color;//차색깔
	String model;//모델
	String owner;//소유주
	//클래스명.정적멤버변수명->객체명.정적멤버변수명
	static int serialNumber;//차의 생산량(차의 종류와 상관없이 합계)
	
	public Car(String color,String model,String owner) {
		this.color=color;
		this.model=model;
		this.owner=owner;
		serialNumber++;//공통으로 모든 객체가 불러다 사용이 가능한 상태
	}
	//차의 생산량을 확인
	public static int getNumber() {
		return serialNumber;
	}
	/* 정적메서드에서는 정적 멤버변수를 불러다 사용 가능하고 멤버변수 사용불가
	 public static String getColor() {
		return color;
	}*/
	static { //static영역 또는 static 블럭 =>클래스 내부에서 사용하는 경우
		System.out.println("제일 먼저 main()보다 먼저 실행해야할 구문이 있으면 사용");
		System.out.println("DB접속이 가능하도록 설정");	
		System.out.println("1.static 멤버변수 2.main()호출,정적메서드,클래스로드");
	}
}

public class CarFactory {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Car c1=new Car("Red","SM5","테스트");
         Car c2=new Car("Blue","Sonata","임시");
         Car c3=new Car("Blue","Matiz","임시2");
         
         System.out.println("지금까지의 차의 생산량은?"+c1.getNumber());
         System.out.println("지금까지의 차의 생산량은?"+c2.serialNumber);
         System.out.println("지금까지의 차의 생산량은?"+Car.serialNumber);
	}
}





