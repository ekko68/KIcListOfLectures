package dao;  

import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.User;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
  
  private static final String INSERT = "INSERT INTO USERTB(USERID, USERNAME, "
      + "PASSWORD, POSTCODE, ADDRESS, EMAIL, JOB, BIRTHDAY) " 
      + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

  private class UserPreparedStatementSetterForInsert 
         implements PreparedStatementSetter{
    
    private User user;

    public UserPreparedStatementSetterForInsert(User user){
      //회원 정보를 프로퍼티로 보유
      this.user = user;
    }
    
    public void setValues(PreparedStatement ps) throws SQLException {
      //회원 정보를 PreparedStatement 인스턴스로 설정      
      ps.setString(1, this.user.getUserId());
      ps.setString(2, this.user.getUserName());
      ps.setString(3, this.user.getPassword());
      ps.setString(4, this.user.getPostCode());
      ps.setString(5, this.user.getAddress());
      ps.setString(6, this.user.getEmail());
      ps.setString(7, this.user.getJob());
      ps.setDate(8, new java.sql.Date(this.user.getBirthDay().getTime()));
    }
  }
  
  public void create(User user) {
    getJdbcTemplate().update(UserDaoImpl.INSERT, 
                new UserPreparedStatementSetterForInsert(user));
  }
}
