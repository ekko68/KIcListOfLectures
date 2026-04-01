package j0623;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

//DB연동
import java.sql.*;
import java.util.Calendar;
import java.awt.event.*;
//---------------------------

public class BookBannap extends JPanel  implements ActionListener {

	//       도서번호 도서제목    도서대여일  도서대여자번호=고객번호,반납목적
	JTextField txtBbun,txtBjemok,txtBdaeil,txtBdaebun,  txtJemok;
	static JTextField txtBbanil;//도서 반납일
	//           도서번호    변경         반납확인   새로입력   종료
	JButton btnBbun,btnChange,btnBannap,btnNew,btnClose;
	DefaultTableModel mod;//JTable과 연결(화면)=>데이터저장 영역
	
	static JFrame calFrame; //달력과 관련된 창
	//DB
	private Connection conn;
	private Statement stmt;
	private ResultSet rs1,rs2;//select
	String sql=null;//sql구문저장
	//---------------------------------
	public BookBannap(){
		design();
        //추가
		addListener();
		accDb();//->daeDisplay()
		//daeDisplay();
	}
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//도서정보 패널========================
		JPanel bookPn=new JPanel(new GridLayout(3,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",20);
		txtBdaeil=new JTextField("",10);
		txtBbanil=new JTextField("",10);
		txtBdaebun=new JTextField("",5);
		//------------------------------------
		txtJemok=new JTextField("",25);  //반납되는 도서 제목을 고객메모에서 제거하기 위함
		//----------------------------------------------------------------------------
		btnBbun=new JButton("확인");
		btnBbun.setMargin(new Insets(0, 3, 0, 3));
		btnChange=new JButton("변경");
		btnChange.setMargin(new Insets(0, 3, 0, 3));

		bPn1.add(new JLabel("번호:"));
		bPn1.add(txtBbun);
		bPn1.add(btnBbun);
		
		bPn2.add(new JLabel("제목:"));
		bPn2.add(txtBjemok);
		txtBjemok.setEditable(false);
		
		bPn3.add(new JLabel("대여일:"));
		bPn3.add(txtBdaeil);	
		txtBdaeil.setEditable(false);
		bPn3.add(new JLabel("      반납일:"));
		bPn3.add(txtBbanil);
		bPn3.add(btnChange);	
		
		bPn4.add(new JLabel("대여자 번호:"));
		bPn4.add(txtBdaebun);
		bPn4.add(txtJemok);   //고객메모란의 대여도서 제목중 반납되는 도서 제목만 제거하기 위해 사용  
		//txtJemok.setVisible(false); //숨긴다.
		txtJemok.setVisible(true);
		txtBdaebun.setEditable(false);
		
		JPanel bottomPn=new JPanel();
		bottomPn.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		btnBannap=new JButton("반납 확인");
		btnNew=new JButton("새로 입력");
		btnClose=new JButton(" 닫 기 ");
		
		bottomPn.add(btnBannap);
		bottomPn.add(btnNew);
		JLabel lbl=new JLabel("    "); 
		bottomPn.add(lbl);
		bottomPn.add(btnClose);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);	
		
		this.add(bookPn);
		this.add(bPn4);
		this.add(bottomPn);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//도서 목록 테이블 삽입
		String[][]data=new String[0][4];//행X 열만
		String []cols={"번호","제목","대번","이름","대여일"}; //대여자 목록
		//DefaultTableModel이 가지고 있는 메서드
		mod=new DefaultTableModel(data,cols){ //테이블 내용 수정 불가
			//행과열을 통해서 데이터부분을 변경시켜줄 수있는 메서드
			    public boolean isCellEditable(int rowIndex, int mColIndex) {
				   return false; //내용 수정불가
				}
			   };
		JTable tab=new JTable(mod);//위에 수정된 데이터모델부분과 JTable결합
		//JTable에서의 필드와 필드사이의 간격을 조절
		//getColumn(인덱스번호)->인덱스번호에 해당하는 필드
		//setPreferredWidth(20)->필드의 길이를 구해주는 메서드(폭을 지정)
		tab.getColumnModel().getColumn(0).setPreferredWidth(20);
		tab.getColumnModel().getColumn(1).setPreferredWidth(150);
		tab.getColumnModel().getColumn(2).setPreferredWidth(20);
		tab.getColumnModel().getColumn(3).setPreferredWidth(30);
		tab.setSelectionBackground(Color.green);
		JScrollPane pa=new JScrollPane(tab);
		this.add(pa);
		
		btnBannap.setEnabled(false);  //반납 버튼 비활성화
		btnNew.setEnabled(false);     
	}
	
