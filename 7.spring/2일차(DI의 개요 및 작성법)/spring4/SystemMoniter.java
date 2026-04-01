package spring4;

//문자를 전송->기간을 정하기
public class SystemMoniter {
   
	private long periodTime;//기간
	//has a 관계
	private SmsSender sender;
	// constructor injection(생성자를 통한 의존성주입)
	
	public SystemMoniter(long periodTime, SmsSender sender) {
		this.periodTime = periodTime;
		this.sender = sender;
		System.out.println("SystemMoniter()생성자 호출됨!");
	}
	//-------------------------------------------------------------
	public String toString() {
		return "Systemoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




