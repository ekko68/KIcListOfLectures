package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.User;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	private static final String SELECT_BY_USERID_PASSWORD = "SELECT USERID, PASSWORD, USERNAME, POSTCODE, ADDRESS, EMAIL, JOB, BIRTHDAY FROM USERTB WHERE USERID = ? AND PASSWORD = ?";
	
	private class UserPreparedStatementSetterForFind implements PreparedStatementSetter{

		private String userId;
		private String password;

		public UserPreparedStatementSetterForFind(String userId, String password) {
			//유저ID, 패스워드를 프로퍼티에 보유
			this.userId = userId;
			this.password = password;
		}
		
		public void setValues(PreparedStatement ps) throws SQLException {
			//유저ID, 패스워드를 PreparedStatement인스턴스로 설정
			ps.setString(1, this.userId);
			ps.setString(2, this.password);				
		}
	}
	
	private class UserResultSetExtractor implements ResultSetExtractor{

		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
				//ResultSet인스턴스로부터 User인스턴스를 작성
				User user = new User();
				user.setUserId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setPostCode(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setBirthDay(rs.getDate(8));
				return user;
			}
			//유저를 찾지 못한 경우는 예외를 thorw
			throw new DataRetrievalFailureException("해당데이터를 찾을 수 없다.");
		}
	}
	
	public User findByUserIdAndPassword(String userId, String password) {
		return (User)getJdbcTemplate().query(SELECT_BY_USERID_PASSWORD, new UserPreparedStatementSetterForFind(userId, password), new UserResultSetExtractor());
	}
}