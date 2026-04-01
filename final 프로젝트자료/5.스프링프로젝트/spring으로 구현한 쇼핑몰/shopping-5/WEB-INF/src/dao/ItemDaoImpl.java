package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import logic.Item;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao{

	private static final String SELECT_ALL = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM";
	
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM WHERE ITEMID = ?";

	private class ItemRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			//ITEM테이블의 레코드를 Item인스턴스로 맵핑
			Item item = new Item();
			item.setItemId(new Integer(rs.getInt(1)));
			item.setItemName(rs.getString(2));
			item.setPrice(new Integer(rs.getInt(3)));
			item.setDescription(rs.getString(4));
			item.setPictureUrl(rs.getString(5));
			return item;
		}
	}
	
	private class ItemPreparedStatementSetterForPrimaryKey implements PreparedStatementSetter{
		
		private Integer itemId;

		public ItemPreparedStatementSetterForPrimaryKey(Integer itemId){
			//상품ID를 프로퍼티로 보유
			this.itemId = itemId;
		}

		public void setValues(PreparedStatement ps) throws SQLException {
			 //상품ID를 PreparedStatement인스턴스로 설정
			ps.setInt(1, this.itemId.intValue());
		}
	}
	
	private class ItemResultSetExtractor implements ResultSetExtractor{
		
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
				 //ResultSet인스턴스로부터 Item인스턴스를 작성
				Item item = new Item();
				item.setItemId(new Integer(rs.getInt(1)));
				item.setItemName(rs.getString(2));
				item.setPrice(new Integer(rs.getInt(3)));
				item.setDescription(rs.getString(4));
				item.setPictureUrl(rs.getString(5));
				return item;
			}
			 //상품을 찾지 못했을 경우는 예외를 throw
			throw new DataRetrievalFailureException("해당데이터가 찾을 수 없다.");
		}
	}

	public List findAll() {
		return getJdbcTemplate().query(ItemDaoImpl.SELECT_ALL, new ItemRowMapper());
	}

	public Item findByPrimaryKey(Integer itemId) {
		return (Item) getJdbcTemplate().query(
				ItemDaoImpl.SELECT_BY_PRIMARY_KEY,
				new ItemPreparedStatementSetterForPrimaryKey(itemId),
				new ItemResultSetExtractor());
	}
}