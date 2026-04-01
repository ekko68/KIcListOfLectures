package j0615;

import java.io.*;

public class FileInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          //FileInputStream
		//C:\webtest\3.java->\을 인식X ->경로구분자->\\  or /
		/*
		 * Koala.jpg==>복사(파일명 변경)
            epp420_64bit.exe=>복사
		 */
		FileInputStream fis=new FileInputStream("C:/webtest/3.java/readme.txt");
		//추가->파일을 만들어서 출력=>FileOutputStream
		/*File f=new File("C:/webtest/3.java/abc2.txt");
		FileOutputStream fos=new FileOutputStream(f);*/
		FileOutputStream fos=new FileOutputStream
				                       (new File("C:/webtest/3.java/abc3.txt"));
		
		//FileOutputStream fos=new FileOutputStream("C:/webtest/3.java/abc.txt");
		
		
		int read=0;//파일을 읽어들여서 임시로 저장
		
		while(true) { //
			read=fis.read();
			//추가
			if(read==-1) break;
			//System.out.write(read);
			fos.write(read);
		}//while
	}
}






