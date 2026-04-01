package j0619;

//급여통장(공유객체)->ATM(Thread 작동)
class ATM implements Runnable{
	
	//급여계좌 금액
	private long Money=10000;
	
	@Override
	public void run() {//공과금
		//형식) synchronized(공유객체명){ 처리해야할 문장;}
		// TODO Auto-generated method stub
		synchronized(this) { //자기 클래스->atm(this)
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(1000);//1초동안 멈춘뒤 실행
				}catch(Exception e) {}
				if(getMoney() <=0)
					break;
				withDraw(1000);
			}//for
		}//synchronized
	}
	//돈을 인출시켜주는 메서드->수정목적
	public void withDraw(long howmuch) {
		//if(Money > 0)
		if(getMoney()>0) {
			Money-=howmuch;
			System.out.println
			   (Thread.currentThread().getName()+","+getMoney());
		}else {
			System.out.println("잔액이 부족합니다.!");
		}
	}
	//잔액을 조회->getter
	public long getMoney() {
		return Money;
	}
}
public class SyncTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ATM atm=new ATM();
         Thread t1=new Thread(atm,"보험금");
         Thread t2=new Thread(atm,"공과금");
         t1.start();  t2.start();
	}
}




