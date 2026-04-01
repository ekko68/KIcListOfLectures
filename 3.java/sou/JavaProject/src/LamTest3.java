//package j1228;
//Thread를 사용한 경우->람다표현식을 사용이 가능

public class LamTest3 extends Thread{

	public void run(){
		while(true){
			try{
				Thread.sleep(1000);//1초
				System.out.println("출력="+System.currentTimeMillis());
			}catch(Exception e){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//방법1
           LamTest3 lt=new LamTest3();
           lt.start();
        //방법2
           new Thread(){
        	   @Override
        	public void run() {
        		// TODO Auto-generated method stub
        		   while(true){
        				try{
        					Thread.sleep(1000);//1초
        					System.out.println("축약형="+System.currentTimeMillis());
        				}catch(Exception e){}
        			}
        	  }
           }.start();
           //객체명.start();
           System.out.println("람다를 이용하는 경우");//->실행
           new Thread(()->{
        	   // 메서드의 기능부분
        	   //public void run() {
        	   while(true){
   				try{
   					Thread.sleep(1000);//1초
   					System.out.println("람다이용="+System.currentTimeMillis());
   				}catch(Exception e){}
   			   }
        	   //
           }).start();
	}

}



