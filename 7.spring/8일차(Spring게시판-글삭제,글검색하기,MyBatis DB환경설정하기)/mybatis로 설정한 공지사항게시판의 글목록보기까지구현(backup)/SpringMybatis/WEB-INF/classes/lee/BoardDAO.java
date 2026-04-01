package lee;

import java.util.List;//글목록보기
//Spring의 jdbc연동시 에러유발->처리해주는 예외처리클래스
import org.springframework.dao.DataAccessException;

public interface BoardDAO{
	
	//1.글목록보기
	public List list() throws DataAccessException;
	
	//2.최대 글번호 구하기
	
	//3.게시판의 글쓰기
	
	//4.조회수 증가
	
	//5.글상세보기
	
	//6.글수정하기
	
	//7.글삭제하기
	
	//8.글검색하기
	
}



/*package lee;

import java.sql.*;
import java.util.*;

//-----1.JNDI방법을 사용하기위해서 import ---
import javax.sql.*;//DataSource->DB접속
import javax.naming.*;//Context(인터페이스),InitialContext(클래스)
//---------------------------------------------------------------------------

public class BoardDAO{
	//private DBConnectionMgr pool=null;->getConnection()
   DataSource ds;//->getConnection()
   
   public BoardDAO(){
		//생성자 : DataSource 얻기 :  InitialContext  와  JNDI 명
		try{
			//pool=DBConnectionMgr.getInstance();
			//JNDI명을 찾기위해서->Context객체
			//InitialContext ctx=new InitialContext();
			Context ctx=new InitialContext();
			//형식)java:comp/env/찾고자하는 별칭(별명)
			ds=(javax.sql.DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds="+ds);
		}catch(Exception e){
			System.out.println("DB접속 실패="+e);
		}
	}
   
	public ArrayList  list(){  // 목록보기->회원관리 리스트작성
		
		ArrayList list = new ArrayList();
		//List list=new ArrayList();
		try{
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			//Connection con=pool.getConnection();
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Board data = new Board();//DTO
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
				data.setDate(rs.getString( "writeday" ));
				data.setReadcnt(rs.getInt( "readcnt" ));
				list.add( data );
			}//end while
			rs.close();	stmt.close(); con.close();
		}catch(Exception e){ e.printStackTrace(); }
		
		return  list;
	}//end list
	
	
	public int getNewNum(){ //글쓰기 번호 얻기->select max(num) from springboard
		int newNum=1;//기본 default
		try{
			String sql="select max(num) from springboard";
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			 if(rs.next()){
				 newNum=rs.getInt(1)+1;
				 System.out.println("다음에 저장할게시물번호="+newNum);
			 }
		}catch(Exception e){
			System.out.println("getNewNum()에러유발="+e);
		}
		return newNum;
	}//end getNewNum();
	
	//public void write(Board board){
	public void write(String author, String title , String content){
		try{
			int newNum = getNewNum();
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println("write의 sql="+sql);
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement stmt = con.prepareStatement(sql);
	  	  	stmt.execute(sql);//stmt.executeUpdate(sql);
	  	  	stmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	
	
	//조회수가 한개증가,select * from springboard where num=?
	public Board retrieve(String num){ // 글 자세히 보기 
		
		Board data = new Board();
	
		try{
			Connection con = ds.getConnection();
			String sql="update springboard set readcnt=readcnt+1 ";
			         sql+="where num="+num;
		    PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate(sql);
			stmt=null;//또 다른 SQL구문을 사용하기 위해서 전의 SQL 지우기
			
			sql = "SELECT * FROM springboard where num="+num;
		    stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
			}//end while
			rs.close();	stmt.close(); con.close();
		}catch(Exception e){ e.printStackTrace(); }
		return  data;
	}//end retrieve
    
	//public void update(Board board){
	public void update( String num , String author, 
			                     String title , String content){ // 글 수정하기
	     try{
		  String sql ="update springboard set title='" + title + "',";
		  sql += " content='" + content+"',";
		  sql += " author ='" + author+"'";
		  sql += " where num=" + num;
		  System.out.println("update()의 sql="+sql);

		  Connection con = ds.getConnection();
		  PreparedStatement stmt = con.prepareStatement(sql);  
		  int update=stmt.executeUpdate(sql);
		  System.out.println("update수정유무="+update);
		  stmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update
   
	 
	  public void delete( String num){ //글 삭제하기
			try{
	    //String sql="delete from springboard where num=?
		String sql="delete from springboard where num="+num;
		    Connection con=ds.getConnection();
		    PreparedStatement pstmt=con.prepareStatement(sql);
		    int delete=pstmt.executeUpdate(sql);
		    System.out.println("delete삭제 유무="+delete);//1->성공,0->실패
		    pstmt.close();con.close();
			}catch(Exception e){
				System.out.println("delete()에러발생="+e);
			}
		}//end delete
      
	  //1.name(검색분야(작성자,제목,,,) 2.value(검색어)
	  public ArrayList search( String name , String value ){ //검색하기
		  
		    ArrayList list = new ArrayList();//레코드 한개이상 검색
		    //List list = new ArrayList();
		    try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println("search()의  sql="+sql );
		  
			      Connection con = ds.getConnection();
		    	  PreparedStatement stmt = con.prepareStatement(sql);
		    	  ResultSet rs = stmt.executeQuery( sql );
		    	  while( rs.next()){
		    		Board data = new Board();
		    		data.setNum(rs.getInt( "num" ));
		    		data.setAuthor(rs.getString( "author" ));
		    		data.setTitle(rs.getString( "title"));
		    		data.setContent(rs.getString( "content" ));
		    		data.setDate(rs.getString( "writeday" ));
		    		data.setReadcnt(rs.getInt( "readcnt" ));
		    		list.add( data );
		    	  }
		    	  rs.close();	stmt.close(); con.close();
		    	}catch( Exception e){ e.printStackTrace();}
		    	return list;
    }
}



*/