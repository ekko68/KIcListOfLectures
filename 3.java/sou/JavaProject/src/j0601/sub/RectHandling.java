package j0601.sub;
//직사각형의 면적을 구해주는 클래스를 작성
//직사각형의 면적을 구해주는 메서드 작성
class Rect{
//int ->0, double->0.0 ,String=>null,boolean->false
//1)private 멤머변수
 private int x; //가로->0
 private int y; //세로->0
 
 //2.값을 저장->Setter Method , 값을 가져오기->Getter Method
 //public=>외부에서 public이 부여된 메서드를 호출이 가능
public void setX(int a) {
	if(a<0) {
		System.out.println("x값은 음수를 입력할 수가 없다");
		x=10;
		return;
	}
	x=a;
}
public void setY(int a) {
	if(a<0) {
		System.out.println("y값은 음수를 입력할 수가 없다");
		y=20;
	}else {
	   y=a;
	}
}

//3.Getter Method->반환값이 있는 메서드(p254)
public int getX() { return x; }
public int getY() { return y; }

  //worker method
  void areaPrint() {
	  System.out.println("직사각형의 면적은=>"+(x*y));
  }
  //3.매개변수 O, 반환값 O ->caller에게 보고
  int areaPrint2(int x,int y) { //23,45
	  /*
	  int result=x*y; //지역변수->이 메서드내에서만 사용가능(지역변수)
	  return result;*/
	  return (x*y); //return (수식) or 변수명
  }
}

public class RectHandling {

	//caller Method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Rect r=new Rect();//객체->변수
           System.out.println("r->"+r);//j0601.sub.Rect@15db9742(저장위치)
           //r.x=10; r.y=20; //객체명.멤버변수=값
           //r.x=-40; r.y=-23;
           r.setX(-40); //10
           r.setY(-23); //20
           r.areaPrint();//객체명.메서드명(~)
           System.out.println("2번째 계산");
           /*
           int result=r.areaPrint2(23, 45);//호출
           System.out.println("보고한 결과(result)=>"+result);*/
           System.out.println("보고한 결과(result)=>"+r.areaPrint2(23, 45));
	}
}










