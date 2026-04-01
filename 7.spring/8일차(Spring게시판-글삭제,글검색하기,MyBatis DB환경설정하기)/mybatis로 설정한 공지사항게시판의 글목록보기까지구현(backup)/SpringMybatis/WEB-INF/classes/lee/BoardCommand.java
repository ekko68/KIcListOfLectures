package lee;

//글쓰기,글수정,로그인 할때 사용(사용자로부터 값을 입력)따로 작성
//유효성
public class BoardCommand {

	//추가
	int num;
	//---------------------
	String author;//작성자
	String title;//글제목
	String content;//글내용
	//추가
	String writeday;//작성일
	int readcnt;//조회수
	String searchName;//검색분야
	String searchValue;//검색어
	//------------------------------
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
		//this.author=HangulConversion.toKor(author);//8859_1->utf-8
		System.out.println("setAuthor()호출됨");
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		//this.title=HangulConversion.toKor(title);
		System.out.println("setTitle()호출됨");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		//this.content=HangulConversion.toKor(content);
		System.out.println("setContent()호출됨");
	}
}
