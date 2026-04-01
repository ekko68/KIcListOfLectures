package j0526;

public class Op2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1=5;//+5
		short s=-4;
		int i=8;
		System.out.println("b1="+b1);
		System.out.println("-s="+(-s));//부호(-,+) 단항산술연산자
		System.out.println("i="+i);
		System.out.println("++i="+(++i));//9
		/*
		 * i=i+1
		 * System.out.println(i)
		 */
		System.out.println("i++="+i++);
		/*
		 * System.out.println(i)
		 *  i=i+1
		 */
		System.out.println("i="+i);//10
		System.out.println("--i="+(--i));//9
		/*
		 * i=i-1   i=10-1=9
		 * System.out.println(i)//9
		 */
		System.out.println("i--="+(i--));//9
		/*
		 * System.out.println(i) //9
		 * i=i-1 ->i=9-1=8
		 */
		System.out.println("i="+i);//8
	}
}










