package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

	List findAll();
	Item findByPrimaryKey(Integer itemId);
}