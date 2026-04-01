import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.sql.*;

public class BookBook extends JPanel{

	JTextField txtBbun,txtBjemok,txtBjang,txtBkuil,txtBdaesu,txtBdaeyn,txtBdaebun,txtBdaeil,txtBbanil;
	JTextArea taBmemo;
	JButton btnInsert,btnUpdate,btnDel,btnFind,btnOption,btnClose;
	JButton btnF,btnP,btnN,btnL,btnin,btnsu;
	JLabel lblRec,lblPic;

	String sql, imgPath; //--- 그림 파일 경로 변수
	int iTotal = 0;	// 자료의 갯수
	int iLast = 0; 	// 마지막 레코드 번호
	JPanel picPn;
	File file;  //--- 이미지 로딩하기 위한 변수
	boolean isInsert = false;	// Insert 버튼 눌림 여부
	boolean isUpdate = false;	// Update 버튼 눌림 여부
	
	public BookBook(){
		design();
	}
	
	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//도서정보 패널========================
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
		JScrollPane scroll=new JScrollPane(taBmemo);
		taBmemo.setBackground(Color.lightGray);
		
		txtBbun.setEditable(false);
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
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		btnsu=new JButton("그림 수정");

	}
	

	public static void main(String[] args){
		BookBook bookBook =new BookBook();
		
		JFrame frame=new JFrame("도서 창");
		frame.getContentPane().add(bookBook);
		frame.setBounds(440,110,430,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
