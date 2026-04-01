import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
public class BookCal extends JPanel implements MouseListener,ActionListener{
	CalendarModel model;
	JTable tab;
	JTextField txtYear;
	TableModel mod;
	JButton btnEx;
	String strban;
	public BookCal(){
		display();
		calendar();
	}
	public void display(){
		this.setLayout(new BorderLayout());
		
		JPanel pn = new JPanel(new BorderLayout());
		JPanel pn1 = new JPanel();
		txtYear = new JTextField();
		txtYear.setEditable(false);
		btnEx = new JButton("확인");
		btnEx.setMargin(new Insets(0, 2, 0, 2));
		btnEx.addActionListener(this);
		pn1.add(txtYear); pn1.add(btnEx);
		
		JPanel pn2 = new JPanel(new BorderLayout());
		model =new CalendarModel();
		tab = new JTable(model);
		tab.setCellSelectionEnabled(true);
		tab.addMouseListener(this);
		tab.setShowGrid(false);
		tab.setShowVerticalLines(true);
		pn2.add(new JScrollPane(tab),"Center");
		
		pn.add(pn1,"North"); pn.add(pn2,"Center");
		this.add(pn);
	}
	public void calendar(){
		Calendar cal=Calendar.getInstance();
		String imsi=cal.get(Calendar.YEAR) + " 년 " + (cal.get(Calendar.MONTH)+1) + " 월";
		model.setMonth((cal.get(Calendar.YEAR)), (cal.get(Calendar.MONTH)));
//		System.out.println(cal.get(Calendar.YEAR)+"  "+cal.get(Calendar.MONTH)+1);
		txtYear.setText(imsi);
	}
	public static void main(String[] args) {
		BookCal videocal=new BookCal();
		JFrame frame=new JFrame("반납일 변경");
		frame.getContentPane().add(videocal);
		frame.setResizable(false);
		frame.setBounds(200,200,250,250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Calendar cal=Calendar.getInstance();
		String imsis=cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-";
		BookBannap.txtBbanil.setText(imsis + strban);
		BookBannap.calFrame.dispose();
	}
	public void mouseClicked(MouseEvent e) {
		tab = (JTable)e.getComponent();
		mod=  tab.getModel();
//		System.out.println("값 : " + 
//				modd.getValueAt(tab.getSelectedRow(),tab.getSelectedColumn()));
		strban = (String) mod.getValueAt(tab.getSelectedRow(),tab.getSelectedColumn());

	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
    
	class CalendarModel extends AbstractTableModel{
	    String[] columName={"일", "월", "화", "수", "목", "금", "토"};
	    int [] numDays={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    String[][] calendar=new String[7][7];
		public String getColumnName(int col){
			return columName[col];
		}
	    public CalendarModel(){
	    }
	    
	    public int getRowCount(){
	      return 6;
	    }
	    
	    public int getColumnCount(){
	      return 7;
	    }
	    
	    public Object getValueAt(int row, int column){
	      return calendar[row][column];
	    }
	    
	    public void setValueAt(Object value, int row, int column){
	      calendar[row][column]=(String)value;
	    }
	    
	    public void setMonth(int year, int month){
	      for(int i=1; i<7; ++i)
	        for(int j=0; j<7; ++j) calendar[i][j]=" ";
	      
	      java.util.GregorianCalendar cal=new java.util.GregorianCalendar();
	      cal.set(year, month, 1);
	      int offset=cal.get(java.util.GregorianCalendar.DAY_OF_WEEK)-1;
//	      offset+=0;
	      int num=daysInMonth(year, month);
	      for(int i=0; i<num; ++i){
	        calendar[offset/7][offset%7]=Integer.toString(i+1);
	        ++offset;
	      }
	    }
	    
	    public boolean isLeapYear(int year){
	      if(year%4==0) return true;
	      return false;
	    }
	    
	    public int daysInMonth(int year, int month){
	      int days=numDays[month];
	      if(month==1 && isLeapYear(year))  ++days;
	      return days;
	    }
	}//CalendarModel끝
}

