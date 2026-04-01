class VarTest4 
{  //변수의 특성
	public static void main(String[] args) 
	{
		System.out.println("변수의 특성");
		//자료형 변수명=값; ->같은 자료형의 변수를 연달아서 여러번 선언
		int num,num2; //,로 구분해서 나열
		num=17;
		System.out.println("num=>"+num);
		num=18;//중간에 값이 변경->그 변경된 값을 기억
        System.out.println("num=>"+num);
		//상수=>값이 정해지면 안바뀌는 경우
        int num3=4,num4=5,num5=6; //변수를 선언하면서 같은 자료형을 ,로 나열
		//int num3=4;int num4=5;int num5=6;
        //상수화된 변수=>전부 대문자로 써준다.
		final int NUM6=40;  //변수앞에 final이 붙으면 상수가 된다.->수식값
		//num6=50;
		//VarTest4.java:14: error: cannot assign a value to final variable num6
        System.out.println("num6=>"+NUM6);
	}
}





