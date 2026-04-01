package logic;

import java.util.List;

public interface ItemCatalog {

  List getItemList();

  Item getItemByItemId(Integer itemId);

  List getItemByItemName(String itemName);

  void entryItem(Item item);

  void updateItem(Item item);

  void deleteItem(Item item);
  
  Item createNewItem();
}
