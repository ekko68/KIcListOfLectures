package j0616;

import java.io.*;

public class MultiThread2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //1.Runnable인터페이스를 상속받은 자식클래스 객체생성
		/*System.out.println("실행시킬 단을 입력?");
		BufferedReader br=new BufferedReader
				                 (new InputStreamReader(System.in));
		int dan=Integer.parseInt(br.readLine());*/
		//GooGoo go=new GooGoo(dan);
		GooGoo go=new GooGoo(7);
		//2.Thread객체 생성->생성자인수(go)로 넣어주기
		Thread t=new Thread(go);
		//3.Thread객체의 start()->가동(run())
		//t.start();
		//2번째 쓰레드를 생성->실행
		PrintThread pt=new PrintThread();
		//우선순위를 정해준다.->setPriority(우선순위 숫자)
		//t.setPriority(10);
		//pt.setPriority(Thread.MIN_PRIORITY);//1
		//
		//t.start(); pt.start();
		t.run();  pt.run();
	}
}
//2.구구단을 출력->Runnable인터페이스를 상속->Thread 클래스를 상속X
class GooGoo  implements Runnable{ //run()
	private int dan;//단을 저장
	public GooGoo(int dan) {
		this.dan=dan;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++) {
			try {
				Thread.sleep(500);
				System.out.println(dan+"단:"+dan+"*"+i+"="+(dan*i));
			}catch(Exception e) {System.out.println(e);}
		}//for
	}
}
//1.임의의 숫자를 속도조절하면서 출력
class PrintThread extends Thread {
	public void run()  {
		for(int i=1;i<=9;i++) {
			try {
				//임의의 숫자를 만드는 방법->난수 생성(0~0.9999999)
				//Math.random()*45+1
				long sleeptime=(int)(Math.random()*500+1);
				Thread.sleep(sleeptime);//1~500
				System.out.println("i="+i);
			}catch(Exception e) {}
		}//for
	}
}







