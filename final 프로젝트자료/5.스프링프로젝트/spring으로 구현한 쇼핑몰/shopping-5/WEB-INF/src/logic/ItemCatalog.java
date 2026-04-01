package logic;

import java.util.List;

public interface ItemCatalog {
	
	List getItemList();

	Item getItemByItemId(Integer itemId);
}