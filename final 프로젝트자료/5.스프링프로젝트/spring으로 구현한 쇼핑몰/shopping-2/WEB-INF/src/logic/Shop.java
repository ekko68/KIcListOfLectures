package logic;

import java.util.List;

public interface Shop {
	
	List getItemList();
	
	Item getItemByItemId(Integer itemId);
}