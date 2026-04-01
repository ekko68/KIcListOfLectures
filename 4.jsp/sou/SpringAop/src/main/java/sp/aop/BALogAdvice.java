package sp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//3.Around Advice를 구현->MethodInterceptor을 상속
//->자동으로 invoke()를 호출한다.->앞,뒤에 공통으로 실행할 내용을 기술
//핵심클래스의 메서드호출->MethodInvocation객체명.proceed()이용해서 호출
public class BALogAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		//invocation.getMethod()=>핵심클래스의 메서드이름을 구해온다.
		System.out.println("invoke()호출됨!!!");
		System.out.println(invocation.getMethod()+"호출전인 경우");
		//핵심클래스의 메서드를 호출=>리턴값이 있는 메서드를 호출하는 경우
		Object returnValue=invocation.proceed();
		System.out.println(invocation.getMethod()+"호출후인 경우");
		System.out.println(returnValue+"를 리턴!!!");
		return null;
	}
}


