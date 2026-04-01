package j0620;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//날짜를 출력=>Date,Galendar
//Date,Galendar
import java.util.Date;

public class SimpleTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Date d=new Date();
           System.out.println("d=>"+d);//d.toString()->날짜를 문자형태로 출력
           //Tue Jun 20 15:43:50 KST 2017
           //추가->형식에 맞춰서 출력->SimpleDateFormat
           /* (1) Scanner sc=new Scanner(System.in); ->getScan()
            * (1) ->getSimple()
            SimpleDateFormat sdf=
        		   new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a");
           */
           SimpleDateFormat sdf=getSimple();
           setSimple(sdf,d);
           /* (2)String name=sc.next(); System.out.println(name); ->setScan(~)
           (2)->setSimple(~)
           String date=sdf.format(d);
           System.out.println("date=>"+date);*/
           
           //---------날짜도 자주 사용(정적메서드 제공)---setCalen,getCalen--------------------------
           Calendar cal=Calendar.getInstance();//표준->getCalen()
           System.out.println("cal=>"+cal);//setCalen
	}
	//1.SimpleDateFormat클래스 객체를 만들어서 갖다주는 메서드 작성
	//public static Scanner getScan(){}
	public static SimpleDateFormat getSimple() {
		 SimpleDateFormat sdf=
      		   new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a");
		 return sdf;
	}
	//2.sdf객체를 받아서 main대신에 대신처리해주는 메서드작성->setSimple
	public static void setSimple(SimpleDateFormat sdf,Date d) {
		String date=sdf.format(d);
        System.out.println("date=>"+date);
	}
}





