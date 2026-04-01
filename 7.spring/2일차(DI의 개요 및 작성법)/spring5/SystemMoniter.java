package spring5;

//문자를 전송->기간을 정하기
public class SystemMoniter {
   
	private long periodTime;//기간
	//has a 관계
	private SmsSender sender;
	//
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}
	public void setSender(SmsSender sender) {
		this.sender = sender;
		System.out.println("setSender()호출됨=>"+sender);
	}
	
	public String toString() {
		return "Systemoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




