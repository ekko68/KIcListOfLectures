package lys.board;

//DBConnectionMgr(DB에 접속),BoardDTO(매개변수,반환형)
//DB사용하기위해서
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//ArrayList,List을 사용하기위해서
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private DBConnectionMgr pool = null;// 1.선언

	// 2.생성자를 통해서 연결=>의존성
	public BoardDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
			System.out.println("pool=>" + pool);
		} catch (Exception e) {
			System.out.println("Error접속 오류=>" + e);
		}
	}
	// 3-1)페이징 처리를 위해서 전체 레코드수를 구해와야 된다.
	// select count(*) from board->select count(*) from member
	// wherew 조건식이 없으면 매개변수 X

	public int getArticleCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;

		try {
			con = pool.getConnection();
			System.out.println("con=" + con);
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);// 필드명이 아니기때문에 select ~ from사이에 나오는순서
			}
		} catch (Exception e) {
			System.out.println("getArticleCount()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// 3-2)글목록보기에 대한 메서드 구현(매개변수)->범위를 지정->zipcode확인
	// 1.레코드의 시작번호, 2.불러올 레코드의 갯수
	// public List<BoardDTO>
	public List getArticles(int start, int end) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null; // ArrayList articleList=null;->10개씩
		// List<BoardDTO> articleList=null;
		try {
			con = pool.getConnection();
			String sql = "select * from board order by ref desc,re_step asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);// mysql이 레코드순번은 내부적으로 0부터
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 레코드가 존재한다면(1개)
				// articleList=new List(); X
				// articleList=new 자식클래스명();
				articleList = new ArrayList(end);// end갯수만큼 데이터를 담기위해서
				do {
					BoardDTO article = new BoardDTO();
					article.setNum(rs.getInt("num"));// 최대값+1->코딩
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));// 오늘날짜->코딩 now()
					article.setReadcount(rs.getInt("readcount"));// ->default->0
					article.setRef(rs.getInt("ref"));// 그룹번호->언어
					article.setRe_step(rs.getInt("re_step"));// 답변글순서->언어
					article.setRe_level(rs.getInt("re_level"));// 답변의 깊이
					article.setContent(rs.getString("content"));// 글내용
					article.setIp(rs.getString("ip"));// 글쓴이의 ip주소->request.getRemoteAddr();
					// 추가
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getArticleCount()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return articleList;
	}

	// 게시판의 글쓰기 및 글 답변달기
	// insert into board values(~)
	public void insertArticle(BoardDTO article) { // ~(MemberDTO mem)

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// num의 최대값을 구해야 된다.->select

		// article->신규글인지 답변글인지 구분
		int num = article.getNum();// 0(신규글) 인지 아닌지를 체크->답변글
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		// 테이블에 입력할 게시물 번호 저장할 변수
		int number = 0;
		System.out.println("insertArticle메서드의 내부의  num=" + num);
		System.out.println("ref=" + ref + ",re_step=>" + re_step + ",re_level=" + re_level);
		String sql = "";
		try {
			con = pool.getConnection();
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 현재 테이블에서 데이터가 한개라도 존재한다면
				number = rs.getInt(1) + 1;// 필드명이 아니기때문에 select ~ from사이에 나오는순서
			} else {// 맨 처음에 레코드가 한개라도 없는 경우->무조건 number=1
				number = 1;
			}

			// 만약에 답변글이라면
			// 같은 그룹번호 이면서 나보다 step값이 큰 놈을 찾아서 그 step을 하나 증가
			if (num != 0) {
				sql = "update board set re_step=re_step+1 where ref=? and re_step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				int update = pstmt.executeUpdate();
				System.out.println("댓글수정유무(update)=>" + update);
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else { // 신규글이라면
				ref = number;// ref=1,2,3,4,5
				re_step = 0;
				re_level = 0;
			}
			// 12개 ->num,reg_date,readcount(생략)->sysdate ,now()<-?대신에
			sql = "insert into board(writer,email,subject,passwd,reg_date,";
			sql += " ref,re_step,re_level,content,ip)values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());// 작성자
			pstmt.setString(2, article.getEmail());// 이메일
			pstmt.setString(3, article.getSubject());// 글제목
			pstmt.setString(4, article.getPasswd());// 암호
			pstmt.setTimestamp(5, article.getReg_date());
			// ------ref,re_step,re_level->신규글 또는 답변글에 맞는 계산값이 적용
			pstmt.setInt(6, ref);// pstmt.setInt(6, article.getRef());X
			pstmt.setInt(7, re_step);// 0
			pstmt.setInt(8, re_level);// 0
			// -------------------------------------------------------------------------
			pstmt.setString(9, article.getContent());// 글내용
			pstmt.setString(10, article.getIp());// request.getRemoteAddr(); //jsp
			int insert = pstmt.executeUpdate();
			System.out.println("게시판의 글쓰기 성공유무(insert)=" + insert);
		} catch (Exception e) {
			System.out.println("insertArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}

	// 글상세보기의 메서드를 호출=>select * from board where num=3;
	// 1.게시물에 해당되는 조회수를 증가 2.증가된 조회수를 가진 레코드를 출력
	public BoardDTO getArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO article = null;// 게시물번호에 해당하는 레코드 한개를 담을 변수

		try {
			con = pool.getConnection();
			String sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);//
			int update = pstmt.executeUpdate();
			System.out.println("조회수 증가유무(update)=>" + update);

			sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 레코드가 존재한다면(1개)
				article = makeArticleFromResult(rs);
				/*
				 * article = new BoardDTO(); article.setNum(rs.getInt("num"));// 최대값+1->코딩
				 * article.setWriter(rs.getString("writer"));
				 * article.setEmail(rs.getString("email"));
				 * article.setSubject(rs.getString("subject"));
				 * article.setPasswd(rs.getString("passwd"));
				 * article.setReg_date(rs.getTimestamp("reg_date"));// 오늘날짜->코딩 now()
				 * article.setReadcount(rs.getInt("readcount"));// ->default->0
				 * article.setRef(rs.getInt("ref"));// 그룹번호->언어
				 * article.setRe_step(rs.getInt("re_step"));// 답변글순서->언어
				 * article.setRe_level(rs.getInt("re_level"));// 답변의 깊이
				 * article.setContent(rs.getString("content"));// 글내용
				 * article.setIp(rs.getString("ip"));
				 */// 글쓴이의 ip주소->request.getRemoteAddr();
			}
		} catch (Exception e) {
			System.out.println("getArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// 글 수정을 하기위한 게시물번호에 해당하는 레코드 찾는 메서드
	public BoardDTO updateGetArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO article = null;// 게시물번호에 해당하는 레코드 한개를 담을 변수

		try {
			con = pool.getConnection();
			String sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 레코드가 존재한다면(1개)
				article = makeArticleFromResult(rs);
				/*
				 * article = new BoardDTO(); article.setNum(rs.getInt("num"));// 최대값+1->코딩
				 * article.setWriter(rs.getString("writer"));
				 * article.setEmail(rs.getString("email"));
				 * article.setSubject(rs.getString("subject"));
				 * article.setPasswd(rs.getString("passwd"));
				 * article.setReg_date(rs.getTimestamp("reg_date"));// 오늘날짜->코딩 now()
				 * article.setReadcount(rs.getInt("readcount"));// ->default->0
				 * article.setRef(rs.getInt("ref"));// 그룹번호->언어
				 * article.setRe_step(rs.getInt("re_step"));// 답변글순서->언어
				 * article.setRe_level(rs.getInt("re_level"));// 답변의 깊이
				 * article.setContent(rs.getString("content"));// 글내용
				 * article.setIp(rs.getString("ip"));
				 */// 글쓴이의 ip주소->request.getRemoteAddr();
			}
		} catch (Exception e) {
			System.out.println("updateGetArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// 중복된 레코드 한개를 담을 수있는 메서드를 따로 처리해주는 메서드 작성
	private BoardDTO makeArticleFromResult(ResultSet rs) throws Exception {

		BoardDTO article = new BoardDTO();
		article.setNum(rs.getInt("num"));// 최대값+1->코딩
		article.setWriter(rs.getString("writer"));
		article.setEmail(rs.getString("email"));
		article.setSubject(rs.getString("subject"));
		article.setPasswd(rs.getString("passwd"));
		article.setReg_date(rs.getTimestamp("reg_date"));// 오늘날짜->코딩 now()
		article.setReadcount(rs.getInt("readcount"));// ->default->0
		article.setRef(rs.getInt("ref"));// 그룹번호->언어
		article.setRe_step(rs.getInt("re_step"));// 답변글순서->언어
		article.setRe_level(rs.getInt("re_level"));// 답변의 깊이
		article.setContent(rs.getString("content"));// 글내용
		article.setIp(rs.getString("ip"));
		return article;
	}

	// 글 수정시켜주는 메서드->insertArticle와 거의 동일=>암호를 물어본다.
	//updatePro.jsp
	public int updateArticle(BoardDTO article) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// passwd를 조회할 >select
		String dbpasswd = null;// db에서 찾은 암호를 저장
		String sql = "";
		int x = -1;// 게시물의 수정성공유무

		try {
			con = pool.getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getNum());// 여러개를 입력->필드별로 Getter호출
			rs = pstmt.executeQuery();
			if (rs.next()) { // 현재 테이블에서 데이터가 한개라도 존재한다면
				dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd=>" + dbpasswd);
				// db상의 암호=웹상에 입력한 암호가 맞다면
				if (dbpasswd.equals(article.getPasswd())) {

					// 12개 ->num,reg_date,readcount(생략)->sysdate ,now()<-?대신에
					sql = "update board set writer=?, email=?, subject=?, passwd=?,";
					sql += " content=?  where num=?";
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, article.getWriter());// 작성자
					pstmt.setString(2, article.getEmail());// 이메일
					pstmt.setString(3, article.getSubject());// 글제목
					pstmt.setString(4, article.getPasswd());// 암호
					pstmt.setString(5, article.getContent());// 글내용
					pstmt.setInt(6, article.getNum());

					int update = pstmt.executeUpdate();
					System.out.println("게시판의 글수정 성공유무(update)=" + update);
					x = 1;
				} else {
					x = 0;// 수정 실패
				}
			} // if(rs.next())
		} catch (Exception e) {
			System.out.println("updateArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// 글 삭제시켜주는 메서드->회원 탈퇴(삭제)=>암호를 물어본다.(deletePro.jsp)
	public int deleteArticle(int num, String passwd) { // 암호를 찾기위한 num
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// passwd를 조회할 >select
		String dbpasswd = null;// db에서 찾은 암호를 저장
		String sql = "";
		int x = -1;// 게시물의 삭제성공유무

		try {
			con = pool.getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);// 여러개를 입력->필드별로 Getter호출
			rs = pstmt.executeQuery();
			//pstmt.close();//메모리 해제 후
			if (rs.next()) { // 현재 테이블에서 데이터가 한개라도 존재한다면
				dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd=>" + dbpasswd);
				// db상의 암호=웹상에 입력한 암호가 맞다면
				if (dbpasswd.equals(passwd)) {
					sql = "delete from board  where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					int delete = pstmt.executeUpdate();
					System.out.println("게시판의 글삭제 성공유무(delete)="+delete);
					x = 1; //삭제성공
				} else {
					x = 0;// 삭제실패
				}
			} // if(rs.next())
		} catch (Exception e) {
			System.out.println("deleteArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
}



