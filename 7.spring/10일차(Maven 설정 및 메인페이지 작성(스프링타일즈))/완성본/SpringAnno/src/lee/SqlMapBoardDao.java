package lee;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

public class SqlMapBoardDao extends SqlSessionDaoSupport
                                                            implements BoardDAO {
	//sqlSession sqlSession 멤버변수선언X
    //글목록보기->ListActionController->list()
	@Override
	public List list() throws DataAccessException {
		// TODO Auto-generated method stub
		//형식) sqlSession객체명.selectOne(실행시킬 sql구문의 id값,매개변수명~)->레코드한개
		//형식) sqlSession객체명.selectList(실행시킬 sql구문의 id값,매개변수명~)->레코드 여러개
		return getSqlSession().selectList("list");
	}
	
	@Override
	public int getNewNum() throws DataAccessException {
		// TODO Auto-generated method stub
		//메모리상의 값(Object)->(Integer)->int
		//id값이 인식X->네임스페이스이름.실행시킬 id값 부여
		//<mapper namespace="board">=>board.getNewNum
		return (Integer)getSqlSession().selectOne("getNewNum");
	}
	
	@Override
	public void write(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		//insert태그->형식)sqlSession객체명.insert("실행시킬 id",매개변수명)
		getSqlSession().insert("write",data);
	}
	//retrieve.do?num=3
	@Override
	public void updateReadcnt(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		//update태그->형식)sqlSession객체명.update("실행시킬 id",매개변수명)
		getSqlSession().update("updateReadcnt", num); //#{num}
	}
	
	@Override
	public BoardCommand retrieve(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (BoardCommand)getSqlSession().selectOne("retrieve",num);
	}
	
	@Override
	public void update(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		//update태그->형식)sqlSession객체명.update("실행시킬 id",매개변수명)
		getSqlSession().update("update",data);
	}
	
	@Override
	public void delete(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		//update태그->형식)sqlSession객체명.delete("실행시킬 id",매개변수명)
		getSqlSession().delete("delete",num);
	}
	
	//------------------>(Map<String,Objec> data)
	@Override
	public List search(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("search",data);
	}
}




