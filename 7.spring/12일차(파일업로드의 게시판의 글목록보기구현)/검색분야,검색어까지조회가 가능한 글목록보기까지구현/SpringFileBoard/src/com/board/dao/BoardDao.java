package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardCommand;

public interface BoardDao {

	//1.목록보기
	public List<BoardCommand> list(Map<String,Object>map);
	
	//2.총레코드수
	public int getRowCount(Map<String,Object>map);
	
	//3.글쓰기...
}
