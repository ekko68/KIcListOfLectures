package Admin;

public class CoslocDTO {
	// COSLOC 테이블과 동일
	private String cosnum; // 코스 id값(1~999)
	private String locnum; // 지도id값 (1~999)
	
	
	public String getCosnum() {
		return cosnum;
	}
	public void setCosnum(String cosnum) {
		this.cosnum = cosnum;
	}
	public String getLocnum() {
		return locnum;
	}
	public void setLocnum(String locnum) {
		this.locnum = locnum;
	}
	
	
	
}
