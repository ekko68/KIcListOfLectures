package j0608;

//신입사원->부서배치->팀장에 정보클래스
class Manager extends Employee{
	/* 눈에는 보이지 않지만 가지고 있음을 표시(주석)
	String name;
	int age;
	String sung;
	String addr;
	long salary;
	 bonus(),display()
	*/
	//추가
	String department;//부서명
	//객체배열=>기본배열,객체(Employee)만 따로 저장하는 배열
	Employee sub[];//신입사원들=>배열로 멤버변수로 선언
	
	//생성자는 상속이 안되기에 그대로 작성
	public Manager() {}
	//String name, int age, String sung, String addr, long salary
	public Manager(String name,int age,String sung,long salary,
			                 String addr,String department) {
		//자식클래스의 생성자->부모클래스 생성자를 호출(중복된 멤버변수 소스코드)
		super(name,age,sung,addr,salary);
		/*
		this.name=name;
		this.age=age;
		this.sung=sung;
		this.salary=salary;
		this.addr=addr; */
		//추가
		this.department=department;
	}
	//오버라이딩 기법
	public double bonus() {
		return salary*3.0;   //return salary*3.0
	}
	public void display() {
		/*System.out.println("==직원의 정보 출력==");
		System.out.println("이름=>"+name);
		System.out.println("나이=>"+age);
		System.out.println("성별=>"+sung);
		System.out.println("주소=>"+addr);
		System.out.println("급여=>"+salary);
		//자기 클래스내부에서 다른 메서드를 호출이 가능(생성자 처럼)
		System.out.println("보너스=>"+bonus());*/
		super.display();
		//추가된 내용
		System.out.println("담당 부서명=>"+department);
		System.out.println("부하직원의 수=>"+sub.length);
	}
}

//신입사원->정보저장,->부서배치에 팀장 정보 출력
public class Company {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.부하직원 3명(합격자)
		Employee e1=new Employee("홍길동",23,"남","서울시 강북구",1500);
		Employee e2=new Employee("이길수",35,"남","대전시 중구",1700);
		Employee e3=new Employee("임시",30,"여","부산시 ~",1800);
		//2.적합도 검사->영업부에 배치
		Manager m1=new Manager("테스트",42,"남",2500,"서울시 강남구","영업부");
		//3.부서배치->신입정보출력,팀장정보 출력->자료형 배열명=new 자료형[갯수]
		m1.sub=new Employee[3];//0,1,2->부하직원
		m1.sub[0]=e1;//홍길동의 정보
		m1.sub[1]=e2;//이길수
		m1.sub[2]=e3;//임시
		//부하직원 정보,팀장출력
		for(int i=0;i<m1.sub.length;i++) {
		//System.out.println("직원이름="+m1.sub[i].name); //e1.name
		//System.out.println("직원나이="+m1.sub[i].age);//e1.age
		//,,,
		   System.out.println("==================");
		   m1.sub[i].display();
		}
		//팀장1명
		m1.display(); //부모로 부터 물려받은 그대로 메서드를 호출
		//System.out.println("팀장의 부서명=>"+m1.department);//나중에 추가된 멤버변수
	}
}







