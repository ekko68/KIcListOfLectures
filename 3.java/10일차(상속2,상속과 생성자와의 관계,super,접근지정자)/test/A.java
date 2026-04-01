package j0608.test;
//자기 클래스내부에서만 사용을 한다면 접근지정자 의미가 없다.(다 접근가능)
public class A {
    private int i=10;//1.멤버변수 앞에 private
    int j; //default접근지정자를 부여
    //2.메서드명 앞에 private를 붙일 수 있다.->외부에서는 절대로 호출불가
    protected int k;
    public int m;
    
    private void print() {
    	System.out.println("private i=>"+i);
    }
    void print2() {
    	System.out.println(" j(default)=>"+j);
    }
    protected void print3() {
    	System.out.println(" protected k=>"+k);
    }
    
    public void print4() {
    	System.out.println(" public m=>"+m);
    }
    //같은 클래스내에서만 실행->main()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         A a=new A();
         a.i=20;
         a.print();
         System.out.println("====default권한====");
         a.j=200;
         a.print2();
         System.out.println("====protected 권한====");
         a.k=300;
         a.print3();
         System.out.println("====public 권한====");
         a.m=400;
         a.print4();
	}
}



