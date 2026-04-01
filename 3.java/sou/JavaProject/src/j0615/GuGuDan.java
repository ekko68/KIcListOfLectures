package j0615;

import java.util.Scanner;

public class GuGuDan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         while(true) { //for(;;){
        	 int i=1;//1~9(열을 저장)
        	 System.out.println("몇단?");
        	 Scanner sc=new Scanner(System.in);
        	 String str=sc.nextLine();//next()->"2"->2*1=2
        	 if(str.equals("q") || str.equals("Q"))
        		 System.exit(0);
        	 //단
        	 int j=Integer.parseInt(str);
        	 if(j<=0 || j>9) {
        		 System.out.println("단은 음수이거나 9단이상 입력불가");
        		 return;
        	 }
        	 System.out.println("==구구단==");
        	 System.out.println("=="+j+"단==");
        	 while(i<=9) {
        		 System.out.println(j+"*"+i+"="+(j*i));
        		 i++;
        	 }//inner while
         }//while
	}
}









