package web.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

public class ItemMenuForm extends ActionForm{

  private List itemList;

  public List getItemList() {
    return this.itemList;
  }

  public void setItemList(List itemList) {
    this.itemList = itemList;
  }
}
