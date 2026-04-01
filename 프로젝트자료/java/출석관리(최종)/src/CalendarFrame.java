
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;




public class CalendarFrame extends Frame implements ActionListener {

   // (2) 고객DB정보 저장
   Connection conn;
   Statement stmt;// SQL문

   // 결석 지각/조퇴
   ResultSet rs1, rsk, rsj;// select->표형태
   String sql = null;// sql구문

   // 학생 고유 번호
   int stnumber;

   FlowLayout tf1 = new FlowLayout(FlowLayout.LEFT, 3, 4);
   GridLayout glt = new GridLayout(2, 1);

   FlowLayout f = new FlowLayout(FlowLayout.LEFT, 3, 5);
   GridLayout gl = new GridLayout(1, 7);
   Calendar nowcal = Calendar.getInstance();

   // 현재 날짜 받기
   int year = nowcal.get(Calendar.YEAR);
   int month = nowcal.get(Calendar.MONTH);

   // 현재 년도, 월, 일
   int hyear = nowcal.get(Calendar.YEAR);
   int hmonth = nowcal.get(Calendar.MONTH) + 1;
   int hday = nowcal.get(Calendar.DATE);

   // 현재 일자 문자로 변경
   String shyear = Integer.toString(hyear);
   String shmonth = Integer.toString(hmonth);
   String shday = Integer.toString(hday);

   // 배치관리자 중복사용을 위한 Panel
   Panel top1 = new Panel();
   Panel top2 = new Panel();

   Panel selectPanel = new Panel();
   Panel labelPanel = new Panel();
   Panel dayPanel[] = new Panel[6];

   // 년월선택및 확인 컴포넌트
   Choice cyear = new Choice();
   Choice cmonth = new Choice();

   Label lyear = new Label("년");
   Label lmonth = new Label("월");
   Button bt = new Button("확인");

   // 요일 컴포넌트
   Label l[] = new Label[7];

   // 날자 컴포넌트
   Label lday[] = new Label[32];

   // 레이블 추가
   private static JTextField tf_stnumber;
   private static JTextField tf_stname;

   // 출석일수, 전체일수, 출석률, 지각일수, 조퇴일수, 결석일수
   int asnumber, cnum, allnum, jinum, jonum, knum, tnum, inum;
   String asname, lbl_t1, lbl_t2;

   // 년도, 월
   String j_year, j_month;

   JLabel lbl1_val = new JLabel();
   JLabel lbl2_val = new JLabel();

