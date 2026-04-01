package j0530;

public class Star2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i,j;//i(행),j(별)
        for(i=1;i<=5;i++) { //행1~5
        	for(j=5;j>=i;j--) {//별1~5
        	System.out.print("*");
        	}
        	System.out.println();//줄바꿈
        }
	}
}







