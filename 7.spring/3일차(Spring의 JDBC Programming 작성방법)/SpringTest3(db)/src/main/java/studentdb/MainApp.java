package studentdb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //1.xml파일 불러오기->resource폴더->xml파일명(Bean.xml)
		ApplicationContext context=
				      new ClassPathXmlApplicationContext("/studentdb/Bean.xml");
		//2.xml->getBean()
		StudentJDBCTemplate st=(StudentJDBCTemplate)
				                                 context.getBean("studentJDBCTemplate");
		//insert,update,delete,select
		System.out.println("st=>"+st);
		st.create("홍길동", 23);//1
		st.create("이길수", 34);//2->37 수정
		st.create("박영진", 45);//3->퇴사(삭제)
		st.create("임시", 22);
		st.create("테스트", 32);
		System.out.println("전체 레코드 검색중....");
		List<Student> sts=st.listStudents();//query(sql,mapper())
		for(Student record:sts) { //for(객체자료형 객체명:collection객체(배열)
		   System.out.println("id="+record.getId());
		   System.out.println("name="+record.getName());
		   System.out.println("age="+record.getAge());
		}//for
		//수정
		st.update(2, 37);//34->37
		//삭제
		System.out.println("삭제시킬 Record번호는 3번");
		st.delete(3);//3번 데이터 삭제
		//5번 데이터 검색
		Student record=st.getStudent(5);
		System.out.println("id="+record.getId());
		System.out.println("name="+record.getName());
		System.out.println("age="+record.getAge());
	}
}









