class VarTest5 
{
	public static void main(String[] args) 
	{
		System.out.println("변수의 사용범위(scope)");
		//초기값->변수를 맨 처음만들고 나서 맨 처음으로 저장된 값
		int su1=10;//변수를 선언하고 나서는 반드시 값을 입력해야 한다.
		//VarTest5.java:7: error: variable su1 might not have been initialized
		{ //블럭처리
		   int su2=20; //블럭내부에서만 존재하는 변수(지역변수)
           System.out.println("su2=>"+su2);
		}
        //System.out.println("블럭밖의 su2=>"+su2);
		System.out.println("su1=>"+su1);
	}
}
