package dr.mini.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;//mybatis의 @Select관련
import org.apache.ibatis.annotations.Update;

import dr.mini.domain.MemberCommand;//DTO

//웹상에서 호출할 메서드를 1.선언->2.구현상속(SQL구문을 작성->메서드작성)->3.xml적용
//SqlMapMemberDAO클래스 상속->MemberMapper.xml와 연결
public interface MemberDao {
	//1.회원 목록보기(페이징 처리)
    @Select(" select * from (select a.*, rownum rnum "
                +" from (select  * from member1 order by reg_date desc) a )"
                +" where rnum>=#{start} and rnum<=#{end}")
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	
	//2.총레코드수 구하기->형식@Select("실행할 SQL구문")
	@Select("select count(*) from member1")
	public int getMemberCount();
	
	//3.글쓰기
	@Insert("insert into member1(id,name,passwd,reg_date)"
                +" values(#{id},#{name},#{passwd},sysdate)")
	public void insertMember
	            (MemberCommand memberCommand);
	
	//4.회원정보보기
	@Select("select * from member1 where id=#{id}")
	public MemberCommand getMember(String id);
	
	
	//5.글수정하기
	@Update("update member1 "
			     +" set passwd=#{passwd},name=#{name}"
			     +" where id=#{id}")
	public void updateMember(MemberCommand member);
	
	//6.글삭제하기
	@Delete("delete from member1 where id=#{id}")
	public void deleteMember(String id);
	
}



