package j0623;

import java.awt.*;
//------------------------
import java.sql.*;//(1)DB연동
import java.awt.event.*;//이벤트 처리부분 
//--------------------------
import javax.swing.*;
import javax.swing.border.*;//테두리에 관련된 클래스 불러오기

//고객메뉴클릭->고객자식창(JInternalFrame+ 부착시킬 컴포넌트 구성(JPanel)
public class BookCustomer extends JPanel{
	
	//고객의 정보를 저장할 변수선언(고객번호,이름,전번,주소,대여수(빌린수)
	JTextField txtCbun,txtCirum,txtCjunhwa,txtCjuso,txtCdaesu;
	JTextArea taCmemo;//메모(대여한 책의 정보)
	//               신규      확인      수정       삭제    검색      옵션           종료
	JButton btnInsert,btnOk,btnUpdate,btnDel,btnFind,btnOption,btnClose;
	JButton btnF,btnP,btnN,btnL;// <<,<, >,>>
	JLabel lblRec;//전체 레코드수 중에서 현재 보고 있는 레코드의 정보
	
	int iTotal = 0;	// 자료의 갯수
	int iLast = 0; 	// 마지막 레코드 번호
	boolean isInsert = false;	// Insert 버튼 눌림 여부(토글버튼)
	boolean isUpdate = false;	// Update 버튼 눌림 여부
	
	//(2) 고객DB정보 저장
	private Connection conn;
	private Statement stmt;//SQL문
	private ResultSet rs;//select->표형태
	String sql=null;//sql구문
	//--------------------------------------------
	
	// 생성자
	public BookCustomer(){
		design();
		//추가
		addListener();//각 버튼의 이벤트처리
		accDb();//DB접속
		init();//고객테이블 불러오기(select)=>오름차순으로 정렬(order by)
		display();
	}
	
