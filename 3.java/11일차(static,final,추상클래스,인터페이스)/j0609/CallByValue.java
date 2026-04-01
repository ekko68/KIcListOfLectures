package j0609;

//caller method->work method
//매개변수를 전달(기본자료형(8byte)->call By Value(값에 의한 전달방법)
//main(원본)---->change_color(복사본값->변경)=>원본값은 불별
public class CallByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int r=-1,g=-1,b=-1;//rgb(0~255)숫자로 표현
        System.out.println("before:red="+r+",green="+g+",blue="+b);
        //메서드를 호출(change_color) =>클래스명.정적메서드->정적메서드(~)
        change_color(r,g,b);
        System.out.println("after:red="+r+",green="+g+",blue="+b);
	}

	//색깔을 변경시켜주는 메서드->매개변수 O ,반환값 X
	static void change_color(int r,int g,int b) { //-1,-1,-1
		r+=10;//r=r+10
		g+=50;//g=g+50;
		b+=100;//b=b+100
		System.out.println("메서드내부의 r="+r+",g="+g+",b="+b);
	}
}





