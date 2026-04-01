package lee;

import java.sql.*;//Connection,PreparedStatement,,,
import java.util.*;//ArrayList,List~
//--------------------------------------------------------------
//추가(JNDI 방식)
import javax.sql.*;//DataSource객체->getConnection()
import javax.naming.*;//Context(인터페이스),InitialContext객체->
                                    //lookup(찾고자하는 이름(JNDI명)
//----------------------------------------------------------------

public class BoardDAO{
   
   DataSource ds; //has a 관계 ->DBConnectionMgr pool=null;
   
   public BoardDAO(){
		//생성자 : DataSource 얻기 :  InitialContext  와  JNDI 명
		try{
			//InitialContext ctx=new InitialContext(); 도 가능하다.
			Context ctx=new InitialContext();
			//lookup("java:comp/env/찾고자하는 jndi명")
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds=>"+ds);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList  list(){  // 목록보기(레코드 한개이상)
		
		ArrayList list = new ArrayList();
		try{
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			Connection con = ds.getConnection();
			//Connection con = pool.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Board data = new Board();
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
	
	public int getNewNum(){ //글쓰기 번호 얻기->최대값+1
		int newNum=1;
		try {
			String sql="select max(num) from springboard";
			Connection con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				newNum=rs.getInt(1)+1;
			}
		}catch(Exception e) {e.printStackTrace();}
		return newNum;
	}//end getNewNum();
	
	//public void write(BoardCommand board)
	public void write(String author, String title , String content){
		try{
			int newNum = getNewNum();//최대값을 구해주는 메서드호출
			System.out.println("newNum=>"+newNum);
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println(sql);//한글이 깨지는지 확인
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement stmt = con.prepareStatement(sql);
	  	  	stmt.execute(sql);//stmt.executeUpdate(sql);
	  	  	stmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	
	//select * from springboard where num=?
	public Board retrieve(String num){ // 글 자세히 보기->조회수 증가 
		Board data=new Board();
		try {
			//1.조회수 증가시키기
			String sql = "update springboard set readcnt=readcnt+1 where num="+num;
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			int update=stmt.executeUpdate(sql);
			System.out.println("조회수 증가유무(update)=>"+update);
			stmt=null;
			
			sql="select * from springboard where num="+num;
			stmt=con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			 if (rs.next()){
				data.setNum( rs.getInt( "num" ) );
				data.setAuthor(rs.getString( "author" ));
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
			}//end while
			rs.close();	stmt.close(); con.close();
		}catch(Exception e) {e.printStackTrace();}
	   return data;
	}//end retrieve
    
	public void update( String num , String author, 
			            String title , String content){ // 글 수정하기
	     try{
		  String sql ="update springboard set title='" + title + "',";
		  sql += " content='" + content+"',";
		  sql += " author ='" + author+"'";
		  sql += " where num=" + num;
		  System.out.println(sql);

		  Connection con = ds.getConnection();
		  PreparedStatement stmt = con.prepareStatement(sql);  
		  int update=stmt.executeUpdate(sql);
		  System.out.println("데이터 수정유무(update)=>"+update);
		  stmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update

	  public void delete( String num){ //글 삭제하기
			try{
		  String sql="delete from springboard where num="+num;
		  Connection con=ds.getConnection();
		  PreparedStatement pstmt=con.prepareStatement(sql);
		  int delete=pstmt.executeUpdate(sql);
		  System.out.println("delete 삭제유무="+delete); //1(성공),0(실패)
		  pstmt.close(); con.close();
			}catch(Exception e) { System.out.println("delete()에러발생="+e);}
	 }//end delete
      //name->검색분야, value->검색어
	  public ArrayList search( String name , String value ){ //검색하기
		    ArrayList list = new ArrayList();
		    //List list = new ArrayList();
		    try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println( sql );
		  
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








