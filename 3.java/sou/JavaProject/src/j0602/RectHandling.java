package j0602;

//다형성(생성자? ,오버로딩? this?)->같은 메서드 호출->결과가 다 다르게 나올수있다
class Rect{
//int ->0, double->0.0 ,String=>null,boolean->false
//1)private 멤머변수
 private int x; //가로->0 grao
 private int y; //세로->0 sero
 
 //(),(x),(y),(x,y)
 //---------------------------------------
 public Rect(){
	 //x=50;y=30;
	 this(50,30);//자기 클래스 생성자->다른 생성자호출할때에는 반드시 첫줄
	 System.out.println("기본생성자(없으면 자동으로 생성-멤버변수 초기화)");
	 //this(50,30);
 } //기본생성자->없으면 자동으로 컴파일러가 생성 O 
   //->다른 생성자 있으면 생성X
 
 public Rect(int x){
	 this.x=x;
	 System.out.println("난 매개변수1개 짜리 생성자호출");
 }
 
 /*Rect(int y){
	 this.y=y;
 }*/
 
 public Rect(int x,int y){ //50,30
	 this.x=x;//r2.x=50;
	 this.y=y;//r2.y=30;
	 System.out.println("난 매개변수2개 짜리 생성자호출");
 }
 //----------------------------------------
 //2.값을 저장->Setter Method , 값을 가져오기->Getter Method
 //public=>외부에서 public이 부여된 메서드를 호출이 가능
public void setX(int x) {
	if(x<0) {
		System.out.println("x값은 음수를 입력할 수가 없다");
		x=10;
		return;
	}
	this.x=x;
}
public void setY(int y) {
	if(y<0) {
		System.out.println("y값은 음수를 입력할 수가 없다");
		y=20;
	}else {
	   this.y=y;
	}
}
//클래스 내부에서는 현재 생성된 객체는 =>this로 표시한다.
//3.Getter Method->반환값이 있는 메서드(p254)
public int getX() { return this.x; }  //객체명.x
public int getY() { return this.y; }  //객체명.y

  //worker method
  void areaPrint() {
	  System.out.println("직사각형의 면적은=>"+(this.x*this.y));//50*30
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
           /*
           r.setX(-40); //10
           r.setY(-23); *///20
           r.areaPrint();//객체명.메서드명(~)
           System.out.println("2번째 계산");
           /*
           int result=r.areaPrint2(23, 45);//호출
           System.out.println("보고한 결과(result)=>"+result);*/
           System.out.println("보고한 결과(result)=>"+r.areaPrint2(23, 45));
           Rect r2=new Rect(); //Rect r2=new Rect(50,30);
           r2.areaPrint();
	}
}










