class VarTest2 
{
	public static void main(String[] args) 
	{
		System.out.println("소수점을 저장");
		float f=5.3f;
		//VarTest2.java:6: error: incompatible types: 
		//possible lossy conversion from double to float
		double f2=5.3;
		System.out.println("f=>"+f+",f2=>"+f2);//f=>5.3,f2=>5.3
		float m_float=123456.789123f;
		double m_double=123456.789123;
		System.out.println("m_float=>"+m_float);
		System.out.println("m_double=>"+m_double);
	}
}
/*
---------- 실행 ----------
소수점을 저장
f=>5.3,f2=>5.3
m_float=>123456.79
m_double=>123456.789123

출력 완료 (0초 경과) - 정상 종료
*/

