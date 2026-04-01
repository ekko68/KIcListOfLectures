package spring11;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //1.xml이 여러개 존재->배열로 관리->파일명 부여->resource자동 인식
		String[] configLocation=new String[] {"app.xml"};
		//2.xml파일을 읽어들임
		AbstractApplicationContext context=
				new ClassPathXmlApplicationContext(configLocation);
		//3.JVM이 종료될때 context객체도 같이 종료될 수있도록
		context.registerShutdownHook();
		//4.객체를 의존성 주입
		SystemMoniter moniter=context.getBean("doorMoniter",SystemMoniter.class);
		System.out.println("moniter=>"+moniter);
		
		SystemMoniter moniter2=context.getBean("lobbyMoniter",SystemMoniter.class);
		System.out.println("moniter2=>"+moniter2);
		
		SystemMoniter moniter3=context.getBean("roomMoniter",SystemMoniter.class);
		System.out.println("moniter3=>"+moniter3);
		//5.JVM이 종료
		context.close();//JVM이 종료시 컨테이너에 존재하는 모든 빈(객체) 종료
	}
}



