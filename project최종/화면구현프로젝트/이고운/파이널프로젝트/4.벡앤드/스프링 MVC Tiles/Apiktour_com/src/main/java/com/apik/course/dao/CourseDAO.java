package com.apik.course.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

public interface CourseDAO {

	public int selectCosCount();

	public int getCourseCount(Map<String, Object> map);

	public List<CourseCommand> getCourseList(Map<String, Object> map);

	public List<CourseVO> getCourseNumList(int cosnum);

	public int getCourseNumCount(int cosnumL);

	public List<CourseVO> getCourseMarkerList(Map<String, Object> map);

	// 관리자 페이지
	// 0.코스 검색 (searchcourse)
	public List<CourseCommand> searchcourse(CourseCommand courseDto) throws DataAccessException;
	// 1.코스 목록 (listcourse)
	public List<CourseCommand> listcourse() throws DataAccessException;
	public int countcourse() throws DataAccessException;
	public int countsearchcourse(CourseCommand courseDto) throws DataAccessException;
	// 3. 코스 등록 (insertcourse)
	public void insertcourse(CourseCommand courseDto) throws DataAccessException;
	// 4. 코스 수정 (updatecourse)
	public void updatecourse(CourseCommand courseDto) throws DataAccessException;
	// 6. 코스 삭제 (deletecourse)
	public void deletecourse(String cosnum) throws DataAccessException;
	// 7.코스 상세정보
	public CourseCommand detailscourse(String cosnum) throws DataAccessException;

}
