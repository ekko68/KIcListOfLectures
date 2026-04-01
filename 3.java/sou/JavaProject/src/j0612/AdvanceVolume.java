package j0612;

//형식) interface 자식인터페이스명 extends 부모인터페이스
public interface AdvanceVolume extends Volume {
   /* public void volumeUp(int level);
	   public void volumeDown(int level);
    */
	public void turnOn();//켜는 경우
	public void turnOff();//끄는 경우
}
