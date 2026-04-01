package j0621;

import java.net.*;//InetAddress,Socket,ServerSocket
//Checked Exception계열->반드시 예외처리해야 한다.(try~catch,throws Exception)
//입출력,DB연동,네트워크 통신,쓰레드

public class NetWorkTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       InetAddress ia=null;
       InetAddress ia2[];//컴퓨터가 한대이상
       //원격컴퓨터에 접속->도메인
       ia=InetAddress.getByName("www.naver.com");//도메인이름
       System.out.println("서버주소->"+ia.getHostAddress());//202.179.177.22
       //서버가 한대이상->getAllByName
       System.out.println("=================");
       ia2=InetAddress.getAllByName("www.naver.com");//도메인 등록ip주소
       //확장 for문
       for(InetAddress aa:ia2)
    	   System.out.println("서버들 주소="+aa.getHostAddress());
       System.out.println("==자기컴퓨터의 정보==");
       InetAddress host=InetAddress.getLocalHost();
       System.out.println("컴퓨터명=>"+host.getHostName());
       System.out.println("ip주소=>"+host.getHostAddress());
	}
}
/*
 * 서버주소->125.209.222.141
=================
서버들 주소=125.209.222.141
서버들 주소=125.209.222.142
==자기컴퓨터의 정보==
컴퓨터명=>kitcoop-PC
ip주소=>192.168.0.57
 */





