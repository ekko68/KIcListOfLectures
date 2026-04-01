package j0616;
//start(),run()의 차이점=>start()?

public class MyThread implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("is Running");
			try {
				Thread.sleep(1000);//1초마다
			}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread my=new MyThread();
        Thread t=new Thread(my);
          t.start();//run()->기존의 main쓰레드는 유지가 되면서 다른 쓰레드를 가동
        //t.run();->기존의 main쓰레드는 멈춘상태에서 다른 쓰레드를 가동
          //성능에 영향을 미친다.(secode coding)
        System.out.println("MainThread Terminated!");
	}
}








