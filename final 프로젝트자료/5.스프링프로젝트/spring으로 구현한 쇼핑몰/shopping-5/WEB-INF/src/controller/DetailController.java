package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;
import logic.User;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.util.WebUtils;

import utils.WebConstants;

public class DetailController extends AbstractController{

	private Shop shopService;
	
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//선택된 상품ID를 취득
		Integer itemId = RequestUtils.getIntParameter(request, "itemId");

		//선택된 상품ID로부터 상품정보를 취득
		Item item = this.shopService.getItemByItemId(itemId);
		
		//모델 작성
		Map model = new HashMap();
		model.put("item", item);

		//반환값이 되는 ModelAndView인스턴스를 작성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addAllObjects(model);

		//로그인한 사용자의 정보 얻기
		User loginUser = (User)WebUtils.getSessionAttribute(request, WebConstants.USER_KEY);
		if(loginUser != null){
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
}