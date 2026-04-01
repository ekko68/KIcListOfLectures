package j0609;

//추상클래스
abstract class Exam extends Object{
	public static int sum(int x,int y) {
		return (x+y);
	}
	public abstract void draw();
	abstract public void go();
}

//일반클래스->추상메서드구현(implements)->자식클래스내부에서 일반메서드로 작성
public class Test extends Exam{
    /*
     *public int sum(int x,int y) {
		return (x+y);
	  }
     */
	public void draw() {}
	public void go() {
		int result=sum(10,20);
		System.out.println("result=>"+result);//30
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test t=new Test();
        t.go();
        System.out.println(sum(30,40));//70
	}
}



