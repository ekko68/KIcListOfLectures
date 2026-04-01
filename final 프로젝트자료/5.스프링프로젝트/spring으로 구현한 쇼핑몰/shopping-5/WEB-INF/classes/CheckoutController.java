package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Cart;
import logic.Shop;
import logic.User;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

import utils.WebConstants;
import exception.CartEmptyException;
import exception.LoginRequiredException;

public class CheckoutController implements Controller{
	
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그인을 확인
		User loginUser = (User)WebUtils.getSessionAttribute(request, WebConstants.USER_KEY);
		if(loginUser == null){
			throw new LoginRequiredException("로그인하지 않았다.");
		}

		//바구니의 상태를 반환함
		Cart cart = (Cart)WebUtils.getSessionAttribute(request, WebConstants.CART_KEY);
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException("바구니가 비었다");
		}
		
		//유저 정보와 바구니 안의 상품정보를 설정
		ModelAndView modelAndView = new ModelAndView("checkout");
		modelAndView.addObject("loginUser", loginUser);
		List itemList = cart.getItemList();
		modelAndView.addObject("itemList", itemList);

		//합계 금액을 설정
		Integer totalAmount = this.shopService.calculateTotalAmount(itemList);
		modelAndView.addObject("totalAmount", totalAmount);
		
		return modelAndView;
	}
}