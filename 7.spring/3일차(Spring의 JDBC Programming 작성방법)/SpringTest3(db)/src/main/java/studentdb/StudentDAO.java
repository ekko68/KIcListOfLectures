package studentdb;

//import java.sql.*  
//import javax.sql.*; (DataSource)
import javax.sql.DataSource;
import java.util.List;//여러개의 레코드 필요

public interface StudentDAO {
 
	//1.DB연결을 시켜주는 메서드 작성(초기화)->DataSource객체->DB연동
	public void setDataSource(DataSource ds);
	
	//2.insert
	public void create(String name,Integer age);//학생명,나이
	
	//3.학생정보->id값 ->select * from where id=1;
	public Student getStudent(Integer id);//(int id);
	
	//4.학생들 정보->select * from student
	public List<Student> listStudents();
	
	//5.학생정보를 삭제->delete from student where id=2;
	public void delete(Integer id);
	
	//6.학생정보를 수정->update 테이블명 set 필드명=값,,,where 
	public void update(Integer id,Integer age);//(int ,int)
}






