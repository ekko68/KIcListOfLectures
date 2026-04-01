package j0526;

//대입(=배정연산자),삼항연산자
public class Op4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("대입,삼항연산자");
         int a=5; int b=7; int x=10; int y=-10;
         //삼항연산자->변수명=(조건식)?항1(참):항2(거짓)
         int absX=(x>=0)?x:-x;  //10->10, -10->-(-10)=10
         int absY=(y>=0)?y:-y;
         System.out.println("x=10일때 ,x의 절대값="+absX);
         System.out.println("y=-10일때 ,y의 절대값="+absY);
         System.out.println("==================");
         //a=a+b ->a+=b ->실행속도가 빠르다.(연산자가 하나)
         a+=b; //a=a+b
         System.out.println("a="+a);//12
         
         a-=b; //a=a-b
         System.out.println("a="+a);//5
         
         a*=b; //a=a*b
         System.out.println("a="+a);//35
         
         a/=b; //a=a/b  ->소수점이 나오면 소수점은 버려진다.(기본연산 int)
         System.out.println("a="+a);//5
         
         a%=b; //a=a%b
         System.out.println("a="+a);//5
	}
}






