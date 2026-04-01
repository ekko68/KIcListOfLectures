package j0607;

// 형식) import 최상위패키지명.하위패키지명...불러올클래스명(*);
import java.util.Scanner;

//외부의 패키지로 만들어서 불러오는 경우
import j0607.abc.PrintTest;

public class RepeatChar {
    //char ch; int n;//매개변수 전달X
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;//문자하나를 저장할 변수->String에서 분리
		int n;//반복할 횟수를 저장할 변수
        Scanner sc=new Scanner(System.in);
        //문자열->nextLine() or next(), 숫자를 입력->nextInt()
        //문자열 라인 단위로 입력(공백포함)->nextLine(), 
        //문자열 단어중심->next()->공백 포함X
        System.out.println("반복할 문자를 입력?");//"ab"=>'a','b' "a"->'a'
        //객체에서 메서드를 호출할때 메서드를 여러개 나열 할 수도 있다.
        String str=sc.nextLine(); // abc ddd  ddd ->next()
        ch=str.trim().charAt(0); //"    a"=>"a"->'a'
        System.out.println("반복할 숫자를 입력?");
        n=sc.nextInt();
        
        /* 
        (1)일반 메서드로 작성한 경우 호출
        RepeatChar rc=new RepeatChar();
        rc.charPrint(n, ch);*/
        //(2)
        //RepeatChar.charPrint(n, ch);
        //(3)외부 패키지의 메서드를 호출하는 경우
        PrintTest.charPrint(n,ch);
        //반복
        /*for(int i=1;i<=n;i++)
        	System.out.print(ch);*/
	}
	//일반,정적구분? static O ->정적메서드 ,static이 X 일반메서드(특수한 경우)
	/* (3) j0607.abc.PrintTest
	 static void charPrint(int n,char ch) {
		for(int i=1;i<=n;i++)
        	System.out.print(ch);
	}*/
}




