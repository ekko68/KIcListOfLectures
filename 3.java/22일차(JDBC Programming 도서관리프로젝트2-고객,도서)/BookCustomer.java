package j0623;

import java.awt.*;
//------------------------
import java.sql.*;//(1)DB연동
import java.awt.event.*;//이벤트 처리부분 
//--------------------------
import javax.swing.*;
import javax.swing.border.*;//테두리에 관련된 클래스 불러오기

//고객메뉴클릭->고객자식창(JInternalFrame+ 부착시킬 컴포넌트 구성(JPanel)
public class BookCustomer extends JPanel implements ActionListener{
	
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
	
	// 생성자->객체를 생성->자동으로 호출되는 메서드=>멤버변수의 값 초기화
	public BookCustomer(){
		design();
		//추가
		addListener();//각 버튼의 이벤트처리
		accDb();//DB접속
		init();//고객테이블 불러오기(select)=>오름차순으로 정렬(order by)
		        //select * from customer order by c_bun asc (1~10)
		display();//화면에 보여달라
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
	//추가(3) 각버튼을 눌렀을때 이벤트처리
	private void addListener() {
		btnInsert.addActionListener(this);//신규버튼
		btnOk.addActionListener(this);
		//확인버튼->비활성화->(신규버튼누르면)활성화된다.
		btnUpdate.addActionListener(this);//수정
		btnDel.addActionListener(this);//삭제
		btnFind.addActionListener(this);//검색
		btnOption.addActionListener(this);//옵션은 그냥뭐
		btnClose.addActionListener(this);//종료
		btnF.addActionListener(this);//맨 처음레코드로 이동 <<
		btnP.addActionListener(this);//이전  <
		btnN.addActionListener(this);//다음 >
		btnL.addActionListener(this);//마지막 레코드 >>
	}
	//DB 접속
	private void accDb() { //자바->입출력,DB접속,네트워크(Check Exception)
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
			rs=stmt.executeQuery(sql);//stmt.executeUpdate();
			//맨 마지막 레코드번호이동->현재행->마지막레코드수
			rs.last();
			iTotal=rs.getRow();//현재 행번호(맨 마지막 레코드번호)
			iLast=rs.getInt("c_bun");//마지막 고객번호->+1
			rs.first();//첫번째 레코드로 이동
		}catch(Exception e) {
			System.out.println("고객테이블 불러오기 실패->"+e);
		}
	}
	//현재 DB에 접속한 행을 보여주는 메서드(단순하고 반복적인 구문)
	private void display() {
		try {
			//형식) 필드값 불러오기->rs.getString("필드명"),rs.getInt("필드명")
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//레코드 이동
		try {
			if(e.getSource()==btnF) { //<<
				rs.first();//맨 처음 레코드로 이동
				display();//첫번째 행에 대한 데이터를 다시 보여달라
			}else if(e.getSource()==btnP) { //<
				if(rs.isFirst()) return;//첫번째행->이전행으로 이동X
				rs.previous();
				display();
			}else if(e.getSource()==btnN) { // > 다음레코드
				if(rs.isLast()) return; //마지막 레코드라면 이동불가
				rs.next();
				display();
			}else if(e.getSource()==btnL) {// >> 마지막 레코드
				rs.last();
				display();
			}
		}catch(Exception e2) {
			System.out.println("레코드 이동 오류=>"+e2);
		}
		//신규->맨처음 레코드입력->저장
		if(e.getSource()==btnInsert) {//신규버튼을 눌렀다면
			if(isInsert==false) {//Insert(신규)버튼을 누르지 않은상태에서 처음 누른경우
				txtCirum.setEditable(true);//편집할 수있는  ->setEnabled(활성화)
				txtCjunhwa.setEditable(true);//전번
				txtCjuso.setEditable(true);//주소
				//"34"->Integer.parseInt("34")->34(String.valueOf(34)->"34"
				txtCbun.setText(String.valueOf(iLast+1));//iLast->총레코드수(맨마지막 레코드번호)+1
			    txtCirum.setText(null);//아직 입력하지 않은 상태
			    txtCjunhwa.setText(null);
			    txtCjuso.setText(null);
			    txtCdaesu.setText(null);//0
			    taCmemo.setText(null);
			    //버튼의 상태를 변경
			    btnInsert.setText("취소");//버튼의 이름
			    btnOk.setEnabled(true);//확인버튼을 활성화->누를수 있게된다.
			    isInsert=true;//한번 클릭했다고 체크
			}else { //isInsert=true인 상태(이미 한번 누른경우)->취소->신규
				txtCirum.setEditable(false);//편집할 수없는  ->setEnabled(활성화)
				txtCjunhwa.setEditable(false);//전번
				txtCjuso.setEditable(false);
				btnInsert.setText("신규");//버튼의 이름
			    btnOk.setEnabled(false);//확인버튼을 비활성화->누를수 없게
			    isInsert=false;
			    display();//다시 한번 불러오기
			}
		}else if(e.getSource()==btnOk) {//확인->실질적으로 데이터 입력된다.
			insertCustomer();//데이터 입력시켜주는 메서드
			//데이터 입력후 입력전의 상태로 다시 전환
			txtCirum.setEditable(false);//편집할 수없는  ->setEnabled(활성화)
			txtCjunhwa.setEditable(false);//전번
			txtCjuso.setEditable(false);
			btnInsert.setText("신규");//버튼의 이름
		    btnOk.setEnabled(false);
		}else if(e.getSource()==btnUpdate) {//수정버튼<-->완료
		   if(isUpdate==false) {//수정버튼을 처음 누른경우
			   txtCirum.setEditable(true);//편집상태로 변환
			   txtCjunhwa.setEditable(true);//전번 변경
			   txtCjuso.setEditable(true);//주소
			   //이동버튼 불가->btnF.setEnabled(false);~
			   btnUpdate.setText("완료");
			   isUpdate=true;
		   }else {//수정버튼을 두번째 누른경우(완료)->수정 마무리->수정
			   updateCustomer();
			   //다음번 레코드를 또 수정하기위해서 다시 수정모드 비활성화
			   txtCirum.setEditable(false);//편집불가능
			   txtCjunhwa.setEditable(false);//전번 변경
			   txtCjuso.setEditable(false);//주소
			   //이동버튼 가능->btnF.setEnabled(true);~
			   btnUpdate.setText("수정");
			   isUpdate=false;
		   }
		}else if(e.getSource()==btnDel) {//삭제버튼
			//사용자에게 진짜 삭제유무?=>confirm->showConfirmDialog()
			//1.부모창(this) 2.메세지내용3.창의 제목 4.옵션(yes|no)
			int re=JOptionPane.showConfirmDialog
			            (this,"현재 고객자료를 정말로 삭제할까요?","삭제",
					                           JOptionPane.YES_NO_OPTION);
			if(re==JOptionPane.YES_OPTION) //예라고 눌렀다면
				  deleteCustomer();
		}else if(e.getSource()==btnFind) {//검색버튼
			      findCustomer();
		}else if(e.getSource()==btnOption) {//옵션버튼
			//나중에 필요하면 추가
		}else if(e.getSource()==btnClose) {//종료버튼
			//닫기->DB연동부분 다 초기화작업후(메모리 삭제후 종료)
			try { //DB연결순서와 정반대로 메모리를 해제한다.
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				System.out.println("메모리 해제가 실패=>"+e2);
			}finally {//예외 발생유무와 상관없이 항상 처리되어야할 문장기술
				//BookMain의 메뉴(book_customer)=>활성화(setEnabled(true|false))
			    BookMain.book_customer.setEnabled(true);
			    BookMain.childWinCustomer.dispose();//자식창종료(메모리해제)
			}//finally
		}
	}
	//위에서 DB와 연결->insert,update,delete,select을 처리해주는 각 메서드 작성
	private void insertCustomer() {
		try {
			//형식)insert into 테이블명 values(값,'값2','2017-06-23',,,,);
			sql="insert into customer values("+
			      txtCbun.getText()+",'"+
				  txtCirum.getText()+"','"+
			      txtCjunhwa.getText()+"','"+
				  txtCjuso.getText()+"',0,'')";
			System.out.println("sql=>"+sql);
			int insert=stmt.executeUpdate(sql);//정수형값을 반환->1(성공),0(실패)
			System.out.println("데이터성공유무(insert)=>"+insert);   
			init();//DB데이터를 다시 오름차순으로 읽어들여라
			rs.last();//추가후 전체 레코드수를 갱신(수정)하기위해서 이동
			display();
		}catch(Exception e) {
			System.out.println("insertCustomer()메서드 호출시 문제발생=>"+e);
		}
	}
	//수정->insert와 거의 소스코드가 비슷(저장이 된다는 사실은 같다)
	private void updateCustomer() {
		try {
			//형식)update 수정할 테이블명 set 수정할 필드명='수정할값'
			//       ,수정필드2=값2 where 조건식(수정할 데이터 찾는 조건)
			sql="update customer set c_irum='"+
				  txtCirum.getText()+  //이름
				  "',c_junhwa='"+txtCjunhwa.getText()+  //전번
				  "',c_juso='"+txtCjuso.getText()+
				  "' where c_bun="+txtCbun.getText();
			System.out.println("수정한 sql=>"+sql);
			//추가=>현재 행을 구해->이동
			int currentRow=rs.getRow();//현재행을 구한다.
			int update=stmt.executeUpdate(sql);//정수형값을 반환->1(성공),0(실패)
			System.out.println("데이터수정 성공유무(update)=>"+update); 
			//추가
			init();//정렬->레코드 이동에 문제가 발생이 된다.
			//수정을 반영하기위해서 수정한 행으로 이동
			//rs.absolute()메서드는 정해진 행으로 바로 이동시킬때 사용한다.
			rs.absolute(currentRow);// rs.absolute(이동할행번호)->행번호로 이동
			display();
		}catch(Exception e) {
			System.out.println("updateCustomer()메서드 호출시 문제발생=>"+e);
		}
	}
	//삭제->주의)이미 대여중인 고객은 반납을 다한 뒤에 삭제할 수있도록 처리
	private void deleteCustomer() {
		try {
			//1)삭제시킬 레코드가 없는 경우->삭제할 수없다는 에러메세지 출력
			if(rs.getRow()==0) {//현재 삭제할 행이 없는 경우(행번호가 없는 경우)
				JOptionPane.showMessageDialog(this,"삭제시킬 자료가 없습니다.");
				return;
			}
			//2)현재 대여중인 고객은 삭제X->taCmemo항목에 빌린 책의 정보가 기록
			if(taCmemo.getText().equals("") || taCmemo.getText()==null) {
				//1~12->현재행을 구해서 현재행-1->행으로 이동
				int currentRow=rs.getRow();//삭제시킬 행번호
				sql="delete from customer where c_bun="+txtCbun.getText();
				int delete=stmt.executeUpdate(sql);
				System.out.println("데이터삭제성공유무(delete)->"+delete);
				init();//고객테이블을 다시 정렬
				if(currentRow==1) {
					;//현재 상태 그대로 유지 (레코드 한개만 존재->이동X)
				}else {//한개이상인 경우
					rs.absolute(currentRow-1);//현재행-1 빠진 이전행으로 이동
				}
				display();//삭제시킨후 바로 반영(화면상에서의 이동)
			}else {// 이미 대여중인 고객을 의미
				JOptionPane.showMessageDialog(this,"도서반납 후에 삭제가능합니다");
			}
		}catch(Exception e) {
			System.out.println("deleteCustomer()메서드=>"+e);
		}
	}
	//검색
	private void findCustomer() {
		//사용자로부터 값을 입력->JOptionPane.showInputDialog
		//간단한 경고->JOptionPane.showMessageDialog
		//yes|no?->JOptionPane.showConfirmDialog(1.부모창,2.메세지내용)
		String re=JOptionPane.showInputDialog(this,"검색할 고객번호를 입력?");
		if(re==null) return;//입력하지 않으면 취소
		try {
			rs.beforeFirst();//rs.Frist()보다 위에 커서를 이동->full Scan
			int couFind=0;//동명이인->찾은 횟수
			while(rs.next()) {//검색할 데이터가 있는동안
				String str=rs.getString(1);//고객번호->내부적으로 하나씩 고객번호
				if(re.equals(str)) {//내가 찾고자하는 고객번호=테이블의 고객번호가 맞다면
				   txtCbun.setText(str);//찾고자하는 고객번호를 입력
				   txtCirum.setText(rs.getString("c_irum"));
				   txtCjunhwa.setText(rs.getString("c_junhwa"));
				   txtCjuso.setText(rs.getString("c_juso"));
				   txtCdaesu.setText(rs.getString("c_daesu"));//대여수
				   taCmemo.setText(rs.getString("c_memo"));//메모내용
				   couFind++;//찾은 횟수
				   lblRec.setText(rs.getRow()+"/"+iTotal);//찾은행(5)/전체레코드수(11)
				   break;//찾은 레코드를 발견했다면 더이상 while구문을 실행X
				}
			}//while
			if(couFind==0) {//찾은 레코드가 없다면
				JOptionPane.showMessageDialog(this, "검색자료를 찾을 수 없습니다");
			}
		}catch(Exception e) {
			System.out.println("findCustomer()메서드 오류=>"+e);
		}
	}
	public static void main(String[] args) {
		BookCustomer bookCustomer=new BookCustomer();//JPanel
		JFrame frame=new JFrame("고객 창");
		frame.getContentPane().add(bookCustomer);//JFrame+JPanel(화면디자인)
		frame.setBounds(200,200,430,450);//x,y,w,h
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}