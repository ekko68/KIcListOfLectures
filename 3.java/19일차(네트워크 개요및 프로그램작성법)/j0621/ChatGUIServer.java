package j0621;
//서버역할->1.클라이언트와의 접속->접속정보->아이디로 구분

import java.net.*;//ServerSocket,Socket
import java.io.*;//입출력->BufferedReader,InputStreamReader,PrintWriter~
import java.util.Vector;//List계열(배열)->실시간으로 접속한 클라이언트수

public class ChatGUIServer {

	ServerSocket ss;//클라이언트와의 접속할때만 필요
	Socket s;//클라이언트와 통신(문자열 전송)
	Vector v;//실시간으로 접속할 클라이언트의 정보를 저장
	//Thread의 객체가 필요->has a 관계로 연결
	ServerThread st;
	//-------------------------------------------------
	public ChatGUIServer() { //생성자->초기화
		//서버를 가동->클라이언트가 접속할때 기다린다.(무한 루프)
		v=new Vector();//생성자에서는 다른 클래스 객체명 사용가능->클라이언트저장
		try {
			ss=new ServerSocket(5432);//책 7777
			System.out.println("ss=>"+ss);
			System.out.println("채팅서버 가동중.....");
			//무한대기
			while(true) {
				s=ss.accept();//요청을 받아들인다.
				System.out.println("Accepted from "+s);
				//생성자->ServerThread객체를 생성->매개변수로 객체를 전달
				st=new ServerThread(this,s);//생성자 호출
				this.addThread(st);
				//Thread를 가동
				st.start();//->run()
			}
		}catch(Exception e) {
			System.out.println("서버접속 실패!->"+e);
		}
	}
	//1.접속한 클라이언트의 정보를 벡터에 저장
	public void addThread(ServerThread st) { //메서드의 매개변수
		 v.add(st);//cg,s(접속한 클라이언트 정보) ServerThread->Object
	}
	//2.퇴장한 클라이언트의 정보를 벡터에서 삭제
	public void removeThread(ServerThread st) {
		 v.remove(st);
	}
	//3.각 클라이언트에게 실시간으로 메세지를 전달시켜주는 메서드 
	public void broadCast(String str) {
		for(int i=0;i<v.size();i++) {
			ServerThread st=(ServerThread)v.elementAt(i);
			//Thread가 send를 호출
			st.send(str);//실질적인 각 클라이언트에게 전송해주는 역할
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new ChatGUIServer();
	}
}

//실시간으로 데이터를 전송->쓰레드 기능
class ServerThread extends Thread{
	
	Socket s;//클라이언트와 통신
	//추가
	ChatGUIServer cg;
	//--------------------------------
	//입출력 스트림객체 필요
	BufferedReader br;//입력용
	PrintWriter pw;//출력용
	String str;//전달할 문자열
	String name;//대화명(id)
	
	//ServerThread의 생성자가 필요->입출력 스트림 생성->통신을 할 준비
	//                            1.메서드호출(broadcast()),2.클라이언트와 통신하기위해서
	public ServerThread(ChatGUIServer cg,Socket s) {
		this.cg=cg;
		this.s=s;//접속한 클라이언트의 정보
		//데이터를 실시간으로 전송->입,출력스트림을 생성
		try {
			br=new BufferedReader    //1.System.in(로컬),2.s.getInputStream()
					(new InputStreamReader(s.getInputStream()));
			//BufferedWriter~ bw.print()->출력할때 어느정도 양(배열정도)
			//버퍼에 쌓아놓기때문에->bw.flush();=>버퍼에 저장된 양을 바로바로 전송
			pw=new PrintWriter(s.getOutputStream(),true);//autoflush 기능때문에
		}catch(Exception e) {
			System.out.println("연결실패(e)=>"+e);//e.toString(),e.getMessage()
		}
	}
	//데이터를 전송해주는 메서드(클라이언트)
	public void send(String str) {
		pw.println(str);
		pw.flush();
	}
	//실시간 데이터를 전송,받는 코딩=>클라이언트 프로그램을 종료->퇴장
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			pw.println("먼저 대화명을 입력하세요?");//<-->br
			name=br.readLine();//<->pw
			//각  클라이언트에게 특정계정이 입장했다는 메세지 전달
			cg.broadCast("["+name+"]님이 입장하셨습니다.");
			while((str=br.readLine())!=null) {
				cg.broadCast("["+name+"]"+str);
			}
			//더이상 입력받을 문자가 없는 동안 계속해서 전달
		}catch(Exception e) {//종료시 연결해제->퇴장으로 간주
			//접속자가 퇴장->접속한 사람들에게 실시간 전송
			cg.removeThread(this);
			cg.broadCast("["+name+"]님이 퇴장하셨습니다.");
			//s.getInetAddress()->상대방의 접속ip주소
			System.out.println(s.getInetAddress()+"의 연결이 종료됨!");
		}
	}
}

