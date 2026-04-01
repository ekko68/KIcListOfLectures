package logic;

import java.util.List;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog {

  private ItemDao itemDao;

  public void setItemDao(ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  public List getItemList() {
    return this.itemDao.findAll();
  }

  public void entryItem(Item item) {
    this.itemDao.create(item);
  }

  public void deleteItem(Item item) {
    this.itemDao.delete(item);
  }

  public void updateItem(Item item) {
    this.itemDao.update(item);
  }

  public List getItemByItemName(String itemName) {
    return this.itemDao.findByItemName(itemName);
  }

  public Item getItemByItemId(Integer itemId) {
    return this.itemDao.findByPrimaryKey(itemId);
  }

  public Item createNewItem() {
    return new Item();
  }
}
