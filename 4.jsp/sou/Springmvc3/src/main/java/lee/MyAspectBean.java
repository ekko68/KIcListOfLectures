package lee;
//공통모듈2
public class MyAspectBean {
    //1.메서드 호출전->SecurityClass->security()
	//SecurityClass class1=null;
	//생성자 MyAspectBean(){}
	public void beforeProcess() {
		SecurityClass class1=new SecurityClass();
		class1.security();
	}
	//2.메서드 호출후
     public void afterProcess() {
		System.out.println("핵심 내용 후에 실행될 메서드");
	}
}
