package j0614;

//예외처리발생-->caller method->work method호출할때 제일 많이 발생
public class HelloTest2 {
	public static void main(String[] args) { //JVM
		// TODO Auto-generated method stub
		try {
		HelloTest2 ht=new HelloTest2();
		ht.go();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열첨자가 잘못계산됐습니다.");
			System.out.println(e.getMessage());//간단한 에러메세지를 출력할때
			System.out.println(e);//e.toString()//중간정도의 에러메세지를 출력
			//아주 자세히 알고 싶다.
			e.printStackTrace();
		}
		System.out.println("예외처리 끝!");
          /*int i=0;//첨자저장
          String greetings[]= {"객체형변환","라이브러리 작성","예외처리"};
          while(i<4) {
        	  System.out.println(greetings[i]);
        	  i++;
          }*///while
	}
	
	public void go() throws ArrayIndexOutOfBoundsException {
		int i=0;//첨자저장
        String greetings[]= {"객체형변환","라이브러리 작성","예외처리"};
        while(i<4) {
      	  System.out.println(greetings[i]);
      	  i++;
        }
	}

}
