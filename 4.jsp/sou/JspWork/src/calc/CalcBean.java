package calc;

public class CalcBean {
	// 멤버변수는 <input type="text" name="num1"와 반드시 일치
	private int num1, num2;
	private String operator = "";// 연산자
	private int result;// 연산결과값을 저장할 변수

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
		System.out.println("setNum1()호출됨!");
	}
    /* Tomcat 8.5기준
     * <jsp:setProperty name="~" property="*"/>->에러유발
	public void setNum1(String num1) {
		this.num1 = Integer.parseInt(num1);
		System.out.println("setNum1()호출됨!");
	}
	*/
	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
		System.out.println("setNum2()호출됨!");
	}

	public int getResult() {
		return result;
	}
	//5+3=8
	public  void  calculate() {
		//+
		if(operator.equals("+")) {
			result=num1+num2;
		}
		//-
		if(operator.equals("-")) {
			result=num1-num2;
		}
		//*
		if(operator.equals("*")) {
			result=num1*num2;
		}
		// /
		if(operator.equals("/")) {
			result=num1/num2;
		}
	}

	public void setOperator(String operator) {
		this.operator = operator;
		System.out.println("setOperator() 호출됨!");
	}
}







