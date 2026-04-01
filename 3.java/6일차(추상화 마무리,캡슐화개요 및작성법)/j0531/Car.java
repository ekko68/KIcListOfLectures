package j0531;
//저장하고 싶은 대상자(객체)->자동차=>공통적인특성,기능

public class Car { //TV,Computer(클래스)

	//1.객체의 공통적인 속성(or 특성)
	private String name;//차이름
	private int output;//배기량->0
	private int year;//년식
	private String color;//차의 색깔
	//상태
	private int current_speed;//속도
	private boolean sidong=false;//차의 시동유무
	
	//2.기능
	//---------------------------------------------------------
	public void setName(String n) {//n=>모닝
		name=n; //name="모닝"
	}
	public void setOutput(int ou) {//ou=-1000   음수는 입력X
		if( ou<=0) {
			System.out.println("입력받은 값은 음수를 입력할 수 없다.");
			output=1000;
			return;
		}
		output=ou;//output=-1000
	}
	public void setYear(int y) {
		if(y <0 || y > 2017) {
			System.out.println("년도는 음수이거나 2017년이상을 입력불가");
			year=2017;//default값을 입력X->0(자동으로)
		}else {
		    year=y;//year=2017
		}
	}
	public void setColor(String c) {
		color=c;//color="blue"
	}
	public void setCurrent_speed(int sp) {
		current_speed=sp;
	}
	public void setSidong(boolean b) {
		sidong=b;
	}
	//Getter 
	public String getName() { return name;}
	public int getOutput() {return output;}
	public int getYear() { return year;}
	public String getColor() {return color;}
	public int getCurrent_speed() {return current_speed;}
	public boolean getSidong() { return sidong;}
	
	//---------------------------------------------------------
	//1)시동걸기=>단순,반복(매개변수 X, 반환형X)
	void startEngine() {
		sidong=true;
		System.out.println("시동이 걸림!!");
	}
	
	//2)속도 증가->80km->120km(수정)->매개변수 필요 O ,반환형 X
	//180km이상은 더이상 증가X ,음수는 입력X
	 void speedUp(int speed) { //function speedUp(speed){}
		 //시동이 걸렸다면
	   if(sidong) {//if(sidong==true) { 조건식의 값이 boolean값인 경우
		 if((speed < 0) || (current_speed+speed >=180)) {
			 System.out.println("속도는 음수이거나 180km이상은 증가불가능!");
			 current_speed=120;
			 return;
		 }else {
		 current_speed+=speed;//current_speed=current_speed+speed;
		 System.out.println(speed+"km만큼 속도가 증가되었습니다.");
		 }
	   }else { //sidong==false
		   System.out.println("먼저 시동을 걸어야 속도를 증가시킬수있습니다.");
	   }
	 }
	//3)속도 감소->speedDown(int speed)
	 //음수X  current_speed-speed <0 ->감소될 수없다.
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
		System.out.println("차의년도="+year);
	}
	
	//5)차의 주차->단순,반복
	void stop() {
		sidong=false;//(2>3)
		current_speed=0;
		System.out.println("주차완료!");
	}
}





