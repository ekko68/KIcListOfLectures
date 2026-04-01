import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class Namelist implements ActionListener{

   private static final Color Color = null;
   private JFrame frame;
   private JLabel BackgroundC;
   private JTable table;
   
   JButton btnAttend;
   JTable tab;
   String [][]data=new String[0][3];
   String []cols={"번호","이름","과목","생년월일"}; ;
   String sname,stname;
   //추가
   static JFrame overlapname;
   DefaultTableModel mod;
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   String sql=null;
   int snum;
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Namelist window = new Namelist();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   public Namelist() {
      initialize();
      accDb();
      addListener();
   }
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.BLACK);
      frame.setBounds(100, 100, 849, 515);
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.setResizable(false);
      
      btnAttend = new JButton("출석");
      btnAttend.setForeground(Color.WHITE);
      btnAttend.setBounds(277, 363, 297, 48);
      btnAttend.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      btnAttend.setOpaque(false);
      btnAttend.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
      btnAttend.setBorder(new BevelBorder(BevelBorder.RAISED));
      btnAttend.setBackground(Color.WHITE);
      frame.getContentPane().add(btnAttend);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
      scrollPane.setBounds(277, 108, 297, 256);
      frame.getContentPane().add(scrollPane);
      

      
      //테이블부분
      
      //DefaultTableModel이 가지고 있는 메서드
      mod=new DefaultTableModel(data,cols){ 
             public boolean isCellEditable(int rowIndex, int mColIndex) {
               return false; //내용 수정불가
            }
            };
      tab=new JTable(mod);
      tab.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
      tab.getColumnModel().getColumn(0).setPreferredWidth(10);
      tab.getColumnModel().getColumn(1).setPreferredWidth(30);
      tab.getColumnModel().getColumn(2).setPreferredWidth(100);
      tab.getColumnModel().getColumn(3).setPreferredWidth(50);
      tab.setSelectionBackground(Color.green);
      
      
      tab.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
             // TODO Auto-generated method stub
             int mRow=tab.rowAtPoint(e.getPoint());
             if(mRow>=0) {
                if(e.getClickCount()==2) {
                   //System.out.println(mRow);
                   try {
                      snum  = Integer.parseInt((String)(mod.getValueAt(tab.getSelectedRow(),0)));
                       stname = (String)mod.getValueAt(tab.getSelectedRow(),2);
                       Main.addAttend(snum,stname);
                       frame.setVisible(false);
                       frame=null;
                   } catch (Exception e3) {
                      // TODO Auto-generated catch block
                      e3.printStackTrace();
                   }
                }
             }
          }
       });
      scrollPane.setViewportView(tab);
      
      BackgroundC = new JLabel("");
      BackgroundC.setIcon(new ImageIcon(Namelist.class.getResource("/images/Background.png")));
      BackgroundC.setBounds(0, 0, 843, 487);
      frame.getContentPane().add(BackgroundC);
   }
   private void accDb() {
      try {
          //1.접속할 드라이버를 메모리에 올리기
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
          String url = "jdbc:oracle:thin:@192.168.0.14:1521:orcl";
         //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
         conn=DriverManager.getConnection(url, "scott", "tiger");
         //추가 (신규,수정->레코드이동->자동으로 스크롤 이동시 수정이 반영)
         stmt=conn.createStatement();
         System.out.println("접속conn=>"+conn);
         insertList(Main.s_Name);
      }catch(Exception e) {
         System.out.println("DB접속 오류=>"+e);
      }
      //일반메서드->다른 일반메서드 호출
      
   }
   private void addListener() {
      btnAttend.addActionListener(this);//이름을 입력하세요 버튼
      }
   private void insertList(String namename) {
   try {
      sql="select S_NAME,S_NUMBER,ST_NAME,S_BIRTH from student where S_NAME='"+namename+"'" ; 
      rs = stmt.executeQuery(sql);
       while(rs.next()) {
          String [] imsi= {
                rs.getString("S_NUMBER"),
                rs.getString("S_NAME"),
                rs.getString("ST_NAME"),
                rs.getString("S_BIRTH").substring(0,10) //생일만 뽑아오기
          };
          mod.addRow(imsi);
    }
   }catch(Exception e2) {
      System.out.println("daeDisplay() 에러유발=>"+e2);
   }
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if ((e.getSource() == btnAttend)){
         //선택한 행,1번째 열의 결과값얻어오기 (= 학생번호 얻어오기)
//         System.out.println(mod.getValueAt(tab.getSelectedRow(),0));
         snum  = Integer.parseInt((String)(mod.getValueAt(tab.getSelectedRow(),0)));
         stname = (String)mod.getValueAt(tab.getSelectedRow(),2);
         Main.addAttend(snum,stname);
         frame.setVisible(false);
         frame=null;
      }
   }
   }