package j0613;

import java.awt.*;//파일만 적용이 된다.(폴더X)
//1)이벤트 처리에 해당되는 클래스,인터페이스를 import
import java.awt.event.*;//WindowAdapter
//2.다른 클래스가 이벤트 처리를 대신 처리해주는 경우
public class WindowTest3 extends Frame {

	public WindowTest3(String s) {
		   super(s);
		   setBounds(300,300,400,200);
		   //이벤트 연결구문->이벤트소스(대상자).addXXXXListener(처리해줄객체명)
		   /*Other2 ot=new Other2();
		   this.addWindowListener(ot);*/
		   this.addWindowListener(new Other2());
		   //------------------------------------------
		   setVisible(true);
	}
	//-----------------inner class 영역---------------------------
	class Other2 extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowClosing");//윈도우의 x버튼을 클릭할때 호출
			System.exit(0);//종료
		}
	}
	//---------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new WindowTest3("내부클래스를 사용하는 경우");
	}
}

//이벤트를 대신 처리해주는 클래스를 따로 작성
//class Other2 implements WindowListener{
/*class Other2 extends WindowAdapter{
	                                     
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");//윈도우의 x버튼을 클릭할때 호출
		System.exit(0);//종료
	}
}*/














