package j0620.extend;

//<? extends T> ->상속관계로 이루어진 클래스만 자료형으로 받게다는 표시
//? ->자식클래스(Man,Woman), T(부모클래스(Person)
//     =>부모클래스 뿐만아니라 자식클래스만 임의의
//          자료형만 입력을 받고싶다.

import java.util.*;

class Person { 
	String name;  
    //Person(){}
}  //class Person {} 부모클래스 (T)

//Man
class Man extends Person{
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
class Woman extends Person{
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

public class WildExtend {

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
		printData(list2);
		
		//Person
		List<Person> list3=new ArrayList<Person>();
		list3.add(new Person());
		printData(list3);
		
		//3.Double->상속관계와 전혀 관련이 없는 클래스를 적용
		List<Double> list4=new ArrayList();
		list4.add(12.5); list4.add(45.6); list4.add(78.9);
		//printData(list4); 부모클래스 or 자식클래스가 아니기때문에 적용X
		
	}
	//<?> 매개변수를 전달받을때 자료형은 그때그때 마다 바뀔수 있다.
	//                                        (List<Object> list) 대용
	//public static void printData(List<?>  list) {  //(ArrayList  list)
	public static void printData(List<? extends Person>  list) {  //(ArrayList  list)
		for(Object obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}	
}



