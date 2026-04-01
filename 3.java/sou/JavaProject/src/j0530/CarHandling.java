package j0530;
//서로 관련이 있는 클래스는 하나의 패키지에 저장

public class CarHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //1.자동차를 생산->객체생성
		//형식) 설계도이름(클래스) 객체명(=변수)=new 설계도명();
		Car morning;//객체 선언 ->TV t; //예약 (메모리에 확정X)
		 morning = new Car();//메모리에 공간할당(인스턴스)//4byte(16진수)
		 //j0530.Car@15db9742->패키지명.클래스명@16진수 (시구읍면동)
		 //주소값(집주소)->거주지
		 System.out.println("morning=>"+morning);
		 //2.저장->객체명.멤버변수(속성)=값
		 morning.name="모닝";
		 morning.output=1000;
		 morning.color="blue";
		 morning.year=2017;
		 //3.시동걸기->메서드작동시키기->메서드호출=>객체명.메서드명(~)
		 morning.startEngine();
		 morning.speedUp(150);
		 morning.speedDown(70);
		 morning.carInfoPrint();
	}
}









