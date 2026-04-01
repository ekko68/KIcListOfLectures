package j0619;
//클래스 내부에서 특정객체를 한개만 생성->대여->반납
public class Singleton {

	//1.객체를 생성->한개만 생성(공유할 수 있도록->정적멤버변수)
	//형식)private static 클래스명 객체명=null;
	private static Singleton instance=null;//선언
	
	//2.객체를 생성->생성자를 호출->형식) private 생성자(){}
	private Singleton() {
		System.out.println("인스턴스(=객체)생성");
	}
	//3.공유객체를 다른 모든 사람들에게 공유->정적메서드
	//형식)public static 클래스의 자료형 정적메서드명() 선언해서 작성
	public static Singleton getInstance() {
		if(instance==null) { //아직 안만들어져 있는 상태
			//만들고자하는 객체를 공유객체로 등록->synchronized(클래스명.class){}
			synchronized(Singleton.class) {
				if(instance==null) {
					instance=new Singleton();
				}
			}
		}//outer if
		return instance;
	}
}





