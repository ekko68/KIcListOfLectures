package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Shop;
import logic.User;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

import utils.WebConstants;

public class LoginFormController extends SimpleFormController {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command,
			BindException bindException) throws Exception {

		//command의 cast
		User user = (User)command;
		try{
			//유저정보의 검색
			User loginUser = this.shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());

			//유저 확인시
			WebUtils.setSessionAttribute(request, WebConstants.USER_KEY, loginUser);
			ModelAndView modelAndView = new ModelAndView
				          (getSuccessView(), "loginUser", loginUser);
			return modelAndView;
		}catch(DataRetrievalFailureException e){
			//유저 미확인시
			bindException.reject("error.login");
			return showForm(request, response, bindException);
		}
	}
}