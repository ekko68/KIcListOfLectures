package j0609;

//caller method->work method
//매개변수를 전달(객체(주소)를 전달->call By Reference(참조에 의한 전달방법)
//main(원본)---->change_color(원본)=>원본값은 변경
class RGBColor{
	int r,g,b;//0,0,0
	RGBColor(int r,int g,int b){
		this.r=r;//color.r=-1;
		this.g=g;//color.g=-1;
		this.b=b;//color.b=-1
	}
}

public class CallByRef {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RGBColor color=new RGBColor(-1,-1,-1);
		System.out.println("color=>"+color);
        System.out.println("before:red="+color.r+",green="+color.g+",blue="+color.b);
        //메서드를 호출(change_color) =>클래스명.정적메서드->정적메서드(~)
        change_color(color);//함수명(&매개변수명)
        System.out.println("after:red="+color.r+",green="+color.g+",blue="+color.b);
	}
    
	//색깔을 변경시켜주는 메서드->매개변수 O ,반환값 X
	static void change_color(RGBColor color1) { //(* color1)
		System.out.println("color1=>"+color1);
		color1.r+=10;//r=r+10
		color1.g+=50;//g=g+50;
		color1.b+=100;//b=b+100
		System.out.println
		    ("메서드내부의 r="+color1.r+",g="+color1.g+",b="+color1.b);
	}
}





