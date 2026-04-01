package j0602;

//외부의 패키지에 들어가 있는 다른 클래스를 참조해서 불러오고
//import 최상위패키지명.하위패키지명....불러올 클래스명 or (*)
import java.util.Scanner;

public class ArrayTest4 {
 //사용자로부터 직접적으로 값을 입력->Scanner클래스를 이용
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//키보드를 통해서 값을 하나 입력 ->문자열을 입력->nextLine() or next()
		//숫자를 입력->nextInt(), nextDouble(),nextFloat();
          Scanner sc=new Scanner(System.in);
          int jumsu[]=new int[5];
          int sum=0;//합계
          double avg=0.0;//평균
          System.out.println("5과목의 점수를 입력하세요?");
          for(int i=0;i<jumsu.length;i++) {
                jumsu[i]=sc.nextInt();  //sc.nextLine() or sc.next()
                sum+=jumsu[i];//sum=sum+jumsu[i]
          }
          //최종평균,합계
          avg=(double)sum/jumsu.length;//5
          System.out.println("총합=>"+sum+",평균=>"+avg);
	}

}







