package order;

//DB접속
import hewon.*;
//////////////////
import java.sql.*;
import java.util.Vector;

public class OrderMgr {

    private DBConnectionMgr pool = null;

    public OrderMgr() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error : 커넥션 가져오기 실패!!");
        }
    }

    public void insertOrder(OrderBean order) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = pool.getConnection();
			
			//주문테이블에 사용자의 주문을 입력하기 위해 쿼리를 작성한
            String query = "insert into shop_order(id, product_no, quantity, date, state)"
                    + " values(?, ?, ? ,now() ,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, order.getId());//사용자의 ID를 입력
            pstmt.setString(2, order.getProduct_no());//주문한 상품번호를 입력
            pstmt.setInt(3, order.getQuantity());//주문수량을 입력
            pstmt.setString(4, "1");//주문상태를 입력=>1의 값은 접수중을 의미
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
    }

   /*주어진 ID에 해당하는 사용자의 주문내역을 가져오기 위한 메소드 */
    public Vector getOrder(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vector vResult = new Vector();

        try {
            con = pool.getConnection();
            String query = "select * from shop_order where id = ? order by no desc";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);//사용자의 ID를 지정
            rs = pstmt.executeQuery();
            while (rs.next()) { //주문내역이 있을 경우=> 주문내역을 저장
                OrderBean order = new OrderBean();
                order.setId(rs.getString("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("date"));
                order.setNo(rs.getString("no"));
                order.setState(rs.getString("state"));
                order.setProduct_no(rs.getString("product_no"));
                vResult.add(order);//주문내역은 하나 이상이 되므로 Vector에 담아 
				                   //돌려주게 된다.
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return vResult;
    }

    // 관리자에서 관리하는 메소드 
    public Vector getOrderList() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector vResult = new Vector();

        try {
            con = pool.getConnection();

			//주문내역을 가져오기 위한 쿼리 작성
            String query = "select * from shop_order order by no desc";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                OrderBean order = new OrderBean();
                order.setId(rs.getString("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("date"));
                order.setNo(rs.getString("no"));
                order.setState(rs.getString("state"));
                order.setProduct_no(rs.getString("product_no"));
                vResult.add(order);//각각 주문내역의 정보를 담고 있는 OrderBean을
				                   //Vector에 담아둡니다.
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, stmt, rs);
        }
        return vResult;
    }

   /*주문상세 정보를 알려주는 메소드 */
    public OrderBean getOrderDetail(String no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        OrderBean order = null;

        try {
            con = pool.getConnection();

			//주문상세 정보를 가져오기 위한 쿼리를 작성
            String query = "select * from shop_order where no = ?";
            pstmt = con.prepareStatement(query);

			//가져올 주문 상세내역에 대한 주문번호를 지정해 준다.
            pstmt.setString(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                order = new OrderBean();
                order.setId(rs.getString("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("date"));
                order.setNo(rs.getString("no"));
                order.setState(rs.getString("state"));
                order.setProduct_no(rs.getString("product_no"));
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return order;
    }

    /*주문처리 상태를 변경하기 위해 메소드를 작성 */
    public boolean updateOrder(String no, String state) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;
        try {
            con = pool.getConnection();

			//주문처리 상태를 변경하기 위해 쿼리를 작성
            String query = "update shop_order set state = ? where no = ?";
            pstmt = con.prepareStatement(query);

			//변경하고자 하는 주문상태와 주문번호를 지정해 준다.
            pstmt.setString(1, state);
            pstmt.setString(2, no);
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }

     /*주문내역을 삭제하기 위한 메소드*/
    public boolean deleteOrder(String no) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try {
            con = pool.getConnection();

			//주문내역을 삭제하기 위한 쿼리를 작성
            String query = "delete from shop_order where no = ?";
            pstmt = con.prepareStatement(query);

			//삭제할 주문번호를 지정
            pstmt.setString(1, no);
            int count = pstmt.executeUpdate();

			//수정작업을 수행한 결과가 하나일 경우 정상적으로 처리
			//된 경우이므로 result에 true를 저장

            if (count == 1) result = true;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }
   
}
