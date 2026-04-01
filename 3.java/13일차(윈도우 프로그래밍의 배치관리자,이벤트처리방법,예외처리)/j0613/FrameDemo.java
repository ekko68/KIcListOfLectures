package j0613;

//창(Frame)을 하나 생성=>화면에 출력
import java.awt.*;//java.awt ,javax.swing패키지
//1.import
import javax.swing.*;
//------------------------
public class FrameDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.Frame창을 하나 생성
		JFrame f=new JFrame();
		f.setBounds(200,300,300,200);//x,y,w,h
		//3.생성된 창을 화면에 보여주기(default->창에 보이지 않는다)
		//x버튼 클릭 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//->System.exit(0)을 호출
		f.setVisible(true); //f.setVisible(false);
	}
}



