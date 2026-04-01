package j0616;

//1.Thread클래스를 상속받으면 쓰레드 기능을 사용
//상속->개발단축,기능을 구현하기위해

public class MultiThread extends Thread { //run() p728

	//쓰레드 이름
	public MultiThread(String s) {
		     super(s);//setName(s); 쓰레드의 이름을 부여<->getName()
	}
	
	@Override
	public void run() {  //실시간으로 데이터를 출력,저장,계산,,,(소문자)
		// TODO Auto-generated method stub
		for(char i='a';i<='z';i++) {
			try {
			Thread.sleep(500);//sleep(1000);//1초
			System.out.println(i);
			System.out.println("쓰레드의 이름=>"+this.getName());
			}catch(Exception e) {e.printStackTrace();}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MultiThread mt=new MultiThread("임시");
         /*
          * MultiThread mt=new MultiThread();
          * mt.setName("임시");
          */
         mt.start();//내부적으로 run() 메서드호출
	}
}








