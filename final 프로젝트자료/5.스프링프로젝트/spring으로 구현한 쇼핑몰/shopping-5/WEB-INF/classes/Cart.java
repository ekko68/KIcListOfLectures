package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart implements Serializable{

  private List itemList = new ArrayList();

  public List getItemList() {
    return this.itemList;
  }

  public boolean isEmpty(){
    if(this.itemList == null || this.itemList.isEmpty()){
      return true;
    }
    return false;
  }
  
  public void push(ItemSet pushedItemSet) {
    //추가 상품이 바구니에 이미 존재하는지를 확인하는 클래스
    boolean itemExistInCart = false;

     //추가된 상품의 상품 ID를 취득
    Item pushedItem = pushedItemSet.getItem();
    int pushedItemId = pushedItem.getItemId().intValue();

    //바구니의 상품 수만을 loop
    for(Iterator it = this.itemList.iterator();it.hasNext();){

       //바구니 안의 상품의 상품 ID를 취득
      ItemSet cartItemSet = (ItemSet)it.next();
      Item cartItem = cartItemSet.getItem();
      int cartItemId = cartItem.getItemId().intValue();
      
      if(cartItemId == pushedItemId){
        //동일 ID의 상품이 바구니에 존재할 경우 수량만을 가산
        cartItemSet.addQuantity(pushedItemSet.getQuantity());
        //추가상품이 바구니 안에 이미 존재한다.
        itemExistInCart = true;
        break;
      }
    }
    
    if(!itemExistInCart){
      //바구니에 동일한 상품이 없으므로 추가
      this.itemList.add(pushedItemSet);
    }
  }

  public void clearAll() {
    this.itemList = new ArrayList();
  }
}


