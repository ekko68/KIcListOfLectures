package j0607;

public class DoubleArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("2차원배열을 생성 및 가변배열");
        //1.형식) 배열의 자료형 배열명[][]=new 자료형[행수][열수];
        //int b[][]=new int[3][3]; //b[0][0]=?,b[0][1]=?,,,,
        //2.형식) 배열의 자료형 배열명[][]={{값1,값2},{값3,,값n}};
        //int b[][]=new int[3][3]; b[0][0]=10;b[0][1]=20;b[0][2]=30;  
        //b[1][0]=40; b[1][1]=50;b[1][2]=60; b[2][0]=70~
        int b[][]= {{10,20,30},{40,50},{60,70,80,90}};
        for(int i=0;i<b.length;i++) { //행의 갯수
        	//System.out.println("b["+i+"]="+b[i]);  b.length=>행의 수
        	for(int j=0;j<b[i].length;j++) {//열의 갯수
        		System.out.println("b["+i+"]["+j+"]="+b[i][j]);
        	}//inner for
        }//outer for
        System.out.println("====================");
        System.out.println("확장 for문(배열의 첨자계산과 상관없이)");
        /* 형식)
         *   for  (2차원 배열 자료형[][]:3차원 배열명)=>참조 정도
         *        for(1차원 배열 자료형[] 배열명(tmp):2차원배열명(score)
                          for(배열의 자료형 출력변수명:1차원배열명(tmp))
        */
        //for(int b[][]:x){
        for(int tmp[]:b) { //2차원배열에서 1차원배열의 값을 하나씩 꺼낸다.
        	for(int su:tmp) 
        		System.out.print(su+"\t");
                System.out.println();
        	}//outer for
	}
}






