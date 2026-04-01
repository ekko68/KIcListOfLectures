package spring5;

//문자전송 시스템
public class SmsSender {
	//-----------------------------
	boolean flag;//문자가 제대로 전달됐는지 체크

  //constructor-arg이용
  public SmsSender(boolean flag) {
		this.flag = flag;
	}
  //-----------------------------------
public String toString() {
	  return "SmsSender 호출";
  }
}
