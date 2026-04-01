package spring8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //1.xml이 여러개 존재->배열로 관리->파일명 부여->resource자동 인식
		String[] configLocation=new String[] {"applicationContext.xml"};
		//2.xml파일을 읽어들임
		AbstractApplicationContext context=
				new ClassPathXmlApplicationContext(configLocation);
		//3.JVM이 종료될때 context객체도 같이 종료될 수있도록
		context.registerShutdownHook();
		//4.객체를 의존성 주입->2.5방식의 코딩->3.x버전대부터
		//SystemMoniter moniter=(SystemMoniter)context.getBean("moniter");
		//getBean("의존성객체를 얻어올 id",형변환을 할 클래스명.class)
		//BookClient book=new BookClient();
		BookClient book=context.getBean("bookClient",BookClient.class);
		System.out.println("book=>"+book);
		
		context.close();//JVM이 종료시 컨테이너에 존재하는 모든 빈(객체) 종료
	}
}



