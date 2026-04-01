package j0531;

public class Star3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i,j;//i(행),j(별)
        for(i=1;i<=5;i++) { //행1~5
        	//1.공백출력->k(공백)
        	for(int k=1;k<i;k++) {
        		System.out.println(" ");
        	}
        	//2.별을 출력
        	for(j=5;j>=i;j--) {//별1~5
        	System.out.print("*");
        	}
        	System.out.println();//줄바꿈
        }
	}
}







