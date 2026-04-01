package j0609;

import java.util.Scanner;

//사용자로부터 값을 입력->대,소문자로 변환
public class ConvertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        System.out.println("문자열을 입력하세요?");
        String str=sc.nextLine();
        //"abA"=>'a','b','A'=>"ABa"
        System.out.println("입력받은 문자열의 길이(str.length())->"+str.length());
        //2.chartAt(인덱스번호)->변수저장
        char ch;
        for(int i=0;i<str.length();i++) {
           ch=str.charAt(i);
           //대문자->소문자로 변환 or 소문자->대문자로 변환
           if(Character.isLowerCase(ch)) //소문자라면
               System.out.print(Character.toUpperCase(ch));
           else
        	   System.out.print(Character.toLowerCase(ch));
        }//for
	}
}







