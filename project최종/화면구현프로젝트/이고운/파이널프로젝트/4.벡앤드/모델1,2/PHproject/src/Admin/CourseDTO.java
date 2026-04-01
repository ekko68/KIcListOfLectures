package Admin;

public class CourseDTO {
	// COURSE 테이블과 동일
	private int cosnum; // 코스 id(1~999)
	private String play; // 쉴래?(REST) 놀래?(PLAY)
	private String cosname; // 코스명(한글 20글자)
	private int lv; // 에너지&피로도 Level (1~5)
	private String intro; // 간략한 소개글( in 상세정보)
	
	
	public int getCosnum() {
		return cosnum;
	}
	public void setCosnum(int cosnum) {
		this.cosnum = cosnum;
	}
	public String getPlay() {
		return play;
	}
	public void setPlay(String play) {
		this.play = play;
	}
	public String getCosname() {
		return cosname;
	}
	public void setCosname(String cosname) {
		this.cosname = cosname;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
	
}

