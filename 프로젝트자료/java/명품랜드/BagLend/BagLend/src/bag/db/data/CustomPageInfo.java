package bag.db.data;

public class CustomPageInfo {
	private int product_num;
	private String name;
	private String tel;
	private String gender;
	private int age;
	private String address;
	private String coupon_info;
	private String product_title;
	private String path;
	
	public CustomPageInfo() {}
	public CustomPageInfo(int product_num,String name,String tel,String gender, int age,String address,
			String coupon_info,String product_title,String path) {
		this.product_num=product_num;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.coupon_info = coupon_info;
		this.product_title = product_title;
		this.path = path;
	}
	
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCoupon_info() {
		return coupon_info;
	}
	public void setCoupon_info(String coupon_info) {
		this.coupon_info = coupon_info;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_info) {
		this.product_title = product_info;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