	//추가
	private void addListener() {
		btnBbun.addActionListener(this);//반납할 도서번호
		btnChange.addActionListener(this);//변경
		btnBannap.addActionListener(this);//반납버튼
		btnNew.addActionListener(this);//새로 작성
		btnClose.addActionListener(this);//종료
	}
	
	private void accDb() {
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
		//일반메서드->다른 일반메서드 호출
		daeDisplay();
	}
	//대여한 책과 고객의 정보를 출력시켜주는 메서드 작성
	private void daeDisplay() {
		try {
			mod.setNumRows(0);//처음에 행의수를 0개로 설정->전데이터삭제 후 
			                                //새로 불러오기 위해
			//도서번호,도서제목(book),대여자번호 대여자이름~
			//도서 대여일이 가장 최근일 기준으로 정렬하되, 도서번호는 오름차순으로 정렬하라
			sql="select b_bun,b_jemok,c_bun,c_irum,b_daeil "+
			       " from book inner join customer "+
				   " on b_daebun=c_bun order by b_daeil desc,b_bun asc";
			rs1=stmt.executeQuery(sql);
			int count=0;//전체 건수
			//번호","제목","대번","이름","대여일
		    while(rs1.next()) {
		    	String [] imsi= {
		    			rs1.getString("b_bun"),
		    			rs1.getString("b_jemok"),
		    			rs1.getString("c_bun"),
		    			rs1.getString("c_irum"),
		    			rs1.getString("b_daeil").substring(0,10)
		    	};
		    	mod.addRow(imsi);//모델에 데이터 추가
		    	count++;//전체 건수 증가
		    }
		    //다른행 총 전체건수를 출력
		    String [] imsi2= {null,"전체건수:"+count};
		    mod.addRow(imsi2);
		    rs1.close();
		}catch(Exception e) {
			System.out.println("daeDisplay() 에러유발=>"+e);
		}
	}
	//콜백메서드->운영체제가 처리
	//->ActionEvent->ActionListener->actionPerformed 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBbun) {//반납할 도서번호 버튼을 눌렀다면
			if(txtBbun.getText().equals("")) {
				txtBbun.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "반납할 도서번호를 입력하세요");
				return;
			}
			try {
			sql="select * from book where b_bun="+txtBbun.getText();
			rs1=stmt.executeQuery(sql);
			if(!rs1.next()) {//1.찾은 도서가 없다면
				JOptionPane.showMessageDialog
				             (this,"등록된 도서가 아닙니다.\n확인바람");
				txtBbun.setText(null);
				rs1.close();//연결끊고
				return;//빠져나감
			}
			//2.등록된 도서가 맞는 경우
			txtBjemok.setText(rs1.getString("b_jemok"));
			//정식대여절차 통과여부 체크
			if(rs1.getString("b_daeyn").equals("n")) {//대여중이지 않은 도서선택시
				JOptionPane.showMessageDialog
	             (this,"정식으로 대여된 도서가 아닙니다.\n확인바람");
	              txtBbun.setText(null);
	              txtBjemok.setText(null);
	               rs1.close();//연결끊고
	              return;
			}
			//반납절차 
			txtBdaeil.setText(rs1.getString("b_daeil").substring(0,10));
			txtBdaebun.setText(rs1.getString("b_daebun"));//대여자번호
			//반납일 설정
			Calendar cal=Calendar.getInstance();
			String imsi=cal.get(Calendar.YEAR)+"-"+
			                  (cal.get(Calendar.MONTH)+1)+"-"+
					           cal.get(Calendar.DATE);
			txtBbanil.setText(imsi);
			//---반납되는 도서제목을 고객의 메모에서 삭제시키는 작업
			sql="select * from customer where c_bun="+txtBdaebun.getText();
			rs2=stmt.executeQuery(sql);
			rs2.next();//찾았다면 레코드 이동
			//고객에서 c_memo필드값을 불러와서 txtJemo출력
			//ex) 도서명1  or  도서명1,도서명2 or 도서명1,도서명2,도서명3
			txtJemok.setText(rs2.getString("c_memo"));
			String ban_jemok=txtJemok.getText();//DB상의 저장된 c_memo
			//DB상의 c_memo글자값과 반납하고자하는 도서제목과 일치하는위치
			int start=ban_jemok.indexOf(txtBjemok.getText());//처음위치
			int end=txtBjemok.getText().length();//반납할 책의 마지막위치
			System.out.println("start="+start+",end=>"+end);
			txtJemok.setSelectionStart(start);//블럭의 시작위치지정
			txtJemok.setSelectionEnd(start+end+1);//,까지포함하기위해서
			txtJemok.requestFocus();
			txtJemok.replaceSelection("");//블럭지정한 부분을 수정하라
			//마지막 ,(콤마)를 떼내기
			try {
				String str=txtJemok.getText();//반납 도서 제목(,가 포함된 전체문자열)
				int a=str.length()-1;//콤마앞
				System.out.println("a=>"+a);//11
				String str1=str.substring(a);//a위치부터 끝까지
				System.out.println("str1=>"+str1);//,
				if(str1.equals(","))
					str=str.substring(0,a);//0포함 a-1=10(콤마바로 앞의 문자열까지)
				System.out.println("str="+str);
				txtJemok.setText(str);//,빠진 앞의 도서제목
			}catch(Exception e2) {}
			btnBannap.setEnabled(true);//반납버튼 활성화
			
			}catch(Exception e2) {
				System.out.println("반납할 도서 조회 실패=>"+e2);
			}
		}else if(e.getSource()==btnChange) {//반납일을 연장
			BookCal bookCal=new BookCal();//달력컴포넌트
			calFrame =new JFrame("반납일 변경");//창
			calFrame.getContentPane().add(bookCal);
			calFrame.setResizable(false);//창조절 금지
			calFrame.setBounds(300,300,250,200);
			calFrame.setVisible(true);
			
		}else if(e.getSource()==btnBannap) {//반납 버튼
			try {
				//고객테이블 수정(customer)
			  sql="update customer set c_memo='"+txtJemok.getText()+
					  "'  where c_bun="+txtBdaebun.getText(); //대여자번호
			  System.out.println("customer수정 sql="+sql);
			  int update=stmt.executeUpdate(sql);
			  System.out.println("customer수정 성공유무(update)=>"+update);
			  
				//도서테이블 수정(book)->b_daeyn=>n, b_daebun=0,b_daeil=null
	  sql="update book set b_daeyn='n' ,b_daebun=0, b_daeil=null,b_banil='"+
			  txtBbanil.getText()+"'  where b_bun="+txtBbun.getText();
	         System.out.println("book수정 sql="+sql);
	         int update2=stmt.executeUpdate(sql);
	         System.out.println("book수정 성공유무(update2)=>"+update2);
	         //반납초기화
	         btnBannap.setEnabled(false);//불활성화
	         btnNew.setEnabled(true);//새로 다시 반납하기위해서 필요->지우고
	         //daeDisplay()다시 읽어들여기
			 daeDisplay();//변경된 내용을 다시 읽어들인다.(실시간 수정반영)
			}catch(Exception e2) {
				System.out.println("도서 반납과정에서 오류발생=>"+e2);
			}
			
		}else if(e.getSource()==btnNew) {//초기화버튼->반납 초기화
			txtBbun.setText(null);
			txtBjemok.setText(null);
			txtBdaeil.setText(null);//대여
			txtBbanil.setText(null);//반납일
			txtBdaebun.setText(null);//대여자번호
			txtJemok.setText(null); //반납처리때문에 필요
			btnNew.setEnabled(false);//새로 버튼 비활성화
			txtBbun.requestFocus();//반납할 도서번호부터 먼저 입력하라고 커서입력
			
		}else if(e.getSource()==btnClose) {//종료 버튼
			try { //conn->stmt->rs1,rs2->메모리 해제순서는 생성순서의 역순
				if(rs1!=null) rs1.close();
				if(rs2!=null) rs2.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				System.out.println("에러유발->e2"+e2);
			}finally {
				BookMain.book_ban.setEnabled(true);//반납메뉴 활성화
				BookMain.childWinBan.dispose();//메모리해제하고 종료
			}
		}
	}
	
	public static void main(String[] args) {
		BookBannap bookBannap = new BookBannap();
		JFrame frame=new JFrame("반납 창");
		frame.getContentPane().add(bookBannap);
		frame.setResizable(false);
		frame.setBounds(200,200,500,400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}