package j0614;
//객체형변환(자동,명시적인 형변환)
//직원->세금율을 계산->출력(taxRate)
//각 업무별로 직원의 세금율이 다르기 때문에 따로 따로 메서드를 작성->구현
//클래스->비슷한 기능을 가진 메서드 여러개->메서드명 통합(구분->오버로딩)
class Employee{
	
	public void taxRate(Employee e) { //객체 자동 형변환(Manager,Engineer)
		if(e instanceof Manager) { //팀장
			Manager m=(Manager)e; //내부적으로 자식에 맞게 자식형으로 형변환준다
			System.out.println("Manager에 맞는세금 구하기");
		}else if(e instanceof Engineer) {//엔지니어
			Engineer en=(Engineer)e;
			System.out.println("Engineer에 맞는 세금 계산하기");
		}else if(e instanceof Employee) {//일반직원
			System.out.println("Employee에 맞는 세금 계산하기");
		}
	}
	/* 업무별로 세금율이 다다르기에 직원의 수가 많고 업무가 복잡
	 * 중복된 코딩이 반복적으로 사용할 수없다(단점)
	 * 상속관계-->가장 최상위 부모클래스형으로 형변환->메서드내부에 따로계산
	public void taxRate(Manager e) {}
	public void taxRate(Engineer e) {}
	*/
}
//팀장의 역할+직원의 역할
class Manager extends Employee{
	//public void taxRate(Manager e) {}
}

//엔지니어로의 역할+직원의 역할
class Engineer extends Employee{
	//public void taxRate(Engineer e) {}
}

public class CastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Employee emp=new Employee();
          Manager man=new Manager();
          Engineer eng=new Engineer();
          //세금율->taxRate()
          emp.taxRate(emp);
          man.taxRate(man);
          eng.taxRate(eng);
	}
}





