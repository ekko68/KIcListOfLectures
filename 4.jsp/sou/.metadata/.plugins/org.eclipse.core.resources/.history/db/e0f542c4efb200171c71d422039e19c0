package sp.aop2;

import org.aspectj.lang.annotation.*;//어노테이션
import org.aspectj.lang.ProceedingJoinPoint;
//around advice->invoke()->proceed()호출해야 되기때문에 필요
//around advice때문에 필요하다.

//AOP역할을 해주는 클래스 설정->Aspect역할->pointcut+advice지정(호출메서드 지정)
@Aspect
public class TestAspect {

	//1.pointcut설정 @Pointcut("execution(~)") 핵심메서드를 지정
	//sp.aop2패키지 뿐만아니라 하위패키지에 있는 매개변수가 없는 
	//모든 public 메서드 적용대상
	@Pointcut("execution(public * sp.aop2..*(..))")
	public void imsi() {} //public void print() {} 
	
	//2.advice종류->@Before,@After-returnning,@Around("핵심메서드명()")
	@Around("imsi()")     //@Around("print()")
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
		//호출할 핵심메서드의 이름,정보를 얻어오는 역할하는 객체
		String result=joinPoint.getSignature().toString();//호출할 메서드
		System.out.println(result+"시작");
		try {
			Object ob=joinPoint.proceed();//핵심메서드를 호출
		}finally {//에러발생과 상관없이 무조건 실행이 되는 구문
			System.out.println(result+"종료");
		}
		return "traceing";
	}
}








