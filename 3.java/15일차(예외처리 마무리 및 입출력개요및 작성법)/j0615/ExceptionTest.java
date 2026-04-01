package j0615;

//프로그램작성->예외처리 작성->제대로 작동되는 지확인
public class ExceptionTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
          a();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("가상으로 배열첨자오류발생 연습했습니다.");
		}
		System.out.println("예외처리 최종종료!");
	}

	static void a() { //NullPointerException=>처리
		try {
			//String s="abc";
			/*String s=null;
			System.out.println("문자열의 길이->"+s.length());*/
			throw new NullPointerException("널포인터에러 연습");
		}catch(NullPointerException e) {
			System.out.println(e.toString());//에러정보를 알려줌
			System.out.println("메서드를 호출할때 먼저 객체가 생성됐는지 확인요망");
		}
		throw new ArrayIndexOutOfBoundsException("배열첨자오류");
	}
}




