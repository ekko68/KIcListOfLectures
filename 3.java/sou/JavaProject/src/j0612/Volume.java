package j0612;

//음악프로그램 전체에 사용되는 모든 공통적인 기능를 메서드선언
public interface Volume {
    //1.볼륨을 올리기->수정
	public void volumeUp(int level);
	//2.볼륨을 내리기->수정
	public void volumeDown(int level);
    //3,4 ->turnOn,turnOff
}
