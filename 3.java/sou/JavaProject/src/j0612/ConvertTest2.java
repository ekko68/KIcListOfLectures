package j0612;

import java.util.Scanner;

//사용자로부터 값을 입력->대,소문자로 변환
public class ConvertTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {  //for(;;){
        Scanner sc=new Scanner(System.in);
        System.out.println("문자열을 입력하세요?");
        String str=sc.nextLine();
        //"abA"=>'a','b','A'=>"ABa"
        //->문자열의 내용비교=>문자열(str).equals(비교문자열)->대소문자 구분
        if (str.equals("e") || str.equals("E")) {
        	System.out.println("프로그램이 정상적으로 종료됩니다.");
        	System.exit(0);//프로그램 정상 종료
        }
        //2.chartAt(인덱스번호)->변수저장
        char ch;
        for(int i=0;i<str.length();i++) {
           ch=str.charAt(i);
           //숫자를 입력을 받은 경우->더이상 실행X->종료
           if(Character.isDigit(ch)) {
        	   System.out.println("영문자만 입력이 가능합니다.");
        	   System.out.println("프로그램 자동종료");
        	   return;//System.exit(0);
           }else {
           //대문자->소문자로 변환 or 소문자->대문자로 변환
           if(Character.isLowerCase(ch)) //소문자라면
               System.out.print(Character.toUpperCase(ch));
           else
        	   System.out.print(Character.toLowerCase(ch));
            }//else
           }//for
        System.out.println();//줄바꿈
		}//while  or for
	  }//main
}







