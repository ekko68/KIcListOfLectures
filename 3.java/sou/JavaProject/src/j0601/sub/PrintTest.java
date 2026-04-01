package j0601.sub;
//생성자,오버로딩을 정리

public class PrintTest {

	//(3)생성자 오버로딩
	PrintTest(char a){
		print(a);//print('v');
		System.out.println("난 문자 1개짜리 생성자호출됨!");
	}
	PrintTest(int a){ //a=2017
		//메서드 호출->객체명.메서드명(~) ->자기 클래스명에서는 객체명을 생략
		print(a);//(2)print(2017);
		System.out.println("난 정수1개짜리 생성자호출됨!");//4)
	}
	PrintTest(boolean a){ //2>3(false)
		print(a);//(2)print(false);
		System.out.println("난 불린값 1개짜리 생성자호출됨!");
	}
	
	//PrintTest(){} //기본생성자는 없으면 자동으로 만들어준다.
	//사용자로부터 값을 하나입력->출력
	
	/*(1)
	 void charPrint(char a) {
		System.out.println("a="+a);
	}
	void intPrint(int a) {
		System.out.println("a="+a);
	}
	void booleanPrint(boolean a) {
		System.out.println("a="+a);
	}*/
	
	//(2)메서드의 오버로딩->메서드 하나로 통합,매개변수갯수, 자료형으로 구분
	void print(char a) {
		System.out.println("a="+a);
	}
	void print(int a) {
		System.out.println("a="+a);//(3)2017
	}
	void print(boolean a) {
		System.out.println("a="+a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println("메서드 호출");
          /* (1) 메서드 오버로딩 X
          PrintTest pt=new PrintTest();
          pt.intPrint(2017);
          pt.charPrint('v');
          pt.booleanPrint(2>3);*/
          
          //(2) 메서드 오버로딩 O
          /*
          PrintTest pt=new PrintTest();
          pt.print(2017);
          pt.print('v');
          pt.print(2>3);
          */
          //(3) 생성자 오버로딩 O ->각각 다른 print() 호출 처리
          PrintTest pt=new PrintTest(2017);//정수형 인수1개짜리 생성자호출 (1)
          PrintTest pt2=new PrintTest('v');
          PrintTest pt3=new PrintTest(2>3);
	}
}






