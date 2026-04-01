package j0614;

import java.awt.*;//그래픽
//추가
import javax.swing.*;
//
import java.awt.event.*;//~Listener,~Adapter(event패키지)->Swing이벤트처리

//ActionEvent->ActionListener(추상메서드명)
//버튼을 클릭,메뉴항목클릭,입력하고 엔터치는 경우

public class ButtonEvent extends JFrame implements ActionListener{

	//부착시킬 컴포넌트->멤버변수로 선언
	JButton b1,b2,b3,b4;//ActionEvent->ActionListener
	JTextField tf1;//사용자로부터 값을 입력받을때 
	//화면디자인->생성자
	public ButtonEvent() {
		super("버튼의 이벤트 연결");//setTitle("버튼의 이벤트 연결")
		setBounds(300,200,300,250);
		//-------부착시킬 컴포넌트 생성,버튼의 이벤트연결,배치관리자 변경----
		//GridLayout gl=new GridLayout(5,1,3,3);
		//setLayout메서드와 setBackGround메서드앞에 getContentPane()
		this.getContentPane().setLayout(new GridLayout(5,1,3,3));//5행 1열
		b1=new JButton("시작");
		b2=new JButton("고");
		b3=new JButton("백");
		b4=new JButton("점프");
		tf1=new JTextField(" ");//빈문자열에 해당하는 텍스트입력창(TextArea)
		//부착시키는 순서=컴포넌트를 만드는 순서와 정반대
		this.getContentPane().add(b1); 
		add(b2);add(b3); add(b4);add(tf1);
		//버튼클릭시 이벤트 연결->이벤트발생대상자.addXXXXXListener(처리객체명)
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		tf1.addActionListener(this);
		//4번째 방법
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//버튼을 클릭할때 자동적으로 호출(ActionEvent e->이벤트 발생컴포넌트정보)
	//1.이벤트 발생시킨 이름을 얻어올 수 있다.(e.getActionCommand())
	//2.이벤트를 발생시킨 컴포넌트의 종류->e.getSource()->tf
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		String s=e.getActionCommand();//클릭한 버튼의 이름
		//이벤트를 발생시킨 컴포넌트정보를 얻어온다
		Object o=e.getSource();//버튼 또는 텍스트필드
		if(o instanceof JButton) {
			JButton b=(JButton)o; //자식클래스형 객체=(자식클래스명)부모객체명;
		//---------------------------------------------
		if(s.equals("시작")) {//시작버튼을 눌렀다면
			b.setBackground(Color.red);//색깔은 Color->정적상수
			setTitle(s);
		}else if(s.equals("고")) { //b2->yellow
			b.setBackground(Color.yellow);//색깔은 Color->정적상수
			setTitle(s);
		}else if(s.equals("백")) { //b3->blue
			b.setBackground(Color.blue);//색깔은 Color->정적상수
			setTitle(s);
		}else { //점프->b4->orange
			b.setBackground(Color.orange);//색깔은 Color->정적상수
			setTitle(s);
		}
	}else { //이벤트발생 객체=>JTextField
		JTextField tf2=(JTextField)o;
		tf2.setText("객체형변환이 중요!");//입력창에 글자를 써준다(수정)
		setTitle(tf2.getText());
	}
		//--------------
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                new ButtonEvent();
	}
}



