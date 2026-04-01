package Admin;

public class PersonDTO {
	// 회원가입 PERSON 테이블과 동일
	private String id; // 회원의 Email
	private String passwd;
	private String name;
	private String gender; // 성별, M,W
	private String age; // 10 ~ 90

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
