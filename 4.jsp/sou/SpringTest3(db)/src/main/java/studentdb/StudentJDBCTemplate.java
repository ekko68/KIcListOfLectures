package studentdb;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;//DB접속
	//PreparedStatement pstmt와 역할이 비슷한 클래스
	private JdbcTemplate jdbcTemplateObject;//query(),update()사용
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource=dataSource;
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);//생성자
		System.out.println("setDataSource()호출돼서 DB연결됨!");
	}

	@Override
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
        //형식)jdbcTemplate객체명.update(실행시킬sql구문,입력받은값을 매개변수)
		String sql="insert into student(name,age) values(?,?)";
		jdbcTemplateObject.update(sql, name,age);
		System.out.println("생성된 레코드이름->+name="+name+",age="+age);
	}

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from student where id=?";
		//반환값=jdbc객체명.queryForObject(실행sql,매개변수(배열),RowMapper객체지정)
		//StudentMapper() sm=new StudentMapper();
		Student st=jdbcTemplateObject.queryForObject
				               (sql,new Object[] {id},new StudentMapper());
		return st;
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		String sql="select * from student";
		//반환값(List)=jdbc객체명.query(실행sql,RowMapper객체지정)
		//StudentMapper() sm=new StudentMapper();
		List<Student> sts=jdbcTemplateObject.query(sql,new StudentMapper());
		return sts;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete  from student where id=?";
		//jdbc객체명.update(실행sql,매개변수,,)
		jdbcTemplateObject.update(sql,id);
		System.out.println("삭제된 레코드 id=>"+id);
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String sql="update student set age=?  where id=?";
		//pstmt.setInt(1,age); pstmt.setInt(2,id)
		//jdbc객체명.update(실행sql,매개변수,,)
		jdbcTemplateObject.update(sql,age,id);
		System.out.println("수정된 id=>"+id);
	}
}







