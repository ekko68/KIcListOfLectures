package j0601.sub;

//개인 정보를 저장(추상화+캡슐화+생성자(다형성))
class Person{ //홍길동

	//1.멤버변수
private	String name;//null
private	int age;//0
//private String addr;//주소  (),(name),(age),(addr),(name,age),(age,addr),
//                                       (name,addr),(name,age,addr)
//(),(name),(age),(name,age)
   
//2.생성자->기본생성자->멤버변수에 값을 한꺼번에 저장시키기 위해서 사용
//Person(){}
 Person(){
	 name="홍길동"; 
	 age=23;
	 System.out.println("난 기본생성자 호출됨!");
 }
 //매개변수 1개
 Person(String n){
	 name=n;//name="김길수";
	 System.out.println("난 문자열한개를 입력받아 호출되는 생성자!");
 }

 Person(int a){
	 age=a;
	 System.out.println("난 정수한개를 입력받아 호출되는 생성자!");
 }
 //매개변수 2개
 Person(String n,int a){
	 name=n; //name="테스트"
	 age=a;   //age=27
	 System.out.println("난 매개변수2개를 입력받아 저장시키는 생성자!!");
 }
 //------------------------------------------------------------------------------
//3.Setter ,Getter 
  public void setName(String n) {
	  name=n;//name="홍길동"
  }
  public void setAge(int a) {
	  age=a;//age=31
  }
  //Getter Method
  public String getName() { return name;}
  public int getAge() { return age;}
  //멤버변수 값만 따로 출력->단순,반복
  void print() {
	  System.out.println("이름=>"+name);
	  System.out.println("나이=>"+age);
  }
}
public class PersonHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//설계도명 객체명=new 생성자명()
          Person p=new Person();//기본생성자를 호출하는 문장
          //p.setName("홍길동");
          //p.setAge(25);
          p.print();
          System.out.println("매개변수 1개짜리 생성자를 이용");
          Person p2=new Person("김길수");//이름(생성자),나이(Setter Method)
          p2.setAge(31);
          p2.print();
          System.out.println("매개변수 2개짜리 생성자를 이용");
          Person p3=new Person("테스트",27);
          System.out.println("이름=>"+p3.getName());//return name
          System.out.println("나이=>"+p3.getAge()); //return age
	}
}





