package j0620;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//날짜를 출력=>Date,Galendar
//Date,Galendar
import java.util.Date;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Date d=new Date();
           System.out.println("d=>"+d);//d.toString()->날짜를 문자형태로 출력
           //Tue Jun 20 15:43:50 KST 2017
           //추가->형식에 맞춰서 출력->SimpleDateFormat
           SimpleDateFormat sdf=
        		   new SimpleDateFormat("yyyy년-MM월-dd일 HH:mm:ss a");
           String date=sdf.format(d);
           System.out.println("date=>"+date);
           //---------날짜도 자주 사용(정적메서드 제공)-----------------------------
           Calendar cal=Calendar.getInstance();//표준
           System.out.println("cal=>"+cal);
	}
}





