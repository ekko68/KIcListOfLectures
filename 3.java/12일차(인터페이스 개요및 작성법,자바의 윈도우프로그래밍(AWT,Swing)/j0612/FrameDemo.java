package j0612;

//창(Frame)을 하나 생성=>화면에 출력
import java.awt.*;//java.awt ,javax.swing패키지

public class FrameDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.Frame창을 하나 생성
		Frame f=new Frame();
		//2.창의 크기(넓이,높이)를 지정(위치)->setSize(w,h)
		/*
		f.setLocation(200, 300);//x,y
		f.setSize(300,200);*/
		f.setBounds(200,300,300,200);//x,y,w,h
		//3.생성된 창을 화면에 보여주기(default->창에 보이지 않는다)
		f.setVisible(true); //f.setVisible(false);
	}
}



