package j0602;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //int su,su2,su3;
		//1.자료형 배열[]=new 자료형[갯수]//0,1,2
		int su2;
		//System.out.println("su2=>"+su2);
		int []su=new int[3];
		su[0]=10; su[1]=20;//su[2]=30
		System.out.println("su[1]=>"+su[1]);
		System.out.println("su[2]=>"+su[2]);
		System.out.println("2.두번째 방법");
		//2.배열의 생성->바로 값을 초기화
		//자료형 배열명[]={값1,값2,값3,,,};
		int c[]= {10,20,30,40,50,60,70,80,90,100,110,120};//for문
		/*
		 * int c[]=new int[4]; c[0]=10; c[1]=20;c[2]=30; c[3]=40;
		 */
		for(int i=0;i<c.length;i++)
			System.out.println("c["+i+"]="+c[i]);
		//확장 for문(=향상된 for문)=>단순히 배열의 저장된 값을 꺼내서 내용 확인
		//형식) for(배열의 자료형 출력변수:배열명 or 컬렉션)->객체위주로 취급
		for(int num:c)										
			System.out.print("num="+num+"\t");
		System.out.println();//줄바꿈
	}
}






