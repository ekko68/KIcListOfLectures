package Admin;

public class MapDTO {
	// MAP 테이블과 동일
	private int locnum; // 지도id값 (1~999)
	private String locname; // 장소명(한글 20글자)
	private double locationx; // 경도값(###.######)
	private double locationy; // 위도값(###.######)
	private String loctype; // 장소타입("A001" "A002)
	public int getLocnum() {
		return locnum;
	}
	public void setLocnum(int locnum) {
		this.locnum = locnum;
	}
	public String getLocname() {
		return locname;
	}
	public void setLocname(String locname) {
		this.locname = locname;
	}
	public double getLocationx() {
		return locationx;
	}
	public void setLocationx(double locationx) {
		this.locationx = locationx;
	}
	public double getLocationy() {
		return locationy;
	}
	public void setLocationy(double locationy) {
		this.locationy = locationy;
	}
	public String getLoctype() {
		return loctype;
	}
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	
	
}
