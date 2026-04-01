package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import web.form.ItemEditForm;
import web.form.ItemMenuForm;

public class ItemMenuAction extends MappingDispatchAction {

  private Shop shopService;

  public void setShopService(Shop shopService) {
    this.shopService = shopService;
  }

  public ActionForward findAll(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    //전체 상품의 정보 얻음
    ItemMenuForm itemMenuForm = (ItemMenuForm) form;
    List itemList = this.shopService.getItemList();
    itemMenuForm.setItemList(itemList);
    return mapping.findForward("success");
  }

  public ActionForward findByItemName(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    //상품명 검색에 의한 상품 리스트를 취득
    ItemMenuForm itemMenuForm = (ItemMenuForm) form;
    String searchItemName = itemMenuForm.getSearchItemName();
    
    if (searchItemName == null || searchItemName.equals("")) {
      //검색 상품명이 빈 경우, 전체 상품 정보를 반환한다
      List itemList = this.shopService.getItemList();
      itemMenuForm.setItemList(itemList);
      return mapping.findForward("success");
    }

    List itemList = this.shopService.getItemByItemName(searchItemName);
    if (itemList == null || itemList.isEmpty()) {
      //검색결과가 빈 경우도 전체 상품 정보를 반환한다
      itemList = this.shopService.getItemList();
      itemMenuForm.setItemList(itemList);
      return mapping.findForward("success");
    }
    
    itemMenuForm.setItemList(itemList);
    return mapping.findForward("success");
  }

  public ActionForward createEdit(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    //상품등록화면이동 시
    Item item = this.shopService.createNewItem();
    
    ItemEditForm itemEditForm = new ItemEditForm();
    itemEditForm.setItem(item);
    request.getSession().setAttribute("itemEditForm", itemEditForm);
    return mapping.findForward("success");
  }

  public ActionForward updateEdit(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    //상품편집화면이동 시
    ItemMenuForm itemMenuForm = (ItemMenuForm) form;
    Item item = this.shopService.getItemByItemId(itemMenuForm.getSelectItemId());
    
    ItemEditForm itemEditForm = new ItemEditForm();
    itemEditForm.setItem(item);
    request.getSession().setAttribute("itemEditForm", itemEditForm);
    return mapping.findForward("success");
  }

  public ActionForward deleteEdit(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    //상품삭제화면이동 시
    ItemMenuForm itemMenuForm = (ItemMenuForm) form;
    Item item = this.shopService.getItemByItemId(itemMenuForm.getSelectItemId());
    
    ItemEditForm itemEditForm = new ItemEditForm();
    itemEditForm.setItem(item);
    request.getSession().setAttribute("itemEditForm", itemEditForm);
    return mapping.findForward("success");
  }
}