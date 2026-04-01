package j0612;

public class Fact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("3!->"+factorial(3)); //3*2*1=>6
        System.out.println("4!->"+factorial(4));//4*3*2*1=24
	}

	public static int factorial(int n) {
		//3->3*2*1=>6
		if(n==1)
			return 1;
		return n*factorial(n-1);
		/*
		 * n=3일때 3*factorial(2)
		 * n=2일때 3*2*factorial(1)
		 * n=1일때  1
		 */
	}
}







