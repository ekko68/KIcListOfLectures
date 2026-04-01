package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.board.domain.BoardCommand;

//SqlSession객체->MyBatis와 연동

@Component
public class BoardDaoImpl 
                       extends SqlSessionDaoSupport 
                                           implements BoardDao {

	//검색분야에 따른 검색어까지 조회(페이징 처리)
	@Override
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=
				getSqlSession().selectList("selectList",map);
		System.out.println("ListDaoImpl테스트중...");
		return list;
	}

	//검색분야에 따른 검색어에 해당하는 총레코드수
	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println("getRowCount()호출");
		return getSqlSession().selectOne("selectCount",map);
	}

}
