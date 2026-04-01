package j0622;

import java.io.*;
import java.util.*;//Properties

/* ex1.properties파일에 저장->Properties객체->load()메서드
 * a=testkim
    b=imsi
 */
public class Protest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.파일을 불러오기
		Properties pro=new Properties();
		try {
			pro.load(new FileInputStream
				("C:/webtest/3.java/sou/JavaProject/src/ex1.properties"));
		}catch(IOException e) {
			System.out.println("파일불러오기 오류->"+e);
		}
		 //2.저장된 속성값을 불러오기->getProperty("키명")<->setProperty(키명,값)
		String avalue=pro.getProperty("a");
		System.out.println("a의 속성값=>"+avalue);
		//3.저장된 속성명의 특정값을 변경->setProperty(키명,값)->메모리상만 저장
		pro.setProperty("b", "property test");//imsi->property test
		System.out.println("pro.getProperty('b')=>"+pro.getProperty("b"));
		//4.실제 파일에 반영->store메서드 사용(동기화) 메모리저장상태=파일상태
		try { //store(속성값을 저장할 파일명,주석(null로 설정))
			pro.store(new FileOutputStream
					("C:/webtest/3.java/sou/JavaProject/src/ex1.properties"),null);
		}catch(IOException e) {e.printStackTrace();}
	}
}




