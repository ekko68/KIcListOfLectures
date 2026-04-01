package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;

import utils.WebConstants;

public class CartController extends MultiActionController{

	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	public ModelAndView add(HttpServletRequest request, 
		               HttpServletResponse resopnse) throws Exception {

		//추가 상품 정보를 취득
		Integer itemId = RequestUtils.getIntParameter(request, "itemId");
		Item selectedItem = this.shopService.getItemByItemId(itemId);
		//추가 상품 개수를 취득
		Integer quantity = RequestUtils.getIntParameter(request, "quantity");

		//바구니를 취득
		Cart cart = (Cart)WebUtils.getSessionAttribute(request, WebConstants.CART_KEY);
		if(cart == null){
			cart = this.shopService.getCart();
			WebUtils.setSessionAttribute(request, WebConstants.CART_KEY, cart);
		}

		//바구니에 상품을 추가
		cart.push(new ItemSet(selectedItem, quantity));

		//바구니 정보와 메시지를 설정
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("message", selectedItem.getItemName() + "을" + quantity + "개, 바구니에 추가했다.");
		modelAndView.addObject("cart", cart);

		//로그인 유저를 취득
		User loginUser = (User)WebUtils.getSessionAttribute(request, WebConstants.USER_KEY);
		if(loginUser != null){
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}

	public ModelAndView clear(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//바구니를 취득
		Cart cart = (Cart)WebUtils.getSessionAttribute(request, WebConstants.CART_KEY);
		if(cart == null){
			cart = this.shopService.getCart();
			WebUtils.setSessionAttribute(request, WebConstants.CART_KEY, cart);
		}
		
		//바구니를 clear
		cart.clearAll();

		//메시지를 설정
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("message", "바구니를 비웠다.");

		//로그인 유저를 취득
		User loginUser = (User)WebUtils.getSessionAttribute(request, WebConstants.USER_KEY);
		if(loginUser != null){
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
	
	public ModelAndView confirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//바구니를 취득
		Cart cart = (Cart)WebUtils.getSessionAttribute(request, WebConstants.CART_KEY);
		if(cart == null){
			cart = this.shopService.getCart();
			WebUtils.setSessionAttribute(request, WebConstants.CART_KEY, cart);
		}
		
		//바구니 정보를 설정
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("cart", cart);

		//로그인 유저를 취득
		User loginUser = (User)WebUtils.getSessionAttribute(request, WebConstants.USER_KEY);
		if(loginUser != null){
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
}