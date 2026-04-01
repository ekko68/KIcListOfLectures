	package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import logic.Item;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao{

	private static final String SELECT_ALL = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM";
	
	private class ItemRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// ITEMテーブルのレコードをItemインスタンスにマッピング
			Item item = new Item();
			item.setItemId(new Integer(rs.getInt(1)));
			item.setItemName(rs.getString(2));
			item.setPrice(new Integer(rs.getInt(3)));
			item.setDescription(rs.getString(4));
			item.setPictureUrl(rs.getString(5));
			return item;
		}
	}

	public List findAll() {
		return getJdbcTemplate().query(ItemDaoImpl.SELECT_ALL, new ItemRowMapper());
	}
}