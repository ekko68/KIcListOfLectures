package j0529;
//다중 if문 대용=>사용자로부터 값을 입력->짝수/홀수(1~10까지의 숫자만)
public class SwitchTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int su=1444;  
		//2의 배수
		//(2)switch ~case
		switch(su) {//(0~10까지의 숫자만)->1324,,,
		case 0:case 2:case 4:
		case 6:
		case 8:
		case 10:
			 		System.out.println(su+"은 짝수입니다.");
			 		break;//생략하면 조건에 만족하지 않은 구문까지도 실행이 된다.
		
		case 1: case 3: case 5: case 7: case 9:
	 		System.out.println(su+"은 홀수입니다.");
	 		break;
	 	default:
	 		System.out.println("입력받을 수는 0~10까지만 입력하세요");
	 		//break 생략 가능
		}//switch
		System.out.println("switch구문 종료2");
	}
}




