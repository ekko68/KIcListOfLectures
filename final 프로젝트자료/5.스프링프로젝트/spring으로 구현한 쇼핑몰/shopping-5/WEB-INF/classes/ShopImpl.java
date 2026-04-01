package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ShopImpl implements Shop{

	private ItemCatalog itemCatalog;
	
	private UserCatalog userCatalog;
	
	private SaleCatalog saleCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public void setSaleCatalog(SaleCatalog saleCatalog) {
		this.saleCatalog = saleCatalog;
	}
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public Cart getCart() {
		return new Cart();
	}

	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}
	
	public void entryUser(User user){
		this.userCatalog.entryUser(user);
	}

	public List getItemList() {
		return this.itemCatalog.getItemList();	
	}

	public Item getItemByItemId(Integer itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}
	
	public void checkout(User user, Cart cart) {
		//매출 정보 작성
		Sale sale = createSale(user, cart);
		//매출 정보를 등록
		entrySale(sale);
	}
	
	public Integer calculateTotalAmount(List itemList){
		//합계금액
		int totalAmount = 0;
		for(Iterator it = itemList.iterator(); it.hasNext();){
			ItemSet itemSet = (ItemSet)it.next();
			int price = itemSet.getItem().getPrice().intValue();
			int quantity = itemSet.getQuantity().intValue();
			totalAmount = totalAmount + (price * quantity);
		}
		return new Integer(totalAmount);
	}

	private Sale createSale(User user, Cart cart) {
		//매출 정보작성
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		Timestamp currentTime = getCurrentTime();
		sale.setUpdateTime(currentTime);
		
		//바구니의 상품종류별 매출 명세정보를 작성
		List itemList = cart.getItemList();
		for(int i = 0; i < itemList.size(); i++){
			ItemSet itemSet = (ItemSet)itemList.get(i);
			//매출 명세 ID는 1번부터 설정
			int saleLineId = i + 1;
			SaleLine saleLine = createSaleLine(sale, saleLineId, itemSet, currentTime);
			sale.addSaleLine(saleLine);
		}
		return sale;
	}

	private void entrySale(Sale sale) {
		this.saleCatalog.entrySale(sale);
	}
	
	
	private Integer getNewSaleId() {
		return this.saleCatalog.getNewSaleId();
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	private SaleLine createSaleLine(Sale sale, int saleLineId , ItemSet itemSet, Timestamp currentTime) {
		return new SaleLine(sale, new Integer(saleLineId), itemSet, currentTime);
	}
}