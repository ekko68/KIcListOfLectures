class VarTest 
{
	public static void main(String[] args) 
	{
		System.out.println("변수선언및 저장");
		//자료형(문자,숫자?) 변수명;
		//var age //자바스크립트
		int age; //변수선언(메모리에 공간이 만들어진다.)
		age=25;//25을 변수 age에 저장=>int age=25;
		//document.write("올해 제 나이는"+age+"살 입니다.");
		System.out.println("올해 제 나이는"+age+"살 입니다.");
		int x=0;//변수를 선언하면서 동시에 값을 저장한 경우

		byte b=23; //-128~127
		short c=12; //-32768~32767
		//byte sum=b+c;//23+12=35
		int sum=b+c; //자바에서 기본연산->int
		//VarTest.java:16: error: incompatible types: //타입이 안맞아요
		//possible lossy conversion from int to byte
		System.out.println("sum=>"+sum);
        //int no=1234567890000;
		long no=1234567890000L;
		//숫자뒤에L or l을 입력한 이유->반드시 long형으로 저장하는 경우에만 사용
		//VarTest.java:21: error: integer number too large: 1234567890000
		System.out.println("합계=>"+(b+c));
        System.out.println("no=>"+no);
	}
}
/*
---------- 실행 ----------
변수선언및 저장
올해 제 나이는25살 입니다.
sum=>35
합계=>35
no=>1234567890000

출력 완료 (0초 경과) - 정상 종료
*/