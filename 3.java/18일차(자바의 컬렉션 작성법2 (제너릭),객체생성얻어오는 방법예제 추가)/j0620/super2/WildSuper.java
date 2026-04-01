package j0620.super2;//중복된 클래스가 존재->다른 패키지관리

//<? super T> -> T(자식클래스)를 고정으로 지정해주고 자식클래스와 연관이 있는
//                        부모클래스는 다 적용이 된다.(매개변수로 허용)

import java.util.*;

class Person { 
	String name;  
	//부모클래스에 소스코드를 추가(생성자 오버로딩)
	Person(){}
	Person(String name){
		this.name=name;
	}
	public String toString() {
		return name;
	}
	//---
}  

//Man
class Man extends Person{  // T(Man)->자식클래스
	//String name;
	Man(String name){
		this.name=name;//m.name="임시"
	}
	//객체의 주소값을 출력시켜주는 메서드(Object)
	@Override
	public String toString() { //getName(){
		// TODO Auto-generated method stub
		return name;
	}
}

//Woman
class Woman extends Person{  //T (자식클래스)
	//String name;
	Woman(String name){
		this.name=name;
	}
	@Override
	public String toString() { //getName(){
		// TODO Auto-generated method stub
		return name;
	}
}

public class WildSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Man
		List<Man> list=new ArrayList<Man>();
		//Man m=new Man("임시");
		list.add(new Man("임시")); //축약형
		list.add(new Man("테스트"));
		printData(list);
		
		//Woman
		List<Woman> list2=new ArrayList<Woman>();
		//Man m=new Man("임시");
		list2.add(new Woman("유관순")); //축약형
		list2.add(new Woman("신사임당"));
		//printData(list2);
		
		//Person
		List<Person> list3=new ArrayList<Person>();
		list3.add(new Person("사장님"));
		list3.add(new Person("이사님"));
		printData(list3);
		
		//3.Double
		List<Double> list4=new ArrayList();
		list4.add(12.5); list4.add(45.6); list4.add(78.9);
		//printData(list4); //상속관계와 관련이 아예없는 클래스 이기때문에 안됨
		
	}
	
	//public static void printData(List<? extends Person>  list) {  //(ArrayList  list)
	//public static void printData(List<? super Woman>  list) { //Woman,Person	
	   public static void printData(List<? super Man>  list) { //Man,Person	허용
	for(Object obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}	
}



