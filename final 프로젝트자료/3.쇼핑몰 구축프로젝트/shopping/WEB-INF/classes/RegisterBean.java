package hewon;

public class RegisterBean{

	private String mem_id;     //회원ID를 저장할 변수
	private String mem_passwd; //회원암호를 저장할 변수
	private String mem_name;   //회원이름을 저장할 변수
	private String mem_num1;   //회원의 주민등록번호 앞자리를 저장할 변수
	private String mem_num2;   //회원의 주민등록번호 뒷자리를 저장할 변수
	private String mem_email;  //회원의 이메일을 저장할 변수
	private String mem_phone;  //회원의 전화번호를 저장할 변수
	private String mem_zipcode; //회원의 우편번호를 저장할 변수
	private String mem_address; //회원의 주소를 저장할 변수
	private String mem_job;     //회원의 직업을 저장할 변수

 //Setter 메소드
 
	public void setMem_id (String mem_id){
		this.mem_id = mem_id;
	}
    public void setMem_passwd (String mem_passwd){
		this.mem_passwd = mem_passwd;
	}
	public void setMem_name (String mem_name){
		this.mem_name = mem_name;
	}
	public void setMem_num1 (String mem_num1){
		this.mem_num1 = mem_num1;
	}
	public void setMem_num2 (String mem_num2){
		this.mem_num2 = mem_num2;
	}
	public void setMem_email (String mem_email){
		this.mem_email = mem_email;
	}
	public void setMem_phone (String mem_phone){
		this.mem_phone = mem_phone;
	}
	public void setMem_zipcode (String mem_zipcode){
		this.mem_zipcode = mem_zipcode;
	}
	public void setMem_address (String mem_address){
		this.mem_address = mem_address;
	}
	public void setMem_job (String mem_job){
		this.mem_job = mem_job;
	}

 //Getter메소드
	public String getMem_id(){
 		return mem_id; 
 	}
	public String getMem_passwd(){
 		return mem_passwd; 
 	}
	public String getMem_name(){
 		return mem_name; 
 	}
	public String getMem_num1(){
 		return mem_num1; 
 	}
	public String getMem_num2(){
 		return mem_num2; 
 	}
	public String getMem_email(){
 		return mem_email; 
 	}
	public String getMem_phone(){
 		return mem_phone; 
 	}
	public String getMem_zipcode(){
 		return mem_zipcode; 
 	}
	public String getMem_address(){
 		return mem_address; 
 	}
	public String getMem_job(){
 		return mem_job; 
 	}
}
