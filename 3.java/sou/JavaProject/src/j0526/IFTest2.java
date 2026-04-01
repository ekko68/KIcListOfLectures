package j0526;

public class IFTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int su = 55;
		// 1~100까지 입력받은 숫자만 짝수,홀수판별
		if ((su >= 1) && (su <= 100)) {
			if (su % 2 == 0) {
				System.out.println(su + "은 짝수입니다.");
			} else { // su%2==1
				System.out.println(su + "은 홀수입니다.");
			}
		} else {
			System.out.println("su값은 1~100까지의 값만 입력이 가능합니다.");
		}
		System.out.println("if문 종료");
	}
}
