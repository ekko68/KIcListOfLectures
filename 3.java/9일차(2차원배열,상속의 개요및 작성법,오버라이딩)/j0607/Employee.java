package j0607;

//회사->입사(신입사원)의 정보->클래스

public class Employee {
	//1. 멤버변수
  String name;//사원명
  int age;//나이
  String sung;//성별
  String addr;//주소
  long salary;//급여->보너스(공기업)->직원(150%),중간관리자(300%) 반영
  
  //2.생성자의 오버로딩 기법
public Employee() {}
public Employee(String name, int age, String sung, String addr, long salary) {
	this.name = name;
	this.age = age;
	this.sung = sung;
	this.addr = addr;
	this.salary = salary;
}
 //보너스를 구해주는 메서드=>급여*1.5(150%)
double bonus() {
	return salary*1.5;   //return salary*3.0
}
 
//직원의 정보를 출력->display()->저장된 내용출력만 단순,반복
public void display() {
	System.out.println("==직원의 정보 출력==");
	System.out.println("이름=>"+name);
	System.out.println("나이=>"+age);
	System.out.println("성별=>"+sung);
	System.out.println("주소=>"+addr);
	System.out.println("급여=>"+salary);
	//자기 클래스내부에서 다른 메서드를 호출이 가능(생성자 처럼)
	System.out.println("보너스=>"+bonus());
}

}





