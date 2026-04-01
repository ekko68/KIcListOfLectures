class VarTest3 
{
	public static void main(String[] args) 
	{
		System.out.println("논리적인값 저장");
		boolean b=true;//소문자만 가능하다.(True ,TRUE X)
		                         //error: cannot find symbol
        boolean b2=2>3;//수식으로 표시(false)
		System.out.println("b=>"+b+",b2=>"+b2);//b=>true,b2=>false
		System.out.println("=문자형=");
		//int age=25;
		char c1='A';
		char c2=65; //int c2=65 ->숫자 , char c2=65(아스키코드값)
        char c3='\u0041';//16진수형태로 저장(문자형태)
		// 65->41-->문자형태로 저장->'\u0000' ~'\uffff'(4자리 표시)->뒤에서부터 계산
        //나머지부분은 0으로 채운다.->'\u0041'
        System.out.println("c1=>"+c1);
        System.out.println("c2=>"+c2+",c3=>"+c3);
         //문자+문자=>문자열,문자열+문자열=>문자열
		String s1="자바기초 문법";
		String s2="연산자";
		String s3=s1+"  "+s2;
		System.out.println("s3=>"+s3);
	}
}
