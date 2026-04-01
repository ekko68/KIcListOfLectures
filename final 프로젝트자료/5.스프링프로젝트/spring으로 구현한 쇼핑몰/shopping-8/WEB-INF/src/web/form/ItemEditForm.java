package web.form;

import logic.Item;
import org.apache.struts.validator.ValidatorForm;

public class ItemEditForm extends ValidatorForm {

  private Item item;

  public Item getItem() {
    return this.item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}
