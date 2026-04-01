package j0619;
//Wrapper 클래스->자바의 기본자료형의 값->컬렉션객체에 저장하기위해서
// 기본자료형<-->Wrapper클래스의 자료형
public class BoxingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("자동 unboxing");
         //unboxing->자바의 객체형(Wrapper)->기본자료형으로 변환
         //int obj=10;
         Integer obj=new Integer(10);//Double obj=new Double(23.5);
         //int sum=obj.intValue()+20;  //객체형->기본자료형+기본자료형->계산X
         //Integer->int으로 변환
         int sum=obj+20; 
         System.out.println("sum=>"+sum);
         //boxing-> 자바의 기본자료형-->자바의 객체형으로 변환
         //double d=123.45;
         System.out.println("자동 Boxing");
         /*Double d=new Double(123.45);//~Character c=new Character('a');
         printDouble(d);*/
         printDouble(new Double(123.45));
         printDouble(143.67);//double d=143.67
	}
      //double->Double=>자동으로 기본자료형->객체형으로 변환돼서 전달
	static void printDouble(Double obj2) { //123.45->toString()=>"123.45"
		System.out.println(obj2.toString());
	}
}






