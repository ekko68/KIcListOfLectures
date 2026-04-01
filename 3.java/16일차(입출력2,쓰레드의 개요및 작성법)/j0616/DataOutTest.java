package j0616;

//자바의 기본자료형에 맞게 파일에 저장예제
import java.io.*;

public class DataOutTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
       //1.파일로 저장
	  FileOutputStream fos=new FileOutputStream("c:/webtest/3.java/data.txt");
	  //2.자바의 자료형에 맞게 포장
	  //메서드의 매개변수가 부모형->자식클래스의 객체도 적용(객체형변환)
	  DataOutputStream dos=new DataOutputStream(fos);
	  //3.메모리에 자료형에 맞게 저장
	  char han='한';
	  System.out.println((int)han);//아스키코드값 출력
	  byte b=21;
	  String str="bg\n";
	  byte ba[]= {65,66,67};//A,B,C(변환)
	  //파일로 저장
	  dos.writeChar(han);
	  dos.writeByte(b);
	  dos.writeBytes(str);//writeString()X
	  dos.write(ba);
	  dos.close();//더이상 출력 스트림 종료->close()
	}
}





