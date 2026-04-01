package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import web.form.ItemEditForm;

public class ItemEditAction extends MappingDispatchAction{

  private Shop shopService;
    
  public void setShopService(Shop shopService) {
    this.shopService = shopService;
  }

  public ActionForward createExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //惑前 殿废 贸府 
    ItemEditForm itemEditForm = (ItemEditForm)form;
    Item item = itemEditForm.getItem();
    this.shopService.entryItem(item);
    return mapping.findForward("success");
  }
  
  public ActionForward updateExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //惑前 祈笼 贸府
    ItemEditForm itemEditForm = (ItemEditForm)form;
    Item item = itemEditForm.getItem();
    this.shopService.updateItem(item);
    return mapping.findForward("success");
  }

  public ActionForward deleteExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //惑前 昏力 贸府
    ItemEditForm itemEditForm = (ItemEditForm)form;
    Item item = itemEditForm.getItem();
    this.shopService.deleteItem(item);
    return mapping.findForward("success");
  }
}