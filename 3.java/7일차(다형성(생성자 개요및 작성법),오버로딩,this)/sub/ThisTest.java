package j0601.sub;

//1)this ->현재 생성된 객체를 가리키는 예약어
public class ThisTest {

	ThisTest(){
		System.out.println("객체생성=>"+this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ThisTest tt=new ThisTest();//기본생성자를 호출
        System.out.println("객체생성후(tt)=>"+tt);
        System.out.println("================");
        ThisTest tt2=new ThisTest();//기본생성자를 호출
        System.out.println("객체생성후(tt2)=>"+tt2);
	}
}




