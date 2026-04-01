package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Sale;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SaleDaoImpl extends JdbcDaoSupport implements SaleDao{

	private static final String SELECT_MAX_SALEID = "SELECT MAX(SALEID) AS SALEID FROM SALE";

	private static final String INSERT = "INSERT INTO SALE(SALEID, USERID, UPDATETIME) VALUES(?, ?, ?)";
	
	private class SalePreparedStatementSetterForInsert implements PreparedStatementSetter{

		private Sale sale;

		public SalePreparedStatementSetterForInsert(Sale sale){
			//매출 정보를 프로퍼티로 보유
			this.sale = sale;
		}

		public void setValues(PreparedStatement ps) throws SQLException {
			//매출 정보를 PreparedStatement 인스턴스로 설정
			ps.setInt(1, this.sale.getSaleId().intValue());
			ps.setString(2, this.sale.getUser().getUserId());
			ps.setTimestamp(3, this.sale.getUpdateTime());
		}
	}

	private class SaleResultSetExtractor implements ResultSetExtractor{

		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
				//ResultSet 인스턴스로부터 매출 ID의 최대값을 취득
				return new Integer(rs.getInt(1));
			}
			//초기값 0을 반환한다.
			return new Integer(0);
		}
	}

	public void create(Sale sale) {
		getJdbcTemplate().update(SaleDaoImpl.INSERT, new SalePreparedStatementSetterForInsert(sale));
	}
	
	public Integer findMaxSaleId() {
		return (Integer)getJdbcTemplate().query(SELECT_MAX_SALEID, new SaleResultSetExtractor());
	}
}