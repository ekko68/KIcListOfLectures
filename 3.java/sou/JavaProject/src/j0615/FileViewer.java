package j0615;

//AWT->Swing
import java.awt.*;
import java.awt.event.*;//이벤트
//추가
import java.io.*;

public class FileViewer extends Frame implements ActionListener {
	
	TextArea ta;//글내용(여러줄을 입력받을때 사용)
	TextField tf;//입력창
	
	public FileViewer() {
		super("파일불러오기");
		setBounds(250,250,400,300);
		setResizable(false);//창의 확대금지
		//add(컴포넌트명,위치)=>add(위치,컴포넌트명)
		add("Center",ta=new TextArea());
		add("South",tf=new TextField());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//이벤트 발생연결
		tf.addActionListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {//TextField의 내용->경로파일
		// TODO Auto-generated method stub
		//이벤트 발생시킨 컴포넌트->e.getSource()
		Object source=e.getSource();
		if(source==tf) {//이벤트 발생시킨 컴포넌트가 tf가 맞는지
			//불러올 파일명 확인
			String fileName=tf.getText();//경로명 및 파일명
			System.out.println("fileName="+fileName);
			tf.setText("");//다음의 파일명을 입력하기 위해서
			File f=new File(fileName);//f.length()->파일의 길이(들여있는 내용만큼)
			//메모리에 저장할 영역byte[]
			try {
			System.out.println("파일의 길이(length)=>"+f.length());
			int readByte=0;//파일의 내용을 읽어들여서 저장변수
			FileInputStream fis=new FileInputStream(f);
			byte input[]=new byte[(int)f.length()];
			
			while((readByte=fis.read(input))!=-1) {
				//byte input[]->TextArea에 출력(String)
				//String 클래스->String=?(byte[])
				String s=new String(input);
				ta.append(s);//TextArea에 출력
				System.out.println(s);//콘솔에 출력
			}
			fis.close();//메모리해제 (입력,출력할것이 없으면 close)
			}catch(Exception e2) {
				System.out.println("경로명 및 파일명을 확인해주세요!");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                new FileViewer();
	}
}



