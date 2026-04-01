package sp.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String path="sp/aop2/app.xml";
         ApplicationContext context=
        		 new ClassPathXmlApplicationContext(path);
         //AOP객체를 생성->Adivisor작동->Advice+pointcut->실행
         AnonoTest an=(AnonoTest)context.getBean("test");
         an.print();
         an.imsi();
	}
}




