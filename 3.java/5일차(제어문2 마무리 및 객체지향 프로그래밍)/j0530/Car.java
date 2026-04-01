package j0530;
//저장하고 싶은 대상자(객체)->자동차=>공통적인특성,기능

public class Car { //TV,Computer(클래스)

	//1.객체의 공통적인 속성(or 특성)
	String name;//차이름
	int output;//배기량
	int year;//년식
	String color;//차의 색깔
	//상태
	int current_speed;//속도
	boolean sidong=false;//차의 시동유무
	
	//2.기능
	
	//1)시동걸기=>단순,반복(매개변수 X, 반환형X)
	void startEngine() {
		sidong=true;
		System.out.println("시동이 걸림!!");
	}
	
	//2)속도 증가->80km->120km(수정)->매개변수 필요 O ,반환형 X
	 void speedUp(int speed) { //function speedUp(speed){}
		 current_speed+=speed;//current_speed=current_speed+speed;
		 System.out.println(speed+"km만큼 속도가 증가되었습니다.");
	 }
	//3)속도 감소->speedDown(int speed)
	 void speedDown(int speed) { //function speedUp(speed){}
		 current_speed-=speed;//current_speed=current_speed+speed;
		 System.out.println(speed+"km만큼 속도가 감소되었습니다.");
	 }
	//4)차의 조회->단순,반복
	void carInfoPrint() {
		System.out.println("==차의 정보==");
		System.out.println("차의이름="+name);
		System.out.println("차의배기량="+output);
		System.out.println("차의색깔="+color);
		System.out.println("차의속도="+current_speed);
	}
	
	//5)차의 주차->단순,반복
	void stop() {
		sidong=false;//(2>3)
		current_speed=0;
		System.out.println("주차완료!");
	}
}





