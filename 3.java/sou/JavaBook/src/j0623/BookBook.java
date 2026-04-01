package j0623;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
//(1)
import java.sql.*;//Connection,Statement,PreparedStatement,ResultSet
import java.util.Calendar;
import java.awt.event.*;//이벤트처리
//----------------------------------------

public class BookBook extends JPanel implements ActionListener{  //화면디자인->Frame결합

	//도서번호,도서제목,장르,구입일,대여수,대여유무(y|n),대여자번호(=고객번호),대여일,반납일
	JTextField txtBbun,txtBjemok,txtBjang,txtBkuil,txtBdaesu,txtBdaeyn,txtBdaebun,txtBdaeil,txtBbanil;
	JTextArea taBmemo;//메모(누가 빌려갔는지 기록)
	//신규(등록),수정,삭제,검색,옵션,종료
	JButton btnInsert,btnUpdate,btnDel,btnFind,btnOption,btnClose;
	JButton btnF,btnP,btnN,btnL,btnin,btnsu;//<<,<,>,>>
	JLabel lblRec,lblPic;//현재 행의위치,이미지정보

	String sql, imgPath; //--- sql구문,그림 파일 경로 변수(c:\imagebook)
	int iTotal = 0;	// 자료의 갯수(도서책)
	int iLast = 0; 	// 마지막 레코드 번호
	JPanel picPn;//이미지가 결합된 패널
	File file;  //--- 이미지 로딩하기 위한 변수(파일의 이름,경로,,,)
	boolean isInsert = false;	// Insert 버튼 눌림 여부(신규 또는 취소)
	                                        // 버튼의 현재상태
	boolean isUpdate = false; // Update 버튼 눌림 여부(수정 또는 완료)
	//DB연동
	private Connection conn;//연결객체
	private Statement stmt;//SQL구문을 사용하기위해서 필요
	private ResultSet rs;//select구문을 사용->결과(표형태)->rs
	//----------------------------------------------------------------
	//화면디자인->DB연결->도서책을 도서번호로 오름차순으로 정렬
	public BookBook(){
		design();
		//추가
		addListener();//각 버튼의 이벤트연결
		accDb();//접속
		init();
		display();//보여주기
	}
	
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//도서정보 패널=(전체 Grid(각행은 FlowLayout)=======================
		JPanel bookPn=new JPanel(new GridLayout(6,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",30);
		txtBjang=new JTextField("",10);
		txtBkuil=new JTextField("",10);
		txtBdaesu=new JTextField("",5);
		txtBdaeyn=new JTextField("",5);
		txtBdaebun=new JTextField("",5);
		txtBdaeil=new JTextField("",10);
		txtBbanil=new JTextField("",10);
		taBmemo=new JTextArea(2,30);
		//메모에 스크롤바 기능
		JScrollPane scroll=new JScrollPane(taBmemo);
		taBmemo.setBackground(Color.lightGray);
		
		//편집상태X
		txtBbun.setEditable(false);//setEditable(true)->편집상태(커서입력)수정
		txtBjemok.setEditable(false);
		txtBjang.setEditable(false);
		txtBkuil.setEditable(false);
		txtBdaesu.setEditable(false);
		txtBdaeyn.setEditable(false);
		txtBdaebun.setEditable(false);
		txtBdaeil.setEditable(false);
		txtBbanil.setEditable(false);
		taBmemo.setEditable(false);
				
		btnInsert=new JButton("신규");
		btnUpdate=new JButton("수정");
		btnDel=new JButton("삭제");
		btnFind=new JButton("검색");
		btnOption=new JButton("옵션");
		btnClose=new JButton("닫기");
		btnF=new JButton(" <<= ");
		btnP=new JButton("  <= ");
		btnN=new JButton(" =>  ");
		btnL=new JButton(" =>> ");
		//현재행/총레코드수
		lblRec=new JLabel(" 0 / 0 ",JLabel.CENTER);
		bPn1.add(new JLabel("번호 :"));
		bPn1.add(txtBbun);
		bPn1.add(new JLabel("                              대여표시 :"));
		bPn1.add(txtBdaeyn);
		
		bPn2.add(new JLabel("제목 :"));
		bPn2.add(txtBjemok);	

		bPn3.add(new JLabel("장르 :"));
		bPn3.add(txtBjang);
		bPn3.add(new JLabel("                구입일 :"));
		bPn3.add(txtBkuil);
		
		bPn4.add(new JLabel("대여횟수 :"));
		bPn4.add(txtBdaesu);
		bPn4.add(new JLabel("                 대여자번호 :"));
		bPn4.add(txtBdaebun);
		
		bPn5.add(new JLabel("대여일 :"));
		bPn5.add(txtBdaeil);
		bPn5.add(new JLabel("            반납일 :"));
		bPn5.add(txtBbanil);

		bPn6.add(new JLabel("메모 :"));
		bPn6.add(scroll);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);
		bookPn.add(bPn4);  bookPn.add(bPn5); 	bookPn.add(bPn6);
		this.add(bookPn);
		
		//이미지 패널----------------------------------------------------
		picPn=new JPanel(new BorderLayout());
		lblPic = new JLabel();
		//lblPic.setPreferredSize(new Dimension(1000, 300));
		picPn.add(lblPic);

		this.add(picPn);

		//레코드 이동 패널------------------------------------------------
		JPanel movePn=new JPanel();
		movePn.setBorder(new TitledBorder(new TitledBorder("레코드 이동"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		movePn.add(btnF);
		movePn.add(btnP);
		movePn.add(lblRec);
		movePn.add(btnN);
		movePn.add(btnL);
		
		this.add(movePn);
		
        //명령 버튼 패널--------------------------------------------------
		JPanel bottomPn1=new JPanel();
		bottomPn1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		bottomPn1.add(btnInsert);
		bottomPn1.add(btnUpdate);
		bottomPn1.add(btnDel);
		bottomPn1.add(btnFind);
		bottomPn1.add(btnOption);
		bottomPn1.add(btnClose);
		
		this.add(bottomPn1);
		//테두리 설정
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//x,y,w,h
		
		btnsu=new JButton("그림 수정");

	}
	//추가
	private void addListener() {
		btnInsert.addActionListener(this);//신규버튼
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
	
    private void accDb() {//접속
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
     	  System.out.println("접속conn=>"+conn);
		}catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
    }
    
    private void init() { //정렬
    	try {
			sql="select  *  from book order by b_bun asc";
			rs=stmt.executeQuery(sql);//stmt.executeUpdate(); insert,update,delete
			//맨 마지막 레코드번호이동->현재행->마지막레코드수
			rs.last();
			iTotal=rs.getRow();//현재 행번호(맨 마지막 레코드번호)->9
			iLast=rs.getInt("b_bun");//마지막 도서번호->+1(9+1=10)
			//select max(b_bun) from book; 웹상에서는 이렇게 코딩
			rs.first();//첫번째 레코드로 이동
		}catch(Exception e) {
			System.out.println("도서 테이블 불러오기 실패->"+e);
		}
    }
    //DB에 있는 필드별로 데이터를 가져와서 화면에 출력
    private void display() {//화면에 보여주기->이미지를 보여주기
    	try {
    		txtBbun.setText(rs.getString("b_bun"));//도서번호
    		txtBjemok.setText(rs.getString("b_jemok"));//책제목
    		txtBjang.setText(rs.getString("b_jang"));//장르
    		//월-일-년도 시 분 초->날짜가 길면->10글자만 화면에 출력
    		//substring(인수1,인수2-1 까지 불러오기)
    		txtBkuil.setText(rs.getString("b_kuipil").substring(0,10));//0~9
    		txtBdaesu.setText(rs.getString("b_daesu"));//대여수(=빌려간 수)
    		//대여유무
    		if(rs.getString("b_daeyn").equals("y")) {
    			txtBdaeyn.setText("대여중");
    			txtBdaeyn.setForeground(Color.RED);//빨간색으로 표시
    		}else {//n
    			txtBdaeyn.setText("비치중");
    			txtBdaeyn.setForeground(Color.BLACK);//검정색으로 표시
    		}
    		//대여자 번호=고객번호
    		txtBdaebun.setText(rs.getString("b_daebun"));
    		//대여일자,반납일자->없으면 "",날짜->10글자만 화면에 출력
    		if(rs.getString("b_daeil")==null) {
    		    txtBdaeil.setText("");
    		}else {//대여날짜가 존재한다면 10글자만 표시
    		    txtBdaeil.setText(rs.getString("b_daeil").substring(0,10));
    		}
    		//반납일
    		if(rs.getString("b_banil")==null) {
    		    txtBbanil.setText("");
    		}else {//반납날짜가 존재한다면 10글자만 표시
    		    txtBbanil.setText(rs.getString("b_banil").substring(0,10));
    		}
    		//메모->이 책의 빌린사람번호 확인
    		taBmemo.setText(rs.getString("b_memo"));
    		lblRec.setText(rs.getRow()+"/"+iTotal);//현재행/총레코드수(총책수)
    		//책의 이미지를 불러오기
    		imgPath=rs.getString("b_image");//c:/bookimage/book6.jpg
    		displayImage();//DB상의 이미지불러오기
    	}catch(Exception e) {
    		System.out.println("display()메서드 오류=>"+e);
    	}
    }
    
    //이미지경로를 지정해서 불러오기
    private void displayImage() { //멤버변수에 존재->매개변수X
    	    ImageIcon icon=createImageIcon(imgPath);//c:/bookimage/book6.jpg
            //이미지를 화면에 보이기위해서->JLabel+ImageIcon결합
    	    lblPic.setIcon(icon);//JLabel->c:/bookimage/book6.jpg
    	    lblPic.setToolTipText("경로는 "+imgPath.toLowerCase());//소문자로출력
    
    	    //이미지를 못불러왔다면
    	    if(icon!=null) {
    	    	lblPic.setText(null);//글자대신에 이미지를 붙이기 위해서
    	    }else {
    	    	lblPic.setText("이미지 없음");//정보
    	    }
    }
    //경로를 지정해 넣어주면 이미지를 만들어서 불러오는 메서드
    private ImageIcon createImageIcon(String path) {
    	if(path!=null) {//불러올 이미지의 경로가 들어가 있다면->이미지객체생성
    		//swing->이미지를 생성->ImageIcon(경로)
    		//ImageIcon 객체명=new ImageIcon(경로포함해서 파일명)
    		return new ImageIcon(path);
    	}else {
    		System.out.println("이미지 불러오는데 실패(경로불분명)");
    		return null;//이미지객체정보를 만들어서 줄 수가 없다는 표시
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
    			//신규,수정,삭제,조회,종료
    			//신규->맨처음 레코드입력->저장
    			if(e.getSource()==btnInsert) {//신규버튼을 눌렀다면
    				if(isInsert==false) {//Insert(신규)버튼을 누르지 않은상태에서 처음 누른경우
    					txtBbun.setText(iLast+1+"");
    					imgPath=null;//새로운 이미지 불러올 정보(경로포함 파일명)
    					
    					//iLast->총레코드수(맨마지막 레코드번호)+1
    				    txtBjemok.setText(null);//제목
    				    txtBjang.setText(null);//장르
    				    //구입날짜->자동으로 오늘날짜 계산
    				    Calendar cal=Calendar.getInstance();
    				    String imsi=cal.get(Calendar.YEAR)+"-"+ //2017-
    				                      (cal.get(Calendar.MONTH)+1)+"-"+//2017-6
    				    		            cal.get(Calendar.DATE);//2017-6-27
    				    //언어처리->편리성 추구
    				    txtBkuil.setText(imsi);//자동으로 오늘 날짜가 출력
    				    txtBdaesu.setText("0");//대여수 0
    				    txtBdaeyn.setText("n");//대여유무->n
    				    txtBdaebun.setText("0");//고객번호는 처음에는 0
    				    txtBdaeil.setText(null);//대여일
    				    txtBbanil.setText(null);//반납일
    				    taBmemo.setBackground(Color.WHITE);//대여자정보,책의상태
    				    //입력가능하게 설정
    				    taBmemo.setEditable(true);//편집할 수있는  ->setEnabled(활성화)
    					txtBjemok.setEditable(true);//제목
    					txtBjang.setEditable(true);//장르
    					txtBkuil.setEditable(true);//장르
    					//제목에 커서입력
    					txtBjemok.requestFocus();
    					//이미지를 새로 삽입
    				    imageIn();
    				    //버튼의 상태를 변경
    				    btnInsert.setText("확인");//버튼의 이름
    				    isInsert=true;//한번 클릭했다고 체크
    				}else { //isInsert=true인 상태(이미 한번 누른경우)->확인
    					taBmemo.setBackground(Color.LIGHT_GRAY);//회색
    					taBmemo.setEditable(false);//
    					txtBjemok.setEditable(false);//제목
    					txtBjang.setEditable(false);//장르
    					txtBkuil.setEditable(false);//구입
    					btnInsert.setText("신규");
    				    isInsert=false;//원래 초기화->다시 다음번 책을 입력하기위해서
    				    //insertBook()호출
    				    insertBook();
    				} 
    			}else if(e.getSource()==btnin) {//이미지 추가->수정과 같다
    				file=null;//불러올 이미지의 파일 정보
    				//파일 대화상자->JFileChooser
    				JFileChooser fileChooser=new JFileChooser();
    				//파일표시
    				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    				int result=fileChooser.showOpenDialog(this);
    				if(result==JFileChooser.CANCEL_OPTION) {//취소를 선택했다면
    					file=null;
    				}else {//불러올 이미지 파일선택했다면
    					file=fileChooser.getSelectedFile();//당신이 선택한 이미지파일명
    					imgPath=file.getPath().replace("\\", "/"); // \->\\ or /인식
    					System.out.println
    					("선택한 이미지 파일 경로 확인(imgPath)=>"+imgPath);
    					displayImage();//이미지+JLabel->화면에 출력
    				}
    				//전의 설정정보 해제
    				picPn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    				lblPic.setVisible(true);//새로 부착된 이미지
    				btnin.setVisible(false);//추가버튼은 안보이게 
    				picPn.add("Center", lblPic);//JLabel+imageicon이 결합이 된 상태
    			}else if(e.getSource()==btnUpdate) {//수정버튼<-->완료
    			  
    			}else if(e.getSource()==btnDel) {//삭제버튼
    				//사용자에게 진짜 삭제유무?=>confirm->showConfirmDialog()
    				//1.부모창(this) 2.메세지내용3.창의 제목 4.옵션(yes|no)
    				int re=JOptionPane.showConfirmDialog
    				            (this,"현재 도서자료를 정말로 삭제할까요?","삭제",
    						                           JOptionPane.YES_NO_OPTION);
    				if(re==JOptionPane.YES_OPTION); //예라고 눌렀다면
    					 // deleteBook();
    			}else if(e.getSource()==btnFind) {//검색버튼
    				      //findBook();
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
    					//BookMain의 메뉴(book_book)=>활성화(setEnabled(true|false))
    				    BookMain.book_book.setEnabled(true);//도서메뉴 활성화
    				    BookMain.childWinBook.dispose();//자식창종료(메모리해제)
    				}//finally
    			}	
    }
    
    //신규이미지를 불러오기 작업(버튼을 생성,배치->테두리 선)
    private void imageIn() {
    	//BorderFactory->테두리를 설정할때 필요로하는  클래스(x,y,w,h)
    	picPn.setBorder(BorderFactory.createEmptyBorder(50,100,50,50));
    	btnin=new JButton("그림삽입");//수정->그림수정
    	btnin.addActionListener(this);
    	lblPic.setVisible(false);//평상시에는 안보임->그림추가할때만 보임(도서등록)
    	picPn.add("Center", btnin);
    }
    //도서신규(등록)
    private void insertBook() {
    	try {
    		sql="insert into book values("+txtBbun.getText() //자동으로 써진글자
    		     +",'"+txtBjemok.getText() //제목
    		     +"','"+txtBjang.getText() //장르
    		     +"','"+txtBkuil.getText() //구입날
    		     +"','"+txtBdaesu.getText() //대여수(0)
    		     +"','"+txtBdaeyn.getText() //대여유무(n)
    		     +"','"+txtBdaebun.getText() //대여자 번호(0)
    		     +"','"+txtBdaeil.getText() //대여일
    		     +"','"+txtBbanil.getText() //반납일
    		     +"','"+taBmemo.getText() //메모(대여자 정보)
    		     +"','"+imgPath+"')";  //새로 불러올 이미지 경로명 및 파일명
    		System.out.println("insert sql=>"+sql);
    		int insert=stmt.executeUpdate(sql); //1->성공, 0->실패
    		System.out.println("데이터 입력성공유무(insert)=>"+insert);
    		init();//행번호가 변경->다시 읽어들여야 한다.
    		rs.last();
    		display();
    	}catch(Exception e) {
    		System.out.println("insertBook()메서드 오류발생=>"+e);
    	}
    }
    //수정->updateBook()
    //삭제->deleteBook()
    //조회->findBook()
	public static void main(String[] args){
		BookBook bookBook =new BookBook();
		
		JFrame frame=new JFrame("도서 창");
		frame.getContentPane().add(bookBook);
		frame.setBounds(440,110,430,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
