package j0622;

//MDI을 사용
import javax.swing.*;

public class JInternalTest extends JFrame{ //부모창
	
	JInternalFrame iframe,iframe2,iframe3;//2개의 자식창
	JDesktopPane desktop;//JInternalFrame과 결합->화면에 출력
	
	public JInternalTest(String str) {
		 super(str);
		 //만드는 순서(밖->안)<->부착(안->밖)
		 desktop=new JDesktopPane();//자식창과 결합하기위해서
		 //1)창의제목,2)창의 크기조절유무(true|false),3)closeable유무
		 //4)창의 확대유무(true|false),5)창의 아이콘유무(true|false)
		 //iframe 1
		 iframe=new JInternalFrame("내부의창1",false,false,true,false);
		 //결합
		 desktop.add(iframe);
		 //자식창에 추가로 컴포넌트 부착
		 iframe.getContentPane().add(new JTextArea("TextArea"));
		 iframe.setBounds(100,100,200,100);//x,y,w,h
		 iframe.setVisible(true);//자식창이 화면에 출력
		 //iframe2
		 iframe2=new JInternalFrame("내부의창2",true,true,true,true);
		 //결합
		 desktop.add(iframe2);
		 //자식창에 추가로 컴포넌트 부착
		 iframe2.getContentPane().add(new JTextArea("TextArea2"));
		 iframe2.setBounds(120,120,200,100);//x,y,w,h
		 iframe2.setVisible(true);
		 //iframe3->80,80,200,100
		 iframe3=new JInternalFrame("내부의창23",true,true,true,true);
		 //결합
		 desktop.add(iframe3);
		 //자식창에 추가로 컴포넌트 부착
		 iframe3.getContentPane().add(new JTextArea("TextArea2"));
		 iframe3.setBounds(80,80,200,100);//x,y,w,h
		 iframe3.setVisible(true);
		 //자식창이 결합된 desktop+JFrame에 부착
		  setContentPane(desktop);//ContentPane에 desktop부착
		  this.setBounds(200,200,400,300);
		  setVisible(true);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new JInternalTest("MDI창");
	}
}



