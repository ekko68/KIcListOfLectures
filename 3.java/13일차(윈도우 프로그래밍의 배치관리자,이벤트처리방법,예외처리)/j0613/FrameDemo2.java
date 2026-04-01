package j0613;

//창(Frame)을 하나 생성=>화면에 출력
import java.awt.*;//java.awt ,javax.swing패키지
//추가
import javax.swing.*;

public class FrameDemo2 extends JFrame{  //setTitle()
	//생성자->자기 클래스 객체를 쓸 수가 없고 다른 클래스 객체는 사용 가능
	public FrameDemo2(String title) {
		        //창의 제목을 출력->수정 setXXXX(String )
		        this.setTitle(title);
				this.setBounds(200,300,300,200);//x,y,w,h
				//3.생성된 창을 화면에 보여주기(default->창에 보이지 않는다)
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true); //f.setVisible(false);
	}
	
	//창만 생성하는 구문
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.Frame창을 하나 생성
		FrameDemo2 f=new FrameDemo2("상속을 이용하는 방법");
	}
}



