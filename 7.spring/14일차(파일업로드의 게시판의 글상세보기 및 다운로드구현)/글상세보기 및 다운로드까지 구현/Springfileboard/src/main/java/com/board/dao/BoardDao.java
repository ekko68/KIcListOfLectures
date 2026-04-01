package com.board.dao;

//게시판의 공통적으로 사용하는 추상메서드
import java.util.*;
import com.board.domain.BoardCommand; //서로 다른 패키지는 import 건다.

public interface BoardDao { //->BoardDaoImpl
  //1.글목록보기
  public List<BoardCommand> list(Map<String,Object> map); //검색분야,검색어
  //2.총갯수->페이징 처리때문에(검색분야,검색어)->검색어에 대해서 갯수가 달라진다
  public int getRowCount(Map<String,Object> map);
  //3.최대글 번호 얻어오기
  public int getNewSeq();
  
  //4.게시판의 글쓰기
  public void insert(BoardCommand board);
  
  //5.게시물에 대한 게시물(레코드)한개 찾기
  public BoardCommand selectBoard(Integer seq);//~(int seq);
  
  //6.게시물번호에 해당하는 조회수 증가
  public void updateHit(Integer seq);
  
  //7.글 수정하기
  public void update(BoardCommand board);
  
  //8.글 삭제하기
  public void delete(Integer seq);
  
}






