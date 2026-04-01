package com.board.domain;
//DTO
import java.sql.Date;
import org.springframework.web.multipart.MultipartFile;

//파일업로드->클래스파일을 이용->업로드파일 이름 
public class BoardCommand {

	private int seq;//게시물번호
	private String writer,title,content,pwd;
	private int hit;//조회수
	private Date regdate;//작성날짜
	//---------------------------------
	private MultipartFile upload;//파일업로드 하기위해 필요한 업로드객체명
	                                           //pom.xml->commons-fileupload-버전명.jar
	//----------------------------------
	private String filename;//업로드할 파일이름
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	//------------------------------------
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	//---------------------------------------------------
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BoardCommand[seq="+seq+",writer="+writer+",title="
				   +title+",content="+content+",pwd="+pwd+",hit="
				   +hit+",regdate="+regdate+",upload="+upload
				   +",filename="+filename+"]";
	}
	
	
	
	
	
	
}
