package j0615;

import java.io.*;//자바의 입출력
//메모리에(데이터를 저장)->모니터에 출력
public class WriteHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        byte hello[]= {72,101,108,108,111,32,87,111,114,108,100,33,10};
        //byte=>데이터 전송단위로 출력
        byte a=72;
        //System.out->표준출력장치(모니터)
        try {
        System.out.println((char)a);
        System.out.write(a);//write메서드를 이용출력X->출력버퍼에 그냥 저장됨
        System.out.write(hello);//배열의 값을 출력->반드시 예외처리해야된다.
        }catch(IOException e) {
        	System.out.println(e);//e.toString()
        }
	}
}