	//고객정보 대화상자의 화면 디자인을 해주는 메서드
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//고객정보 패널========================
		JPanel customerPn=new JPanel(new GridLayout(4,1));
		//테두리 설정
		customerPn.setBorder(new TitledBorder(new TitledBorder("고객 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel cPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtCbun=new JTextField("",5);
		txtCirum=new JTextField("",10);
		txtCjunhwa=new JTextField("",15);
		txtCjuso=new JTextField("",28);
		txtCdaesu=new JTextField("",5);
		taCmemo=new JTextArea(2,28);
		JScrollPane scroll=new JScrollPane(taCmemo);//메모란에 스크롤 기능
		taCmemo.setBackground(Color.lightGray);//전체 배경 색깔(회색)
		
		//신규,수정하기전까지는 편집모드는 비활성화된 상태
		txtCbun.setEditable(false);//~setEditable(true)->활성화(커서입력 가능)
		txtCirum.setEditable(false);
		txtCjunhwa.setEditable(false);
		txtCjuso.setEditable(false);
		txtCdaesu.setEditable(false);
		taCmemo.setEditable(false);
		
		btnInsert=new JButton("신규");
		btnOk=new JButton("확인");
		btnUpdate=new JButton("수정");
		btnDel=new JButton("삭제");
		btnFind=new JButton("검색");
		btnOption=new JButton("옵션");
		btnClose=new JButton("닫기");
		btnF=new JButton(" <<= ");
		btnP=new JButton("  <= ");
		btnN=new JButton(" =>  ");
		btnL=new JButton(" =>> ");
		lblRec=new JLabel(" 0 / 0 ",JLabel.CENTER);
		cPn1.add(new JLabel("번호 :"));
		cPn1.add(txtCbun);
		cPn1.add(new JLabel("       이름 :"));
		cPn1.add(txtCirum);
		
		cPn2.add(new JLabel("전화 :"));
		cPn2.add(txtCjunhwa);	
		cPn2.add(new JLabel("      대여횟수 :"));
		cPn2.add(txtCdaesu);
		
		cPn3.add(new JLabel("주소 :"));
		cPn3.add(txtCjuso);
		
		cPn4.add(new JLabel("메모 :"));
		cPn4.add(scroll);

		customerPn.add(cPn1);  customerPn.add(cPn2); 	customerPn.add(cPn3);	customerPn.add(cPn4);
		this.add(customerPn);
		
		btnOk.setEnabled(false);//확인버튼은 신규버튼을 누르기전까지는 비활성화
		
		//레코드 이동 패널========================
		JPanel movePn=new JPanel();
		movePn.setBorder(new TitledBorder(new TitledBorder("레코드 이동"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		movePn.add(btnF);
		movePn.add(btnP);
		movePn.add(lblRec);
		movePn.add(btnN);
		movePn.add(btnL);
		
		this.add(movePn);
		
        //명령 버튼 패널========================
		JPanel bottomPn1=new JPanel();
		bottomPn1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		bottomPn1.add(btnInsert);
		bottomPn1.add(btnOk);
		JLabel lbl1=new JLabel("    "); 
		bottomPn1.add(lbl1);
		bottomPn1.add(btnUpdate);
		bottomPn1.add(btnDel);
		
		JPanel bottomPn2=new JPanel();
		bottomPn2.add(btnFind);
		bottomPn2.add(btnOption);
		JLabel lbl2=new JLabel("                          "); 
		bottomPn2.add(lbl2);
		bottomPn2.add(btnClose);
		
		this.add(bottomPn1);
		this.add(bottomPn2);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	//추가(3)
	private void addListener() {}
	//DB 접속
	private void accDb() {
		try {
			 //1.접속할 드라이버를 메모리에 올리기
      	  Class.forName("oracle.jdbc.driver.OracleDriver");
      	  String url="jdbc:oracle:thin:@localhost:1521:orcl";//url주소값
      	  //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
      	  conn=DriverManager.getConnection(url, "test1", "t1234");
      	  //추가 (신규,수정->레코드이동->자동으로 스크롤 이동시 수정이 반영)
      	  stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
      			  ResultSet.CONCUR_UPDATABLE);
      	  /*
      	   * ResultSet.TYPE_SCROLL_SENSITIVE->양방향으로 스크롤이동시 업데이트반영
      	   * ResultSet.CONCUR_UPDATABLE->현재 커서의 위치에서 정보업데이트 가능
      	   */
      	  System.out.println("접속con=>"+conn);
		}catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
	}
	//고객테이블의 고객번호순으로  정렬(오름차순)
	private void init() {
		try {
			sql="select  *  from customer order by c_bun asc";
			rs=stmt.executeQuery(sql);
			//맨 마지막 레코드번호이동->현재행->마지막레코드수
			rs.last();
			iTotal=rs.getRow();//현재 행번호(맨 마지막 레코드번호)
			iLast=rs.getInt("c_bun");//마지막 고객번호->+1
			rs.first();//첫번째 레코드로 이동
		}catch(Exception e) {
			System.out.println("고객테이블 불러오기 실패->"+e);
		}
	}
	private void display() {
		try {
			txtCbun.setText(rs.getString("c_bun"));//고객번호
			txtCirum.setText(rs.getString("c_irum"));//고객이름
			txtCjunhwa.setText(rs.getString("c_junhwa"));//고객전번
			txtCdaesu.setText(rs.getString("c_daesu"));//대여수
			txtCjuso.setText(rs.getString("c_juso"));//주소
			taCmemo.setText(rs.getString("c_memo"));//메모
			
			lblRec.setText(rs.getRow()+"/"+iTotal);//현레코드수/전체레코드수
		}catch(Exception e) {
			System.out.println("display()실행오류=>"+e);
		}
	}
	
	public static void main(String[] args) {
		BookCustomer bookCustomer=new BookCustomer();
		JFrame frame=new JFrame("고객 창");
		frame.getContentPane().add(bookCustomer);//JFrame+JPanel(화면디자인)
		frame.setBounds(200,200,430,450);//x,y,w,h
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}