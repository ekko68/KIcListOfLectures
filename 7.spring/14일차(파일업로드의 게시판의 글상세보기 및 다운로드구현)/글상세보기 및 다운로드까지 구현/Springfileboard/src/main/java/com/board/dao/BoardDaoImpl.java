package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.board.domain.BoardCommand;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
   //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
   //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
	
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("list()호출됨!");
		return list;
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub //->Object->Integer->int로 변환
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount",map);
	}
	
	//최대값
	public int getNewSeq() {
			// TODO Auto-generated method stub
		//Object->Integer->int
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq()의 newseq=>"+newseq);
	    return newseq;
	    //return (Integer)getSqlSession().selectOne("getNewSeq");
    }
	//글쓰기
	public void insert(BoardCommand board) {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertBoard",board);
    }
	//레코드 한개
	public BoardCommand selectBoard(Integer seq) {
			// TODO Auto-generated method stub
		   //BoardCommand command=
		   //(BoardCommand)getSqlSession().selectOne("selectBoard",seq);
		   //return command;
			return (BoardCommand)getSqlSession().selectOne("selectBoard",seq);//Object->BoardCommand
		}
	//조회수 
	public void updateHit(Integer seq) {
			// TODO Auto-generated method stub
		getSqlSession().update("updateHit",seq);
		}
	
	//글수정하기
	public void update(BoardCommand board) {
			// TODO Auto-generated method stub
			
		}
	//글삭제하기
    public void delete(Integer seq) {
    		// TODO Auto-generated method stub
    		
    }
	
	
	
	
	
	
	
	
}



