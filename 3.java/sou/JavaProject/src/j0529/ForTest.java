package j0529;

public class ForTest {
    //자바언어=>c언어(제어문)+c++언어(객체지향 언어(클래스 작성)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("1.for문의 유형(c++유형)");
         for(int i=1;i<=5;i++) { //while(i<=5)
           System.out.println("반복문연습"+i);
         }
         System.out.println("for문 종료");
         System.out.println("2.for문의 유형2(c언어유형)");
         /* (1)
          * int k;
         for(k=10;k>5;k--)
        	 System.out.println(k+"테스트");*/
         System.out.println("3.초기식이 생략이 된 경우");
         int k=10;
         for(;k>5;k--)
        	 System.out.println(k+"테스트");
         System.out.println("4.최소한의 for문구조(증감식도 생략이 가능)");
         int c=1;
         //c++; //증감식은 생략이 가능한데 for문 밖에 코딩X(인식X->무한루프에 빠짐)
         for(;c<=20;) {
         //for(;;) { while(true) { 다 생략하면 무한루프
        	 //System.out.println("i="+i+"\t")
        	 System.out.print("20번 반복"+c+"\t");
             c++; //증감식은 for문내부에 사용(코딩)->무한루프에 빠지지 않는다.
         }//
         System.out.println("5.합계,곱을 동시에 구하기");//1~4,100
         //1+2+3+4,,,,+100=? 변수? 변수의 갯수? 합계,반복할 횟수(2개)
         int sum=0; //i ->for문
         int gap=1;//곱을 저장
         for(int i=1;i<=4;i++) {
        	 sum+=i;//sum=sum+i;
        	 gap*=i;//gap=gap*i;
         }
         System.out.println("최종합계(sum)="+sum);
         System.out.println("최종곱(gap)="+gap);
	}
}







