package j0530;

public class BreakTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println("레이블이 있는 Break문");
          //        1)      2)
          //레이블(대,소문자구분) 형식:레이블명:
          A:
          for(int a=0;a<5;a++) { 
        	  //    3)       4) 7)       6)
          	for(int b=0;b<5;b++) {
          		//추가
          		if(b==2) break A; //조건식->break 레이블명;
          		//----------------
          		System.out.println("a="+a+",b="+b);//5)8)
          	}
            System.out.println(); 
          }//outer for	
          //A:
          System.out.println("이중 for문 종료");
	}
}



