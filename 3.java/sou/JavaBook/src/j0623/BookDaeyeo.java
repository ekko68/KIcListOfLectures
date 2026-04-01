package j0623;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

//DB연동-------------------
import java.sql.*;
import java.util.Calendar;
import java.awt.event.*;
//----------------------------

public class BookDaeyeo extends JPanel implements ActionListener {
	
	//부착시킬 컴포넌트 리스트
	//              고객번호   이름      전화             주소      도서번호 도서명   대여일
	JTextField txtCbun,txtCirum,txtCjunhwa,txtCjuso,txtBbun,txtBjemok,txtBdaeil;
	JTextArea taCmemo;//고객이 빌려간 도서의 설명
	//              고객번호  이름         전화          도서번호  제목    대여유무 새로작성 종료
	JButton btnCbun,btnCirum,btnCjunhwa,btnBbun,btnBjemok,btnDaeyeo,btnNew,btnClose;
	//고객정보 찾았는지 체크 bv(대여해줄 책을 찾았는지)
	boolean bg=false, bv=false;  //대여확인 버튼 활성화 여부
	//(2)DB연동
	private Connection conn;//연결객체
	private Statement stmt;//sql구문을 사용하기위해 필요한 객체
	private ResultSet rs1,rs2;//rs1(고객찾기), rs2(도서찾기)
	String sql=null;//sql구문 저장
	//------------------------------------------------------------
	
