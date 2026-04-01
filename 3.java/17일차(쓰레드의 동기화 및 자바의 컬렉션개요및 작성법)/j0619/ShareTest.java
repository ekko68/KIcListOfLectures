package j0619;
//동기화->Thread+입출력예제
import java.io.*;

//Thread를 가동
public class ShareTest implements Runnable{  //extends Thread

	RandomAccessFile raf=null;//현재폴더 기준->임의의파일생성
	
	//초기화->생성자=>Thread객체를 생성->한개의 파일에 글자를 쓰도록처리
	public ShareTest() {
		try {
			//1.경로포함해서 생성할 파일명,2.모드(r,rw~)rw->없으면 생성->있으면 덮어쓰기
			raf=new RandomAccessFile("c:/webtest/3.java/result.txt","rw");
			//Thread객체생성
			Thread t1=new Thread(this,"lys");//Runnable객체명,쓰레드 이름->setName()
			Thread t2=new Thread(this,"test");
			//Thread객체 실행->start()
			t1.start(); t2.start();
		}catch(IOException e) {
			System.out.println("파일생성에 오류=>"+e);//e.toString()
		}
	}
	@Override
		public synchronized void run() { //Thread 기능->파일에 내용을 써주는 기능
			// TODO Auto-generated method stub
		    //raf의 writeBytes() 을 이용->FilePointer->글자쓸때마다 포인터이동
		   try {
			   for(int i=0;i<1000;i++) {
				   raf.writeBytes
				   (Thread.currentThread().getName()+"["+i+"]"+raf.getFilePointer()+"\n");
			   }
		   }catch(Exception e) {
			   System.out.println("파일에 출력오류=>"+e);
		   }
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.객체생성
		      new ShareTest();
	}
}



