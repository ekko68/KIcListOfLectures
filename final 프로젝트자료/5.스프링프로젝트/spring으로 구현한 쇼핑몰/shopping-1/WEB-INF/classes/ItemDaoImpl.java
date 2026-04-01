package dao;

import java.sql.*;
import java.util.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
//Ãß°¡
import logic.Item;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {
  
	private static final String SELECT_ALL="select itemid,itemname," +
			                             "price,description,pictureurl from item";
	
	private class ItemRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs,int rowNum)throws SQLException {
		  Item item = new Item();
		  item.setItemId(new Integer(rs.getInt(1)));
		  item.setItemName(rs.getString(2));
		  item.setPrice(new Integer(rs.getInt(3)));
		  item.setDescription(rs.getString(4));
		  item.setPictureUrl(rs.getString(5));
		  
		  return item;
		}
	}
	
	@Override
	public List findAll(){
	  return getJdbcTemplate().query(ItemDaoImpl.SELECT_ALL, new ItemRowMapper());
	}
}
