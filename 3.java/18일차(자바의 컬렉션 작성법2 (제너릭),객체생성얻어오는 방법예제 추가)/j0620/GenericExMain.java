package j0620;

public class GenericExMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자료형만 다르고 비슷한 기능을 가진 메서드를 호출->중복코드 생략->간결성
        GenericEx<String> ge=new GenericEx<String>();
        GenericEx<Integer> ge2=new GenericEx<Integer>();
        GenericEx<Double> ge3=new GenericEx<Double>();
        
        String ss[]= {"제너릭","제너릭종류","제너릭 적용연습"};
        Integer ss2[]= {1,2,3}; //int ss2={1,2,3}
        Double ss3[]= {3.4,5.6,9.8};
        ge.set(ss);
        ge.print();
        ge2.set(ss2);
        ge2.print();
        ge3.set(ss3);
        ge3.print();
	}
}
