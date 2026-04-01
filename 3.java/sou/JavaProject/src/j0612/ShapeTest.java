package j0612;

import java.util.Scanner;

//원,직사각형의 면적을 선택

public class ShapeTest extends Shape implements Drawable{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("도형을 선택해서 원,직사각형을 그리는 프로그램");
	}
	//원의 면적
	@Override
	public double area(int r) {
		// TODO Auto-generated method stub
		return (r*r*Math.PI);
	}
	
	//직사각형의 면적
	@Override
	public double area(int w, int h) {
		// TODO Auto-generated method stub
		return (w*h);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          while(true) { //계속입력을 받아서 면적을 구하는 프로그램 작성
        	  Scanner sc=new Scanner(System.in);
        	  System.out.println("원하는 도형선택? 1.원 2.직사각형 3.종료");
        	  int choice=sc.nextInt();
        	  switch(choice) {
        	  case 1://원
        		  System.out.println("1.원의 반지름을 입력?");
        		  int r=sc.nextInt();
        		  ShapeTest st=new ShapeTest();
        		  st.res=st.area(r);
        		  st.printArea();
        		  break;
        	  case 2://직사각형->가로,세로?(nextInt)
        		  System.out.println("1.사각형의 넓이(가로)을 입력?");
        		  int w=sc.nextInt();
        		  System.out.println("2.사각형의 높이(세로)을 입력?");
        		  int h=sc.nextInt();
        		  ShapeTest st2=new ShapeTest();
        		  st2.res=st2.area(w,h);
        		  st2.printArea();
        		  break;
        	  case 3://종료
        		  System.out.println("프로그램이 정상종료됩니다.!");
        		  System.exit(0);
        		  break;
        	  }//switch
          }//while
	}
}






