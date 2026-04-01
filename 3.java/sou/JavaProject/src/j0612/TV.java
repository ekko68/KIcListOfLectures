package j0612;

//형식) class 자식클래스명 implements 부모인터페이스명
public class TV implements AdvanceVolume {

	//@Override->angular,react=>장식자(스프링)
	private int VolLevel;//볼륨의 크기
	
	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub
        VolLevel+=level;
        System.out.println("TV의 볼륨을 올립니다.!");
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		VolLevel-=level;
		if(VolLevel < 0)
			VolLevel=0;
        System.out.println("TV의 볼륨을 내립니다.!");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
       System.out.println("TV 프로그램을 turn On!");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV 프로그램을 turn Off!");
	}
	//나머지 메서드는 개발자에게 맡김...
	
}

