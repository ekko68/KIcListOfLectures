package j0529;
//다중 if문 대용=>사용자로부터 값을 입력->짝수/홀수
public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int su=34;  
		//2의 배수
		/* (1)
		if (su % 2 == 0) 
			System.out.println(su + "은 짝수입니다.");
		 else  // su%2==1
			System.out.println(su + "은 홀수입니다.");*/
		//(2)switch ~case
		switch(su % 2) {
		case 0:
			 		System.out.println(su+"은 짝수입니다.");
			 		break;//생략하면 조건에 만족하지 않은 구문까지도 실행이 된다.
		case 1:
	 		System.out.println(su+"은 홀수입니다.");
	 		break;
		}//switch
		System.out.println("switch구문 종료");
	}
}




