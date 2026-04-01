package j0620;

import static java.lang.System.out; //자주 사용되는 클래스명 생략
//제너릭이 적용이 되는 클래스를 작성->특정 자료형의 값
//을 입력받아서 저장,조회,계산
//외부의 배열의 자료형에 상관없이 항상 적용이 되는 클래스를 만들 고 싶다.
public class GenericEx<T> {
        T [] v;  //String [] v; Type=>외부에서 전달되는 자료형을 의미
        
        //1.v배열에 값을 저장시켜주는 메서드(Setter)
        public void set(T [] n) {
        	 v=n;   //this.v=v;
        }
        //2.v배열의 값을 꺼내서 화면에 출력시켜주는 메서드(단순,반복)
        public void print() {
        	for(T s:v)
        		out.println(s);
        }
}




