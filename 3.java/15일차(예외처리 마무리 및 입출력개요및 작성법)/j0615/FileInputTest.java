package j0615;

import java.io.*;

public class FileInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          //FileInputStream
		//C:\webtest\3.java->\을 인식X ->경로구분자->\\  or /
		FileInputStream fis=new FileInputStream("C:/webtest/3.java/readme.txt");
		int read=0;//파일을 읽어들여서 임시로 저장
		
		/* (1)
		 * while(read!=-1) { //더이상 파일의 내용을 읽어들일수 없을때까지
			read=fis.read();
			System.out.write(read);
		}*/
		
		while(true) { //
			read=fis.read();
			//추가
			if(read==-1) break;
			System.out.write(read);
		}//while
	}
}






