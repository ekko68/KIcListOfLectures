package lys.board;

//DBConnectionMgr(DB�� ����),BoardDTO(�Ű�����,��ȯ��)
//DB����ϱ����ؼ�
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//ArrayList,List�� ����ϱ����ؼ�
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private DBConnectionMgr pool = null;// 1.����

	// 2.�����ڸ� ���ؼ� ����=>������
	public BoardDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
			System.out.println("pool=>" + pool);
		} catch (Exception e) {
			System.out.println("Error���� ����=>" + e);
		}
	}
	// 3-1)����¡ ó���� ���ؼ� ��ü ���ڵ���� ���ؿ;� �ȴ�.
	// select count(*) from board->select count(*) from member
	// wherew ���ǽ��� ������ �Ű����� X

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
				x = rs.getInt(1);// �ʵ���� �ƴϱ⶧���� select ~ from���̿� �����¼���
			}
		} catch (Exception e) {
			System.out.println("getArticleCount()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// 3-2)�۸�Ϻ��⿡ ���� �޼��� ����(�Ű�����)->������ ����->zipcodeȮ��
	// 1.���ڵ��� ���۹�ȣ, 2.�ҷ��� ���ڵ��� ����
	// public List<BoardDTO>
	public List getArticles(int start, int end) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null; // ArrayList articleList=null;->10����
		// List<BoardDTO> articleList=null;
		try {
			con = pool.getConnection();
			String sql = "select * from board order by ref desc,re_step asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);// mysql�� ���ڵ������ ���������� 0����
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {// ���ڵ尡 �����Ѵٸ�(1��)
				// articleList=new List(); X
				// articleList=new �ڽ�Ŭ������();
				articleList = new ArrayList(end);// end������ŭ �����͸� ������ؼ�
				do {
					BoardDTO article = new BoardDTO();
					article.setNum(rs.getInt("num"));// �ִ밪+1->�ڵ�
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));// ���ó�¥->�ڵ� now()
					article.setReadcount(rs.getInt("readcount"));// ->default->0
					article.setRef(rs.getInt("ref"));// �׷��ȣ->���
					article.setRe_step(rs.getInt("re_step"));// �亯�ۼ���->���
					article.setRe_level(rs.getInt("re_level"));// �亯�� ����
					article.setContent(rs.getString("content"));// �۳���
					article.setIp(rs.getString("ip"));// �۾����� ip�ּ�->request.getRemoteAddr();
					// �߰�
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getArticleCount()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return articleList;
	}

	// �Խ����� �۾��� �� �� �亯�ޱ�
	// insert into board values(~)
	public void insertArticle(BoardDTO article) { // ~(MemberDTO mem)

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// num�� �ִ밪�� ���ؾ� �ȴ�.->select

		// article->�űԱ����� �亯������ ����
		int num = article.getNum();// 0(�űԱ�) ���� �ƴ����� üũ->�亯��
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		// ���̺� �Է��� �Խù� ��ȣ ������ ����
		int number = 0;
		System.out.println("insertArticle�޼����� ������  num=" + num);
		System.out.println("ref=" + ref + ",re_step=>" + re_step + ",re_level=" + re_level);
		String sql = "";
		try {
			con = pool.getConnection();
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { // ���� ���̺��� �����Ͱ� �Ѱ��� �����Ѵٸ�
				number = rs.getInt(1) + 1;// �ʵ���� �ƴϱ⶧���� select ~ from���̿� �����¼���
			} else {// �� ó���� ���ڵ尡 �Ѱ��� ���� ���->������ number=1
				number = 1;
			}

			// ���࿡ �亯���̶��
			// ���� �׷��ȣ �̸鼭 ������ step���� ū ���� ã�Ƽ� �� step�� �ϳ� ����
			if (num != 0) {
				sql = "update board set re_step=re_step+1 where ref=? and re_step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				int update = pstmt.executeUpdate();
				System.out.println("��ۼ�������(update)=>" + update);
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else { // �űԱ��̶��
				ref = number;// ref=1,2,3,4,5
				re_step = 0;
				re_level = 0;
			}
			// 12�� ->num,reg_date,readcount(����)->sysdate ,now()<-?��ſ�
			sql = "insert into board(writer,email,subject,passwd,reg_date,";
			sql += " ref,re_step,re_level,content,ip)values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());// �ۼ���
			pstmt.setString(2, article.getEmail());// �̸���
			pstmt.setString(3, article.getSubject());// ������
			pstmt.setString(4, article.getPasswd());// ��ȣ
			pstmt.setTimestamp(5, article.getReg_date());
			// ------ref,re_step,re_level->�űԱ� �Ǵ� �亯�ۿ� �´� ��갪�� ����
			pstmt.setInt(6, ref);// pstmt.setInt(6, article.getRef());X
			pstmt.setInt(7, re_step);// 0
			pstmt.setInt(8, re_level);// 0
			// -------------------------------------------------------------------------
			pstmt.setString(9, article.getContent());// �۳���
			pstmt.setString(10, article.getIp());// request.getRemoteAddr(); //jsp
			int insert = pstmt.executeUpdate();
			System.out.println("�Խ����� �۾��� ��������(insert)=" + insert);
		} catch (Exception e) {
			System.out.println("insertArticle()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}

	// �ۻ󼼺����� �޼��带 ȣ��=>select * from board where num=3;
	// 1.�Խù��� �ش�Ǵ� ��ȸ���� ���� 2.������ ��ȸ���� ���� ���ڵ带 ���
	public BoardDTO getArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO article = null;// �Խù���ȣ�� �ش��ϴ� ���ڵ� �Ѱ��� ���� ����

		try {
			con = pool.getConnection();
			String sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);//
			int update = pstmt.executeUpdate();
			System.out.println("��ȸ�� ��������(update)=>" + update);

			sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {// ���ڵ尡 �����Ѵٸ�(1��)
				article = makeArticleFromResult(rs);
				/*
				 * article = new BoardDTO(); article.setNum(rs.getInt("num"));// �ִ밪+1->�ڵ�
				 * article.setWriter(rs.getString("writer"));
				 * article.setEmail(rs.getString("email"));
				 * article.setSubject(rs.getString("subject"));
				 * article.setPasswd(rs.getString("passwd"));
				 * article.setReg_date(rs.getTimestamp("reg_date"));// ���ó�¥->�ڵ� now()
				 * article.setReadcount(rs.getInt("readcount"));// ->default->0
				 * article.setRef(rs.getInt("ref"));// �׷��ȣ->���
				 * article.setRe_step(rs.getInt("re_step"));// �亯�ۼ���->���
				 * article.setRe_level(rs.getInt("re_level"));// �亯�� ����
				 * article.setContent(rs.getString("content"));// �۳���
				 * article.setIp(rs.getString("ip"));
				 */// �۾����� ip�ּ�->request.getRemoteAddr();
			}
		} catch (Exception e) {
			System.out.println("getArticle()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// �� ������ �ϱ����� �Խù���ȣ�� �ش��ϴ� ���ڵ� ã�� �޼���
	public BoardDTO updateGetArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO article = null;// �Խù���ȣ�� �ش��ϴ� ���ڵ� �Ѱ��� ���� ����

		try {
			con = pool.getConnection();
			String sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {// ���ڵ尡 �����Ѵٸ�(1��)
				article = makeArticleFromResult(rs);
				/*
				 * article = new BoardDTO(); article.setNum(rs.getInt("num"));// �ִ밪+1->�ڵ�
				 * article.setWriter(rs.getString("writer"));
				 * article.setEmail(rs.getString("email"));
				 * article.setSubject(rs.getString("subject"));
				 * article.setPasswd(rs.getString("passwd"));
				 * article.setReg_date(rs.getTimestamp("reg_date"));// ���ó�¥->�ڵ� now()
				 * article.setReadcount(rs.getInt("readcount"));// ->default->0
				 * article.setRef(rs.getInt("ref"));// �׷��ȣ->���
				 * article.setRe_step(rs.getInt("re_step"));// �亯�ۼ���->���
				 * article.setRe_level(rs.getInt("re_level"));// �亯�� ����
				 * article.setContent(rs.getString("content"));// �۳���
				 * article.setIp(rs.getString("ip"));
				 */// �۾����� ip�ּ�->request.getRemoteAddr();
			}
		} catch (Exception e) {
			System.out.println("updateGetArticle()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// �ߺ��� ���ڵ� �Ѱ��� ���� ���ִ� �޼��带 ���� ó�����ִ� �޼��� �ۼ�
	private BoardDTO makeArticleFromResult(ResultSet rs) throws Exception {

		BoardDTO article = new BoardDTO();
		article.setNum(rs.getInt("num"));// �ִ밪+1->�ڵ�
		article.setWriter(rs.getString("writer"));
		article.setEmail(rs.getString("email"));
		article.setSubject(rs.getString("subject"));
		article.setPasswd(rs.getString("passwd"));
		article.setReg_date(rs.getTimestamp("reg_date"));// ���ó�¥->�ڵ� now()
		article.setReadcount(rs.getInt("readcount"));// ->default->0
		article.setRef(rs.getInt("ref"));// �׷��ȣ->���
		article.setRe_step(rs.getInt("re_step"));// �亯�ۼ���->���
		article.setRe_level(rs.getInt("re_level"));// �亯�� ����
		article.setContent(rs.getString("content"));// �۳���
		article.setIp(rs.getString("ip"));
		return article;
	}

	// �� ���������ִ� �޼���->insertArticle�� ���� ����=>��ȣ�� �����.
	//updatePro.jsp
	public int updateArticle(BoardDTO article) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// passwd�� ��ȸ�� >select
		String dbpasswd = null;// db���� ã�� ��ȣ�� ����
		String sql = "";
		int x = -1;// �Խù��� ������������

		try {
			con = pool.getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getNum());// �������� �Է�->�ʵ庰�� Getterȣ��
			rs = pstmt.executeQuery();
			if (rs.next()) { // ���� ���̺��� �����Ͱ� �Ѱ��� �����Ѵٸ�
				dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd=>" + dbpasswd);
				// db���� ��ȣ=���� �Է��� ��ȣ�� �´ٸ�
				if (dbpasswd.equals(article.getPasswd())) {

					// 12�� ->num,reg_date,readcount(����)->sysdate ,now()<-?��ſ�
					sql = "update board set writer=?, email=?, subject=?, passwd=?,";
					sql += " content=?  where num=?";
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, article.getWriter());// �ۼ���
					pstmt.setString(2, article.getEmail());// �̸���
					pstmt.setString(3, article.getSubject());// ������
					pstmt.setString(4, article.getPasswd());// ��ȣ
					pstmt.setString(5, article.getContent());// �۳���
					pstmt.setInt(6, article.getNum());

					int update = pstmt.executeUpdate();
					System.out.println("�Խ����� �ۼ��� ��������(update)=" + update);
					x = 1;
				} else {
					x = 0;// ���� ����
				}
			} // if(rs.next())
		} catch (Exception e) {
			System.out.println("updateArticle()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// �� ���������ִ� �޼���->ȸ�� Ż��(����)=>��ȣ�� �����.(deletePro.jsp)
	public int deleteArticle(int num, String passwd) { // ��ȣ�� ã������ num
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// passwd�� ��ȸ�� >select
		String dbpasswd = null;// db���� ã�� ��ȣ�� ����
		String sql = "";
		int x = -1;// �Խù��� ������������

		try {
			con = pool.getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);// �������� �Է�->�ʵ庰�� Getterȣ��
			rs = pstmt.executeQuery();
			//pstmt.close();//�޸� ���� ��
			if (rs.next()) { // ���� ���̺��� �����Ͱ� �Ѱ��� �����Ѵٸ�
				dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd=>" + dbpasswd);
				// db���� ��ȣ=���� �Է��� ��ȣ�� �´ٸ�
				if (dbpasswd.equals(passwd)) {
					sql = "delete from board  where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					int delete = pstmt.executeUpdate();
					System.out.println("�Խ����� �ۻ��� ��������(delete)="+delete);
					x = 1; //��������
				} else {
					x = 0;// ��������
				}
			} // if(rs.next())
		} catch (Exception e) {
			System.out.println("deleteArticle()�޼��� ��������" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	//id값에 해당하는 데이터를 검색->담을 수 있는 메서드작성
	public List<String> getArticleId(String name){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> nameList=new ArrayList();//찾고자하는 id값만 담을 객체
		String sql="";
		
		try {
			con = pool.getConnection();
			sql = "select writer from board where writer like '%"+name+"%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {//찾은 작성자id가 있다면
				String writer=rs.getString("writer");
				nameList.add(writer);
			}
		} catch (Exception e) {
			System.out.println("getArticleId()에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return nameList;
	}
}








