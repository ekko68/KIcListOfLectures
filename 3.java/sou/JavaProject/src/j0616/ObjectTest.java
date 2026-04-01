package j0616;

import java.io.*;

//조건)객체를 파일로 저장->USB->전송(네트워크로 전송(파일 첨부)
//직렬화가 가능한 클래스->객체를 직렬화할때 올바르게 저장되는 객체를 만들수
 //                                   있는 클래스

//형식) class 클래스명 implements Serializable
class Person implements Serializable {
	String name;
	int age;
	transient String addr;//transient 멤버변수=>저장X->null
}

public class ObjectTest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
           Person p=new Person();
           p.name="홍길동";
           p.age=34;
           p.addr="경기도 광명시~";
           //파일로 저장-ObjectOutputStream>FileOutputStream
           FileOutputStream fos=
        		   new FileOutputStream("c:/webtest/3.java/object.txt");
           ObjectOutputStream oos=new ObjectOutputStream(fos);
           //~.writeBytes("홍길동"), ~.writeInt(34),~.writeBytest("경기도~");
           oos.writeObject(p);//Object->모든 객체다 저장이 가능하게 만들기위해
           //파일로 저장될때 Person->Object로 변환돼서 저장이 된다.
           oos.close();
           
           //집에 있는 컴퓨터에 작업
           FileInputStream fis=
        		   new FileInputStream("c:/webtest/3.java/object.txt");
           ObjectInputStream ois=new ObjectInputStream(fis);
           //직렬화된 객체를 다시 원래상태로 되돌리기위해서 원래형으로 형변환
           Person p2=(Person)ois.readObject();
           System.out.println
           ("이름="+p2.name+",나이="+p2.age+",주소="+p2.addr);
	}
}








