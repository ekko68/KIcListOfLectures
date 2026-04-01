package j0531;

public class Alpha2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        int i,j;//i(행),j(별)
        //추가
        char mnu='A';
        for(i=1;i<=5;i++) { //행1~5
        	for(j=1;j<=i;j++) {//별1~5
        	System.out.print(mnu);//출력할때 의 전의 아스키코드 증가값을 출력
        	 mnu++;//문자->내부 아스키코드값으로 기억(숫자)
        	}
        	System.out.println();//줄바꿈
        }
	}
}


