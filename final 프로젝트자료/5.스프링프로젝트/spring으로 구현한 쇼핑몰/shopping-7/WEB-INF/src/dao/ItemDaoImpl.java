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

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

  private static final String SELECT_ALL = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM";

  private static final String SELECT_BY_PRIMARY_KEY = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM WHERE ITEMID = ?";

  private static final String SELECT_BY_ITEMANME = "SELECT ITEMID, ITEMNAME, PRICE, DESCRIPTION, PICTUREURL FROM ITEM WHERE ITEMNAME LIKE ?";

  private static final String INSERT = "INSERT INTO ITEM(ITEMNAME, PRICE, DESCRIPTION, PICTUREURL) VALUES(?, ?, ?, ?)";

  private static final String DELETE = "DELETE FROM ITEM WHERE ITEMID = ?";

  private static final String UPDATE = "UPDATE ITEM SET ITEMNAME = ?, PRICE = ?, DESCRIPTION = ? , PICTUREURL = ? WHERE ITEMID = ?";
  
  private class ItemPreparedStatementSetterForPrimaryKey implements PreparedStatementSetter{
    
    private Integer itemId;
    
    public ItemPreparedStatementSetterForPrimaryKey(Integer itemId){
      //상품ID를 프로퍼티로 저장
      this.itemId = itemId;
    }

    public void setValues(PreparedStatement ps) throws SQLException {
      //상품ID를 PreparedStatement 인스턴스로 설정
      ps.setInt(1, this.itemId.intValue());
    }
  }

  private class ItemPreparedStatementSetterForItemNameSearch implements PreparedStatementSetter{
    
    private String itemName;
    
    public ItemPreparedStatementSetterForItemNameSearch(String itemName){
      //상품명을 프로퍼티로 저장
      this.itemName = itemName;
    }

    public void setValues(PreparedStatement ps) throws SQLException {
      //상품명을 PreparedStatement 인스턴스로 설정
      ps.setString(1, this.itemName);
    }
  }
  
  private class ItemPreparedStatementSetterForInsert implements PreparedStatementSetter{
    
    private Item item;

    public ItemPreparedStatementSetterForInsert(Item item){
      //상품정보를 프로퍼티로 저장
      this.item = item;
    }

    public void setValues(PreparedStatement ps) throws SQLException {
      //상품정보를 PreparedStatement 인스턴스로 설정
      ps.setString(1, this.item.getItemName());
      ps.setInt(2, this.item.getPrice().intValue());
      ps.setString(3, this.item.getDescription());
      ps.setString(4, this.item.getPictureUrl());
    }
  }

  private class ItemPreparedStatementSetterForUpdate implements PreparedStatementSetter{
    
    private Item item;
    
    public ItemPreparedStatementSetterForUpdate(Item item){
      //상품정보를 프로퍼티로 저장
      this.item = item;
    }

    public void setValues(PreparedStatement ps) throws SQLException {
      //상품정보를 PreparedStatement 인스턴스로 설정
      ps.setString(1, this.item.getItemName());
      ps.setInt(2, this.item.getPrice().intValue());
      ps.setString(3, this.item.getDescription());
      ps.setString(4, this.item.getPictureUrl());
      ps.setInt(5, this.item.getItemId().intValue());
    }
  }
  
  private class ItemRowMapper implements RowMapper{

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
      //ITEM테이블의 레코드를 Item 인스턴스에 맵핑
      Item item = new Item();
      item.setItemId(new Integer(rs.getInt(1)));
      item.setItemName(rs.getString(2));
      item.setPrice(new Integer(rs.getInt(3)));
      item.setDescription(rs.getString(4));
      item.setPictureUrl(rs.getString(5));
      return item;
    }
  }

  private class ItemResultSetExtractor implements ResultSetExtractor{

    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

      if(rs.next()){
        //ResultSet 인스턴스로부터 Item 인스턴스를 작성
        Item item = new Item();
        item.setItemId(new Integer(rs.getInt(1)));
        item.setItemName(rs.getString(2));
        item.setPrice(new Integer(rs.getInt(3)));
        item.setDescription(rs.getString(4));
        item.setPictureUrl(rs.getString(5));
        return item;
      }
      //상품을 찾지 못한 경우는 예외를 throw
      throw new DataRetrievalFailureException("해당 데이터를 찾지 못했다.");
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

  public List findByItemName(String itemName) {
    return getJdbcTemplate().query(ItemDaoImpl.SELECT_BY_ITEMANME,
        new ItemPreparedStatementSetterForItemNameSearch(itemName),
        new ItemRowMapper());
  }

  public void create(Item item) {
    getJdbcTemplate().update(ItemDaoImpl.INSERT, new ItemPreparedStatementSetterForInsert(item));
  }

  public void delete(Item item) {
    getJdbcTemplate().update(ItemDaoImpl.DELETE, new ItemPreparedStatementSetterForPrimaryKey(item.getItemId()));
  }

  public void update(Item item) {
    getJdbcTemplate().update(ItemDaoImpl.UPDATE, new ItemPreparedStatementSetterForUpdate(item));
  }
}