package hewon;

//웹상에 호출되는 메서드를 선언하는 클래스->DB연결시킨 후 메서드 호출
//DBConnectionMgr --->MemberDAO 서로 연결(has a 관계)
import java.sql.*;//DB
import java.util.*;//Vector,ArrayList

public class MemberDAO {
    //1.DBConnectionMgr객체를 선언
	private DBConnectionMgr pool=null;
	
	//2.생성자를 통해서 객체를 얻어온다.->서비스
	public MemberDAO() {
		try {
			pool=DBConnectionMgr.getInstance();//정적메서드
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB연결 실패->"+e);
		}
	}//생성자
	
	//1)요구분석에 따른 회원로그인을 체크인 해주는 메서드 필요
	//int ,boolean(true,false)->nup,1234
	//select id,passwd from member where id='nup' and passwd='1234'
	public  boolean  loginCheck(String id,String passwd) {
		//1.DB연결코딩
		Connection  con=null;
		PreparedStatement pstmt=null;//stmt객체보다 실행속도가 빠르다
		ResultSet rs=null;//select인 경우만 필요
		boolean check=false;
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();//connection을 만들어서 제공
			System.out.println("con=>"+con);
			sql="select id,passwd from member where id=? and passwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs=pstmt.executeQuery();
			check=rs.next();//데이터가 존재->true ,없으면 ->false
		}catch(Exception e) {
			System.out.println("loginCheck()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
	}
	//2)회원가입->중복id를 체크인 해주는 메서드 필요
	//select id from member where id='kkk';
	public boolean checkId(String id) {
		
		Connection  con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean check=false;
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			sql="select id from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			check=rs.next();//데이터가 존재->true ,없으면 ->false
		}catch(Exception e) {
			System.out.println("checkId()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
	}
	
	//3)우편번호->우편번호를 검색->자동으로 입력
	//select zipcode from zipcode where area3 like '수유3동%';->String
	//select zipcode,area1 from zipcode where area3 like '수유3동%';->ZipcodeDTO
	//select * from zipcode where area3 like '수유3동%'; //한개이상->Vector or ArrayList
	public  Vector<ZipcodeDTO>   zipcodeRead(String area3) {
		
		Connection  con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;//select
		//추가
		Vector<ZipcodeDTO> vecList=new Vector();
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			sql="select * from zipcode where area3 like '"+area3+"%'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//레코드가 한개 이상
			while(rs.next()) {
				//vector or ZipcodeDTO(필드별로 저장(Setter)->rs.getXXX(필드명)
				ZipcodeDTO tempZipcode=new ZipcodeDTO();
				tempZipcode.setZipcode(rs.getString("zipcode"));//("142-890");
				tempZipcode.setArea1(rs.getString("area1"));
				tempZipcode.setArea2(rs.getString("area2"));
				tempZipcode.setArea3(rs.getString("area3"));
				tempZipcode.setArea4(rs.getString("area4"));
				//vector or ArrayList에 담는 구문
				vecList.add(tempZipcode);//대략 13개의 레코드가 저장이 된다.
			}
		}catch(Exception e) {
			System.out.println("zipcodeRead() 실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		return vecList;
	}
	
	//4)회원가입->insert into values(?,?,?~?)
	public boolean memberInsert(MemberDTO mem) {
		
		Connection  con=null;
		PreparedStatement pstmt=null;
		//ResultSet rs=null;->select만 필요
		boolean check=false;//회원가입 성공유무
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			//트랜잭션 처리
			con.setAutoCommit(false);
			//-------------------------------
			sql="insert into member values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem.getMem_id());//~(1,'test')
			pstmt.setString(2, mem.getMem_passwd());
			pstmt.setString(3, mem.getMem_name());
			pstmt.setString(4, mem.getMem_email());
			pstmt.setString(5, mem.getMem_phone());
			pstmt.setString(6, mem.getMem_zipcode());
			pstmt.setString(7, mem.getMem_address());
			pstmt.setString(8, mem.getMem_job());
			
			int insert=pstmt.executeUpdate();//반환 1 (성공),0 (실패)
			con.commit();//실질적으로 insert작동된다.
			if(insert > 0) { //if(insert==1){
				check=true;
			}
		}catch(Exception e) {
			System.out.println("memberInsert()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt);
		}
		return check;
	}
	
	//5)회원수정을 위한 계정별 회원정보를 출력메서드->nup
	//select * from member wher id='nup';
	//select * from member->public ArrayList or Vector getMemberList(){}
	public MemberDTO getMember(String mem_id) {
		
		Connection  con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO mem=null;//id값에 해당되는 레코드한개의 정보
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			sql="select * from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id); //~(1,'nup')
			rs=pstmt.executeQuery();
			//id값에 해당하는 레코드를 찾았다면?
			//String name=rs.getString("name")
			if(rs.next()) {    //while(rs.next()){}=>여러개의 레코드를 담을때
				mem=new MemberDTO();
				mem.setMem_id(rs.getString("id"));//~('nup')
				mem.setMem_passwd(rs.getString("passwd"));
				mem.setMem_name(rs.getString("name"));
				mem.setMem_phone(rs.getString("phone"));
				mem.setMem_zipcode(rs.getString("zipcode"));
				mem.setMem_address(rs.getString("address"));
				mem.setMem_email(rs.getString("e_mail"));
				mem.setMem_job(rs.getString("job"));
			}
		}catch(Exception e) {
			System.out.println("getMember()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		return mem; //return name;
	}
	//6)회원수정->회원가입과 동일하다.
	public boolean memberUpdate(MemberDTO mem) {
		
		System.out.println("mem.getMem_id()=>"+mem.getMem_id());
		Connection  con=null;
		PreparedStatement pstmt=null;
		boolean check=false;//회원수정 성공유무
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			//트랜잭션 처리
			con.setAutoCommit(false);
			//-------------------------------
			sql="update member set passwd=?,name=?,e_mail=?,phone=?,"
					+ " zipcode=?,address=?, job=?  where id=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem.getMem_passwd());
			pstmt.setString(2, mem.getMem_name());
			pstmt.setString(3, mem.getMem_email());
			pstmt.setString(4, mem.getMem_phone());
			pstmt.setString(5, mem.getMem_zipcode());
			pstmt.setString(6, mem.getMem_address());
			pstmt.setString(7, mem.getMem_job());
			pstmt.setString(8, mem.getMem_id());
			
			int update=pstmt.executeUpdate();//반환 1 (성공),0 (실패)
			con.commit();//실질적으로 update작동된다.
			if(update == 1) { //if(update==1){
				check=true; //수정성공
			}
		}catch(Exception e) {
			System.out.println("memberUpdate()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt);//rs는 없다.(select가 아님)
		}
		return check;
	}
	
	//7)회원탈퇴
	//passwd->사용자로부터 직접 입력받는 경우, id->파라미터값으로 전달
	public int deleteMember(String id,String passwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null; //select passwd from member where id='nup'
		String dbpasswd="";//DB상에서 찾은 암호를 저장
		int x=-1;//회원 탈퇴 유무
		
		try {
			con=pool.getConnection();
			con.setAutoCommit(false);
			//1.id값에 해당하는 되는 암호먼저 찾기
			pstmt=con.prepareStatement("select passwd from member where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//암호가 존재한다면
			if(rs.next()) {
				dbpasswd=rs.getString("passwd");//rs.getString(1);
				System.out.println("dbpasswd="+dbpasswd);
				//dbpasswd(DB상에서 찾은 암호)==passwd(웹상))
				if(dbpasswd.equals(passwd)) {
					pstmt=con.prepareStatement("delete from member where id=?");
					pstmt.setString(1, id);
					int delete=pstmt.executeUpdate();
					con.commit();
					System.out.println("delete(회원탈퇴 성공유무)="+delete);
					x=1;//회원탈퇴 성공
				}else {//회원탈퇴 실패->암호가 틀린경우
					x=0;
				}
			}
		}catch(Exception e) {
			System.out.println("deleteMember()호출됨=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	
	//8)회원리스트->select * from member (상품,카테고리,,,,)
	public ArrayList<MemberDTO>  getMemberList(){
		
		Connection  con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MemberDTO> memList=null;// 레코드한개이상 의 정보
		String sql="";//실행시킬 sql구문
		//2.실행시킬 SQL구문이 필요
		try {
			con=pool.getConnection();
			sql="select * from member ";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//id값에 해당하는 레코드를 찾았다면?
			//String name=rs.getString("name")
			while(rs.next()) {    //while(rs.next()){}=>여러개의 레코드를 담을때
				MemberDTO mem=new MemberDTO();
				mem.setMem_id(rs.getString("id"));//~('nup')
				mem.setMem_passwd(rs.getString("passwd"));
				mem.setMem_name(rs.getString("name"));
				mem.setMem_phone(rs.getString("phone"));
				mem.setMem_zipcode(rs.getString("zipcode"));
				mem.setMem_address(rs.getString("address"));
				mem.setMem_email(rs.getString("e_mail"));
				mem.setMem_job(rs.getString("job"));
				//ArrayList에 담기
				memList.add(mem);
			}
		}catch(Exception e) {
			System.out.println("getMemberList()실행 에러유발->"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		return memList;
		
	}
}








