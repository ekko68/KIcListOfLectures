package lys.board;

import java.sql.Timestamp;

public class BoardDTO {

	private int num;// �Խù���ȣ(article)
	private String writer;// �ۼ���
	private String subject;// ������
	private String email;// �̸���
	private String content;// �۳���
	private String passwd;// ��ȣ(�۾���,�ۼ����Ҷ�,�ۻ���)
	private Timestamp reg_date;// �ۼ���¥->sysdate, now()(Mysql)
	private int readcount;// ��ȸ��->default->0
	private String ip;// �ۼ����� ip�ּҸ� ���
	// ��ۿ� ���õ� �ʵ�
	private int ref;// �� �׷��ȣ(=�Խù� ��ȣ)
	private int re_step;// �亯���� ������ ����(=���� �׷��϶��� �亯�ۼ���)
	private int re_level;// �亯���� �亯�� ���� ����(depth)
	// private String file;=>������ ���� �߰�->�ڷ��

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		//writer.replaceAll("<","&lt;");
		//writer.replaceAll(">","&gt;");
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

}
