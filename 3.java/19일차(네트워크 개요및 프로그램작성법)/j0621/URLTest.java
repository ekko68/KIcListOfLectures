package j0621;

import java.io.*;//접속->입출력이 필요
//특정 사이트에 접속->정보를 가져오는 클래스->URL,URLConnection
import java.net.URL;
import java.util.Scanner;//키보드로 특정 사이트를 직접 입력

public class URLTest {
    public URLTest(String s) throws Exception {
    	URL url=new URL(s);
    	System.out.println("url=>"+url);
    	//직접 사이트에서 데이터를 가져오기(출력->입력)
    	InputStream in=url.openStream();
    	//사이트 접속->홈페이지 파일을 가져와서 콘솔에 출력
    	BufferedReader br=new BufferedReader
    			                            (new InputStreamReader(in));
    	String ss;//읽어들여서 임시로 저장할 변수 선언->int ss;
    	while((ss=br.readLine())!=null) { //불러올 데이터가 존재하는 한
    		System.out.println(ss); //System.out.write(ss)
    	}
    	in.close(); br.close();
    }
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
         System.out.println("접속할 사이트 도메인 이름?(http://도메인이름)");
         String domain=sc.next();
         new URLTest(domain); //http://www.naver.com
	}
}





