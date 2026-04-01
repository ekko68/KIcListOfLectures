package j0529;

//p167
public class WhileTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복할 횟수를 기억변수 선언
		//무한루프->조건식이 항상 참인되기때문에 무한적으로 계속수행이 되는 경우
		int i=11; //var i=1;
		/* (1) 
		while(i<=10){ //while(true)->c언어( while(1){
         System.out.println("반복할 횟수가 있는 while문"+i);
		 i++; //i=i+1
		}*///블럭처리
		
		   do { 
	         System.out.println("반복할 횟수가 있는 while문"+i);
			 i++; //i=i+1
			}while(i<=10);
		System.out.println("while구문 종료됨!");
	}
}





