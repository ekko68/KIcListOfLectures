package sp.aop;
//2.핵심모듈 클래스(=target 클래스)
//save(),write()->핵심메서드

import java.lang.reflect.Method;

public class TestServiceImpl implements TestService {

	private String msg="before AOP 연습";
	/*
	public void before(Method method, Object[] args, Object target) 
	           throws Throwable {
   // TODO Auto-generated method stub
      log.info(method.toString()+"메서드:"+target+"에서 호출전!!!");
   }*/
	@Override
	public void save(String msg) { //회원수정
		//회원로그인 부분을 코딩->중복코딩을 써야 된다.
		//before();
		// TODO Auto-generated method stub
        this.msg=msg;
        System.out.println("save() 메서드호출됨");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		////회원로그인 부분을 코딩
       System.out.println("write()호출됨="+this.msg);
	}
}


