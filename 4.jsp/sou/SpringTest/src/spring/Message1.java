package spring;

public class Message1 implements MessageInter {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		   System.out.println("안녕!"+name+"씨!");
	}
}
