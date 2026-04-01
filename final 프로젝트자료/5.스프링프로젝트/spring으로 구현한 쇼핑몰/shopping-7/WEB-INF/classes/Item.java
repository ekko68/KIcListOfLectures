package logic;

import java.io.Serializable;

import utils.UiUtils;

public class Item implements Serializable{
	
	private Integer itemId;

	private String itemName;
	
	private Integer price;
	
	private String description;
	
	private String pictureUrl;

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getItemId() {
		return this.itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
		//상품등록
		//return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getPictureUrl() {
		return this.pictureUrl;
	}
	
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
}