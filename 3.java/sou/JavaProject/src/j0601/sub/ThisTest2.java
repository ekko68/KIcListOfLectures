package j0601.sub;

public class ThisTest2 {

	private int a=100;
	//ThisTest2(){}
	public void setA(int a) {
		 this.a=a;//a=200;   //this=>멤버변수와 매개변수를  구분하기위해서 사용
	}
	public int getA() { return a;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ThisTest2 tt=new ThisTest2();
           tt.setA(200);
           System.out.println("tt.getA()=>"+tt.getA());
	}
}





