package j0622;

//열거형을 사용
public class EnumTest {
    //누구나 외부에서 접근이 가능하면서 사용할 수 있도록 공유된 상수화된 변수
	//enum 클래스에 추가
	
	public static final int SUN=0; //자주 사용이 되는 숫자값을 따로 선언
	public static final int MON=1;
	public static final int TUE=2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int su1,su2,su3,su4;
       su1=SUN;
       su2=TUE;
       //사용1=>열거형클래스명.열거형상수지정
       System.out.println("su1=>"+su1+"su2=>"+su2);
       System.out.println("====외부의  enum을 사용하는 경우====");
       System.out.println(Day.SUN);//Day.항목->항목에 해당하는 문자열 출력
       System.out.println(Day.SUN.ordinal());//열거형 항목에 해당 숫자를 반환
       System.out.println(Day.MON.ordinal());
       
       //사용2 열거형 객체명=열거형클래스명.열거형항목
       Day d=Day.SUN;//SUN문자열
       su3=Day.SUN.ordinal();//0
       switch(d) {
       //case 열거형클래스명.항목 X
            case SUN:System.out.println("일요일"); break;
            case MON:System.out.println("월요일"); break;
       }//switch
	}
}