	public BookDaeyeo(){
		design();
		//
		addListener();
		accDb();
		//display()->처음부터 보여주는 것이 아니기때문에 (필요로할때만 검색)
	}
	
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//고객정보 패널========================
		JPanel customerPn=new JPanel(new GridLayout(3,2));
		customerPn.setBorder(new TitledBorder(new TitledBorder("고객 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel cPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));

		txtCbun=new JTextField("",5);
		txtCirum=new JTextField("",10);
		txtCjunhwa=new JTextField("",10);
		txtCjuso=new JTextField("",20);
		txtCjuso.setEditable(false);
		
		taCmemo=new JTextArea(2,20);
		JScrollPane scroll=new JScrollPane(taCmemo,	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		taCmemo.setEditable(false);
		taCmemo.setBackground(Color.lightGray);
		
		btnCbun=new JButton("확인1");
		btnCbun.setMargin(new Insets(0, 3, 0, 3));
		btnCirum=new JButton("확인2");
		btnCirum.setMargin(new Insets(0, 3, 0, 3));
		btnCjunhwa=new JButton("확인3");
		btnCjunhwa.setMargin(new Insets(0, 3, 0, 3));

		cPn1.add(new JLabel("번호:"));
		cPn1.add(txtCbun);
		cPn1.add(btnCbun);
		
		cPn2.add(new JLabel("이름:"));
		cPn2.add(txtCirum);	
		cPn2.add(btnCirum);
		
		cPn3.add(new JLabel("전화:"));
		cPn3.add(txtCjunhwa);
		cPn3.add(btnCjunhwa);
		
		cPn4.add(new JLabel("주소:"));
		cPn4.add(txtCjuso);
		
		customerPn.add(cPn1); customerPn.add(cPn2); customerPn.add(cPn3);
		customerPn.add(cPn4); 
		customerPn.add(new JLabel("고객이 대여한 도서  ☞   ",JLabel.RIGHT));
		customerPn.add(scroll); 
		scroll.setBorder(BorderFactory.createEmptyBorder(1, 1, 5, 5));
		this.add(customerPn);
				
		//도서정보 패널========================
		JPanel bookPn=new JPanel(new GridLayout(3,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",20);
		txtBdaeil=new JTextField("",10);
		btnBbun=new JButton("확인1");
		btnBbun.setMargin(new Insets(0, 3, 0, 3));
		btnBjemok=new JButton("확인2");
		btnBjemok.setMargin(new Insets(0, 3, 0, 3));

		bPn1.add(new JLabel("번호:"));
		bPn1.add(txtBbun);
		bPn1.add(btnBbun);
		
		bPn2.add(new JLabel("제목:"));
		bPn2.add(txtBjemok);
		bPn2.add(btnBjemok);
		
		bPn3.add(new JLabel("대여일:"));
		bPn3.add(txtBdaeil);	
		
		JPanel bottomPn=new JPanel();
		bottomPn.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		btnDaeyeo=new JButton("대여 확인");
		btnNew=new JButton("새로 입력");
		btnClose=new JButton(" 닫 기 ");
		
		bottomPn.add(btnDaeyeo);
		bottomPn.add(btnNew);
		JLabel lbl=new JLabel("    ");  //버튼 사이에 공백 부여
		bottomPn.add(lbl);
		bottomPn.add(btnClose);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);	
		
		this.add(customerPn);
		this.add(bookPn);
		this.add(bottomPn);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		btnDaeyeo.setEnabled(false); //대여 버튼 비활성화
		btnNew.setEnabled(false);
	}
     //이벤트 연결
	private void addListener() {
		btnCbun.addActionListener(this);//고객번호
		btnCirum.addActionListener(this);//고객제목
		btnCjunhwa.addActionListener(this);//고객전화
		btnBbun.addActionListener(this);//도서번호
		btnBjemok.addActionListener(this);//도서제목
		btnDaeyeo.addActionListener(this);//대여유무
		btnNew.addActionListener(this);//새로 작성->다른 사람 대여
		btnClose.addActionListener(this);//종료
	}
	
	private void accDb() {//접속
    	try {
			 //1.접속할 드라이버를 메모리에 올리기
     	  Class.forName("oracle.jdbc.driver.OracleDriver");
     	  String url="jdbc:oracle:thin:@localhost:1521:orcl";//url주소값
     	  //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
     	  conn=DriverManager.getConnection(url, "test1", "t1234");
     	  //추가 (신규,수정->레코드이동->자동으로 스크롤 이동시 수정이 반영)
     	  stmt=conn.createStatement();
     	  System.out.println("접속conn=>"+conn);
		}catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트정보를 가져오는 객체
		// TODO Auto-generated method stub
		if(e.getSource()==btnCbun) {//고객번호 버튼을 눌렀다면
			if(txtCbun.getText().equals("")) {
				txtCbun.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "고객번호를 입력하세요");
				return;
			}
			sql="select * from customer where c_bun="+txtCbun.getText();
			processCustomer();
		}else if(e.getSource()==btnCirum) {//이름버튼
			if(txtCirum.getText().equals("")) {
				txtCirum.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "고객이름를 입력하세요");
				return;
			}
			sql="select * from customer where c_irum='"+txtCirum.getText()+"'";
			processCustomer();
		}else if(e.getSource()==btnCjunhwa) {//전번버튼
			if(txtCjunhwa.getText().equals("")) {
				txtCjunhwa.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "고객전번를 입력하세요");
				return;
			}
			sql="select * from customer where c_junhwa='"+txtCjunhwa.getText()+"'";
			processCustomer();
		}else if(e.getSource()==btnBbun) {//도서번호 버튼
			if(txtBbun.getText().equals("")) {
				txtBbun.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "도서번호를 입력하세요");
				return;
			}
			sql="select * from book where b_bun="+txtBbun.getText();
			processBook();
		}else if(e.getSource()==btnBjemok) {//도서제목 버튼
			if(txtBjemok.getText().equals("")) {
				txtBjemok.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "도서제목을 입력하세요");
				return;
			}
			sql="select * from book where b_jemok='"+txtBjemok.getText()+"'";
			processBook();
		}else if(e.getSource()==btnDaeyeo) {//대여 버튼
			//1.대여 도서 제목을 메모에 표시(고객정보)->아직 DB에는 저장되지 않은 상태
			if(taCmemo.getText().equals("")) {//처음 빌린경우
				taCmemo.setText(txtBjemok.getText());//메모란에 도서제목을 출력
			}else {//한권이상 빌린경우(도서제목,도서제목2,도서제목3,
			    taCmemo.setText(taCmemo.getText()+","+txtBjemok.getText());
			}
			
			//고객->수정
			try {
				//1.고객의 대여수를 증가,고객의 메모필드에도 수정
				sql="select c_daesu from customer where c_bun="+txtCbun.getText();
				rs1=stmt.executeQuery(sql);
				rs1.next();//찾은 레코드로 이동하라->if(rs1.next()==true)
				int daesu=rs1.getInt(1);//rs1.getInt("c_daesu")->권장
				System.out.println("대여수(daesu)="+daesu);
				//빌려가는 고객의 정보를 찾아서 대여수증가,메모란에 기록
				sql="update customer set c_daesu="+(daesu+1)+
						", c_memo='"+taCmemo.getText()+"'  where c_bun="+
						txtCbun.getText();
				System.out.println("고객대여sql=>"+sql);
				int update=stmt.executeUpdate(sql);//1->성공,0->실패
				System.out.println("고객정보수정 성공유무(update)=>"+update);
				bg=false;//다시 불활성화
				rs1.close();//finally에서 사용해야 된다.
			}catch(Exception e2) {
				System.out.println("고객 대여과정에서 오류발생=>"+e2);
				return;//이 문장이후의 문장수행하지 말고 종료(트랜잭션때문에)
			}
			//도서->대여해주는 책을 찾아서 대여수증가,대여유무->y,b_daebun=고객번호
			try {
				sql="select b_daesu from book where b_bun="+txtBbun.getText();
				rs2=stmt.executeQuery(sql);
				rs2.next();//찾으면 레코드 이동->화면에 보임
				int daesu=rs2.getInt(1);
				System.out.println("현재 도서의 대여수출력(daesu)="+daesu);
				
				sql="update book set b_daesu="+(daesu+1)+
						",b_daeyn='y', b_daebun="+txtCbun.getText()+ //대여자번호
						",b_daeil='"+txtBdaeil.getText()+
						"'  where b_bun="+txtBbun.getText();
				System.out.println("도서정보 sql=>"+sql);
				int update2=stmt.executeUpdate(sql);
				System.out.println("도서대여정보 수정 성공유무(update2)=>"+update2);
				bv=false;
				rs2.close();
			}catch(Exception e2) {
				System.out.println("도서대여 문제발생(e2)=>"+e2);
				return;
			}
			//대여확인 한 후
			btnDaeyeo.setEnabled(false);//불활성화
			btnNew.setEnabled(true);//새로 대여를 할수 있도록 초기화
		}else if(e.getSource()==btnNew) {//초기화버튼->고객,도서 찾기 초기화
			txtCbun.setText(null);
			txtCirum.setText(null);
			txtCjunhwa.setText(null);
			taCmemo.setText(null);
			txtBbun.setText(null);
			txtBjemok.setText(null);
			txtBdaeil.setText(null);
			bg=false;  bv=false;
			btnNew.setEnabled(false);//새로 버튼 비활성화
			
		}else if(e.getSource()==btnClose) {//종료 버튼
			try { //conn->stmt->rs1,rs2->메모리 해제순서는 생성순서의 역순
				if(rs1!=null) rs1.close();
				if(rs2!=null) rs2.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				System.out.println("에러유발->e2"+e2);
			}finally {
				BookMain.book_dae.setEnabled(true);//대여메뉴 활성화
				BookMain.childWinDae.dispose();//메모리해제하고 종료
			}
		}
	}
	//고객정보를 찾아서 출력시켜주는 메서드
	private void processCustomer() {//단순,반복->중복된 코딩이 많다.
		try {
		rs1=stmt.executeQuery(sql);
		if(rs1.next()) {//고객번호,이름,전번
			txtCbun.setText(rs1.getString("c_bun"));
			txtCirum.setText(rs1.getString("c_irum"));
			txtCjunhwa.setText(rs1.getString("c_junhwa"));
			txtCjuso.setText(rs1.getString("c_juso"));
			taCmemo.setText(rs1.getString("c_memo"));
			bg=true;//고객정보 찾은 표시
			btnDaeyeo.setEnabled(bg && bv);//true && false=>false
		  }else {
			  JOptionPane.showMessageDialog(this, "해당자료는 없습니다");
			    txtCbun.setText(null);
				txtCirum.setText(null);
				txtCjunhwa.setText(null);
				txtCjuso.setText(null);
				taCmemo.setText(null);
			 bg=false;//못찾은 경우
			 btnDaeyeo.setEnabled(false);
		  }
		}catch(Exception e) {
			System.out.println("고객정보 검색실패=>e"+e);
		}
	}
	//도서정보를 찾아서 출력시켜주는 메서드
	private void processBook() {
		try {
			rs2=stmt.executeQuery(sql);
			if(rs2.next()) {//도서번호,이름
				txtBbun.setText(rs2.getString("b_bun"));
				txtBjemok.setText(rs2.getString("b_jemok"));
				//대여가능 여부 판단->b_daeyn=y or n
				if(rs2.getString("b_daeyn").equals("y")) {//대여중인 북을 선택한 경우
					JOptionPane.showMessageDialog(this, "현재 대여중인 도서입니다");
					txtBbun.setText(null);//화면에 출력X
					txtBjemok.setText(null);
					txtBbun.requestFocus();//커서입력
					return;
				}
				//대여일 =>오늘 날짜 구하기
				Calendar cal=Calendar.getInstance();
				String imsi=cal.get(Calendar.YEAR)+"-"+
				                  (cal.get(Calendar.MONTH)+1)+"-"+
						           cal.get(Calendar.DATE);
				txtBdaeil.setText(imsi);
				
				bv=true;//도서정보 찾은 표시
				btnDaeyeo.setEnabled(bg && bv);//true && true=>true
			  }else {
				  JOptionPane.showMessageDialog(this, "해당자료는 없습니다");
				 txtBbun.setText(null);
				 txtBjemok.setText(null);
				 bv=false;//도서책 못찾은 경우
				 btnDaeyeo.setEnabled(false);
			  }
			}catch(Exception e) {
				System.out.println("고객정보 검색실패=>e"+e);
			}
	}
	
	public static void main(String[] args) {
		BookDaeyeo daeyeo=new BookDaeyeo();
		JFrame frame=new JFrame("대여 창");
		frame.getContentPane().add(daeyeo);
		//frame.setResizable(false);
		frame.setBounds(200,200,580,400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
