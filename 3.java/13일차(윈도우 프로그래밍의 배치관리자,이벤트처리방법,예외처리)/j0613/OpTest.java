package j0613;

import java.util.Scanner;//rt.jar

public class OpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int a,b;//첫수,두번째수를 저장
        char op;//"+"=>char로 입력X->String으로 받아서 분리->char(charAt)
        System.out.println("첫수를 입력?");
        //a=sc.nextInt();//nextDouble(소수점) (1)
        a=Integer.parseInt(sc.nextLine());//"5.4"->5(2)
        System.out.println("연산자[+,-,*,/]");
        String s=sc.nextLine();//"+"->'+' (2)  ->"aabaa   bvvvv"
        //String s=sc.next();//(1)
        op=s.charAt(0); //op=sc.nextLine().charAt(0);
        System.out.println("두번째수를 입력?");
        b=Integer.parseInt(sc.nextLine());//(2)
        //b=sc.nextInt();//(1)
        
        switch(op) {//'+'
        case '+':
        	System.out.println(a+"+"+b+"="+(a+b));
        	break;
        	//-
        case '-':
        	System.out.println(a+"-"+b+"="+(a-b));
        	break;	
        	//*
        case '*':
        	System.out.println(a+"*"+b+"="+(a*b));
        	break;	
        	// /
        case '/':
        	System.out.println(a+"/"+b+"="+(a/b));
        	break;
        }//switch
	}
}