   public CalendarFrame() {
      accDb();

      JLabel label = new JLabel("번호 :");
      label.setBounds(12, 13, 39, 15);

      tf_stnumber = new JTextField();
      tf_stnumber.setText("");
      tf_stnumber.setBounds(12, 10, 23, 21);
      tf_stnumber.setColumns(3);
      tf_stnumber.setEditable(false);

      tf_stname = new JTextField();
      tf_stname.setText("");
      tf_stname.setColumns(6);
      tf_stname.setBounds(123, 10, 52, 21);
      tf_stname.setEditable(false);

      JLabel label_1 = new JLabel("이름 :");
      label_1.setBounds(85, 13, 39, 15);

      top1.setLayout(tf1);
      top1.add(label);
      top1.add(tf_stnumber);
      top1.add(label_1);
      top1.add(tf_stname);

      add(top1);



      // 년 초이스 컴포넌트
      for (int i = 2010; i < 2018; i++) {
         String year = " " + i;
         cyear.add(year);
      }

      // 월 초이스 컴포넌트
      for (int i = 1; i < 13; i++) {
         String month = " " + i;
         cmonth.add(month);
      }

      // 버튼 액션리스너 설정
      bt.addActionListener(this);

      // 요일 컴포넌트
      String lstr[] = { "  일", "월", "화", "수", "목", "금", "토" };

      for (int i = 0; i < 7; i++) {
         l[i] = new Label(lstr[i]);
      }

      // 날짜 컴포넌트
      lday[0] = new Label(" ");

      for (int i = 1; i < lday.length; i++) {
         String sday = " ";
         if (i < 10)
            sday = "   " + i;
         else
            sday = " " + i;

         lday[i] = new Label(sday);
         lday[i].setSize(5, 5);

      }

      cyear.select(year - 2010);
      cmonth.select(month);

      // 년월일및확인 컴포넌트 배치
      selectPanel.setLayout(f);
      selectPanel.add(cyear);
      selectPanel.add(lyear);
      selectPanel.add(cmonth);
      selectPanel.add(lmonth);
      selectPanel.add(bt);

      add(selectPanel);

      // 요일컴포넌트배치
      labelPanel.setLayout(gl);
      for (int i = 0; i < l.length; i++) {
         labelPanel.add(l[i]);
      }

      add(labelPanel);

      String stnumber_chk = JOptionPane.showInputDialog("조회하고자하는 학생 번호를 입력해주세요");
      this.stnumber = Integer.parseInt(stnumber_chk);

      try {
         sql = "select * from attend where as_number=" + stnumber;
         rs1 = stmt.executeQuery(sql);

         System.out.println(sql);
         // 번호, 이름, 첫번째라벨, 두번째라벨

         if (rs1.next()) {
            asnumber = rs1.getInt("as_number");
            asname = rs1.getString("as_name");

            System.out.println(asnumber);
            System.out.println(asname);

            tf_stnumber.setText(Integer.toString(asnumber));
            tf_stname.setText(asname);
         } else {
            JOptionPane.showMessageDialog(this, "해당 학생 번호가 존재하지않습니다");
            return;

         }
      } catch (Exception e) {
         System.out.println("번호,이름" + e);
      }

      // 날짜 컴포넌트 배치 메소드 호출
      daytext(year, month, this.stnumber);
      
      top2.setLayout(glt);
      top2.add(lbl1_val);
      top2.add(lbl2_val);

      // 프레임설정
      setSize(235, 350);
      setVisible(true);
      setLayout(f);


      
      addWindowListener(new WindowAdapter() {
    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	       // TODO Auto-generated method stub
    	    	 setVisible(false);
    	        
    	    }
    	 });
      
      
      
      
   }

   public void daytext(int year, int month, int stnumber) {

      Calendar setcal = Calendar.getInstance();
      setcal.set(year, month, 1);

      // 그달의 첫번째날의 요일 받기
      int firstday = setcal.get(Calendar.DAY_OF_WEEK);

      // 그달의 마지막날 받기
      int lastday = setcal.getActualMaximum(Calendar.DAY_OF_MONTH);

      // 날짜 인덱스
      int dayindex = 1;
      int sunday = 1;

      // int saturday;

      // 배치
      dayPanel[0] = new Panel();
      dayPanel[0].setLayout(new GridLayout(6, 7));

      // 폰트

      // Font redfont = new Font("",Color.red);

      // 1일이 되기전 공백 채우기

      for (int i = 1; i < firstday; i++) {
         dayPanel[0].add(new Label("  "));
         sunday++;
      }

      // DB값 체크

      String syear = Integer.toString(year);
      String smonth = Integer.toString(month + 1);

      if (month < 10) {
         smonth = "0" + smonth;
      }

      // 금일 월, 일
      if (hmonth < 10) {
         shmonth = "0" + Integer.toString(hmonth);
      }
      if (hday < 10) {
         shday = "0" + Integer.toString(hday);
      }

      // 금일 년월일
      int hymd = Integer.parseInt(shyear + shmonth + shday);

      // 1일 부터 날짜 채우기
      // 배경색상 변경

      int cnum = 0;
      int allnum = 0;
      int jinum = 0;
      int jonum = 0;
      int knum = 0;
      int tnum = 0;
      int inum = 0;

      for (int j = 0; j < lastday; j++) {
         lday[dayindex].setBackground(Color.WHITE);

         if (sunday % 7 == 1) {
            lday[dayindex].setForeground(Color.red);
            inum++;
         } else if (sunday % 7 == 0) {
            lday[dayindex].setForeground(Color.blue);
            tnum++;
         } else {
            lday[dayindex].setForeground(Color.black);

            // 현재 선택 일자
            String sday = Integer.toString(j + 1);
            if (j < 9) {
               sday = "0" + Integer.toString(j + 1);
            }
            // System.out.println(sday);

            // 현재선택 년월일
            int ymd = Integer.parseInt(syear + smonth + sday);

            // 번호, 이름
            String get_tfstnumber = tf_stnumber.getText();
            String get_tfstname = tf_stname.getText();

            // 금일 이후의 일자인 경우 글자색 회색으로 처리 혹은 20170401 수강일 전으로
            if (hymd < ymd || 20170401 >= ymd) {
               lday[dayindex].setForeground(Color.gray);
            } else {

               // 출석,결석,지각,조퇴 여부
               String b_cchk = "f";
               String b_kchk = "f";
               String b_jichk = "f";
               String b_jochk = "f";

               try {
                  String sql1 = "select a_number from attend";
                  String sql2 = " where as_number=" + get_tfstnumber + " and a_year= '" + syear
                        + "' and a_month= '" + smonth + "' and a_day= '" + sday + "'";

                  // 해당 학생번호, 년, 월 맞는 것 모두 불러오는데 count 로
                  sql = sql1 + sql2;

                  rsk = stmt.executeQuery(sql);
                  // System.out.println("우선실행" + sql);
                  // System.out.println(sql);
                  if (rsk.next()) {
                     cnum++; // 출석한 경우
                     b_cchk = "t";

                     String sql3 = " select to_char(A_STIME,'HH24:MI') as stime, to_char(A_ETIME,'HH24:MI') as etime from attend";
                     rsj = stmt.executeQuery(sql3 + sql2);

                     System.out.println(sql3 + sql2);
                     // System.out.println(sql3 + sql2);
                     rsj.next();// 찾았다면 레코드 이동

                     String stime = rsj.getString("stime").replace(":", "");
                     String etime = rsj.getString("etime").replace(":", "");

                     int stime_val = Integer.parseInt(stime);
                     int etime_val = Integer.parseInt(etime);

                     System.out.println("s/" + stime_val);
                     System.out.println("e/" + etime_val);

                     // 지각한 경우
                     if (stime_val > 930) {
                        jinum++;
                        b_jichk = "t";
                     }
                     // 조퇴한경우
                     if (etime_val < 1830) {
                        jonum++;
                        b_jochk = "t";
                     }
                  } else {

                     knum++; // 결석한 경우
                     b_kchk = "t";
                  }
                  System.out.println("  출석일수:" + cnum + " 전체일수:" + allnum + " 출석률:");

                  if (b_jichk.equals("t") && b_jochk.equals("t")) { // 지각+조퇴
                     lday[dayindex].setBackground(Color.GREEN);
                  } else if (b_jichk.equals("t")) { // 지각한경우
                     lday[dayindex].setBackground(Color.YELLOW);
                  } else if (b_jochk.equals("t")) { // 조퇴한경우
                     lday[dayindex].setBackground(Color.ORANGE);
                  }

                  if (b_kchk.equals("t")) {
                     lday[dayindex].setBackground(Color.pink);
                  }

               } catch (Exception e) {

               }

            }

         }

         // 토일 제외한 전체 일수
         sunday++;
         allnum++;

         dayPanel[0].add(lday[dayindex++]);

      }

      // cnum, allnum, jinum, jonum, knum

      /*
       * lbl1_val.setBounds(12, 38, 260, 21); lbl2_val.setBounds(12, 58, 260, 21);
       */


      while (dayPanel[0].getComponentCount() < 42) {
         dayPanel[0].add(new Label("  "));
      }

      this.add(dayPanel[0]);
      
      allnum = allnum - tnum - inum;

      lbl1_val.setText("  출석일수" + cnum + " 전체일수:" + allnum);
      lbl2_val.setText("  지각일수" + jinum + " 조퇴일수:" + jonum + " 결석일수:" + knum);
      // 나머지 공백채우기

      add(top2);
   }

   @Override

   public void actionPerformed(ActionEvent e) {

      int year = cyear.getSelectedIndex() + 2010;
      int month = cmonth.getSelectedIndex();

      System.out.println(year + " " + month);

      // 날짜 컴포넌트 지우기
      dayPanel[0].setVisible(false);

      // 날짜배치 컴포넌트 호출
      daytext(year, month, this.stnumber);

      // 다시 그리기
      setVisible(true);

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

   public static void main(String[] args) {
      CalendarFrame cf = new CalendarFrame();
   }
}