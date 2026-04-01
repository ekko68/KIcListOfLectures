package spring2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.xml파일의 위치를 알려준다.->절대경로
		//(2) 상대경로 ->이름만 쓴경우->src폴더에 저장된 경우(default)
		Resource resource=new  ClassPathResource("/spring2/initContext.xml");
		
		//2.빈즈공장을 불러와서 객체생성
		BeanFactory factory=new XmlBeanFactory(resource);//xml파일 정보
		//3.factory에서 getBean("불러올 객체를 가져오는 id값을 지정")=>형변환
		MessageBeanDI bean=(MessageBeanDI)factory.getBean("mBean");
		MessageBeanDI bean2=(MessageBeanDI)factory.getBean("mBean");
		MessageBeanDI bean3=(MessageBeanDI)factory.getBean("mBean");
		//4.spring 4.2버전 기준->객체의 주소값이 다 같다(=singleton)
		System.out.println("bean=>"+bean);
		System.out.println("bean2=>"+bean2);
		System.out.println("bean3=>"+bean3);
		System.out.println("bean==bean2"+(bean==bean2));
		bean.sayHello();
	}
}





