package j0608;
//상속과 생성자와의 관계
//import java.lang.Object;->import java.lang.*을 내부적으로 자동으로 추가시켜줌
//java.lang에 있는  클래스외에 다른 클래스를 불러올때에는 반드시 import써야된다

class Parent extends Object{
	public Parent() {
		System.out.println("난 Parent 기본생성자 호출됨!");
	}
	//자식입장에서 내용만 수정
	public String toString() {
		// TODO Auto-generated method stub
		return "내용을 변경하고 싶다";
	}
}
//class Child extends Object
class Child extends Parent{
	public Child() {
		System.out.println("난 Child 기본생성자 호출됨!");
	}
}

public class InheriTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Parent p=new Parent();
         System.out.println("p=>"+p);//j0608.Parent@15db9742
         System.out.println("p.toString()=>"+p.toString());
         Child c=new Child();
         System.out.println("c=>"+c);
         System.out.println("c.toString()=>"+c.toString());
	}

}



