package j0526;

public class IFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("if문 유형");//평서문
		int su=19;//->입력받은 값을 저장
		//(1) if(조건식(변수,수식)) 실행1
		/*if (su%2==0) { //하나의 조건식에 동시에 실행할 문장 하나 이상일때 블럭
			System.out.println(su+"은 짝수입니다.");
		}*/
		if (su%2==0) { 
			System.out.println(su+"은 짝수입니다.");
			System.out.println("블럭처리 연습1");
		}else {  //su%2==1
			System.out.println(su+"은 홀수입니다.");
			System.out.println("블럭처리 연습2");
		}
		System.out.println("삼항연산자로 변경");
		String su2=(su%2==0)?"짝수":"홀수";
		System.out.println("입력받은값(su)은 "+su2+"입니다.");
		System.out.println("if문 종료");
	}

}




