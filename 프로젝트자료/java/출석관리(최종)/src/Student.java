
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField txt_SNumber, txt_SName, txt_SBirth, txt_SEmail, txt_SAddress, txt_SPtel1, txt_SPtel2, txt_SPtel3,
			txt_STNumber, txt_STName;

	JLabel lbl_SImage, lbl_SNumber, lbl_SName, lbl_SBirth, lbl_SEmail, lbl_SAddress, lbl_SPtel, lbl_, lbl2_, lbl_SJobok,
			lbl_STNumber, lbl_STName, lbl_SGender;

	JButton btn_SBirth, btn_SInsert, btn_SOk, btn_SUpdate, btn_SDelete, btn_SFind;

	ButtonGroup group, group2;
	JRadioButton rdbtn_Man, rdbtn_Woman, rdbtn_SJobokY, rdbtn_SJobokN;

	// 강좌명
	JComboBox cbox_STName;
	Vector STNlist;

	// 생년월일
	JComboBox cbox_SByear;
	Vector SByear_list;

	JComboBox cbox_SBmonth;
	Vector SBmonth_list;

	JComboBox cbox_SBday;
	Vector SBday_list;

	// 이미지 삽입
	Container con_SImage; // 작업 영역을 위한 기본 패널 담을 객체
	ImageIcon im_SImage; // 타이틀 바의 이미지를 가지는 객체

	Image st_img = null;

	JLabel SIM_label;

	// 이미지 파일 저장
	private JFrame frm = new JFrame();
	private JFileChooser fileChooser = new JFileChooser();
	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JButton btn_SImage = new JButton();
	private JLabel fileLabel = new JLabel();
	private JTextField address = new JTextField();
	JButton button;

	File sourceimage;

	// 이미지 변경
	String img_path = "L:/출결_과제/img/235x315.png";

	boolean isInsert = false; // Insert 버튼 눌림 여부(토글버튼)
	boolean isUpdate = false; // Update 버튼 눌림 여부

	// (2) 고객DB정보 저장
	Connection conn;
	Statement stmt, stmt2;// SQL문
	ResultSet rs1, rs2;// select->표형태
	static String sql = null;// sql구문
	String sql2 = null;// sql구문
	private JLabel lblNewLabel;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student() {
		accDb();
		design();
		addListener();
		// display()->처음부터 보여주는 것이 아니기때문에 (필요로할때만 검색)

	}

	public Student(int snum) {
		accDb();
		design();
		addListener();
		setVisible(true); // st1.setVisible(true);
		findStudent(snum);
	}

	private void accDb() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.14:1521:orcl";
			conn = DriverManager.getConnection(url, "scott", "tiger");

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("접속con=>" + conn);
		} catch (Exception e) {
			System.out.println("DB접속 오류=>" + e);
		}
	}

	public void setDesign() {
		// cp.setLayout(new BorderLayout());
		// JPanel pTop=new JPanel();
	}

	public void design() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 515);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * lbl_SImage = new JLabel("이미지 삽입"); // lblNewLabel_1.setIcon(new // ImageIcon(
		 * "/Users/Chosooyoung/Downloads/KakaoTalk_Photo_2017-06-28-16-59-09_89.jpeg"));
		 * lbl_SImage.setBackground(Color.WHITE); lbl_SImage.setFont(new Font("맑은 고딕",
		 * Font.PLAIN, 12)); lbl_SImage.setHorizontalAlignment(SwingConstants.CENTER);
		 * lbl_SImage.setBounds(502, 59, 209, 226); contentPane.add(lbl_SImage);
		 */
		
		button = new JButton("출석부");
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		button.setEnabled(true);
		button.setBorder(new LineBorder(Color.WHITE, 2, true));
		button.setBackground(Color.WHITE);
		button.setBounds(12, 443, 68, 26);
		
		contentPane.add(button);

		txt_SNumber = new JTextField();
		txt_SNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SNumber.setBackground(Color.LIGHT_GRAY);
		txt_SNumber.setForeground(Color.BLACK);
		txt_SNumber.setBounds(116, 39, 68, 26);
		txt_SNumber.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SNumber.setEditable(false);
		contentPane.add(txt_SNumber);
		txt_SNumber.setColumns(10);

		txt_SName = new JTextField();
		txt_SName.setForeground(Color.WHITE);
		txt_SName.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SName.setColumns(10);
		txt_SName.setBounds(116, 75, 111, 26);
		txt_SName.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SName.setEditable(false);
		txt_SName.setOpaque(false);
		contentPane.add(txt_SName);

		SByear_list = new Vector();
		SBmonth_list = new Vector();
		SBday_list = new Vector();

		// 현재 년도
		int year = Calendar.getInstance().get(Calendar.YEAR);

		for (int y = 1970; y <= year; y++) {
			SByear_list.add(y);
		}
		for (int m = 1; m <= 12; m++) {

			String m_val = Integer.toString(m);
			if (m > 0 && m < 10) {
				m_val = "0" + m_val;
			}

			SBmonth_list.add(m_val);
		}

		for (int d = 1; d <= 31; d++) {

			String d_val = Integer.toString(d);
			if (d > 0 && d < 10) {
				d_val = "0" + d_val;
			}

			SBday_list.add(d_val);
		}

		// 콤보박스 생성
		cbox_SByear = new JComboBox(SByear_list);
		cbox_SByear.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		cbox_SByear.setBorder(new LineBorder(Color.WHITE, 2, true));

		cbox_SBmonth = new JComboBox(SBmonth_list);
		cbox_SBmonth.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		cbox_SBmonth.setBorder(new LineBorder(Color.WHITE, 2, true));

		cbox_SBday = new JComboBox(SBday_list);
		cbox_SBday.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		cbox_SBday.setBorder(new LineBorder(Color.WHITE, 2, true));

		cbox_SByear.setBounds(116, 149, 60, 26);
		cbox_SBmonth.setBounds(180, 149, 47, 26);
		cbox_SBday.setBounds(230, 149, 47, 26);

		contentPane.add(cbox_SByear);
		contentPane.add(cbox_SBmonth);
		contentPane.add(cbox_SBday);

		txt_SEmail = new JTextField();
		txt_SEmail.setForeground(Color.WHITE);
		txt_SEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SEmail.setColumns(10);
		txt_SEmail.setBounds(116, 187, 186, 26);
		txt_SEmail.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SEmail.setOpaque(false);

		contentPane.add(txt_SEmail);

		txt_SAddress = new JTextField();
		txt_SAddress.setForeground(Color.WHITE);
		txt_SAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SAddress.setColumns(10);
		txt_SAddress.setBounds(116, 225, 254, 60);
		txt_SAddress.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SAddress.setOpaque(false);
		contentPane.add(txt_SAddress);

		lbl_ = new JLabel("-");
		lbl_.setBackground(Color.WHITE);
		lbl_.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setBounds(170, 301, 5, 26);
		contentPane.add(lbl_);

		lbl2_ = new JLabel("-");
		lbl2_.setBackground(Color.WHITE);
		lbl2_.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl2_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2_.setBounds(235, 301, 5, 26);
		contentPane.add(lbl2_);

		txt_SPtel1 = new JTextField();
		txt_SPtel1.setForeground(Color.WHITE);
		txt_SPtel1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SPtel1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SPtel2 = new JTextField();
		txt_SPtel2.setForeground(Color.WHITE);
		txt_SPtel2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SPtel2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txt_SPtel3 = new JTextField();
		txt_SPtel3.setForeground(Color.WHITE);
		txt_SPtel3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_SPtel3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		txt_SPtel1.setColumns(3);
		txt_SPtel2.setColumns(4);
		txt_SPtel3.setColumns(4);

		txt_SPtel1.setBounds(116, 301, 50, 26);
		txt_SPtel2.setBounds(180, 302, 50, 26);

		txt_SPtel3.setBounds(246, 302, 50, 26);

		txt_SPtel1.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SPtel2.setBorder(new LineBorder(Color.WHITE, 2, true));
		txt_SPtel3.setBorder(new LineBorder(Color.WHITE, 2, true));

		txt_SPtel1.setOpaque(false);
		txt_SPtel2.setOpaque(false);
		txt_SPtel3.setOpaque(false);

		contentPane.add(txt_SPtel1);
		contentPane.add(txt_SPtel2);
		contentPane.add(txt_SPtel3);

		/*
		 * txt_SJobok = new JTextField(); txt_SJobok.setColumns(10);
		 * txt_SJobok.setBounds(146, 339, 187, 26); txt_SJobok.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED)); contentPane.add(txt_SJobok);
		 */

		group2 = new ButtonGroup();
		rdbtn_SJobokY = new JRadioButton("예");
		rdbtn_SJobokY.setForeground(Color.WHITE);
		rdbtn_SJobokY.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		rdbtn_SJobokY.setBounds(116, 339, 60, 23);
		rdbtn_SJobokN = new JRadioButton("아니오");
		rdbtn_SJobokN.setForeground(Color.WHITE);
		rdbtn_SJobokN.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		rdbtn_SJobokN.setBounds(180, 339, 100, 23);
		rdbtn_SJobokN.setOpaque(false);
		rdbtn_SJobokY.setOpaque(false);
		group2.add(rdbtn_SJobokY);
		group2.add(rdbtn_SJobokN);

		contentPane.add(rdbtn_SJobokY);
		contentPane.add(rdbtn_SJobokN);

		/*
		 * txt_STNumber = new JTextField();
		 * txt_STNumber.setBackground(Color.LIGHT_GRAY);
		 * txt_STNumber.setForeground(Color.RED); txt_STNumber.setColumns(10);
		 * txt_STNumber.setBounds(146, 377, 69, 26); txt_STNumber.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED)); contentPane.add(txt_STNumber);
		 */

		// 강좌명 추가
		STNlist = new Vector();
		STNlist.add("---선택---");

		try {
			sql = "select t_name from teach";
			rs1 = stmt.executeQuery(sql);

			while (rs1.next()) {
				STNlist.add(rs1.getString("t_name"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// 콤보박스 생성
		cbox_STName = new JComboBox(STNlist);
		cbox_STName.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		cbox_STName.setBorder(new LineBorder(Color.WHITE, 2, true));

		// cbox_STName.setBounds(146, 415, 187, 26);
		cbox_STName.setBounds(116, 377, 250, 26);
		contentPane.add(cbox_STName);

		lbl_SNumber = new JLabel("학생 번호");
		lbl_SNumber.setForeground(Color.WHITE);
		lbl_SNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SNumber.setBounds(43, 44, 61, 16);
		txt_SNumber.setEditable(false);
		contentPane.add(lbl_SNumber);

		lbl_SName = new JLabel("이름");
		lbl_SName.setForeground(Color.WHITE);
		lbl_SName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SName.setBounds(43, 80, 61, 16);
		contentPane.add(lbl_SName);

		lbl_SBirth = new JLabel("생년월일");
		lbl_SBirth.setForeground(Color.WHITE);
		lbl_SBirth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SBirth.setBounds(43, 154, 61, 16);
		contentPane.add(lbl_SBirth);

		lbl_SEmail = new JLabel("이메일");
		lbl_SEmail.setForeground(Color.WHITE);
		lbl_SEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SEmail.setBounds(43, 192, 61, 16);
		contentPane.add(lbl_SEmail);

		lbl_SAddress = new JLabel("주소");
		lbl_SAddress.setForeground(Color.WHITE);
		lbl_SAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SAddress.setBounds(43, 230, 61, 16);
		contentPane.add(lbl_SAddress);

		lbl_SPtel = new JLabel("핸드폰번호");
		lbl_SPtel.setForeground(Color.WHITE);
		lbl_SPtel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SPtel.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SPtel.setBounds(43, 306, 61, 16);
		contentPane.add(lbl_SPtel);

		lbl_SJobok = new JLabel("조기 취업 여부");
		lbl_SJobok.setForeground(Color.WHITE);
		lbl_SJobok.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SJobok.setBounds(24, 342, 80, 16);
		contentPane.add(lbl_SJobok);

		/*
		 * lbl_STNumber = new JLabel("강좌번호"); lbl_STNumber.setFont(new Font("맑은 고딕",
		 * Font.PLAIN, 12)); lbl_STNumber.setHorizontalAlignment(SwingConstants.CENTER);
		 * lbl_STNumber.setBounds(73, 382, 61, 16); contentPane.add(lbl_STNumber);
		 */

		lbl_STName = new JLabel("강좌명");
		lbl_STName.setForeground(Color.WHITE);
		lbl_STName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_STName.setHorizontalAlignment(SwingConstants.CENTER);
		// lbl_STName.setBounds(73, 420, 61, 16);
		lbl_STName.setBounds(43, 382, 61, 16);
		contentPane.add(lbl_STName);

		btn_SInsert = new JButton("신규");
		btn_SInsert.setForeground(Color.WHITE);
		btn_SInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SInsert.setBackground(Color.WHITE);
		btn_SInsert.setBounds(439, 443, 68, 26);
		btn_SInsert.setBorder(new LineBorder(Color.WHITE, 2, true));
		btn_SInsert.setOpaque(false);
		contentPane.add(btn_SInsert);

		btn_SOk = new JButton("확인");
		btn_SOk.setForeground(Color.WHITE);
		btn_SOk.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SOk.setBackground(Color.WHITE);
		btn_SOk.setBounds(519, 443, 68, 26);
		btn_SOk.setBorder(new LineBorder(Color.WHITE, 2, true));
		btn_SOk.setOpaque(false);
		contentPane.add(btn_SOk);

		/*
		 * try { sourceimage = new File("L:/출결_과제/img/235x315.png"); st_img =
		 * ImageIO.read(sourceimage); } catch (IOException e) {
		 * System.out.println("이미지파일이 없습니다."); }
		 * 
		 * JLabel label = new JLabel(new ImageIcon(st_img)); label.setBounds(495, 39,
		 * 235, 315); contentPane.add(label);
		 */
		SIM_label = new JLabel();
		SIM_label.setBounds(495, 39, 235, 315);
		contentPane.add(SIM_label);

		change_img(img_path);
		fileLabel.setForeground(Color.WHITE);

		// 기본 컴포넌트 설정
		fileLabel.setText("파일 경로");
		fileLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		address.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		address.setBorder(new LineBorder(Color.WHITE, 2, true));
		address.setColumns(30);
		btn_SImage.setForeground(Color.WHITE);
		btn_SImage.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SImage.setBorder(new LineBorder(Color.WHITE, 2, true));
		btn_SImage.setText("이미지 삽입");
		btn_SImage.setOpaque(false);

		fileLabel.setBounds(428, 377, 60, 29);
		address.setBounds(495, 377, 186, 29);
		address.setEditable(false);
		address.setBackground(Color.LIGHT_GRAY);
		btn_SImage.setBounds(693, 377, 111, 29);

		contentPane.add(fileLabel);
		contentPane.add(address);
		contentPane.add(btn_SImage);

		btn_SUpdate = new JButton("수정");
		btn_SUpdate.setForeground(Color.WHITE);
		btn_SUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SUpdate.setBackground(Color.WHITE);
		btn_SUpdate.setBounds(679, 443, 68, 26);
		btn_SUpdate.setBorder(new LineBorder(Color.WHITE, 2, true));
		btn_SUpdate.setOpaque(false);
		contentPane.add(btn_SUpdate);

		btn_SFind = new JButton("검색");
		btn_SFind.setForeground(Color.WHITE);
		btn_SFind.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SFind.setBackground(Color.WHITE);
		btn_SFind.setOpaque(false);
		btn_SFind.setBounds(599, 443, 68, 26);

		btn_SFind.setBorder(new LineBorder(Color.WHITE, 2, true));
		contentPane.add(btn_SFind);

		btn_SDelete = new JButton("삭제");
		btn_SDelete.setForeground(Color.WHITE);
		btn_SDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_SDelete.setBackground(Color.WHITE);
		btn_SDelete.setBounds(759, 443, 68, 26);
		btn_SDelete.setBorder(new LineBorder(Color.WHITE, 2, true));
		btn_SDelete.setOpaque(false);
		contentPane.add(btn_SDelete);

		group = new ButtonGroup();
		rdbtn_Man = new JRadioButton("남자");
		rdbtn_Man.setForeground(Color.WHITE);
		rdbtn_Man.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		rdbtn_Man.setBounds(116, 117, 60, 23);
		rdbtn_Woman = new JRadioButton("여자");
		rdbtn_Woman.setForeground(Color.WHITE);
		rdbtn_Woman.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		rdbtn_Woman.setBounds(180, 117, 54, 23);
		rdbtn_Woman.setOpaque(false);
		rdbtn_Man.setOpaque(false);
		group.add(rdbtn_Man);
		group.add(rdbtn_Woman);

		contentPane.add(rdbtn_Man);
		contentPane.add(rdbtn_Woman);

		lbl_SGender = new JLabel("\uC131\uBCC4");
		lbl_SGender.setForeground(Color.WHITE);
		lbl_SGender.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SGender.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_SGender.setBounds(43, 119, 61, 16);
		contentPane.add(lbl_SGender);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Student.class.getResource("/images/SB4.png")));
		lblNewLabel.setBounds(0, 0, 833, 477);
		contentPane.add(lblNewLabel);

		// 초기화
		reset();
	}

	private void addListener() {
		btn_SInsert.addActionListener(this);// 신규버튼
		btn_SOk.addActionListener(this);
		btn_SUpdate.addActionListener(this);// 삭제
		btn_SDelete.addActionListener(this);// 검색
		btn_SFind.addActionListener(this);
		btn_SImage.addActionListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btn_SInsert) {// 신규버튼을
			// 눌렀다면
			if (isInsert == false) { // Insert(신규)버튼을 누르지 않은 상태에서 처음 누른 경우

				resetStudent_motion(true);
				resetStudent_value();

				rdbtn_Man.setSelected(true);

				// 학생번호 마지막 번호+1 자동 입력
				sql = "select s_number from student order by s_number desc";
				try {
					rs1 = stmt.executeQuery(sql);
					if (!rs1.next()) {
						int max_snum = 1;
						txt_SNumber.setText(Integer.toString(max_snum));
					} else {
						int max_snum = rs1.getInt("s_number");
						txt_SNumber.setText(Integer.toString(max_snum + 1));
					}
				} catch (Exception e2) {
					System.out.println("max_snum값 뽑아오기 에러" + e2);
				}

				txt_SNumber.setEditable(false);

				// 신규 등록 시 조기 취업여부는 아니오 고정, 비활성화
				rdbtn_SJobokY.setEnabled(false);
				rdbtn_SJobokN.setEnabled(false);
				rdbtn_SJobokN.setSelected(true); // 라디오버튼 조기취업여부 아니오 체크

				// 확인버튼 활성화
				btn_SOk.setEnabled(true);
				btn_SFind.setEnabled(false);

				// 신규버튼
				isInsert = true;
				btn_SInsert.setText("취소");// 버튼의 이름

			} else {

				// 초기화
				resetStudent_value();
				resetStudent_motion(false);

				isInsert = false;
				btn_SInsert.setText("신규");// 버튼의 이름
				// 확인버튼 활성화
				btn_SOk.setEnabled(false);
				btn_SFind.setEnabled(true);
			}

		} else if (e.getSource() == btn_SOk) {
			inupStudent("insert"); // 데이터 입력시켜주는 메서드
			btn_SInsert.setText("신규");// 버튼의 이름

		} else if (e.getSource() == btn_SFind) { // 검색버튼
			findStudent();

		} else if (e.getSource() == btn_SUpdate) { // 수정버튼
			if (isUpdate == false) { // Insert(신규)버튼을 누르지 않은 상태에서 처음 누른 경우

				resetStudent_motion(true);
				isUpdate = true;
				btn_SUpdate.setText("완료");// 버튼의 이름

			} else {

				isUpdate = false;
				inupStudent("update");
				btn_SUpdate.setText("수정");// 버튼의 이름

			}
		} else if (e.getSource() == btn_SDelete) {
			deleteStudent();
		} else if (e.getSource() == btn_SImage) { // 이미지 삽입 시

			int returnVal = fileChooser.showOpenDialog(frm);
			if (returnVal == JFileChooser.APPROVE_OPTION) {

				// 열기 버튼을 누르면
				File file = fileChooser.getSelectedFile();
				String file_addr = file.toString().replace('\\', '/');
				address.setText(file_addr);

				change_img(file_addr);

			} else {
				// 취소 버튼을 누르면
				address.setText("");
				System.out.println("취소합니다");
			}
		}

		if (e.getSource() == button) {
			CalendarFrame.main(null);
		}
		
		
		
	} // e: ActionPerformed

	// 동작 비활성화
	private void resetStudent_motion(boolean status) {
		cbox_STName.setEnabled(status);
		cbox_SByear.setEnabled(status);
		cbox_SBmonth.setEnabled(status);
		cbox_SBday.setEnabled(status);

		txt_SNumber.setEditable(status);
		txt_SName.setEditable(status);
		txt_SEmail.setEditable(status);
		txt_SAddress.setEditable(status);
		txt_SPtel1.setEditable(status);
		txt_SPtel2.setEditable(status);
		txt_SPtel3.setEditable(status);

		rdbtn_SJobokY.setEnabled(status);
		rdbtn_SJobokN.setEnabled(status);
		rdbtn_Man.setEnabled(status);
		rdbtn_Woman.setEnabled(status);

		btn_SImage.setEnabled(status);
	}

	// null값으로 초기화
	private void resetStudent_value() {
		txt_SNumber.setText(null);
		txt_SName.setText(null);
		txt_SEmail.setText(null);
		txt_SAddress.setText(null);
		txt_SPtel1.setText(null);
		txt_SPtel2.setText(null);
		txt_SPtel3.setText(null);
		address.setText(null);

		rdbtn_SJobokY.setSelected(false);
		rdbtn_SJobokN.setSelected(false);
		rdbtn_Man.setSelected(false);
		rdbtn_Woman.setSelected(false);

		change_img("L:/출결_과제/img/235x315.png");
		cbox_SByear.setSelectedIndex(0);
		cbox_SBmonth.setSelectedIndex(0);
		cbox_SBday.setSelectedIndex(0);
		cbox_STName.setSelectedIndex(0);
	}

	// 초기화
	private void reset() {

		resetStudent_value();
		resetStudent_motion(false);

		btn_SFind.setEnabled(true);
		btn_SOk.setEnabled(false);
		btn_SInsert.setEnabled(true);
		btn_SUpdate.setEnabled(false);
		btn_SDelete.setEnabled(false);
	}

	// 데이터 삽입
	private void inupStudent(String inup_chk) {

		try {

			// 강좌명
			String STName_val = cbox_STName.getSelectedItem().toString();

			// 필수값
			if (txt_SName.getText().equals("")) {
				txt_SName.requestFocus();// 커서
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				return;
			} else if (txt_SEmail.getText().equals("")) {
				txt_SEmail.requestFocus();// 커서
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요");
				return;
			} else if (txt_SAddress.getText().equals("")) {
				txt_SAddress.requestFocus();// 커서
				JOptionPane.showMessageDialog(this, "주소를 입력하세요");
				return;
			} else if (txt_SPtel1.getText().equals("") || txt_SPtel2.getText().equals("")
					|| txt_SPtel3.getText().equals("")) {
				txt_SEmail.requestFocus();// 커서
				JOptionPane.showMessageDialog(this, "핸드폰번호를 입력하세요");
				return;
			} else if (STName_val.equals("---선택---")) {
				cbox_STName.requestFocus();
				JOptionPane.showMessageDialog(this, "강좌명을 선택하세요");
				return;
			} else {

				// 생년월일 가져오기
				String SBirth_val = cbox_SByear.getSelectedItem().toString() + "-"
						+ cbox_SBmonth.getSelectedItem().toString() + "-" + cbox_SBday.getSelectedItem().toString();

				// 핸드폰 번호 가져오기
				String SPtel_val = txt_SPtel1.getText() + "-" + txt_SPtel2.getText() + "-" + txt_SPtel3.getText();

				// 중복 리턴
				sql = "select s_number from student where s_name='" + txt_SName.getText() + "' and s_birth='"
						+ SBirth_val + "'";
				rs1 = stmt.executeQuery(sql);

				if (rs1.next() && inup_chk == "insert") {
					System.out.println(rs1.next());
					System.out.println(sql);
					JOptionPane.showMessageDialog(this, "이미 등록된 학생입니다.");
					return;
				}

				// 성별, 조기취업여부 선택 값 가져오기
				String Sgender_ck;
				String SJbok_ck;

				if (rdbtn_Man.isSelected())
					Sgender_ck = "M";
				else
					Sgender_ck = "W";

				if (rdbtn_SJobokY.isSelected())
					SJbok_ck = "Y";
				else
					SJbok_ck = "N";

				int chk_tnumber = 0;
				try {
					sql = "select t_number from teach where t_name='" + STName_val + "' ";

					System.out.println(sql);

					rs2 = stmt.executeQuery(sql);
					System.out.println(sql);

					rs2.next();
					chk_tnumber = rs2.getInt("t_number");
					System.out.println(chk_tnumber);
					System.out.println("출력넘버!!222");
				} catch (Exception e) {
					System.out.println(e);
				}

				if (inup_chk == "insert") {
					sql = "insert into student values(" + txt_SNumber.getText() + ",'" + txt_SName.getText() + "', '"
							+ Sgender_ck + "', '" + SBirth_val + "', '" + txt_SEmail.getText() + "', '"
							+ txt_SAddress.getText() + "', '" + SPtel_val + "','" + SJbok_ck + "', " + chk_tnumber
							+ ", '" + STName_val + "', '" + address.getText() + "'  )"; /// 이미지

				} else if (inup_chk == "update") {
					sql = "update student set s_name='" + txt_SName.getText() + "', s_gender='" + Sgender_ck
							+ "', s_birth='" + SBirth_val + "', s_email='" + txt_SEmail.getText() + "', s_address='"
							+ txt_SAddress.getText() + "', s_ptel='" + SPtel_val + "', s_jobok='" + SJbok_ck
							+ "', st_number=" + chk_tnumber + ", st_name='" + STName_val + "', st_image='"
							+ address.getText() + "' where s_number=" + txt_SNumber.getText();
				}

				System.out.println(sql);
				/// 삽입

				System.out.println("sql=>" + sql);
				int inup = stmt.executeUpdate(sql);
				System.out.println("데이터 성공유무" + inup + "/" + inup_chk + "=" + sql);

				// 초기화
				reset();

			}
		} catch (Exception e) {
			System.out.println(inup_chk + "메서드 호출시 문제발생" + e);
		}

	}

	private void findStudent() {

		String re = JOptionPane.showInputDialog(this, "검색할 학생번호를 입력하세요");
		if (re == null) {
			return;// 입력하지 않으면 취소
		} else {
			try {

				sql = "select * from student where s_number=" + Integer.parseInt(re);

				System.out.println(sql);
				rs1 = stmt.executeQuery(sql);
				System.out.println(rs1);

				if (rs1.next()) {// 값이 있다면

					// 확인버튼 활성화
					btn_SUpdate.setEnabled(true);

					resetStudent_motion(false);

					txt_SNumber.setText(rs1.getString("s_number"));
					txt_SName.setText(rs1.getString("s_name"));

					if (rs1.getString("s_gender").equals("M"))
						rdbtn_Man.setSelected(true);
					else
						rdbtn_Woman.setSelected(true);

					cbox_SByear.setSelectedItem(Integer.parseInt(rs1.getString("s_birth").substring(0, 4)));
					cbox_SBmonth.setSelectedItem(rs1.getString("s_birth").substring(5, 7));
					cbox_SBday.setSelectedItem(rs1.getString("s_birth").substring(8, 10));

					txt_SEmail.setText(rs1.getString("s_email"));
					txt_SAddress.setText(rs1.getString("s_address"));
					address.setText(rs1.getString("st_image"));

					String[] sptel_arr = rs1.getString("s_ptel").split("-");

					txt_SPtel1.setText(sptel_arr[0]);
					txt_SPtel2.setText(sptel_arr[1]);
					txt_SPtel3.setText(sptel_arr[2]);

					if (rs1.getString("s_jobok").equals("N"))
						rdbtn_SJobokN.setSelected(true);
					else
						rdbtn_SJobokY.setSelected(true);

					cbox_STName.setSelectedItem(rs1.getString("st_name"));

					// 이미지 변경

					change_img(rs1.getString("st_image"));

					btn_SInsert.setEnabled(true);
					btn_SOk.setEnabled(false);
					// btn_SImage.setEnabled(false);

					btn_SUpdate.setEnabled(true);
					btn_SDelete.setEnabled(true);
					btn_SFind.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(this, "검색자료를 찾을 수 없습니다");
				}
			} catch (Exception e) {
				System.out.println("findStudent()메서드 오류=>" + e);
			}
		} // else
	}

	public void findStudent(int snum) {
		try {
			System.out.println("snum=>" + snum);
			sql = "select * from student where s_number=" + snum;

			System.out.println(sql);
			rs1 = stmt.executeQuery(sql);
			System.out.println("rs1=>" + rs1);

			if (rs1.next()) {// 값이 있다면
				// 확인버튼 활성화
				btn_SUpdate.setEnabled(true);

				resetStudent_motion(false);

				txt_SNumber.setText(rs1.getString("s_number"));
				txt_SName.setText(rs1.getString("s_name"));

				if (rs1.getString("s_gender").equals("M"))
					rdbtn_Man.setSelected(true);
				else
					rdbtn_Woman.setSelected(true);

				cbox_SByear.setSelectedItem(Integer.parseInt(rs1.getString("s_birth").substring(0, 4)));
				cbox_SBmonth.setSelectedItem(rs1.getString("s_birth").substring(5, 7));
				cbox_SBday.setSelectedItem(rs1.getString("s_birth").substring(8, 10));

				txt_SEmail.setText(rs1.getString("s_email"));
				txt_SAddress.setText(rs1.getString("s_address"));
				address.setText(rs1.getString("st_image"));

				String[] sptel_arr = rs1.getString("s_ptel").split("-");

				txt_SPtel1.setText(sptel_arr[0]);
				txt_SPtel2.setText(sptel_arr[1]);
				txt_SPtel3.setText(sptel_arr[2]);

				if (rs1.getString("s_jobok").equals("N"))
					rdbtn_SJobokN.setSelected(true);
				else
					rdbtn_SJobokY.setSelected(true);

				cbox_STName.setSelectedItem(rs1.getString("st_name"));

				// 이미지 변경

				change_img(rs1.getString("st_image"));

				btn_SInsert.setEnabled(true);
				btn_SOk.setEnabled(false);
				// btn_SImage.setEnabled(false);

				btn_SUpdate.setEnabled(true);
				btn_SDelete.setEnabled(true);
				btn_SFind.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(this, "검색자료를 찾을 수 없습니다");
			}
		} catch (Exception e) {
			System.out.println("findStudent()메서드 오류=>" + e);
			e.printStackTrace();
		}
	} // else

	private void deleteStudent() {

		int del_chk = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?");

		JOptionPane.showMessageDialog(this, del_chk);
		if (del_chk == 0) {

			try {
				sql = "delete from student where s_number=" + txt_SNumber.getText();

				System.out.println("sql=>" + sql);
				int del = stmt.executeUpdate(sql);
				System.out.println("데이터 삭제 deleteStudent " + sql);

				// 초기화
				isInsert = false;
				reset();
				JOptionPane.showMessageDialog(null, "삭제되었습니다");

			} catch (Exception e) {
				System.out.println("데이터 삭제 deleteStudent" + e);
			}

		} else {
			return;// 입력하지 않으면 취소
		}

	}

	// 이미지 변경 메소드
	public void change_img(String img_pa) {

		System.out.println(img_pa);
		ImageIcon image = new ImageIcon(img_pa);

		SIM_label.setIcon(image);

	}
}