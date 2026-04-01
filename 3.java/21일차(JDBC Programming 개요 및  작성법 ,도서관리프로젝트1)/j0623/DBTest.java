package j0623;

import java.sql.*;//DB관련 라이브러리 불러오기(1)->필수 예외처리

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Connection con=null;//연결객체를 얻어와야 SQL 구문을 사용 가능
          //JDBC_URL 구성 = JDBC:oracle:thin:@IP주소:포트:SID (컴퓨터위치)
          String url="jdbc:oracle:thin:@localhost:1521:orcl";//url주소값 
          try {
        	 //1.접속할 드라이버를 메모리에 올리기
        	  Class.forName("oracle.jdbc.driver.OracleDriver");
        	  //2.접속하기위한 메서드(1.접속url ,2.계정명,3.접속 암호)
        	  con=DriverManager.getConnection(url, "scott", "tiger");
        	  System.out.println("접속con=>"+con);
          }catch(Exception e) {
        	  System.out.println("DB연결 테스트 실패=>"+e);
          }
	}
}


