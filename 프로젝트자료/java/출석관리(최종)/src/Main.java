import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


class Timer implements Runnable { 
   JLabel timertxt; 
   public Timer(JLabel timertxt) { 
      this.timertxt = timertxt; 
   }
   @Override 
   public void run() { 
      while (true) { 
         Calendar c = Calendar.getInstance(); 
         int hour = c.get(Calendar.HOUR_OF_DAY); 
         int min = c.get(Calendar.MINUTE); 
         int second = c.get(Calendar.SECOND); 
         String clockText = Integer.toString(hour); 
         clockText = clockText.concat(":"); 
         clockText = clockText.concat((min < 10) ? "0" + Integer.toString(min) : Integer.toString(min)); 
         clockText = clockText.concat(":"); 
         clockText = clockText.concat((second < 10) ? "0" + Integer.toString(second) : Integer.toString(second)); 
         timertxt.setText(clockText); 
         try { 
            Thread.sleep(1000); 
         }  
         catch (InterruptedException e) { 
            return; 
         } 
      } 
   } 
} 

public class Main extends JFrame implements ActionListener{

   private JPanel contentPane;
   static JTextField txt_MOk;
   static private JLabel txt_Field,txt_Field2,timertxt;
   JButton btn_MOk;

   //DB
   private Connection conn;
   private static Statement stmt;
   private static ResultSet rs1;
   private static ResultSet rs2;
   static String sql=null;
   String st_Name;
static String leave;
   static String systime;
   static int sysdate,a_stime,a_etime;
   private int snum;
   static boolean attyn = true;
   
   Thread th; 

   static String s_Name;
   
   /**
    * Launch the application.
    */
   
