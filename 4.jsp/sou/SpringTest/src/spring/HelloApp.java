package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.xml파일의 위치를 알려준다.->절대경로
		/* (1)
		 * Resource resource=new FileSystemResource
	      ("C:/webtest/4.jsp/sou/SpringTest/src/spring/applicationContext.xml");*/
		
		//(2) 상대경로 ->이름만 쓴경우->src폴더에 저장된 경우(default)
		Resource resource=new  ClassPathResource("/spring/applicationContext.xml");
		
		//2.빈즈공장을 불러와서 객체생성
		BeanFactory factory=new XmlBeanFactory(resource);//xml파일 정보
		//3.factory에서 getBean("불러올 객체를 가져오는 id값을 지정")=>형변환
		//Message1 me=new Message1();
		//Message1 me=(Message1)factory.getBean("test");
		MessageInter bean=(MessageInter)factory.getBean("test");
		//Message2 me=(Message2)factory.getBean("test2");
		bean.sayHello("테스트");
	}
}





