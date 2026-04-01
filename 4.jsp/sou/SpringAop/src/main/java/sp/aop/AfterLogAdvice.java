package sp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

//After Advice구현->AfterReturningAdvice을 상속
public class AfterLogAdvice implements AfterReturningAdvice {
    //1.추가된 객체 2.핵심클래스의 메서드명 3.생성된 객체들 4.target클래스의 객체
	@Override
	public void afterReturning(Object returnValue, 
			                                 Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(method.toString()+"메서드:"+target+"에서 호출후!!!");
	}
}
