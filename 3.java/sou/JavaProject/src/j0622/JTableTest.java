package j0622;

//2차원표형태로 제공되는 컴포넌트 ->JTable
//MVC모델=>1.Model(데이터 저장)->배열로 선언(데이터저장)  
//                  2.View(화면 JTable) 
//                  3.Controller->Model-->JTable와 연결해서 보여줌

import java.awt.*;
import javax.swing.*;

public class JTableTest extends JFrame {
    JTable table;
    
    public JTableTest() {
    	setTitle("JTable 구조 연습");
    	//---- Model------------------------
    	String header[]= {"one","two","three"};//컬럼명
    	String cells[][]= {{"111","222","333"},
    			                   {"444","555","666"},
    			                   {"777","888","999"}};
    	//JTable을 생성(1.데이터부분(모델),2.컬러명
    	table=new JTable(cells,header);//JTable+모델
    	/*JScrollPane js=new JScrollPane(table);//JScrollPane+JTable(모델)
    	this.add(js);*/
    	this.add(new JScrollPane(table));
    	//-----------------------------
    	setBounds(300,300,300,200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                 new JTableTest();
	}
}


