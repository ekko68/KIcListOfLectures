package j0526;

public class Op5Cast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("자동형변환");
         short s=12; // 00000000 00001100
         int n=s; //int n=12; 00000000 00000000 00000000 00001100
         
         //자동형변환 예2) 서로 연산을 할때 형이 변환된다.
         char c='A';//65
         int n2=c+1;//char(2byte)+int(4byte)=>int(65)+int(1)=int(66)
         System.out.println("n2=>"+n2);
         System.out.println("(char)n2=>"+(char)n2);//66->char(B)
         int su=(int)3.5;
         System.out.println("su=>"+su);//강제형변환->데이터의 일부소실
         
         int x=123;
         float y=x+12.3f;//int+float->float+float->123.0f+12.3f
         System.out.println("y="+y);//135.3f
         System.out.println("강제형변환 주의할점");
         byte s2=12; short s3=45;
         int re=s2+s3; //byte+short=>short+short->기본 연산단위(int)
         short re2=(short)(s2+s3);
         System.out.println("re="+re);
         System.out.println("re2="+re2);
	}
}





