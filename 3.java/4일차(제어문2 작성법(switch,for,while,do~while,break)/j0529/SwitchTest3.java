package j0529;
//다중 if문 대용=>사용자로부터 값을 입력->짝수/홀수(1~10까지의 숫자만)
public class SwitchTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("조건식에서도 드디어 문자를 사용이 가능하다.");
		String day="10"; 
		//(2)switch ~case
		switch(day) {//조건식에도 문자열을 사용이 가능
		
		case "10":
			 		System.out.println("10을 선택했습니다.");
			 		break;
		case "20": 
	 		System.out.println("20을 선택했습니다.");
	 		break;
		}//switch
		System.out.println("switch구문 종료3");
	}
}




