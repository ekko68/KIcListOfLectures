package CatCafeProject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
//
import javax.swing.JMenu;//메뉴이름
import javax.swing.JMenuBar;//메뉴판
import javax.swing.JMenuItem;//특정 메뉴의 메뉴항목
//-------------------------------
import javax.swing.JOptionPane;//사용자로부터 값을 입력, 경고
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.BevelBorder;

//CatcafeInfo.java 고양이
//CatcafePerson.java 사람
//CatcafeJoin.java 입양버튼
public class CatcafeMain extends JFrame implements ActionListener{

	//대여,반납,고객,도서,종료(메뉴항목을 의미)
	//-> static => 다른 대화상자에서 불러다 사용할 목적

	//(고양이)
	public static JMenuItem cat_info, cat_person, cat_join, cat_close;
	public static JMenuItem cat_db;
	
	//자식창을 선언(MDI창의 자식창들)
	//(고양이)
	public static JInternalFrame childWinInfo, childWinPerson, childWinJoin;
	public static JInternalFrame childWinDb;

	public JDesktopPane desktopPane = new JDesktopPane() {
       ImageIcon icon = new ImageIcon("C:/catCafe/picCats/main_test2.png");
       Image image = icon.getImage();
       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       Image newimage = image.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);

       @Override
       protected void paintComponent(Graphics g)
       {
           super.paintComponent(g);
           g.drawImage(newimage, 0, 0, this);
       }
	};  //frame 생성
	
	public CatcafeMain(String str) {
		super(str);
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.add(desktopPane);
		//1.메뉴바 생성
		JMenuBar mbar = new JMenuBar();  //메뉴바
		//메뉴바의 테두리 설정
		mbar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		//2.부착시킬 메뉴생성(고양이)
		JMenu mCat = new JMenu("메뉴 선택");//메뉴항목 이름
		cat_info = new JMenuItem("고양이 관리");
		cat_person = new JMenuItem("고객관리");
		cat_join = new JMenuItem("분양관리");
		cat_close = new JMenuItem("종료");
		
		//부착시키는 순서 ->(고양이)
		mCat.add(cat_info);
		mCat.add(cat_person);
		mCat.add(cat_join);
		mCat.addSeparator(); //분리선
        mCat.add(cat_close);
        
		//2.부착시킬 메뉴생성(DB)
		JMenu mCatDb = new JMenu("DB메뉴");//메뉴항목 이름
		cat_db = new JMenuItem("DB 관리");
		
		//부착시키는 순서 ->(DB)
		mCatDb.add(cat_db);
		
		//메뉴의 이벤트 처리(고양이)
	    cat_info.addActionListener(this);  cat_person.addActionListener(this);
	    cat_join.addActionListener(this);
	    cat_close.addActionListener(this);
		//메뉴의 이벤트 처리(고양이)
		cat_db.addActionListener(this);
		
	    //메뉴를 메뉴바에 결합(고양이)
		mbar.add(mCat);
		mbar.add(mCatDb);

		setJMenuBar(mbar);  //frame에 메뉴바 장착
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(0, 0);//x,y
		this.setSize(dimension.width, dimension.height);//스크린의 w,h
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource().equals(cat_info)){
			createListen("고양이관리", 500, 550, "info");
			CatcafeInfo info = new CatcafeInfo();
			childWinInfo.getContentPane().add(info);
			childWinInfo.setLocation(0, 100);
			desktopPane.add(childWinInfo);
			this.getContentPane().add(desktopPane);
			childWinInfo.show();
			cat_info.setEnabled(false);
		}else if(e.getSource().equals(cat_person)){
			createListen("고객관리", 750, 540, "person");
			CatCafePerson person = new CatCafePerson();
			childWinPerson.getContentPane().add(person);
			childWinPerson.setLocation(500, 100);
			desktopPane.add(childWinPerson);
			this.getContentPane().add(desktopPane);
			childWinPerson.show();
			cat_person.setEnabled(false);
		}else if(e.getSource().equals(cat_join)){
			createListen("분양관리", 520, 660, "join");
			CatcafeJoin join = new CatcafeJoin();
			childWinJoin.getContentPane().add(join);
			childWinJoin.setLocation(1040, 100);
			desktopPane.add(childWinJoin);
			this.getContentPane().add(desktopPane);
			childWinJoin.show();
			cat_join.setEnabled(false);
		}else if(e.getSource().equals(cat_db)){
			createListen("DB관리", 400, 510, "db");
			CatcafeDb db = new CatcafeDb();
			childWinDb.getContentPane().add(db);
			childWinDb.setLocation(0, 330);
			desktopPane.add(childWinDb);
			this.getContentPane().add(desktopPane);
			childWinDb.show();
			cat_db.setEnabled(false);
		}else if(e.getSource().equals(cat_close)){
			int re = JOptionPane.showConfirmDialog(this, 
				"정말 종료할까요?","선택",JOptionPane.YES_NO_OPTION);
			if(re == JOptionPane.NO_OPTION) return;
			
			System.exit(0);
		}
	}
	
	
	
	//내부창의 환경설정(자식창의 제목,자식창의 w,h, 전달받은 문자열)
	private void createListen(String title, int w, int h, String str){
		if(str.equals("info")){//고양이정보
			childWinInfo = new JInternalFrame(title, false, false, false, true);
			childWinInfo.setSize(w, h);
		}else if(str.equals("person")){//사람정보
			childWinPerson = new JInternalFrame(title, false, false, false, true);
			childWinPerson.setSize(w, h);
		}else if(str.equals("join")){//입양창
			childWinJoin = new JInternalFrame(title, false, false, false, true);
			childWinJoin.setSize(w, h);
		}else if(str.equals("db")){//DB창
			childWinDb = new JInternalFrame(title, false, false, false, true);
			childWinDb.setSize(w, h);
		}
	}
	
	public static void main(String[] args) {
		//오늘 날짜를 창의 제목에 출력 -> Date,Calendar
		//Data d= new Date(); 옛날방식
		Calendar calendar=Calendar.getInstance();
		int y=calendar.get(Calendar.YEAR);//2017-> get(정적상수명)
		int m=calendar.get(Calendar.MONTH)+1;//0~11 만 리턴
		int d=calendar.get(Calendar.DATE);//일
		new CatcafeMain("고양이 입양관리 ver 1.0   ★ 오늘은 " + y + "년 " + m + "월 " + d + "일");
	}
}





