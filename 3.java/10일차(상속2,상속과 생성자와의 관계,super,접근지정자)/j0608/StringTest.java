package j0608;

public class StringTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //문자열=>객체로 취급(기본자료형이 아니다.->참조형)
		String str="Hello";//권장=>새로 무조건 공간X->없으면 공간생성
		                           //주소값이 같고 내용도 같다
		String str2=new String("Hello");//옛날방식=>새로 공간이 생성->Hello저장
		//주소값이 다 다르다.
		String str3="Hello";//위의 str을 그대로 불러다 사용(주소값이 같다)
		String str4="Hello";
		
		if(str==str2)
			System.out.println("주소값이 서로 같다");
		else
			System.out.println("주소값이 서로 다르다");
		//str,str3 주소,내용을 비교
		if(str==str3)
			System.out.println("주소값이 서로 같다");
		else
			System.out.println("주소값이 서로 다르다");
		//내용을 비교->equals()내용 비교
		if(str.equals(str3))
			System.out.println("str과 str3의 내용이 서로 같다");
		else
			System.out.println("str과 str3의 내용이 서로 다르다");
	}

}






