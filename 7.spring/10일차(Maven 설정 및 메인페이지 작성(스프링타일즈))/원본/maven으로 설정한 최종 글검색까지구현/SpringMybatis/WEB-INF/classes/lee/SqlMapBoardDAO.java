package lee;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

//실질적으로 웹상에서 호출할 메서드를 구현->Mybatis->메서드호출
//SqlSessionDaoSupport클래스상속->getSqlSession()

public class SqlMapBoardDAO 
                                extends SqlSessionDaoSupport 
                                          implements BoardDAO {
     //sqlSessionFactory->setSqlSessionFactory(~)
	
	@Override
	public List list() throws DataAccessException {
		// TODO Auto-generated method stub
		//DB에 접속->sql구문을 실행->결과값만 반환
		//->컨트럴러클래스->jsp에 전달
		//형식)sqlSession객체명.selectOne(xml의 id값)->레코드한개
		//형식)sqlSession객체명.selectList(xml의 id값)->한개이상
		
		return getSqlSession().selectList("list");
	}
	
	//Board.xml->sql구문 등록
	@Override
	public int getNewNum() throws DataAccessException {
		// TODO Auto-generated method stub
		//(형변환)sqlSession객체명.selectOne(xml의 id)
		//Object->Integer->int
		return (Integer)getSqlSession().selectOne("getNewNum");
	}
	
	@Override
	public void write(BoardCommand board) throws DataAccessException {
		// TODO Auto-generated method stub
		//getSqlSession().insert|update|delete(xml의 id값,전달할 매개변수명)
		getSqlSession().insert("write",board);
	}
	
	@Override
	public void updatecnt(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updatecnt", num);
	}
	
	@Override
	public BoardCommand retrieve(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (BoardCommand)
				getSqlSession().selectOne("retrieve",num);
	}
	//글수정하기
	@Override
	public void update(BoardCommand board) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("update",board);
	}
	//글삭제하는 메서드 작성->delete(~)
	@Override
	public void delete(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().delete("delete",num);
	}
	//검색하기
	@Override
	public List search(BoardCommand board) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("search",board);
	}
}



