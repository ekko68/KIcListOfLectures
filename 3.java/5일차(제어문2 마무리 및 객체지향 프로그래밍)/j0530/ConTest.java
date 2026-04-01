package j0530;

public class ConTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println("레이블이 없는 Continue문");
          //        1)      2)
         // A:
          for(int a=0;a<5;a++) { 
        	  //    3)       4) 7)       6)
          	for(int b=0;b<5;b++) {
          		//추가
          		//if(b==2) continue A;
          		if(b==2) continue;
          		//----------------
          		System.out.println("a="+a+",b="+b);//5)8)
          	}
            System.out.println(); 
          }//outer for		  
          System.out.println("이중 for문 종료");
	}
}



