package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.SaleLine;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SaleLineDaoImpl extends JdbcDaoSupport implements SaleLineDao{

	private static final String INSERT = "INSERT INTO SALELINE(SALEID, SALELINEID, ITEMID, QUANTITY, UPDATETIME) VALUES(?, ?, ?, ?, ?)";
	
	private class SaleLinePreparedStatementSetterForInsert implements PreparedStatementSetter{

		private SaleLine saleLine;
		
		public SaleLinePreparedStatementSetterForInsert(SaleLine saleLine){
			//매출 명세정보를 프로퍼티로 보유
			this.saleLine = saleLine;
		}

		public void setValues(PreparedStatement ps) throws SQLException {
			//매출 명세정보를 PreparedStatement인스턴스로 설정
			ps.setInt(1, this.saleLine.getSale().getSaleId().intValue());
			ps.setInt(2, this.saleLine.getSaleLineId().intValue());
			ps.setInt(3, this.saleLine.getItem().getItemId().intValue());
			ps.setInt(4, this.saleLine.getQuantity().intValue());
			ps.setTimestamp(5, this.saleLine.getUpdateTime());
		}
	}
	
	public void create(SaleLine saleLine) {
		getJdbcTemplate().update(SaleLineDaoImpl.INSERT, new SaleLinePreparedStatementSetterForInsert(saleLine));
	}
}
