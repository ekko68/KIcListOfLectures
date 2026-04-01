package j0601.sub;
//3개를 입력받아서 최대값을 구하시오.
public class ThreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a=12;
       int b=4;
       int c=19;
     
       //두개의 값을 비교->큰값을 선택->나머지값으로 비교->최종 큰값
       //부하직원을 호출하는 문장
       ThreeTest  tt=new ThreeTest();
       tt.getMaxPrint(a, b, c);
       tt.getMaxPrint(78, 12, 56);
       tt.getMaxPrint(33, 89, 42);
       tt.getMaxPrint(19, 90, 33);
       /*
       max=(a>b)?a:b;  //(12>4)?12:4
       max=(max > c)?max:c;   //(12>19)?12:19
       System.out.println("최대값(max)=>"+max);*/
       //또 다른 세개의 입력값->최대값
	}
	
	//메서드 작성->매개변수의 유무,반환형의 유무->getMaxPrint()
	void getMaxPrint(int a,int b,int c) {
		   int max;
		   max=(a>b)?a:b;  //(12>4)?12:4
	       max=(max > c)?max:c;   //(12>19)?12:19
	       System.out.println("최대값(max)=>"+max);
	}
}







