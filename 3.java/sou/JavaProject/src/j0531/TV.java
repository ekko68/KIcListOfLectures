package j0531;
//추상화->설계도(객체->TV)
public class TV {
	//1.객체의 공통적인 특성=>멤버변수->초기화 O or X
     String name;//모델명
     String maker;//제조사
     String color;//색깔
     //상태
     boolean power=false;//전원스위치 off
     int channel=2;//기본채널->초기값 안주면 0(int)
     
     //2.공통의 기능
     //1)리모콘의 스위치on->turnOn->단순,반복->매개변수X ,반환값 X
     void turnOn() {
    	 power=!power;//power=true; !(false)
    	 System.out.println("TV가 turnOn됨!");
     }
     
     //2)리모콘의 스위치off->turnOff
     void turnOff() {
    	 power=!power;//power=false; !(true)
    	 System.out.println("TV가 turnOff됨!");
     }
     
     //3)채널 변경(증가)->수정->매개변수 O ,반환값 X
     void channelAdd(int ch) { //5
    	 channel+=ch;//channel=channel+ch
    	 System.out.println(channel+"만큼 채널을 증가돼서 이동.");
     }
  
     //4)채널 변경(감소)
     void channelSub(int ch) { //5
    	 channel-=ch;//channel=channel+ch
    	 System.out.println(channel+"만큼 채널을 감소돼서 이동.");
     }
     
     //5)말->채널변경
     void channelSpeak(String str) { //tvn->17->equals()
    	  if(str.equals("tvn")) {
    		  channel=17;
    		  System.out.println(channel+"로 이동합니다.");
    	  }else if(str.equals("ocn")) {
    		  channel=23;
    		  System.out.println(channel+"로 이동합니다.");
    	  }
     }
     //6)TV의 현재 상태를 출력->단순,반복
     void tvDisplay() {
    	 System.out.println("***TV정보 출력***");
    	 System.out.println("TV이름="+name);
    	 System.out.println("TV제조사="+maker);
    	 System.out.println("TV색깔="+color);
    	 System.out.println("TV의 현재채널="+channel);
     }
}



