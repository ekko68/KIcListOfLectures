package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

  List findAll();

  Item findByPrimaryKey(Integer itemId);
  
  List findByItemName(String itemName);
  
  void create(Item item);

  void update(Item item);
  
  void delete(Item item);
}
