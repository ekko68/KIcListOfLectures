package j0602;

//p167
public class WhileTest2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 반복할 횟수를 기억변수 선언
		// 무한루프->조건식이 항상 참인되기때문에 무한적으로 계속수행이 되는 경우
		//메서드내부의 변수->지역변수
		int start = 10; // var i=1;
		int end = 20;
		//객체명.메서드명(~)
		WhileTest2 wt=new WhileTest2();
		wt.whilePrint(start, end);
		wt.whilePrint(30, 60);
		wt.whilePrint(90, 200);
		// start > end
		/*if (start > end) {
			System.out.println("start값은 end값은 클수가 없다.");
			return;// if구문 이하구문을 실행하지말고 그대로 종료하라(탈출문)
		} else { // start<=end
			while (start <= end) { // while(시작값<=종료값)
				System.out.println("반복할 횟수가 있는 while문" + start);
				start++; // start=start+1
			} // 블럭처리
		}*/
		System.out.println("while구문 종료됨!");
	}// main구문의 끝을 만나면 종료
	
	//매개변수 O ,반환형 X
	void whilePrint(int start,int end) {
		if (start > end) { //if(10>20)
			System.out.println("start값은 end값은 클수가 없다.");
			return;// if구문 이하구문을 실행하지말고 그대로 종료하라(탈출문)
		} else { // start<=end
			while (start <= end) { // while(시작값<=종료값)
				System.out.println("반복할 횟수가 있는 while문" + start);
				start++; // start=start+1
			} // 블럭처리
		}
	}
	
	
	
	
	
	
}
