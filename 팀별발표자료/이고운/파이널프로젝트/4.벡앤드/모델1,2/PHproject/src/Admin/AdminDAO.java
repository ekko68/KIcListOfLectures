package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Admin.*;

public class AdminDAO {

	// 1.DBConnectionMgr객체를 선언
	private DBConnectionMgr pool = null;

	// 2.생성자를 통해서 객체를 얻어온다. -> service 를 이용하여 객체를 얻어오는 방식 사용
	public AdminDAO() {
		try {
			pool = DBConnectionMgr.getInstance(); // 정적 메소드(getInstance)를 통해 객체를
													// 얻어오기.
			System.out.println("pool : " + pool);
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}// 생성자

	// 1) 아이디 체크
	// 신규 id 와 기존 id가 중복되는지 체크 해주는 메소드
	public boolean checkId(String id) {
		// loginCheck메소드에 있는 코드를 복사해서 수정해서 사용
		// 1. DB연결 코딩
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;

		// 2. 실행시킬 sql문
		String sql = "select id from Person where id=?";
		try {
			con = pool.getConnection();
			System.out.println("con : " + con);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // ?에 무엇을 넣을지 선언
			rs = pstmt.executeQuery();
			check = rs.next(); // 데이터가 있으면 true, 없으면 false
		} catch (Exception e) {
			System.out.println("checkId()메소드 에러 : " + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		} // 3. DB 연결 해제
		return check;
	}

	// 2) 회원 등록 추가 메소드 -> DB에 등록
	public boolean PersonInsert(PersonDTO per) {
		// loginCheck메소드에 있는 코드를 복사해서 수정해서 사용
		// 1. DB연결 코딩
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean check = false; // 회원 추가 성공 유무
		
		
		System.out.println(" get Id : "+per.getId());
		System.out.println(" getPasswd : "+per.getPasswd());
		System.out.println(" getName : "+per.getName());
		System.out.println(" getGender : "+per.getGender());
		System.out.println(" getAge : "+per.getAge());

		// 2. 실행시킬 sql문
		String sql = "insert into Person values(?,?,?,?,?)";
		try {
			con = pool.getConnection();
			// 트렉젝션 처리
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, per.getId());
			pstmt.setString(2, per.getPasswd());
			pstmt.setString(3, per.getName());
			pstmt.setString(4, per.getGender());
			pstmt.setString(5, per.getAge());			

			int insert = pstmt.executeUpdate();
			System.out.println("insert 성공유무 : " + insert);
			System.out.println("insert sql : "+sql);
			con.commit();
			if (insert == 1)
				check = true;
		} catch (Exception e) {
			System.out.println("PersonInsert()메소드 에러 : " + e);
		} finally {
			pool.freeConnection(con, pstmt);
		} // 3. DB 연결 해제
		return check;
	}

	
	// 3) 회원 리스트

	//3) 회원 리스트
	public List getMemberList() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List memList = null; // ArrayList articleList=null;->10개씩
		// List<BoardDTO> articleList=null;
		try {
			con = pool.getConnection();
			String sql = "select * from Person";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memList = new ArrayList();
			while (rs.next()) {
					PersonDTO person = new PersonDTO();
					person.setId(rs.getString("id"));
					person.setPasswd(rs.getString("passwd"));
					person.setName(rs.getString("name"));
					person.setGender(rs.getString("gender"));
					person.setAge(rs.getString("age"));
					// 추가
					memList.add(person);
			}
		} catch (Exception e) {
			System.out.println("getMember()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return memList;
	}
	
	
}