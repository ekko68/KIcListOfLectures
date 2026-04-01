package j0616;

//자바의 기본자료형에 맞게 파일에 저장예제
import java.io.*;

public class DataOutTest2 {

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
	  fos.close();//원칙
	  //만들어진 파일의 내용을 다시 읽어들여서 확인후 출력
	  DataInputStream dis=new DataInputStream
			                    (new FileInputStream("c:/webtest/3.java/data.txt"));
	    //변수명=read자료형()
	   char c=dis.readChar();
	   byte b1=dis.readByte();
	   String s=dis.readLine();//메서드에 밑줄->deprecation(앞으로 쓰지말것(경고))
	   //byte배열이 필요
	   byte bb[]=new byte[3];//65,66,67
	   dis.read(bb);
	   dis.close();
	   System.out.println("c->"+c);
	   System.out.println("b1->"+b1);
	   System.out.println("s->"+s);
	   System.out.println("bb->"+bb); //->byte[]->String으로 변환
	   //String str2=new String(bb);
	   System.out.println("str2=>"+new String(bb));
	   
	}
}





