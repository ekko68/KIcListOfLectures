package j0613;

import java.util.Scanner;

//Scanner클래스 객체를 얻어오는 메서드 2개 작성->Setter,Getter 방법을 이용
public class ScanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //Scanner sc=new Scanner(System.in);
		ScanTest st=new ScanTest();
		Scanner sc=st.getScan();
		st.setScan(sc);
        
        /*System.out.println("문자를 입력하세요?");
        String s=sc.nextLine();//"+"->'+' (2)
        System.out.println("입력받은 문자열은=>"+s);*/
        
	}
	//2.Scanner객체를 만들어주는 갖다주는 메서드 작성->getXXX
	public  Scanner getScan() { //public 반환형객체자료형 getXXX(){
		Scanner sc=new Scanner(System.in);
		return sc;
	}
	//3.Scanner객체를 넘겨받아서 대신 일을 처리해주는 메서드->setXXX
	public void setScan(Scanner sc2) {
		System.out.println("문자를 입력하세요?");
        String s=sc2.nextLine();//"+"->'+' (2)
        System.out.println("입력받은 문자열은=>"+s);
	}
}








