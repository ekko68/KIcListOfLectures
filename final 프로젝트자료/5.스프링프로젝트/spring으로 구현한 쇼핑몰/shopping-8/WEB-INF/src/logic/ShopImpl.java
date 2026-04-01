package logic;

import java.util.List;

public class ShopImpl implements Shop {

  private ItemCatalog itemCatalog;

  public void setItemCatalog(ItemCatalog itemCatalog) {
    this.itemCatalog = itemCatalog;
  }

  public List getItemList() {
    return this.itemCatalog.getItemList();
  }

  public void entryItem(Item item) {
    this.itemCatalog.entryItem(item);
  }

  public void deleteItem(Item item) {
    this.itemCatalog.deleteItem(item);
  }

  public void updateItem(Item item) {
    this.itemCatalog.updateItem(item);
  }

  public List getItemByItemName(String itemName) {
    return this.itemCatalog.getItemByItemName(itemName);
  }

  public Item getItemByItemId(Integer itemId) {
    return this.itemCatalog.getItemByItemId(itemId);
  }

  public Item createNewItem() {
    return this.itemCatalog.createNewItem();
  }
}
