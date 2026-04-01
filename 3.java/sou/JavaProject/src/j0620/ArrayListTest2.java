package j0620;
//회원을 입력->회원로그인->관리자는 회원리스트
import java.io.*;//입력
import java.util.*;//Scanner,ArrayList~

//객체직렬화가 가능한 클래스=>implements Serializable
//Person객체 정보를 파일 또는 외부 컴퓨터로 데이터 전송이 가능

class Person implements Serializable{
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() { return name;}
	public int getAge() { return age;}
}

public class ArrayListTest2 {

    //PersonList을 출력 메서드
	public void getPersonList(ArrayList<Person> list) {
		//for(int i=0;i<list.size();i++){Person st=list.get(i);~}
		for(Person st:list) { //for(객체자료형 객체명:ArrayList객체명)
			System.out.println("이름=>"+st.getName());
			System.out.println("나이=>"+st.getAge());
			System.out.println("================");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
         System.out.println("사람이름?");
         String name=sc.next();//단어
         System.out.println("나이는?");
         int age=sc.nextInt();
         
         Person p=new Person();//new Person(name,age);
         p.setName(name);
         p.setAge(age);
         
         Person p2=new Person();
         p2.setName("임시2");
         p2.setAge(32);
         
         //ArrayList에 저장->ArrayList<String>
         //ArrayList<Object>  list=new ArrayList<Object>();
         ArrayList<Person>  list=new ArrayList<Person>();
         list.add(p); list.add(p2);
         ArrayListTest2 alt=new ArrayListTest2();
         alt.getPersonList(list);
	}
}





