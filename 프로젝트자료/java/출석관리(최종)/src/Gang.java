import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Gang extends JFrame implements ActionListener {

   private static final Color Color = null;
   private JFrame frame;
   private JLabel BackgroundC;
   private JTable tab;
   private JTextField textField;
   JButton btnSearch;
   DefaultTableModel mod;
   // DB
   private Connection conn;
   private Statement stmt;
   private ResultSet rs1, rs2, rs3;
   String sql = null;
   String [][]data=new String[0][2];
   String []cols={"강좌명","번호","학생명"}; 
   private JButton btnJava;
   private JButton btnBig;
   private JButton btnJungbo;
   private JButton btnLast;
   private JButton btnfind;
   private JButton btnreset;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Gang window = new Gang();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   public Gang() {
      accDb();
      initialize();
      addListener();
   }
   private void initialize() {
      frame = new JFrame();
         frame.getContentPane().setBackground(Color.BLACK);
         frame.setBounds(100, 100, 849, 515);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().setLayout(null);
         frame.setResizable(false);
         
         btnreset = new JButton("초기화");
         btnreset.setBounds(479, 125, 73, 30);
         btnreset.setForeground(Color.WHITE);
         btnreset.setBorder(javax.swing.BorderFactory.createEmptyBorder());
         btnreset.setOpaque(false);
         btnreset.setFont(new Font("맑은 고딕", Font.BOLD, 13));
         btnreset.setBorder(new BevelBorder(BevelBorder.RAISED));
         btnreset.setBackground(Color.WHITE);
         frame.getContentPane().add(btnreset);
         
         btnJava = new JButton("자바개발");
         btnJava.setBounds(44, 23, 174, 65);
         btnJava.setForeground(Color.WHITE);
         btnJava.setBorder(new LineBorder(Color.WHITE, 4, true));
         btnJava.setOpaque(false);
         btnJava.setFont(new Font("맑은 고딕", Font.BOLD, 28));
         btnJava.setBackground(Color.WHITE);
         frame.getContentPane().add(btnJava);
         
         btnJungbo = new JButton("정보보안");
         btnJungbo.setBounds(416, 23, 174, 65);
         btnJungbo.setForeground(Color.WHITE);
         btnJungbo.setBorder(new LineBorder(Color.WHITE, 4, true));
         btnJungbo.setOpaque(false);
         btnJungbo.setFont(new Font("맑은 고딕", Font.BOLD, 28));
         btnJungbo.setBackground(Color.WHITE);
         frame.getContentPane().add(btnJungbo);
         
         btnBig = new JButton("빅데이터");
         btnBig.setBounds(230, 23, 174, 65);
         btnBig.setForeground(Color.WHITE);
         btnBig.setBorder(new LineBorder(Color.WHITE, 4, true));
         btnBig.setOpaque(false);
         btnBig.setFont(new Font("맑은 고딕", Font.BOLD, 28));
         btnBig.setBackground(Color.WHITE);
         frame.getContentPane().add(btnBig);
         
         btnLast = new JButton("증강현실");
         btnLast.setBounds(602, 23, 174, 65);
         btnLast.setForeground(Color.WHITE);
         btnLast.setBorder(new LineBorder(Color.WHITE, 4, true));
         btnLast.setOpaque(false);
         btnLast.setFont(new Font("맑은 고딕", Font.BOLD, 28));
         btnLast.setBackground(Color.WHITE);
         frame.getContentPane().add(btnLast);
         
         btnfind = new JButton("학생조회");
         btnfind.setBounds(479, 437, 75, 25);
         btnfind.setForeground(Color.WHITE);
         btnfind.setBorder(javax.swing.BorderFactory.createEmptyBorder());
         btnfind.setOpaque(false);
         btnfind.setFont(new Font("맑은 고딕", Font.BOLD, 13));
         btnfind.setBorder(new BevelBorder(BevelBorder.RAISED));
         btnfind.setBackground(Color.WHITE);
         frame.getContentPane().add(btnfind);
         btnfind.setVisible(false);
         
         btnSearch = new JButton("조회");
         btnSearch.setBounds(434, 125, 43, 30);
         btnSearch.setForeground(Color.WHITE);
         btnSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
         btnSearch.setOpaque(false);
         btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 13));
         btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED));
         btnSearch.setBackground(Color.WHITE);
         frame.getContentPane().add(btnSearch);
         
         // textfield 이벤트
         textField = new JTextField();
         textField.setHorizontalAlignment(SwingConstants.CENTER);
         textField.setBounds(280, 127, 142, 30);
         textField.setBorder(new LineBorder(Color.WHITE));
         textField.setBorder(new BevelBorder(BevelBorder.LOWERED));
         frame.getContentPane().add(textField);
         textField.setColumns(10);
         
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(280, 169, 274, 258);
         scrollPane.setBorder(new LineBorder(Color.WHITE, 3, true));
         scrollPane.setOpaque(false);
         
         frame.getContentPane().add(scrollPane);
         
         mod=new DefaultTableModel(data,cols){ 
             public boolean isCellEditable(int rowIndex, int mColIndex) {
               return false; //내용 수정불가
            }
            };
      tab=new JTable(mod);
      tab.getColumnModel().getColumn(0).setPreferredWidth(150);
      tab.getColumnModel().getColumn(1).setPreferredWidth(10);
      tab.getColumnModel().getColumn(2).setPreferredWidth(10);
      tab.setSelectionBackground(Color.green);

         scrollPane.setViewportView(tab);
         
         
         
         tab.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                int mRow=tab.rowAtPoint(e.getPoint());
                if(mRow>=0) {
                   if(e.getClickCount()==2) {
                      //System.out.println(mRow);
                      try {
                         new Student(Integer.parseInt((String)(mod.getValueAt(tab.getSelectedRow(),1))));
                      } catch (Exception e3) {
                         // TODO Auto-generated catch block
                         e3.printStackTrace();
                      }
                      
                   }
                }
             }
          });

         BackgroundC = new JLabel("");
         BackgroundC.setIcon(new ImageIcon(Gang.class.getResource("/images/SB4.png")));
