package CatCafeProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//DB연동
import java.sql.*;
import java.util.Calendar;
import java.awt.event.*;
import java.text.SimpleDateFormat;

//오라클 DB
//people	: no, fkresearch_no, name, tel, addr, suspend, note
//			: 번호, 리서치연결, 이름, 전화, 주소, 입양정보(y|n), 비고(원하는고양이 등)
//cat		: no, fk_person_no, kind, name, gender, birthday, picpath, isreleased, note
//			: 번호, 입양자연결, 품종, 이름, 성별, 생일, 사진, 입양정보(y|n), 비고
//research	: no, familyagree, residence, havepet, note
//			: 번호, 가족동의여부(y|n), 주거형태, 애완동물여부(y|n), 비고

public class CatcafeJoin extends JPanel implements ActionListener{
	
	//부착시킬 컴포넌트 리스트
	//		 입양자번호,  이름,    주소,    전화,냥이번호,  이름,   나이,   품종,     입양,    사진,  성별
	JTextField txtPbun,txtPname,txtPjuso,txtPtel,txtCbun,txtCname,txtCage,txtCpum,txtCbunYang,imgCat,txtCmf;
	JTextField txtCbirthday, txtPsuspend, txtCfpn;
	//			고양이생일, 입양 여부
	JTextArea taPmemo, taCmemo;//메모
	//	입양자번호,냥이번호,냥이이름,냥이나이,냥이성별,냥이품종,입양여부,입양,보류
	JButton btnPbun,btnCbun,btnCname,btnCage,btnCmf,btnCpum,btnCbunYang,btnBunYang,btnCan,btnPname,btnPjosu,btnPtel,btnClose;
	JButton btnPsuspend;
	//고객정보 찾았는지 체크 bv(대여해줄 책을 찾았는지)
	boolean bg=false, bv=false;  //대여확인 버튼 활성화 여부
	JLabel lblPic;
	
	
	/*
	//부착시킬 컴포넌트 리스트
	//		 입양자번호,  이름,    주소,    전화,냥이번호,  이름,   나이,   품종,     분양,    사진,  성별
	JTextField txtPbun,txtPname,txtPjuso,txtPtel,txtCbun,txtCname,txtCage,txtCpum,txtCbunYang,imgCat,txtCfm;
	JTextArea taCmemo;//메모
	//	입양자번호,냥이번호,냥이이름,냥이나이,냥이성별,냥이품종,분양여부,입양,보류
	JButton btnPbun,btnCbun,btnCname,btnCage,btnCmf,btnCpum,btnCbunYang,btnBunYang,btnCan;
	*/
	
	
	//(2) DB연동
	private Connection conn;//연결객체
	private Statement stmt;//sql 구문을 사용하기 위해 필요한 객체
	private ResultSet rs1, rs2;//rs1 고객정보, rs2 도서정보
	String sql,imgPath;//sql구문 저장
	private JPanel catImg;
	//-------------------------------------------------
	
	
	public CatcafeJoin(){
		design();
		//
		addListener();
		accDb();
		//display() -> 처음부터 보여주는것이 아니기때문에 (필요로 할때만 검색)

	}
	
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//고객정보 패널========================
		GridLayout gl_personPn = new GridLayout(0,2);
		JPanel personPn=new JPanel(gl_personPn);
		personPn.setBorder(new TitledBorder(new TitledBorder("입양자 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		FlowLayout fl_pPn1 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn1=new JPanel(fl_pPn1);
		FlowLayout fl_pPn2 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn2=new JPanel(fl_pPn2);
		FlowLayout fl_pPn3 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn3=new JPanel(fl_pPn3);
		FlowLayout fl_pPn4 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn4=new JPanel(fl_pPn4);
		FlowLayout fl_pPn5 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn5=new JPanel(fl_pPn5);
		FlowLayout fl_pPn6 = new FlowLayout(FlowLayout.LEFT);
		JPanel pPn6=new JPanel(fl_pPn6);

		txtPbun=new JTextField("",10);
		txtPname=new JTextField("",10);
		txtPtel=new JTextField("",10);
		txtPjuso=new JTextField("",15);
		txtPjuso.setEditable(false);
		txtPsuspend=new JTextField("",10);
		txtPsuspend.setEditable(false);
		txtCfpn=new JTextField("",13);
		txtCfpn.setEditable(false);
		
		taPmemo=new JTextArea(2,20);
		JScrollPane scroll=new JScrollPane(taPmemo,	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		taPmemo.setLineWrap(true);
		taPmemo.setEditable(false);
		taPmemo.setBackground(Color.lightGray);
		
		btnPbun=new JButton("확인1");
		btnPbun.setMargin(new Insets(0, 3, 0, 3));
		btnPname=new JButton("확인2");
		btnPname.setMargin(new Insets(0, 3, 0, 3));
		btnPtel=new JButton("확인3");
		btnPtel.setMargin(new Insets(0, 3, 0, 3));

		pPn1.add(new JLabel("번호:"));
		pPn1.add(txtPbun);
		pPn1.add(btnPbun);
		
		pPn2.add(new JLabel("이름:"));
		pPn2.add(txtPname);	
		pPn2.add(btnPname);
		
		pPn3.add(new JLabel("전화:"));
		pPn3.add(txtPtel);
		pPn3.add(btnPtel);
		
		pPn4.add(new JLabel("주소:"));
		pPn4.add(txtPjuso);
		
		pPn5.add(new JLabel("입양:"));
		pPn5.add(txtPsuspend);
		
		pPn6.add(new JLabel("입양냥이:"));
		pPn6.add(txtCfpn);
		
		personPn.add(pPn1); personPn.add(pPn2); personPn.add(pPn3);
		personPn.add(pPn4); personPn.add(pPn5); personPn.add(pPn6); 
		personPn.add(new JLabel("입양자가 선택한 고양이  ☞   ",JLabel.RIGHT));
		personPn.add(scroll); 
		scroll.setBorder(BorderFactory.createEmptyBorder(1, 1, 5, 5));
		this.add(personPn);
		
		JPanel bottomPn=new JPanel();
		bottomPn.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		btnBunYang=new JButton("입양 확인");
		btnCan=new JButton("입양보류");
		btnClose=new JButton(" 닫 기 ");
		
		bottomPn.add(btnBunYang);
		bottomPn.add(btnCan);
		JLabel lbl=new JLabel("    ");  //버튼 사이에 공백 부여
		bottomPn.add(lbl);
		bottomPn.add(btnClose);
		
		this.add(personPn);
		
		JPanel catPn = new JPanel();
		add(catPn);
		catPn.setLayout(new GridLayout(0, 2, 0, 0));

		//이미지 패널----------------------------------------------------
		catImg = new JPanel();
		catImg.setBorder(new TitledBorder(new TitledBorder("고양이 사진"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		catPn.add(catImg);
		catImg.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblPic = new JLabel();
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = "C:/catCafe/picCats/noCat.jpg";
		displayImage();
		catImg.add(lblPic);
		
		
		//고양이정보 패널========================
		JPanel catPnSub=new JPanel();
		catPn.add(catPnSub);
		catPnSub.setBorder(new TitledBorder(new TitledBorder("고양이 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		
		FlowLayout fl_cPn1 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn1=new JPanel(fl_cPn1);
		FlowLayout fl_cPn2 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn2=new JPanel(fl_cPn2);
		FlowLayout fl_cPn3 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn3=new JPanel(fl_cPn3);
		FlowLayout fl_cPn4 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn4=new JPanel(fl_cPn4);
		FlowLayout fl_cPn5 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn5=new JPanel(fl_cPn5);
		FlowLayout fl_cPn6 = new FlowLayout(FlowLayout.LEFT);
		JPanel cPn6=new JPanel(fl_cPn6);
		
		txtCbun=new JTextField("",10);
		txtCname=new JTextField("",10);
		//txtCage=new JTextField("",10);
		txtCpum=new JTextField("",10);
		txtCpum.setEditable(false);
		txtCbunYang=new JTextField("",10);
		txtCbunYang.setEditable(false);
		txtCmf=new JTextField("",10);
		txtCmf.setEditable(false);
		txtCbirthday=new JTextField("",10);
		txtCbirthday.setEditable(false);

		btnCbun=new JButton("검색");
		btnCbun.setMargin(new Insets(0, 3, 0, 3));
		btnCname=new JButton("검색");
		btnCname.setMargin(new Insets(0, 3, 0, 3));
		
		catPnSub.setLayout(new GridLayout(6, 1, 0, 0));
		
		cPn1.add(new JLabel("번호:"));
		cPn1.add(txtCbun);
		cPn1.add(btnCbun);
		
		cPn2.add(new JLabel("이름:"));
		cPn2.add(txtCname);
		cPn2.add(btnCname);
		
		cPn3.add(new JLabel("생일:"));
		cPn3.add(txtCbirthday);				
		
		cPn4.add(new JLabel("성별:"));
		cPn4.add(txtCmf);
		//cPn4.add(btnCmf);
		
		cPn5.add(new JLabel("품종:"));
		cPn5.add(txtCpum);
		//cPn5.add(btnCpum);
		
		cPn6.add(new JLabel("입양여부:"));
		cPn6.add(txtCbunYang);
		//cPn6.add(btnCbunYang);

		catPnSub.add(cPn1);  
		catPnSub.add(cPn2);
		catPnSub.add(cPn3);
		catPnSub.add(cPn4);
		catPnSub.add(cPn5);
		catPnSub.add(cPn6);
		
		//고양이 메모==============================
		GridLayout gl_catNotePn = new GridLayout(0,1);
		JPanel catNotePn=new JPanel(gl_catNotePn);
		catNotePn.setBorder(new TitledBorder(new TitledBorder("고양이 메모"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		
		taCmemo=new JTextArea(2,20);
		JScrollPane scroll2=new JScrollPane(taCmemo,	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		taCmemo.setLineWrap(true);
		taCmemo.setEditable(false);
		taCmemo.setBackground(Color.lightGray);
		
		catNotePn.add(scroll2); 
		scroll2.setBorder(BorderFactory.createEmptyBorder(1, 1, 5, 5));
		
		this.add(catNotePn);
		
		this.add(bottomPn);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
		btnBunYang.setEnabled(false); //대여 버튼 비활성화
		btnCan.setEnabled(false);
	}
	private void addListener() {
		btnPbun.addActionListener(this);	//입양자번호
		btnPname.addActionListener(this);	//입양자이름
		btnPtel.addActionListener(this);	//입양자전화
		btnCbun.addActionListener(this);	//냥이번호
		btnCname.addActionListener(this);	//냥이이름
		btnBunYang.addActionListener(this);	//분양완료
		btnCan.addActionListener(this);		//새로작성
		btnClose.addActionListener(this);	//종료
	}
	
	private void accDb() {
		try {
			//1.오라클 드라이버 메모리에 올림
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";//url주소값
			//2.접속하기위한 메서드(1.접속url,2.계정명, 3.접속 암호)
			conn=DriverManager.getConnection(url, "test1", "t1234");
			//추가(신규,수정 -> 레코드이동 -> 자동으로 스크롤 이동시 수정이 반영)
			stmt=conn.createStatement();//웹에서는 사용안함

			System.out.println("접속conn=>"+conn);
		}catch(Exception e) {
			System.out.println("DB접속 오류=>"+e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 정보를 가져오는 객체
		// TODO Auto-generated method stub
		if(e.getSource()==btnPbun) {//고객버튼을 눌렀다면
			if(txtPbun.getText().equals("")) {
				txtPbun.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "입양자번호를 입력하세요");
				return;
			}
			sql="select * from people where no="+txtPbun.getText();
			processPerson();
			
		}else if(e.getSource()==btnPname){//이름버튼
			if(txtPname.getText().equals("")) {
				txtPname.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "입양자이름을 입력하세요");
				return;
			}
			sql="select * from people where name='"+txtPname.getText()+"'";
			processPerson();
			
		}else if(e.getSource()==btnPtel){//전화버튼
			if(txtPtel.getText().equals("")) {
				txtPtel.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "입양자전화번호를 입력하세요");
				return;
			}
			sql="select * from people where tel='"+txtPtel.getText()+"'";
			processPerson();
			
		}else if(e.getSource()==btnCbun){//고양이번호버튼
			if(txtCbun.getText().equals("")) {
				txtCbun.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "고양이번호를 입력하세요");
				return;
			}
			sql="select * from cat where no="+txtCbun.getText();
			processCat();
			
		}else if(e.getSource()==btnCname){//고양이이름버튼
			if(txtCname.getText().equals("")) {
				txtCname.requestFocus();//커서
				JOptionPane.showMessageDialog(this, "고양이 이름을 입력하세요");
				return;
			}
			sql="select * from cat where name='"+txtCname.getText()+"'";
			processCat();
			
		}else if(e.getSource()==btnBunYang){
			try {
				sql="select * from people where suspend='"+txtPsuspend.getText()+"'";
				rs1=stmt.executeQuery(sql);
				//if(rs1.equals("Y")) {
				if(rs1.next()) {
					if(rs1.getString("suspend").equals("Y")) {
						System.out.println("이사람입양불가!");
						JOptionPane.showMessageDialog(this, "입양이 불가능한 고객입니다.");
						txtPbun.setText(null);
						txtPname.setText(null);
						txtPtel.setText(null);
						txtPjuso.setText(null);
						txtPsuspend.setText(null);
						taPmemo.setText(null);
						txtCbun.setText(null);
						txtCname.setText(null);
						txtCbirthday.setText(null);
						txtCmf.setText(null);
						txtCbunYang.setText(null);
						txtCpum.setText(null);
						taCmemo.setText(null);
						imgPath = "C:/catCafe/picCats/noCat.jpg";
						displayImage();
						return;
					}else {
						System.out.println("입양이 가능한사람이다!");
						//분양 메서드 실행
						int re=JOptionPane.showConfirmDialog(this, "현재 보고있는 고양이를 입양하시겠습니까?", "입양", JOptionPane.YES_NO_OPTION);
						if(re==JOptionPane.YES_OPTION) {//예 라고 눌렀다면
							processBunYang();
						}/*else if(re==JOptionPane.NO_OPTION){
							//뭐라고 해야하지1
						}else if(re==JOptionPane.CANCEL_OPTION) {
							//뭐라고 해야하지2
						}else if(re==JOptionPane.CLOSED_OPTION) {
							//뭐라고 해야하지3
						}*/
						
					}
				}
			}catch(Exception e2){
				System.out.println("분양정보 확인실패=>"+e2);
			}
			
			//입양확인 한 후
			//btnBunYang.setEnabled(false);// 비활성화
		}else if(e.getSource()==btnCan){//초기화 버튼 -> 고객,도서찾기 초기화
			clear();
		}else if(e.getSource()==btnClose){//종료버튼
			int re = JOptionPane.showConfirmDialog(this, "정말 종료할까요?","선택",JOptionPane.YES_NO_OPTION);
			try {// conn -> stmt -> rs1,rs2 -> 메모리 해제순서는 생성순서의 역순
				if(re == JOptionPane.YES_OPTION) {
					if(rs1!=null)rs1.close();
					if(rs2!=null)rs2.close();
					if(stmt!=null)stmt.close();
					if(conn!=null)conn.close();
				}
				if(re == JOptionPane.NO_OPTION) return;
			}catch(Exception e2) {
				System.out.println("에러유발->e2"+e2);
			}finally {
				if(re == JOptionPane.YES_OPTION) {
					CatcafeMain.cat_join.setEnabled(true);//대여메뉴 활성화
					CatcafeMain.childWinJoin.dispose();//메모리해제하고 종료
				}
				if(re == JOptionPane.NO_OPTION) return;
				
			}
		}
	}
	
	//고객정보를 찾아서 출력시켜주는 메서드//입양자 정보
	private void processPerson() {//단순, 반복-> 중복된 코딩이 많다.
		try {
			rs1=stmt.executeQuery(sql);
			if(rs1.next()) {//고객번호,이름,전번
				txtPbun.setText(rs1.getString("no"));
				txtPname.setText(rs1.getString("name"));
				txtPtel.setText(rs1.getString("tel"));
				txtPjuso.setText(rs1.getString("addr"));
				txtPsuspend.setText(rs1.getString("suspend"));
				taPmemo.setText(rs1.getString("note"));
				txtCfpn.setText(null);
				if(rs1.getString("suspend").equals("Y")) {
					JOptionPane.showMessageDialog(this, "현재 입양이 불가능한 사람입니다.");
					bg=false;
					btnBunYang.setEnabled(bg && bv);
				}
				//고양이 정보를 찾아서 사람번호를 비교
				String sql2 = "select * from cat where fk_Person_no="+txtPbun.getText();
				rs2=stmt.executeQuery(sql2);
				//System.out.println(sql2);//sql2가 잘 구동되는지 확인
				while(rs2.next()) {
					if(rs2.getString("fk_Person_no").equals(txtPbun.getText())) {
						txtCfpn.setText(rs2.getString("name"));
					}				
				}
				bg=true;//고객정보 찾은 표시
				btnBunYang.setEnabled(bg && bv);//true && false
			}else {
				JOptionPane.showMessageDialog(this, "해당자료는 없습니다.");
				txtPbun.setText(null);
				txtPname.setText(null);
				txtPtel.setText(null);
				txtPjuso.setText(null);
				txtPsuspend.setText(null);
				taPmemo.setText(null);
				txtCfpn.setText(null);
				bg=false;//못찾은 경우
				btnBunYang.setEnabled(false);//true && false
			}

		}catch(Exception e) {
			System.out.println("고객정보 검색실패 => "+e);
		}
	}
	//책정보를 찾아서 출력시켜주는 메서드//고양이 정보
	private void processCat() {
		try {
			rs2=stmt.executeQuery(sql);
			if(rs2.next()) {//고객번호,이름,전번
				txtCbun.setText(rs2.getString("no"));
				txtCname.setText(rs2.getString("name"));
				String str1=rs2.getString("birthday").substring(0,10);
				txtCbirthday.setText(str1);
				//rs2.getString("birthday")
				txtCmf.setText(rs2.getString("gender"));
				txtCpum.setText(rs2.getString("kind"));
				txtCbunYang.setText(rs2.getString("isReleased"));
				taCmemo.setText(rs2.getString("note"));
				imgPath=rs2.getString("picPath");
				displayImage();
				//rs2.getString("isReleased").
				if(rs2.getString("isReleased").equals("Y")) {
					JOptionPane.showMessageDialog(this, "현재 입양완료된 고양이입니다.");
					bv=false;
					btnBunYang.setEnabled(bg && bv);
					return;
				}
				
				bv=true;//도서정보 찾은 표시
				btnBunYang.setEnabled(bg && bv);//true && true => true
			}else {
				JOptionPane.showMessageDialog(this, "해당자료는 없습니다.");
				txtCbun.setText(null);
				txtCname.setText(null);
				txtCbirthday.setText(null);
				txtCmf.setText(null);
				txtCpum.setText(null);
				txtCbunYang.setText(null);
				taCmemo.setText(null);
				imgPath = "C:/catCafe/picCats/noCat.jpg";
				displayImage();
				bv=false;//도서정보 못찾은 경우
				btnBunYang.setEnabled(false);
			}
			//고양이의 이미지를 불러오기
			//imgPath=rs2.getString("picPath");//c:/bookimage/book6.jpg
			btnCan.setEnabled(true);//초기화
		}catch(Exception e) {
			System.out.println("고양이정보 검색실패 => "+e);
		}
		//displayImage();
	}
	private void processBunYang() {
		//고양이 분양 프로세스
		try {
			if(txtCfpn.getText().equals("")) {
				sql="update cat set fk_Person_no="+txtPbun.getText()+" where no="+txtCbun.getText();
				int update3 = stmt.executeUpdate(sql);//정수형값을 반환 -> 1(성공),0(실패)
				System.out.println("데이터수정성공유무(update3)고양이 분양한사람은?=> "+update3);
				
				try {
					//고양이 정보수정
					if(txtCbunYang.getText().equals("N")){
						sql="update cat set isReleased='Y' where no="+txtCbun.getText();
						System.out.println("고양이 수정 sql=>"+sql);
						int update = stmt.executeUpdate(sql);//정수형값을 반환 -> 1(성공),0(실패)
						System.out.println("데이터수정성공유무(update)고양이=> "+update);
						
						sql="update cat set note='"
								+(taCmemo.getText()+"\n"+txtPname.getText()+"님께서 입양함")
								+"' where no="+txtCbun.getText();
						System.out.println("고양이 수정2 sql=>"+sql);
						int update2 = stmt.executeUpdate(sql);//정수형값을 반환 -> 1(성공),0(실패)
						System.out.println("데이터수정성공유무(update2)고양이 메모=> "+update2);
						//사람의 입양냥이가 없을경우에만 데이터를 입력한다. --- 하는중
					}
					System.out.println("수정한 sql=>"+sql);

					if(txtPsuspend.getText().equals("N")){
						sql="update People set suspend='Y' where no="+txtPbun.getText();
						System.out.println("입양자 수정 sql=>"+sql);
						int update = stmt.executeUpdate(sql);//정수형값을 반환 -> 1(성공),0(실패)
						System.out.println("데이터수정성공유무(update)입양자=> "+update);
						
						sql="update People set note='"
							+(taPmemo.getText()+"\n"+txtCbun.getText()+"번 "+txtCname.getText()+" 고양이 입양함")
							+"' where no="+txtPbun.getText();
						System.out.println("입양자 수정2 sql=>"+sql);
						int update2 = stmt.executeUpdate(sql);//정수형값을 반환 -> 1(성공),0(실패)
						System.out.println("데이터수정성공유무(update)입양자 메모=> "+update2);
					}
					System.out.println("수정한 sql=>"+sql);
					clear();

				}catch(Exception e) {
					System.out.println("분양프로세스 실패=> "+e);
				}
				
			} else {
				throw new Exception();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "분양받은 고양이가 있어서 분양불가");
			System.out.println("이미 분양받은사람 오류"+e);
		}
	}
	
	private void clear() {
		txtPbun.setText(null);
		txtPname.setText(null);
		txtPtel.setText(null);
		txtPjuso.setText(null);
		txtPsuspend.setText(null);
		taPmemo.setText(null);
		txtCfpn.setText(null);
		txtCbun.setText(null);
		txtCname.setText(null);
		txtCbirthday.setText(null);
		txtCmf.setText(null);
		txtCbunYang.setText(null);
		txtCpum.setText(null);
		taCmemo.setText(null);
		imgPath = "C:/catCafe/picCats/noCat.jpg";
		displayImage();
		bg=false; bv=false;
		btnCan.setEnabled(false);//새로버튼 비활성화
		btnBunYang.setEnabled(false);
	}
	//이미지 경로를 지정해서 불러오기
	private void displayImage() {//멤버변수의 존재 -> 매개변수 X
		ImageIcon icon = createImageIcon(imgPath);//c:/bookimage/book6.jpg
		//이미지를 화면에 보이기 위해서 -> JLable + ImageIcoon 결합

		//이미지 사이즈 조절을 위한구문 ======
		//ImageIcon객체를 생성
		ImageIcon originIcon = new ImageIcon(imgPath);  

		//ImageIcon에서 Image를 추출
		Image originImg = originIcon.getImage(); 

		//추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		Image changedImg= originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH );

		//새로운 Image로 ImageIcon객체를 생성
		ImageIcon Icon = new ImageIcon(changedImg);
		//이미지 사이즈 조절을 위한구문 종료 ======
		
		lblPic.setIcon(Icon);//JLabel -> c:/bookimage/book6.jpg
		lblPic.setToolTipText("경로는"+imgPath.toLowerCase());//소문자로 출력

		//이미지를 못 불러왔다면
		if(icon!=null) {
			lblPic.setText(null);//글자 대신에 이미지를 붙이기 위해서
		}else {
			lblPic.setText("이미지 없음");
		}
	}
	
	//이미경로를 넣어주면 이미지를 출력해주는 메서드
	private ImageIcon createImageIcon(String path) {
		if(path!=null) {//불러올 이미지의 경로가 들어가 있다면 -> 이미지 객체 생성
			//swing -> 이미지를 생성 -> ImageIcon(경로)
			//ImageIcon 객체명 = new ImageIcon(경로 포함해서 파일명)
			return new ImageIcon(path);
		}else {
			System.out.println("이미지 불러오는데 실패(경로 불분명)");
			return null;//이미지 객체정보를 만들어서 줄 수가 없다는 표시
		}
	}
	
	
	public static void main(String[] args) {
		CatcafeJoin ccj=new CatcafeJoin();
		JFrame frame=new JFrame("입양화면");
		frame.getContentPane().add(ccj);
		//frame.setResizable(false);
		frame.setBounds(200,200,520,660);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
