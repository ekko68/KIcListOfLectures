package logic;

//한글처리 추가
import utils.UiUtils;
import java.io.Serializable;

public class Item {
    private Integer itemId;
    private String itemName;
    private Integer price;
    private String description;
    private String pictureUrl;
    
	public Integer getItemId() {
		return itemId;
	}
	public String getItemName() {
		//한글처리 메서드호출
		System.out.println("저장된값을 출력(itemName)="+itemName);
	    //return UiUtils.toUnicode(itemName);
		return itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public String getDescription() {
		return UiUtils.toUnicode(description);
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		//System.out.println("한글처리 적용전itemName="+itemName);
		//this.itemName = UiUtils.toUnicode(itemName);
		this.itemName = itemName;
        //System.out.println("한글처리 적용후itemName="+itemName);
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setDescription(String description) {
		//System.out.println("한글처리 적용전description="+description);
		//this.description = UiUtils.toUnicode(description);
		this.description = description;
		//System.out.println("한글처리 적용후description="+description);
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
