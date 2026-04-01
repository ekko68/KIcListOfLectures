package com.apik.course.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.course.dao.CourseDAO;
import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

public class CourseDaoImpl extends SqlSessionDaoSupport implements CourseDAO {
	
	@Override
	public int selectCosCount() {
		// TODO Auto-generated method stub
		//int count=(Integer)getSqlSession().selectOne("selectCount");
		//return count;				
		return getSqlSession().selectOne("selectCosCount");
	}
	
	@Override
	public int getCourseCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCourseCount", map);
	}

	@Override
	public List<CourseCommand> getCourseList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 List<CourseCommand> list=getSqlSession().selectList("selectCourseList", map);
		 return list;
	}
	
	@Override
	public List<CourseVO> getCourseNumList(int cosnum) {
		List<CourseVO> list=getSqlSession().selectList("selectCourseNumList", cosnum);
		return list;
	}

	@Override
	public int getCourseNumCount(int cosnumL) {
		return getSqlSession().selectOne("selectCourseNumCount", cosnumL);
	}

	@Override
	public List<CourseVO> getCourseMarkerList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<CourseVO> list=getSqlSession().selectList("selectCourseMarker", map);
		 return list;
	}
	

	//관리자 페이지
	//코스 검색
	@Override
	public List<CourseCommand> searchcourse(CourseCommand courseDto) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("searchcourse 메소드 실행");
		return getSqlSession().selectList("searchcourse",courseDto);
	}
	
	//코스 목록
	@Override
	public List<CourseCommand> listcourse() throws DataAccessException {
		// TODO Auto-generated method stub
		List<CourseCommand> listcourse=getSqlSession().selectList("listcourse");
		return listcourse;
	}
	
	//검색된 목록 수
	@Override
	public int countcourse() throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCosCount");
	}
	@Override
	public int countsearchcourse(CourseCommand courseDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countsearchcourse",courseDto);
	}
	
	
	//코스 등록
	@Override
	public void insertcourse(CourseCommand courseDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertcourse",courseDto);
	}
	
	//코스 상세정보
	@Override
	public CourseCommand detailscourse(String cosnum) throws DataAccessException {
		// TODO Auto-generated method stub
		return (CourseCommand)getSqlSession().selectOne("detailscourse",cosnum);
	}
	
	//코스 수정
	@Override
	public void updatecourse(CourseCommand courseDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updatecourse",courseDto);
	}
	
	//코스 삭제
	@Override
	public void deletecourse(String cosnum) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().delete("deletecourse",cosnum);
	}
	
	
}
