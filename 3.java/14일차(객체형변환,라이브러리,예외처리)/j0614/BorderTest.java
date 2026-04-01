package j0614;

import java.awt.*;//1)그래픽에 대한 클래스 가져오기
//1)
//추가
import javax.swing.*;//1)Swing 불러오기

public class BorderTest extends JFrame{ //2)상속을 받아서 화면디자인

	//화면에 부착시킬 컴포넌트를 선언
	//Panel p; //장판
	JButton b1,b2,b3,b4,b5;
	
	public BorderTest(String title) {
		super(title);//setTitle(title);
		setBounds(200,200,400,200);//x,y,w,h
		//창에 부착시킬 컴포넌트를 생성->
		//부착->창객체명.add(부착시킬 컴포넌트명)
		b1=new JButton("연습1");
		b2=new JButton("연습2");
		b3=new JButton("연습3");
		b4=new JButton("연습4");
		b5=new JButton("연습5");
		//창객체명.add(부착시킬 컴포넌트명,위치(BorderLayout.위치)
		/* (1) BorderLayout방식으로 배치
		add(b1,BorderLayout.NORTH); North
		add(b2,BorderLayout.SOUTH); South
		add(b3,"Center"); //BorderLayout.CENTER
		add(b4,"East");//오른쪽
		add(b5,"West");*///왼쪽
		//(2),(3) FlowLayout,GridLayout 방식으로 배치시킬때 필요
		//FlowLayout fl=new FlowLayout();
		/*GridLayout gl=new GridLayout(3,2,5,5);//행수,열수,수평간격,수직간격(gap)
		this.setLayout(gl);*/
		//setLayout,setBackground 메서드 앞에 getContentPane()
		this.getContentPane().setLayout(new GridLayout(3,2,5,5));//생성자형태로 객체값을 입력
		
		add(b1); 
		add(b2);
		add(b3); 
		add(b4);
		add(b5); 
		//추가->x버튼을 누르면 종료(JFrame)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//정상종료
		//메모리에 올려놓은 부분->메모리 해제하고 프로그램 종료(System.exit(0);)
		//setDef~메서드를 사용X->x버튼을 누르면 창만 닫힌다 메모리 해제X
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         BorderTest bt=new BorderTest("배치관리자연습");
	}
}
