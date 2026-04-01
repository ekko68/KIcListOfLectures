package j0612;

import java.awt.*;//1)

public class BorderTest extends Frame{

	//화면에 부착시킬 컴포넌트를 선언
	//Panel p; //장판
	Button b1,b2,b3,b4,b5;
	
	public BorderTest(String title) {
		setTitle(title);
		setBounds(200,200,400,200);
		//창에 부착시킬 컴포넌트를 생성->
		//부착->창객체명.add(부착시킬 컴포넌트명)
		b1=new Button("연습1");
		b2=new Button("연습2");
		b3=new Button("연습3");
		b4=new Button("연습4");
		b5=new Button("연습5");
		this.add(b1); add(b2); add(b3); add(b4); add(b5);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         BorderTest bt=new BorderTest("배치관리자연습");
	}
}
