package j0607;

//메서드 오버로딩+배열+확장 for문 이용(p287)

public class VarArgTest {
    
	//클래스 외부에 메서드 선언X, 값을 하나 입력->출력
	/* 정적 매개변수 방법(매개변수가 정해져 있는 경우에 사용(정적(고정))
	(1)=>가변 매개변수 을 이용
	public void print(String a) {
		System.out.println("a=>"+a);
	}
	public void print(String a,String b) {
		System.out.println("a=>"+a+",b=>"+b);
	}
	
	public void print(String a,String b,String c) {
		System.out.println("a=>"+a+",b=>"+b+",c=>"+c);
	}*/
	//(2) 가변 매개변수 형태로 메서드를 작성->반드시 자료형은 같아야 된다.(배열)
	// 메서드 작성방법과 동일->(자료형 ... 배열명) //배열표시 [] 사용 금지
	//public void print(String ... names,String str) { 에러유발->뒤에 위치
	public void print(String ... names) {
		//String names[]={"홍길동"};
		//String names[]={"홍길동","이길수"};
		//String names[]={"홍길동","이길수","테스트",,,};
		for(int i=0;i<names.length;i++)   //for(String su:names)
			System.out.print(names[i]+",");//System.out.print(su+",")
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VarArgTest vat=new VarArgTest();
		vat.print("홍길동");
		vat.print("홍길동","이길수");
		vat.print("홍길동","이길수","테스트");
		vat.print("홍길동","이길수","테스트","테스트2");
		vat.print("홍길동","이길수","테스트","테스트2","테스트3");
		vat.print("홍길동","이길수","테스트","테스트2","테스트3","테스트4");
		//,,,
	}
}







