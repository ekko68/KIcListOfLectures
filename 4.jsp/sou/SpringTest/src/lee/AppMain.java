package lee;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.Message1의 객체->sayHello()
		//프로그램 개발할때->문제가 발생->소스변경을 변경한다면
		//Message1 me=new Message1();
		Message2 me=new Message2();
		me.sayHello("홍길동");
	}
}
