package j0614;

//사용자로부터 값을 입력(숫자)->출력
public class ExceptionTotal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("매개변수 2개(동적배열)");
		try {//에러가 발생 가능성이 있는 구문
			int a = Integer.parseInt("9");
			int b = Integer.parseInt(" ");
			System.out.println("a=" + a + ",b=" + b);
			System.out.println("a를 b로 나눈 몫=>" + (a / b));
		} catch (ArithmeticException e) {// 1.
			System.out.println(e);// e.toString(),e.getMessage()간단한 에러정보)
			System.out.println("9를 0으로 나눌 수가 없습니다.");
			// IndexOutOfBoundsException(배열첨자)
			// NumberFormatException->
			// Integer.parseInt("5")->5오류발생시 처리
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			System.out.println(e);// e.toString()
			System.out.println("입력받은 갯수는 반드시 2개이거나 숫자를 입력요망");
		} catch (Exception e) {// 위에 언급한 예외처리클래스 외의 예외는 Exception
								// 이 처리해줄 수 있다.(자동 객체형변환)
			System.out.println(e);// e.toString()
			System.out.println("위에서 발생한 예외처리 외의 다른 예외처리를 처리해줄 수 있다");
		}finally {
			System.out.println
			("에러발생 유무와 상관없이 반드시 처리하고 프로그램 종료해야 코드필요");
			//DB접속하고 나서 나중에 메모리해제 하고 프로그램 종료
		}
	}
}





