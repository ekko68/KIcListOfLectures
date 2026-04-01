package j0612;

//재귀메서드
public class RecuError {
    //caller method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          showHi(3);//->showHi(2)->showHi(1)
          /*showHi(2);
          showHi(1);*/
	}

	//부하직원(work method)->내부적으로 반복되는 횟수를 감소시키면서 자기자신을
	//반복해서 호출하는 메서드=>재귀메서드
	public static void showHi(int cnt) {//3
		System.out.println("Hi~");
		if(cnt==1)
			return;
		showHi(--cnt);//showHi(cnt--);  먼저 감소하고나서 자기 자신메서드호출
		/* cnt=3  Hi=>showHi(2);
		 * cnt=2  Hi=>showHi(1);
		 * cnt=1  Hi=>루프탈출
		 */
		/*if(cnt==1)
			return;*/
	}
}









