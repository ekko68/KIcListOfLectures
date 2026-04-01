package j0526;

public class Op1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //System.out.println("산술,증감연산자");
		System.out.println("산술,증감연산자");
		/*
		int a=3,b=4;
		int c=a+b ; ///기본 연산 자료형->int =>코드 이식성때문(자바의 특성)
		                 //형변환와 연관
		System.out.println("c=>"+c);*/
		
		int a=4;  //var a=4  or a=4(자바스크립트)
		int b=a++;
		/*
		 * int b=a; b=4
		 * a++ =>a=a+1 ->a=5
		 */
		int c=++a;
		/*
		 * a=a+1 =>a=5+1
		 * int c=a; int c=6
		 */
		System.out.println("a="+a+",b="+b+",c="+c);//6,4,6
		
		
	}
}







