package j0531;

public class TVHandling {
	public static void main(String[] args) { //caller method
		// TODO Auto-generated method stub
        //1.객체생성(tv) t->TV t=new TV();
		TV t;//선언
		t=new TV();//생성->4byte(주소값을 저장한 변수)
		//값을 저장->객체명.멤버변수=값
		t.name="삼성smartTV";
		t.color="검정색";
		
		//turnOn=>객체명.메서드명(~)->worker method(부하직원)
		t.turnOn();
		t.channelAdd(5);//2+5=7
		t.channelSpeak("ocn");
		t.channelSub(4);
		//t.tvDisplay();
		System.out.println("TV정보출력");
		System.out.println("TV이름="+t.name);//객체명.멤버변수명
		t.tvDisplay();
	}

}









