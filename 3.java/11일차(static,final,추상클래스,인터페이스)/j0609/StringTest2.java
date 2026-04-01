package j0609;
//String의 다양한 메서드 정리
import java.util.Scanner;//import java.util.*;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
         System.out.println("문자열을 입력하세요?");//nextLine()(문장),next()(단어)
         String input=sc.nextLine(); //"hello  ".trim() 도 가능
         //정적메서드->클래스명.정적메서드명(~)
         //                                             01234
         StringTest2.stringPrint(input);//"imsi2"
	}
	//main()이 대신 입력받은 문자열을 받아서 대신 처리해주는 메서드
    public static void stringPrint(String s) {
    	//1.concat->문자열 결합
    	System.out.println("s.concat('test')=>"+s.concat("test"));
    	//2.substring(시작인덱스(O),종료인덱스(바로앞번호))->
    	//   substring(시작인덱스)=>시작인덱스번호부터 문자열끝까지 뽑아내라
    	System.out.println("s.substring(1,4)=>"+s.substring(1,4));
    	System.out.println("s.substring(1)=>"+s.substring(1,4));
    	//3.toUpperCase()->대문자로 변환<->toLowerCase() 소문자로 변환
    	System.out.println("s.toUpperCase()=>"+s.toUpperCase());
    	//4.특정문자열을 변경->replace(변경전단어(i),변경후 단어(t))
    	System.out.println("s.replace('i','t')=>"+s.replace('i','t'));
    	//5.문자열의 길이->length()
    	System.out.println("s.length()=>"+s.length());
    	//6.문자열중에서 특정위치에 있는 문자출력=>charAt(인덱스번호)
    	System.out.println("s.charAt(2)=>"+s.charAt(2));//'s'
    	//7.특정문자가 몇번째 인덱스번호에 위치?->indexOf('찾는단어')->인덱스번호
    	System.out.println("s.indexOf('s')=>"+s.indexOf('s'));//2
    	//8.공백제거->trim()->"abcd   "=>"abcd"
    	System.out.println("s.trim()=>"+s.trim());
    }
}







