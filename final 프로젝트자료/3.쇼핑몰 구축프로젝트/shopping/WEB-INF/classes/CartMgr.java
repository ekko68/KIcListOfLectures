package product;

import java.util.Hashtable;
//추가
import order.*;
///////////////////////
public class CartMgr {

    private Hashtable hCart = new Hashtable();

    public CartMgr() {
    }
    
	/*장바구니에 상품을 등록시키는 메소드*/
    public void addCart(OrderBean order) {

		//OrderBean으로부터 선택한 상품의 상품번호와 수량을 가져온다.
        String product_no = order.getProduct_no();
        int quantity = order.getQuantity();

		//선택한 상품수량이 적어도 1개 이상일 경우 실행된다.
        if (quantity > 0) {
            if (hCart.containsKey(product_no)) { //선택한 상품이 이미 장바구니에 있는지 검사

			    //이미 장바구니에 있는 상품이라면 장바구니에 있는 상품의 수량을 가져온다.
                OrderBean tempOrder = (OrderBean) hCart.get(product_no);

				//장바구니에 있는 상품수량에 현재 신청한 수량을 더해준다.
                quantity += tempOrder.getQuantity();
                tempOrder.setQuantity(quantity);	//총수량을 저장
                hCart.put(product_no, tempOrder);//장바구니를 새로이 저장
            } else {
                 //중복된 상품이 아니라면 장바구니에 새롭게 상품을 추가
                hCart.put(product_no, order);
            }
        }
    }
   
    /*장바구니에 등록된 상품리스트를 알아보기*/
    public Hashtable getCartList() {
        return hCart;
    }
    
	/*장바구니의 정보를 수정하기 위해서 장바구니 정보를 새로 입력 */
    public void updateCart(OrderBean order) {
        String product_no = order.getProduct_no();
        hCart.put(product_no, order);
    }

    /*해쉬테이블에 저장된 장바구니의 목록을 지움 */
    public void deleteCart(OrderBean order) {
        String product_no = order.getProduct_no();
        hCart.remove(product_no);
    }

}