package web.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class ItemMenuForm extends ActionForm {

  private List itemList;

  private String searchItemName;

  private Integer selectItemId;

  public List getItemList() {
    return this.itemList;
  }

  public void setItemList(List itemList) {
    this.itemList = itemList;
  }

  public String getSearchItemName() {
    return this.searchItemName;
  }

  public void setSearchItemName(String searchItemName) {	
    this.searchItemName = searchItemName;
  }

  public Integer getSelectItemId() {
    return this.selectItemId;
  }

  public void setSelectItemId(Integer selectItemId) {
    this.selectItemId = selectItemId;
  }
}