//        BackgroundC.setIcon(new ImageIcon(Gang.class.getResource("192.168.0.49/images/SB4.png")));
//         BackgroundC.setIcon(new ImageIcon(Gang.class.getResource("192.168.0.49/images/GB.png")));
         BackgroundC.setBounds(0, 0, 849, 493);
         frame.getContentPane().add(BackgroundC);
      }
   private void accDb() {
      try {
         // 1.접속할 드라이버를 메모리에 올리기
         Class.forName("oracle.jdbc.driver.OracleDriver");
          String url = "jdbc:oracle:thin:@192.168.0.14:1521:orcl";
         // 2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
         conn = DriverManager.getConnection(url, "scott", "tiger");
         // 추가 (신규,수정->레코드이동->자동으로 스크롤 이동시 수정이 반영)
         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
         System.out.println("접속conn=>" + conn);
      } catch (Exception e) {
         System.out.println("DB접속 오류=>" + e);
      }
      
   }
   private void reset() {
      mod.setNumRows(0);
      btnfind.setVisible(false);
   }
   
   
   private void addList(String st_name) {
      try {
         mod.setNumRows(0);
         sql = "select ST_NAME,S_NAME,S_NUMBER from student where st_name Like '%" + st_name+ "%' ORDER BY ST_NAME";
         System.out.println(sql);
         rs1 = stmt.executeQuery(sql);
         if(!rs1.next()) {
            JOptionPane.showMessageDialog
            (this,"강좌명을 정확하게 입력해주세요.");
            return;
         }
         rs1.previous();
         while (rs1.next()) {
            String[] imsi = { 
                  rs1.getString("ST_NAME"), 
                  rs1.getString("S_NUMBER"),
                  rs1.getString("S_NAME")
            };
            mod.addRow(imsi);
         }
         btnfind.setVisible(true);
      } catch (Exception e2) {
         System.out.println("리스트 에러유발=>" + e2);
      }
   }
   
   private void addListener() {
      btnSearch.addActionListener(this);// 출석버튼
      textField.addActionListener(this);
      btnLast.addActionListener(this); //증강현실
      btnJungbo.addActionListener(this); //정보보안
      btnBig.addActionListener(this); //빅데이터
      btnJava.addActionListener(this); //자바개발  
      btnfind.addActionListener(this);
      btnreset.addActionListener(this);
   }
   
   

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if ((e.getSource() == btnSearch)||(e.getSource() == textField)) {
          addList(textField.getText());
      }if (e.getSource()==btnBig) {
         addList("빅데이터 분석 및 자바 딥러닝");
      }if (e.getSource()==btnJungbo) {
         addList("ICT기반 정보시스템 보안엔지니어 양성");
      }if (e.getSource()==btnLast) {
         addList("가상현실VR");
      }if (e.getSource()==btnJava) {
         addList("프론트엔드 개발 및");
      }if (e.getSource()==btnfind) {
         int snum  = Integer.parseInt((String)(mod.getValueAt(tab.getSelectedRow(),1)));
          new Student(snum);//Student st1=new Student(snum);
      }if (e.getSource()==btnreset) {
         reset();
      }
       
   }
} 