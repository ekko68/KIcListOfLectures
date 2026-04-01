package product;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.HttpServletRequest;
//DBConnectionMgr.class추가
import hewon.*;
//////////////////////////////
//orderBean.class추가
import order.*;
////////////////////////////
import java.sql.*;
import java.util.Vector;


public class ProductMgr {

    private DBConnectionMgr pool = null;

    public ProductMgr() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error : 커넥션 가져오기 실패!!");
        }
    }
    /*상품을 등록시키는 메소드*/
    public boolean insertProduct(HttpServletRequest req) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try {
			//C:/Tomcat 4.1/webapps/shopping/data
            String uploadDir = "C:/Tomcat 4.1/webapps/shopping/data/";
            MultipartRequest multi = new MultipartRequest(req, uploadDir, 5 * 1024 * 1024,
				                    "euc-kr", new DefaultFileRenamePolicy());

            con = pool.getConnection();
            String query = "insert into shop_product(name, price, detail, date, stock, image)"
                    + "values(?, ?, ?, now(), ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, multi.getParameter("name"));
            pstmt.setString(2, multi.getParameter("price"));
            pstmt.setString(3, multi.getParameter("detail"));
            pstmt.setString(4, multi.getParameter("stock"));

            if (multi.getFilesystemName("image") == null) {
                pstmt.setString(5, "ready.gif");
            } else {
                pstmt.setString(5, multi.getFilesystemName("image"));
            }
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;

        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }

    /* 상품번호에 대한 자세한 상품의 정보를 알려주는 메소드 구현 */
	
    public ProductBean getProduct(String no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProductBean product = null;

        try {
            con = pool.getConnection();
            String query = "select * from shop_product where no=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new ProductBean();
                product.setNo(rs.getInt("no"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setDetail(rs.getString("detail"));
                product.setDate(rs.getString("date"));
                product.setStock(rs.getString("stock"));
                product.setImage(rs.getString("image"));
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return product;

    }  

    /* 상품의 수정에 대한 메소드 */
    public boolean updateProduct(HttpServletRequest req) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;
		//파일 저장 경로를 수정
        String uploadDir = "C:/Tomcat 4.1/webapps/shopping/data/";

        try {
            con = pool.getConnection();
       MultipartRequest multi = new MultipartRequest(req, uploadDir, 5 * 1024 * 1024, 
				                 "euc-kr", new DefaultFileRenamePolicy());

            if (multi.getFilesystemName("image") == null) {
String query = "update shop_product set name = ?, price = ?,detail = ?, stock = ?  where no = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, multi.getParameter("name"));
                pstmt.setString(2, multi.getParameter("price"));
                pstmt.setString(3, multi.getParameter("detail"));
                pstmt.setString(4, multi.getParameter("stock"));
                pstmt.setString(5, multi.getParameter("no"));
            } else {
				//새로운 이미지를 업로드하였다면 새로운 이미지를 수정
String query = "update shop_product set name =? ,price = ?, detail = ?,stock = ?, image = ?  where no = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, multi.getParameter("name"));
                pstmt.setString(2, multi.getParameter("price"));
                pstmt.setString(3, multi.getParameter("detail"));
                pstmt.setString(4, multi.getParameter("stock"));
                pstmt.setString(5, multi.getFilesystemName("image"));
                pstmt.setString(6, multi.getParameter("no"));
            }
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }

   /*해당상품의 재고수량을 줄이기 위한 메소드 구현 */
    public void reduceProduct(OrderBean order) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = pool.getConnection();
            String query = "update shop_product set stock = (stock - ? ) where no = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, order.getQuantity());
            pstmt.setString(2, order.getProduct_no());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
    }
    
	/*현재 등록된 상품리스트의 정보를 알려주는 메소드    */
    public Vector getProductList() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector vProduct = new Vector();

        try {
            con = pool.getConnection();
            String query = "select * from shop_product order by no desc";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                ProductBean product = new ProductBean();
                product.setNo(rs.getInt("no"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setDetail(rs.getString("detail"));
                product.setDate(rs.getString("date"));
                product.setStock(rs.getString("stock"));
                product.setImage(rs.getString("image"));
                vProduct.add(product);
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, stmt, rs);
        }
        return vProduct;
    }
      

    /* 등록된 상품을 삭제시키는 메소드*/
    public boolean deleteProduct(String no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try {
            con = pool.getConnection();
            String query = "delete from shop_product where no = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }
}