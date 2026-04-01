package j0613;

import java.awt.*;//파일만 적용이 된다.(폴더X)
//1)이벤트 처리에 해당되는 클래스,인터페이스를 import
import java.awt.event.*;
//2.다른 클래스가 이벤트 처리를 대신 처리해주는 경우
public class WindowTest2 extends Frame {

	public WindowTest2(String s) {
		   super(s);
		   setBounds(300,300,400,200);
		   //이벤트 연결구문->이벤트소스(대상자).addXXXXListener(처리해줄객체명)
		   Other ot=new Other();
		   this.addWindowListener(ot);
		   //this.addWindowListener(new Other());
		   //------------------------------------------
		   setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new WindowTest2("다른 클래스인 Other가 대신처리해준 경우");
	}
	/*@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");//창이 활성화될때 호출
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		//윈도우가 닫힌 후에 발생
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");//윈도우의 x버튼을 클릭할때 호출
		System.exit(0);//종료
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");//창이 비활성화될때 호출
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeIconified");
		//작업표시줄에 있던 창이 튀어올라오는 경우
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");//창이 작업표시줄에 들어간 상태
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");//창이 열렸을때 발생
	}*/
}

//이벤트를 대신 처리해주는 클래스를 따로 작성
class Other implements WindowListener{
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");//창이 활성화될때 호출
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		//윈도우가 닫힌 후에 발생
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");//윈도우의 x버튼을 클릭할때 호출
		System.exit(0);//종료
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");//창이 비활성화될때 호출
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeIconified");
		//작업표시줄에 있던 창이 튀어올라오는 경우
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");//창이 작업표시줄에 들어간 상태
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");//창이 열렸을때 발생
	}
}














