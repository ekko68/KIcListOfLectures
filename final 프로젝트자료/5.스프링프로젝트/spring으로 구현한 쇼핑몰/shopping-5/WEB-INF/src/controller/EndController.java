package controller;

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

public class EndController implements Controller{
	
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

		//바구니의 상태를 확인
		Cart cart = (Cart)WebUtils.getSessionAttribute(request, WebConstants.CART_KEY);
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException("바구니가 비었다");
		}
		
		//매출 데이터 기록
		this.shopService.checkout(loginUser, cart);

		//바구니 정보 삭제
		WebUtils.setSessionAttribute(request, WebConstants.CART_KEY, null);
		ModelAndView modelAndView = new ModelAndView("end");
		modelAndView.addObject("loginUser", loginUser);
		return modelAndView;
	}
}