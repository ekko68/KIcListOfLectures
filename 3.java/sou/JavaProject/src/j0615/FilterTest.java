package j0615;

//키보드로 값을 입력->한글데이터 출력하기
import java.io.*;

public class FilterTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
        //System.in
		/* (1)
		 InputStreamReader isr=new InputStreamReader(System.in);
		//Reader객체 뿐만아니라 Reader클래스의 자식클래스의 객체까지 생성자인수
		BufferedReader br=new BufferedReader(isr);*/
		
		//Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader
				                              (new InputStreamReader(System.in));
		String name;
		int kor,eng,tot;
		
		System.out.println("이름은?");
		name=br.readLine();//sc.nextLine() or sc.next()
		System.out.println("국어?");
		kor=Integer.parseInt(br.readLine());//"45"->45 //sc.nextInt()
		//영어?
		System.out.println("영어?");
		eng=Integer.parseInt(br.readLine());
		tot=kor+eng;
		
		//이름=? 총점=?
		System.out.println("이름="+name+",총점=>"+tot);
	}
}









