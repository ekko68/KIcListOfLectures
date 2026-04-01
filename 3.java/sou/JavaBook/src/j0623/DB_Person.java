package j0623;

import java.awt.*;
import java.awt.event.*;//ActionEvent->ActionListener
import javax.swing.*;//JTable
import javax.swing.table.*;//DefaultTableModel(데이터저장)

//추가
import java.sql.*;//DB연동(1)
//--------------------------------

public class DB_Person extends JFrame implements ActionListener{

	JLabel l1,l2,l3;//이름,나이,전화번호
	JTextField tf1,tf2,tf3;
	JPanel panel;//+JLabel,JTextField 부착
	//JTable
	Object ob[][]=new Object[0][3];//데이터 표시(행X) 열만 나오게 설정
	DefaultTableModel model;//데이터저장 부분
	JTable table;
	JScrollPane js;
	String str[]= {"이름","나이","전화번호"};//컬럼명
	
	//추가(2)
	Connection con=null;//연결객체
	PreparedStatement pstmt=null;//SQL 구문을 실행
	ResultSet rs=null;//select구문을 사용하는 경우
	//--------------------------------------------------------
	
	public DB_Person() {//컴포넌트 생성->부착
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
		 //1.DB접속->2.select->JTable에 관한 구문에 코딩
		 connect();
		 select();
		 this.addWindowListener(new WindowAdapter() {
			 @Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {  //프로그램 종료하기전에 메모리에 DB연동 부분 해제
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				}catch(Exception e2) {}
				System.exit(0);
			}
		 });
	}
	
	//connect메서드는 다른 클래스에서 호출X->내부적으로 호출->처리
	private void connect() {
		try {
			//1.오라클 드라이버 메모리에 올림
			 //1.접속할 드라이버를 메모리에 올리기
      	  Class.forName("oracle.jdbc.driver.OracleDriver");
      	  String url="jdbc:oracle:thin:@localhost:1521:orcl";//url주소값
      	  //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
      	  con=DriverManager.getConnection(url, "test1", "t1234");
      	  System.out.println("접속con=>"+con);
		}catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
	}
	public void select() {
		try {
			String sql="select * from person";
			pstmt=con.prepareStatement(sql);
			System.out.println("pstmt=>"+pstmt);
			rs=pstmt.executeQuery();
			System.out.println("rs=>"+rs);
			//person테이블에서 불러오기
			while(rs.next()) {
				String name=rs.getString("name");
				String age=rs.getString("age");
				String tel=rs.getString("tel");
				//Object []=>저장->model에 추가->JTable에 결과를 확인
				Object data[]= {name,age,tel};
				model.addRow(data);
				System.out.println(name+","+age+","+tel);
			}
		}catch(Exception e) {
			System.out.println("select()메서드 실행오류=>"+e);
		}
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
			model.addRow(data);//모델에 저장한 데이터=>테이블에 저장(insert)
			//String sql="insert into person values('테스트2','34','02-123-0987')";
			try {
			String sql="insert into person values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			//형식)pstmt.set자료형(?순서번호,저장할값)->setString,setInt~
			pstmt.setString(1, tf1.getText());//~(1,'테스트2')
			pstmt.setString(2, tf2.getText());
			pstmt.setString(3, tf3.getText());
			int insert=pstmt.executeUpdate();//1->sql성공, 0->sql 실패
			System.out.println("데이터 성공유무(insert)=>"+insert);
			//select
			rs=pstmt.executeQuery("select * from person");
			while(rs.next()) {
				String name=rs.getString("name");
				String age=rs.getString("age");
				String tel=rs.getString("tel");
				System.out.println(name+","+age+","+tel);
			  }
			}catch(Exception e2) {
				System.out.println("person테이블에 데이터입력실패=>"+e2);
			}
			//---------------------------------------------------------
			//재입력
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf1.requestFocus();
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new DB_Person();
	}
}





