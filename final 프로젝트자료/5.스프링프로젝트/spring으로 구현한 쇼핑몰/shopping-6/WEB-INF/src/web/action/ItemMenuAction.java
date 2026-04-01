package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Shop;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.struts.ActionSupport;

import web.form.ItemMenuForm;

public class ItemMenuAction extends ActionSupport{

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    ItemMenuForm itemMenuForm = (ItemMenuForm)form;
   
    //ApplicationContext취득
    ApplicationContext applicationContext = getWebApplicationContext();
    Shop shopService = (Shop)applicationContext.getBean("shopService");
    
    //상품리스트 정보의 취득
    List itemList =  shopService.getItemList();
    itemMenuForm.setItemList(itemList);
    
    return mapping.findForward("success");
  }
}