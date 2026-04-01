package lee.model;
//핵심클래스(=Target 클래스)->메서드->컨트롤러호출
public class MyModel {
	//beforeProcess()
	public String processMsg() {
		System.out.println("핵심기능 실행됨!");
		return "스프링웹 AOP연습";
	}
	//afterProcess()
}
