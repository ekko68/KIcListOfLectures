package lee;
//사용자로부터 순수 입력받는값만 처리해주는 클래스
public class BoardCommand {
     String author,title,content;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		System.out.println("setAuthor()호출됨");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("setTitle()호출됨");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("setContent()호출됨");
	}
}


