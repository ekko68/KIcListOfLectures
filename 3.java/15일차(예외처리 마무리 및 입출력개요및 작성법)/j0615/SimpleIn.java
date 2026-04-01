package j0615;
//키보드를 통해서 입력받아서 입력받은 값 그대로 출력
import java.io.*;

public class SimpleIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         //키보드로 값을 입력->저장->더 이상 입력X->-1을 리턴
		int charRead;//System.in.read()->문자->숫자로 바꿔서 저장
		//char->0~65535 저장범위
		System.out.println("입력하고자하는 문자열을 입력요망?");
		while((charRead=System.in.read())>=0)  //어떠한 글자라도 계속입력중이라면
			System.out.write(charRead);
	}
}





