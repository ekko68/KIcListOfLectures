package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Admin.*;

public class CourseDAO {

	// DBConnectionMgr객체를 선언
	private DBConnectionMgr pool = null;

	// 생성자를 통해서 객체를 얻어온다. -> service 를 이용하여 객체를 얻어오는 방식 사용
	public CourseDAO() {
		try {
			pool = DBConnectionMgr.getInstance(); // 정적 메소드(getInstance)를 통해 객체를 얻어오기.
			System.out.println("pool : " + pool);
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}// 생성자

	// 1) 한 코스의 정보
	public CourseDTO getCourseDTO(int cosnum) {

		CourseDTO dto = new CourseDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection();
			String sql = "select cosnum, play, cosname, lv, intro from course where cosnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cosnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setCosnum(rs.getInt("cosnum"));
				dto.setPlay(rs.getString("play"));
				dto.setCosname(rs.getString("cosname"));
				dto.setLv(rs.getInt("lv"));
				dto.setIntro(rs.getString("intro"));
			}
		} catch (Exception e) {
			System.out.println("getCourseDTO()메서드 에러유발" + e);
			e.printStackTrace();
		}

		return dto;
	}

	// 2) 코스유형(paly or rest)과 레벨값(1~5) 조건에 맞는 코스 목록 조회
	public List getCourseList(String play, int lv) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List cosList = null; // ArrayList articleList=null;->10개씩
		// List<BoardDTO> articleList=null;
		try {
			con = pool.getConnection();
			String sql = "select cosnum, play, cosname, lv from course where play=? and lv=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, play);
			pstmt.setInt(2, lv);
			rs = pstmt.executeQuery();
			cosList = new ArrayList();

			while (rs.next()) {
				CourseDTO course = new CourseDTO();
				course.setCosnum(rs.getInt("cosnum"));
				course.setPlay(rs.getString("play"));
				course.setCosname(rs.getString("cosname"));
				course.setLv(rs.getInt("lv"));
				// course.setIntro(rs.getString("intro"));
				// 추가
				cosList.add(course);
			}
		} catch (Exception e) {
			System.out.println("getCourseList()메서드 에러유발" + e);
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return cosList;
	}

	// 3) 코스 검색 수
	public int getCourseCount(String play, int lv) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			con = pool.getConnection();
			System.out.println("con=" + con);
			String sql = "select count(*) from course where play=? and lv=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, play);
			pstmt.setInt(2, lv);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);// 필드명이 아니기때문에 select ~ from사이에 나오는순서
			}
		} catch (Exception e) {
			System.out.println("getCourseCount()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// 4) 코스넘버 n에 포함된 여행지 정보 조회
	public List getCourseNumList(int cosnum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List cosnumList = null; // ArrayList articleList=null;->10개씩
		// List<BoardDTO> articleList=null;
		try {
			con = pool.getConnection();
			String sql = "select c.cosnum, c.lv, l.locnum, m.locname, m.locationx, m.locationy, m.loctype "
					+ "from course c, cosloc l, map m " + "where l.locnum=m.locnum " + "and c.cosnum=l.cosnum "
					+ "and c.cosnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cosnum);
			rs = pstmt.executeQuery();
			cosnumList = new ArrayList();

			while (rs.next()) {
				CourseDTO course = new CourseDTO();
				course.setCosnum(rs.getInt("cosnum"));
				course.setLv(rs.getInt("lv"));

				CoslocDTO cosloc = new CoslocDTO();
				cosloc.setLocnum(rs.getString("locnum"));

				MapDTO map = new MapDTO();
				map.setLocnum(rs.getInt("locnum"));
				map.setLocname(rs.getString("locname"));
				map.setLocationx(rs.getDouble("locationx"));
				map.setLocationy(rs.getDouble("locationy"));
				map.setLoctype(rs.getString("loctype"));

				// 추가
				cosnumList.add(course);
				cosnumList.add(cosloc);
				cosnumList.add(map);

			}
		} catch (Exception e) {
			System.out.println("getCourseList()메서드 에러유발" + e);
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return cosnumList;
	}

}
