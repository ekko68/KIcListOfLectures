package j0622;

import java.net.*;//Socket클래스->서버프로그램과 연결하기위해서
import java.util.Properties;
import java.io.*;//입출력
import java.awt.*;//GUI
import java.awt.event.*;//event 처리해야 되기

//추가
import javax.swing.*;//JFrame,JTextArea,JTextField
//실시간으로 데이터를 전송->Thread->X Runnable인터페이스를 상속받음

class ChatGUIClient extends JFrame  implements ActionListener,Runnable
{
	JTextArea ta;//클라이언트의 대화를 출력=>스크롤바 기능X
	JTextField tf;//입력
	//추가
	JScrollPane js; //스크롤바
	//----------------
	Socket s;//서버와 통신하기위해서 
	BufferedReader br;//입력(대용량)
	PrintWriter pw;//출력->BufferedWriter(X)
	String str,str1;//서버,대화에 출력할 문자열
	
	public ChatGUIClient(){
       //객체생성 및 배치
	   ta = new JTextArea();
	   tf = new JTextField();
	   //추가
	   js = new JScrollPane(ta); //JTextArea가 결합된 스크롤바
	 
	   add(js,"Center");
	   add(tf,"South");//아래
	   //----이벤트 연결-----
	   tf.addActionListener(this);
	   setBounds(200,200,500,350);//x,y,w,h
	   setVisible(true);
	   tf.requestFocus();//커서입력->입력할 준비
       //추가
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.addWindowListener(new WindowAdapter() {
		   @Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		  }
	   });
	   //서버와 연결하는 구문
	   try{
		   //--------------------------------------------------------------
		    Properties props=new Properties();
			FileInputStream in=new FileInputStream
					("C:/webtest/3.java/sou/JavaProject/src/port.properties");
			String ip="";//불러올 ip주소를 저장
			//입출력->파일을 불러올 수 있는 상태인지 체크->available()->-1(X)
			//파일의 정보를 가지고 있으면서 현재 불러올수 있다면
			if(in!=null && in.available()>0) {
				props.load(in);
				ip=props.getProperty("ip");//"1"
				//port=props.getProperty("port");//5432
			}
		   //---------------------------------------------------------------
		   //1.접속할 컴퓨터ip주소(서버)->192.168.0.57,포트번호(5432)
		   //s=new Socket("192.168.0.57",5432); ->나중에는 지워야 된다.
		   s=new Socket(ip,5432);//~(ip,port); 권장
		   System.out.println("s="+s);
		   //입출력 스트림 생성
		   pw=new PrintWriter(s.getOutputStream(),true);  //System.in
		   br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		  
	   }catch(Exception e){
		   System.out.println("접속오류="+e);
	   }
	   //Thread 객체를 생성->run()호출
	   Thread ct=new Thread(this);//Runnable인터페이스를 상속받은 자식클래스객체
	   ct.start();//run()
	}//생성자
    //run
	public void run() {
		//더 이상 입력받을 수 없을때까지 ->TextArea
		try {
			//서버가 보내준 글자를 출력->TextArea
			while((str1=br.readLine())!=null) {
				ta.append(str1+"\n");//상대방이 보내준 글자 세로로 출력
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	//채팅할때 ->이벤트발생시 호출되는 메서드=>글자->서버->상대방
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		str=tf.getText();
		tf.setText("");//새로 입력하기위해서
		pw.println(str);//내가 입력한 글자
		pw.flush();
	}
	public static void main(String[] args) 
	{
		new ChatGUIClient();
	}
}
