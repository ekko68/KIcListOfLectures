package j0530;
//이중 for문(제어문 내부에 또 다른 제어문)
public class ForTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println("중첩for(이중 for)문");
          //        1)   2)13)   //12)
          for(int a=0;a<5;a++) { //0,1,2,3,4->각각의 행을 체크(a)
        	  //System.out.println("a="+a);
        	  //      3)      4)7) 10)     6)9)
          	for(int b=0;b<5;b++) {//각각의 행별로 찍어주는 별의 수(b)
          		//System.out.println("a="+a+",b="+b);//5)8)
          		System.out.print("*");
          	}
            System.out.println(); //줄바꿈 //11)
          }//outer for		  
          System.out.println("이중 for문 종료");
	}
}



