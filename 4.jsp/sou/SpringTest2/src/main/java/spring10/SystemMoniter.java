package spring10;

public class SystemMoniter {
    //has a 관계->byType->PhoneCall와 같은 자료형의 객체
	/*private PhoneCall call;  (1) byType

	public void setCall(PhoneCall call) {
		this.call = call;
		System.out.println("setCall()호출(call)=>"+call);
	}*/
	//(2)byName
	private PhoneCall phonecall;//type과 이름을 같게 준다(멤버변수명)

	public void setPhonecall(PhoneCall phonecall) {
		this.phonecall = phonecall;
		System.out.println("setPhone()호출(phonecall)=>"+phonecall);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SystemMoniter[phonecall="+phonecall+"]";
	}
}



