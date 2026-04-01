package com.apik.course.command;
// 코스, 마커, 위치, details  통합 DTO
public class CourseVO {
	// Course TB
		private int cosnum; // 코스 id(1~999)
		private String play; // 쉴래?(REST) 놀래?(PLAY)
		private String cosname; // 코스명(한글 20글자)
		private int lv; // 에너지&피로도 Level (1~5)
		private String intro; // 간략한 소개글( in 상세정보)

		// COSLOC 테이블과 동일
		private int cosnumL; // 코스 id값(1~999)
		private int locnum; // 지도id값 (1~999)

		// MAP 테이블과 동일
		private int locnumM; // 지도id값 (1~999)
		private String locname; // 장소명(한글 20글자)
		private double locationx; // 경도값(###.######)
		private double locationy; // 위도값(###.######)
		private String loctype; // 장소타입("A001" "A002)
		
		// icontiype
		private String loctypeI,type;
		
		// DETAILS table
		private int locnumD;
 		private String address;
 		private String imgname;
 		private String tel;
 		private String time;
 		private String contents;

		// Course TB
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

		// COSLOC
		public int getCosnumL() {
			return cosnumL;
		}

		public void setCosnumL(int cosnumL) {
			this.cosnumL = cosnumL;
		}

		public int getLocnum() {
			return locnum;
		}

		public void setLocnum(int locnum) {
			this.locnum = locnum;
		}

		
		// MAP 테이블
		public int getLocnumM() {
			return locnumM;
		}

		public void setLocnumM(int locnumM) {
			this.locnumM = locnumM;
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

		public int getLocnumD() {
			return locnumD;
		}

		// details		
		public void setLocnumD(int locnumD) {
			this.locnumD = locnumD;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getImgname() {
			return imgname;
		}

		public void setImgname(String imgname) {
			this.imgname = imgname;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getContents() {
			return contents;
		}

		public void setContents(String contents) {
			this.contents = contents;
		}

		public String getLoctypeI() {
			return loctypeI;
		}

		public void setLoctypeI(String loctypeI) {
			this.loctypeI = loctypeI;
		}

		// icontype
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		
		
}
