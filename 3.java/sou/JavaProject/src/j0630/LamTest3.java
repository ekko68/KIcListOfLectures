package j0630;
//Thread를 이용해서 사용->람다표현식

public class LamTest3 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("출력=>"+System.currentTimeMillis());
			}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //방법1
		LamTest3 lt=new LamTest3();
		lt.start();
		//방법2->익명클래스의 객체를 이용
		//Thread 객체명=new Thread(){메서드 선언 및 내용}
		new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println("축약형=>"+System.currentTimeMillis());
					}catch(Exception e) {}
				}//while
			}//run
		}.start();
		//익명객체(이름이 없는 객체).메서드명();
		//익명객체의 람다표현식으로 메서드를 호출하는 경우->메서드명을 생략
		//익명함수 대용으로 사용목적
		//Thread t=new Thread(()->~)
		new Thread(()->{            //public void run이 생략 ()->{메서드의 내용}
			while(true) {
				try {
					Thread.sleep(1000);
					System.out.println("람다이용=>"+System.currentTimeMillis());
				}catch(Exception e) {}
			}//while
	    }).start();
	}//main의 끝
}



