package dr.mini.domain;

import java.sql.Date;
//각 필드에 대한 Setter,Getter Method구성된 DTO

public class MemberCommand {
	
    private String id; //회원id
    private String passwd;//암호
    private String name;//회원명
    private Date reg_date;//회원가입날짜
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberCommand[id="+id+",passwd="+passwd
				  +",name="+name+",reg_date="+reg_date+"]";
	}
}
