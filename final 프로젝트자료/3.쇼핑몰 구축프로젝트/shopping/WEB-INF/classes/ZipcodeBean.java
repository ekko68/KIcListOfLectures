package hewon;

public class ZipcodeBean {

	private String zipcode;	//우편번호를 저장할 변수
	private String area1; //도시 또는 도를 저장할 변수
	private String area2; //구 또는 소도시를 저장할 변수
	private String area3; //동 또는 면,리를 저장할 변수
	private String area4; //주소의 번지를 저장할 변수

	public void setZipcode(String zipcode){
		this.zipcode=zipcode; 
	}

	public void setArea1(String area1){
		this.area1=area1; 
	}

	public void setArea2(String area2){
		this.area2=area2; 
	}

	public void setArea3(String area3){
		this.area3=area3; 
	}

	public void setArea4(String area4){
		this.area4=area4; 
	}


    public String getZipcode(){
 		return zipcode; 
 	}

    public String getArea1(){
 		return area1; 
 	}
	 public String getArea2(){
 		return area2; 
 	}
	 public String getArea3(){
 		return area3; 
 	}
	 public String getArea4(){
 		return area4; 
 	}
}