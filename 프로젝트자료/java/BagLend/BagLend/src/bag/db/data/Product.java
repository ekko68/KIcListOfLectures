package bag.db.data;


public class Product {
	
	private int num;
	private String title;
	private String info;
	private String state;
	private String image;

	public Product() {};
	public Product(int num,String title,String info,String state,String image) {
		this.num=num;
		this.title=title;
		this.info=info;
		this.state=state;
		this.image=image;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