   public Main() {
      accDb();
      design();
      addListener();
      /*addActionListener(new WindowAdapter() {
      	@Override
      	public void windowClosing(WindowEvent e) {
      		// TODO Auto-generated method stub
      		if(rs1!=null) rs1.close();
      		if(stmt!=null) stmt.close();
      		if(conn!=null) conn.close();
      	}
      });*/
  
      Timer runnable = new Timer(timertxt); 
      th = new Thread(runnable); 
      th.start(); 
   }
   private void accDb() {
      try {
          //1.접속할 드라이버를 메모리에 올리기j
          Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.0.14:1521:orcl";
         //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
         conn=DriverManager.getConnection(url, "scott", "tiger");
         //추가 (신규,수정->레코드이동->자동으로 스크롤 이동시 수정이 반영)
         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                  ResultSet.CONCUR_UPDATABLE);
         System.out.println("접속conn=>"+conn);
      }catch(Exception e) {
         System.out.println("DB접속 오류=>"+e);
      }
   }

   private void design() {
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 849, 515);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      setResizable(false);
      contentPane.setLayout(null);

      btn_MOk = new JButton("출석");
      
     
      timertxt = new JLabel("현재시각");
      timertxt.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      timertxt.setHorizontalAlignment(SwingConstants.CENTER);
      timertxt.setBounds(675, 8, 161, 35);
      timertxt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      timertxt.setOpaque(false);
      contentPane.add(timertxt);
      txt_Field = new JLabel("[ WELCOME ]");
      txt_Field.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      txt_Field.setHorizontalAlignment(SwingConstants.CENTER);
      txt_Field.setBounds(23, 86, 808, 88);
      txt_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      txt_Field.setOpaque(false);
      contentPane.add(txt_Field);
      
      txt_Field2 = new JLabel("");
      txt_Field2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      txt_Field2.setHorizontalAlignment(SwingConstants.CENTER);
      txt_Field2.setBounds(23, 40, 785, 74);
      txt_Field2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      txt_Field2.setOpaque(false);
      contentPane.add(txt_Field2);

      btn_MOk.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
      btn_MOk.setBorder(new BevelBorder(BevelBorder.RAISED));
      btn_MOk.setBackground(Color.WHITE);
      btn_MOk.setBounds(505, 209, 84, 29);
      btn_MOk.setOpaque(false);
      contentPane.add(btn_MOk);

      txt_MOk = new JTextField("학생이름을 입력하세요.");
      txt_MOk.addFocusListener(new FocusAdapter() {
         @Override
         public void focusLost(FocusEvent arg0) {
            txt_MOk.setText("학생이름을 입력하세요");
            txt_MOk.setForeground(Color.GRAY);
         }
      });
      txt_MOk.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txt_MOk.setText("");
         }
      });
      txt_MOk.setForeground(Color.GRAY);
      
      txt_MOk.setHorizontalAlignment(SwingConstants.CENTER);
      txt_MOk.setBounds(257, 209, 225, 30);
      txt_MOk.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      txt_MOk.setBorder(new BevelBorder(BevelBorder.LOWERED));
      contentPane.add(txt_MOk);
      txt_MOk.setColumns(10);
      
      JLabel txt_Mname = new JLabel();
      txt_Mname.setBackground(Color.WHITE);
      txt_Mname.setFont(new Font("Verdana", Font.BOLD, 45));
      txt_Mname.setHorizontalAlignment(SwingConstants.CENTER);
      txt_Mname.setForeground(Color.WHITE);
      txt_Mname.setBounds(225, 86, 410, 88);
      contentPane.add(txt_Mname);

      
      JButton btn_Mstudent = new JButton("");
      btn_Mstudent.setBackground(Color.WHITE);
      btn_Mstudent.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            Student.main(null);
         }
      });
      btn_Mstudent.setIcon(new ImageIcon(Main.class.getResource("/images/IdCard.png")));
      btn_Mstudent.setBounds(447, 268, 142, 131);
      btn_Mstudent.setBorderPainted(false);
      btn_Mstudent.setContentAreaFilled(false);
      btn_Mstudent.setFocusPainted(false);
      contentPane.add(btn_Mstudent);

      JButton btn_Teach = new JButton("");
      btn_Teach.setBackground(Color.WHITE);
      btn_Teach.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            Gang.main(null);

         }
      });

      btn_Teach.setIcon(new ImageIcon(Main.class.getResource("/images/mul.png")));
      btn_Teach.setBounds(251, 268, 142, 131);
      btn_Teach.setBorderPainted(false);
      btn_Teach.setContentAreaFilled(false);
      btn_Teach.setFocusPainted(false);
      contentPane.add(btn_Teach);

      JLabel classL = new JLabel("강좌 리스트");
      classL.setBackground(Color.WHITE);
      classL.setForeground(Color.BLACK);
      classL.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      classL.setHorizontalAlignment(SwingConstants.CENTER);
      classL.setBounds(261, 411, 121, 30);
      contentPane.add(classL);

      JLabel memberL = new JLabel("회원 관리");
      memberL.setBackground(Color.WHITE);
      memberL.setForeground(Color.BLACK);
      memberL.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      memberL.setHorizontalAlignment(SwingConstants.CENTER);
      memberL.setBounds(457, 411, 121, 30);
      contentPane.add(memberL);

      JLabel BackgroundM = new JLabel("");
      BackgroundM.setIcon(new ImageIcon(Main.class.getResource("/images/Back.png")));
      BackgroundM.setBounds(0, 0, 843, 487);
      contentPane.add(BackgroundM);
      
      
      
      
   }
     private void addListener() {
        btn_MOk.addActionListener(this);//출석버튼
        txt_MOk.addActionListener(this);//이름을 입력하세요 버튼
        
      }
     //출석 넣기
     static void addAttend(int snum,String st_Name) {
        nowDateTime();
        //출석 시간과 퇴실 시간 불러오기
        try{ sql="select a_number,to_char(a_stime,'YYYYMMDD'),to_char(a_etime,'YYYYMMDD') from attend "
                 +"where as_number = "+snum;
                 rs1=stmt.executeQuery(sql); 
                 if(!rs1.next()) {
                    a_stime=0;
                    a_etime=0;
                 }
                 a_stime=rs1.getInt("to_char(a_stime,'YYYYMMDD')");
                 a_etime=rs1.getInt("to_char(a_etime,'YYYYMMDD')");
           }catch(SQLException e){
              System.out.println("출석유무를 확인하는 구문의 오류발생"+e);
           }
        //출석을 하자!
           if(sysdate != a_stime) {
           try {     sql="insert into attend values("+"sq_AttNum.nextval" //출석번호
                     +",(select s_number from student where s_number="+snum+")" //학생고유번호
                     +",'"+s_Name //이름
                     +"',(select st_number from student where s_number="+snum+")" //강좌고유번호
                     +",(select st_name from student where s_number="+snum+")"  //강좌명
                     +",sysdate" //출석처리
                     +",null" //아직 퇴실처리 x
                     +",to_char(sysdate,'YYYY')" //년
                     +",to_char(sysdate,'MM')" //월
                     +",to_char(sysdate,'DD')" //일
                     +",Null"
                     +",'Y')";  
                int insert=stmt.executeUpdate(sql); //1->성공, 0->실패
                System.out.println(sql);
                System.out.println(insert);
                txt_Field.setText(s_Name+"님! "+
                        systime+ " 출석 되었습니다");
                        txt_Field2.setText(st_Name);
                     txt_MOk.setForeground(Color.GRAY);
             }catch(Exception e) {
                System.out.println("출석넣기 오류발생=>"+e);
             }
           }
           else if((sysdate == a_stime)&&(sysdate!=a_etime)){
              if(!attyn) {
               leave =JOptionPane.showInputDialog("퇴실시간보다 이릅니다.\n조퇴사유를 말씀해주세요.");
              }
               try {     sql="update attend set a_etime=sysdate,"
                     + "a_leave='"+leave
                     +"' where as_number = "+snum //학생번호
                     //오늘날짜의 시간만 변경하기위한 조건문
                     + " and to_char(a_stime,'YYYY-MM-DD')=(select to_char(sysdate,'YYYY-MM-DD') from dual)";
                   int update2=stmt.executeUpdate(sql);
                   System.out.println(sql);
                    txt_Field.setText(s_Name+"님! "+
                         systime+ " 퇴실 되었습니다");
                         txt_Field2.setText(st_Name);
                         txt_MOk.setForeground(Color.GRAY);
                    
                 }catch(Exception e) {
                    System.out.println("퇴실하기 오류발생=>"+e);
                 }
              //출석 퇴실이 전부되어있다! 
            }else if((sysdate == a_stime)&&(sysdate == a_etime)){
               JOptionPane.showMessageDialog(null,"이미 퇴실처리가 되어있습니다");
            }
             System.out.println("시스템데이트 : "+sysdate);
           System.out.println("출결시작 : "+a_stime);
           System.out.println("퇴실시작 : "+a_etime);
     }
     private static void nowDateTime() {
        try {
             sql="select to_char(sysdate,'HH24MI'),to_char(sysdate,'YYYYMMDD') from dual";  
             rs2=stmt.executeQuery(sql); //1->성공, 0->실패
             rs2.next();
             int hh = Integer.parseInt(rs2.getString("to_char(sysdate,'HH24MI')").substring(0,2));
             int mm = Integer.parseInt(rs2.getString("to_char(sysdate,'HH24MI')").substring(2,4));
             
             if((hh<18)||(hh==18)&&(mm<=30)) {attyn = false;} //오후6시30분전에 퇴실시 조퇴사유묻기
             else {attyn = true;} // 평소
             
             
             //AM & PM 처리 
             String ap_chk = "AM";
             String s_mm = Integer.toString(mm);
             if (hh>12) ap_chk = "PM";
             if (hh>12) hh = hh- 12;
             String s_hh = Integer.toString(hh);
             if (mm <10) s_mm = "0"+ s_mm;
             if (hh <10) s_hh = "0"+ s_hh;
             systime = ap_chk+s_hh+":"+s_mm;
             
             sysdate = Integer.parseInt (rs2.getString("to_char(sysdate,'YYYYMMDD')"));
          
        }catch(Exception e) {
             System.out.println("nowDateTime()메서드 오류발생=>"+e);
          }
     } 
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      //출석 버튼 클릭 및 엔터치면나오게하는 구문
         if ((e.getSource() == btn_MOk)||(e.getSource() == txt_MOk)) {
            if(txt_MOk.getText()=="") {
               JOptionPane.showMessageDialog(this, "이름을 입력하세요");
               txt_MOk.setText("이름을 입력하세요");
               return;
            }else {
               try {
                   sql="select S_NAME,S_NUMBER,ST_NAME from student where S_NAME='"+txt_MOk.getText()+"' " ;  
                   System.out.println("insert sql=>"+sql);
                   rs1=stmt.executeQuery(sql); //1->성공, 0->실패
                   
                   if(!rs1.next()) {
                     JOptionPane.showMessageDialog
                     (this,"등록된 이름이 없습니다!\n다시 입력하세요");
                     txt_MOk.setText(null);
                     txt_Field2.setText(" ");
                     txt_Field.setText("[ WELCOME ]");
                     rs1.close();
                     return;
                  }
                   st_Name = rs1.getString("ST_NAME");
                   s_Name = rs1.getString("S_NAME");
                   
                   if(!rs1.next()) {//한번더 불렀는데 없다면(테이블의 값이 1개뿐이라면)
                      rs1.previous();
                      snum = Integer.parseInt(rs1.getString("S_NUMBER"));
                      System.out.println(s_Name);
                      addAttend(snum,st_Name);
                   }else {
                       JOptionPane.showMessageDialog(null,"중복된 이름이 있습니다. 선택화면으로 넘어갑니다");
                       Namelist.main(null);
                   }
                }catch(Exception e2) {
                   System.out.println("출석 오류발생=>"+e2);
                }   
            }
         }
   }
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}