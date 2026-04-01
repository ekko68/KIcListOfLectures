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
}
