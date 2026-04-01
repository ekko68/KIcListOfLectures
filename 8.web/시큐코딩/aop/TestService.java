package sp.aop;

//모든 핵심클래스에서 공통으로 사용할 목적으로 메서드
public interface TestService {
   public void save(String msg);//입력(ex 회원수정)
   public void write();//출력 목적
}
