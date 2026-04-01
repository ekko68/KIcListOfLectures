package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Shop;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//상품 리스트 정보를 취득
		List itemList = this.shopService.getItemList();
		
		//모델 작성
		Map model = new HashMap();
		model.put("itemList", itemList);
		
		//반환값이 되는ModelAndView인스턴스를 생성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}