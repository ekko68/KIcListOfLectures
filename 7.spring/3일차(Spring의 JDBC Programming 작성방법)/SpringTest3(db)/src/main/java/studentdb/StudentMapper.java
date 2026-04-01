package studentdb;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//Object->형변환을 시켜서 받을려고 제너릭 준거임 ->RowMapper<Student>
public class StudentMapper implements RowMapper<Student>{
	
   //callBack 메서드->내부적으로 자동적으로 호출해주는 메서드
	//1.ResultSet 객체 반환해준다.(테이블 정보), 검색된 갯수
  @Override
public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	  //if(rs.next()) or while(rs.next()) X
	  System.out.println("mapRow() 호출됨(rownum)=>"+rowNum);
	  //while(rs.next()){
	  Student st=new Student();//DTO객체생성
	  st.setId(rs.getInt("id"));
	  st.setName(rs.getString("name"));
	  st.setAge(rs.getInt("age"));
	return st; //query()의 반환값으로 받는다.
   }
}




