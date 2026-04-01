package test; //기능별로 분류

//반드시 public class로 작성할것->~Bean->~DTO
//private 멤버변수(=input type->name이름과 동일)
//Setter,Getter 메서드 작성

public class BeanTest {

	private String str;
	private String addr;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
		System.out.println("setStr()호출됨!");
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("setAddr()호출됨!");
	}
}
