package j0602;

public class IFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("if문 유형");//평서문
		int su=19;//->입력받은 값을 저장=>동적으로 입력
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
		//절대값->음수->양수,양수->양수
		int abs=-500;
		abs=(abs < 0)?-abs:abs;
		System.out.println("abs=>"+abs);
		//정적메서드(=클래스 메서드)를 이용->내장(java.lang.Math->~)
		System.out.println("기존의 정적메서드를 이용");
		abs=Math.abs(-2500);
		System.out.println("절대값 abs=>"+abs);
		int max=Math.max(34,98);
		System.out.println("최대값(max)=>"+max);
		System.out.println("if문 종료");
	}

}




