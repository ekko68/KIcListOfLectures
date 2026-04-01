package j0612;
//설계한 내용을 바탕->TV,Radio
public class VolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("설계한 대로 실행(인터페이스를 구현)");
        TV t=new TV();
        Radio ra=new Radio();
        
        //객체는  다 다르지만 공통으로 사용하는 메서드는  통일성부여->기능은 다르다
        //=>다형성의 한예로 
        
        t.turnOn();
        ra.turnOn();
        t.volumeUp(12);
        ra.volumeUp(7);
        //오버로딩->비슷한 기능을 가진 메서드->메서드명을 통일->다형성의 한예
	}

}





