package j0622;

import java.awt.*;
import java.awt.event.*;//ActionEvent->ActionListener
import javax.swing.*;//JTable
import javax.swing.table.*;//DefaultTableModel(데이터저장)

public class JTableTest2 extends JFrame implements ActionListener{

	JLabel l1,l2,l3;//이름,나이,전화번호
	JTextField tf1,tf2,tf3;
	JPanel panel;//+JLabel,JTextField 부착
	//JTable
	Object ob[][]=new Object[0][3];//데이터 표시(행X) 열만 나오게 설정
	DefaultTableModel model;//데이터저장 부분
	JTable table;
	JScrollPane js;
	String str[]= {"이름","나이","전화번호"};//컬럼명
	
	public JTableTest2() {//컴포넌트 생성->부착
		 super("테이블에 데이터입력");
		 panel=new JPanel();
		 panel.setBackground(Color.orange);//<->getBackground()
		 //1.문자열 2.위치(left,Center,right)
		 l1=new JLabel("이름",JLabel.CENTER);
		 l2=new JLabel("나이",JLabel.LEFT);//default
		 l3=new JLabel("전번",JLabel.RIGHT);
		 
		 tf1=new JTextField();tf2=new JTextField(); tf3=new JTextField();
		 //패널의 배치=>3행2열=>GridLayout
		 panel.setLayout(new GridLayout(3,2));//구조변경
		 panel.add(l1); panel.add(tf1);//이름
		 panel.add(l2); panel.add(tf2);//나이
		 panel.add(l3); panel.add(tf3);//전번
		 this.add("North",panel);//위치,컴포넌트명
		 //JTable을 가운데 배치
		 model=new DefaultTableModel(ob,str);//1.데이터저장[][] 2.컬럼명
		 table=new JTable(model);//table=new JTable(ob,str);
		 js=new JScrollPane(table);
		 this.add("Center", js);
		 setBounds(1250,250,300,300);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
		 //이벤트 연결하는 코딩
		 tf1.addActionListener(this);
		 tf2.addActionListener(this);
		 tf3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf1) { //이름을 입력한 후 enter친 경우
			tf2.requestFocus();//커서입력
		}else if(e.getSource()==tf2) {//나이입력후 enter
			tf3.requestFocus();
		}else if(e.getSource()==tf3) {//전번
			if(tf1.getText().equals("") && tf2.getText().equals("") &&
			    tf3.getText().equals("")) { //alert(~)
				//JOptionPane.showMessageDialog(부모명,경고메세지)
				JOptionPane.showMessageDialog(this,"값을 입력하세요!");
				tf1.requestFocus();//이름부터 다시 입력
				return;
			}//inner if
			//다입력을 했다면 값을 모델에 데이터를 입력->JTable에 화면 결과출력
			//형식) 모델객체명.addRow(저장할값(배열[]))
			Object data[]= {tf1.getText(),tf2.getText(),tf3.getText()};
			model.addRow(data);
			//재입력
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf1.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new JTableTest2();
	}
}





