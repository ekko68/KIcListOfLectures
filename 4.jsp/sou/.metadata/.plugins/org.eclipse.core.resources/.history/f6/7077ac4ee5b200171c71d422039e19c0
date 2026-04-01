package sp.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResultMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String path="sp/aop/app.xml";
         ApplicationContext context=
        		 new ClassPathXmlApplicationContext(path);
         //AOP객체를 생성->Adivisor작동->Advice+pointcut->실행
         TestService service=(TestService)context.getBean("testService");
         service.save("AOP 적용연습");//this.msg="AOP 적용연습"
         //after advice
         //before advice(before()작동 실행)->실행상태에서 처리
         service.write();
         //after advice
	}
}




