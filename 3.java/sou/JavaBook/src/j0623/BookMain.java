package j0623;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;//날짜

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
//
import javax.swing.JMenu;//메뉴이름
import javax.swing.JMenuBar;//메뉴판
import javax.swing.JMenuItem;//특정 메뉴의 메뉴항목
//------------------------------------------------------------------------------
import javax.swing.JOptionPane;//사용자로부터 값을 입력,경고(대화상자)
import javax.swing.JRootPane;
import javax.swing.border.BevelBorder;//테두리

public class BookMain extends JFrame implements ActionListener{

	//대여,반납,고객,도서,종료(메뉴 항목을 의미)
	//->static=>다른 대화상자에서 불러다 사용할목적
	//클래스명.정적메서드 ,클래스명.정적멤버변수명
	public static JMenuItem book_dae, book_ban, book_customer,book_book,book_close;

	//자식창을 선언(MDI창의 자식창들)
	public static JInternalFrame childWinDae,childWinBan,
		childWinCustomer,childWinBook;

	public JDesktopPane desktopPane = new JDesktopPane();  //frame 생성
	
	public BookMain(String str) {
		super(str);
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		//1.메뉴바 생성
		JMenuBar mbar = new JMenuBar();  //메뉴바
		//메뉴바의 테두리 설정
		mbar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		//2.부착시킬 메뉴생성
		JMenu mbook = new JMenu("메뉴 선택");
		
		//3.메뉴에 부착시킬 메뉴항목을 생성
		book_dae = new JMenuItem("대여관리");//메뉴항목 이름
		book_ban = new JMenuItem("반납관리");
		book_customer = new JMenuItem("고객관리");
		book_book = new JMenuItem("도서관리");
		book_close = new JMenuItem("종료");
		
		//부착시키는 순서->
		mbook.add(book_dae);       mbook.add(book_ban);
		mbook.add(book_customer);  mbook.add(book_book);
        mbook.addSeparator(); //분리선
		mbook.add(book_close);
		
		//메뉴의 이벤트 처리
		book_dae.addActionListener(this); 
		book_ban.addActionListener(this);
		book_customer.addActionListener(this);  
		book_book.addActionListener(this);
	    book_close.addActionListener(this);
		//메뉴를 메뉴바에 결합
		mbar.add(mbook);
		
		setJMenuBar(mbar);  //frame에 메뉴바 장착
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(0, 0);//x,y
		this.setSize(dimension.width, dimension.height);//스크린의 w,h
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(book_dae)){
			createListen("대여", 580, 400, "dae");
			BookDaeyeo daeyeo = new BookDaeyeo();
			childWinDae.getContentPane().add(daeyeo);
			childWinDae.setLocation(10, 10);
			desktopPane.add(childWinDae);
			this.getContentPane().add(desktopPane);
			childWinDae.show();
			book_dae.setEnabled(false);
		}else if(e.getSource().equals(book_ban)){
			createListen("반납", 500, 400, "ban");
			BookBannap bannap = new BookBannap();
			childWinBan.getContentPane().add(bannap);
			childWinBan.setLocation(110, 60);
			desktopPane.add(childWinBan);
			this.getContentPane().add(desktopPane);
			childWinBan.show();
			book_ban.setEnabled(false);
		}else if(e.getSource().equals(book_customer)){
			createListen("고객", 430, 400, "customer");
			BookCustomer customer = new BookCustomer();
			childWinCustomer.getContentPane().add(customer);
			childWinCustomer.setLocation(210, 110);
			desktopPane.add(childWinCustomer);
			this.getContentPane().add(desktopPane);
			childWinCustomer.show();
			book_customer.setEnabled(false);
		}else if(e.getSource().equals(book_book)){
			createListen("도서", 430, 680, "book");
			BookBook book = new BookBook();
			childWinBook.getContentPane().add(book);
			childWinBook.setLocation(310, 20);
			desktopPane.add(childWinBook);
			this.getContentPane().add(desktopPane);
			childWinBook.show();
			book_book.setEnabled(false);
		}else if(e.getSource().equals(book_close)){
			int re = JOptionPane.showConfirmDialog(this, 
				"정말 종료할까요?","선택",JOptionPane.YES_NO_OPTION);
			if(re == JOptionPane.NO_OPTION) return;
			System.exit(0);
		}
	}
	//내부창의 환경설정(자식창의 제목,자식창의w,h,전달받은 문자열)
	private void createListen(String title, int w, int h, String str){
		if(str.equals("dae")){//대여
			childWinDae = new JInternalFrame(title, false, false, false, true);
			childWinDae.setSize(w, h);
		}else if(str.equals("ban")){
			childWinBan = new JInternalFrame(title, false, false, false, true);
			childWinBan.setSize(w, h);
		}else if(str.equals("customer")){
			childWinCustomer = new JInternalFrame(title, false, false, false, true);
			childWinCustomer.setSize(w, h);
		}else if(str.equals("book")){
			childWinBook = new JInternalFrame(title, false, false, false, true);
			childWinBook.setSize(w, h);
		}
	}
	
	public static void main(String[] args) {
		//오늘 날짜를 창의 제목에 출력->Date,Calendar
		//Date d=new Date(); 옛날방식
		Calendar calendar=Calendar.getInstance();
		int y=calendar.get(Calendar.YEAR);//2017->get(정적상수명)
		int m=calendar.get(Calendar.MONTH)+1;//0~11 만 리턴->06
		int d=calendar.get(Calendar.DATE);//일->26
		new BookMain("도서관리 ver 1.0   ★ 오늘은 " + y + "년 " + m + "월 " + d + "일");
	}
}





