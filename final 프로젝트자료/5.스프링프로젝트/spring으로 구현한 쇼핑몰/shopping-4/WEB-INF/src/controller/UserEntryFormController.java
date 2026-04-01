package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Shop;
import logic.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

import utils.WebConstants;

public class UserEntryFormController extends SimpleFormController{
	
	private Shop shopService;
	
	public Shop getShopService() {
		return this.shopService;
	}

	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	protected Object formBackingObject(HttpServletRequest request) 
		               throws Exception {
		//메시지소스로부터 초기표시데이터 취득
		MessageSourceAccessor accessor = getMessageSourceAccessor();
		User user = new User();
		user.setUserId(accessor.getMessage("user.userId.default"));
		user.setUserName(accessor.getMessage("user.userName.default"));
		return user;
	}

	protected void initBinder(HttpServletRequest request,
		               ServletRequestDataBinder binder) throws Exception {
		//Date형의 bithDay프로퍼티를 커스터마이즈
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birthDay",
			          new CustomDateEditor(dateFormat, false));
	}
	
	protected Map referenceData(HttpServletRequest request) 
		                    throws Exception {
		//콤보박스데이터를 작성
		Map model = new HashMap();
		String[] jobs = new String[]
			{"변호사", "의사", "교수", "주부", "학생", "the others"};
		model.put("jobs", jobs);
		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command,
		                      BindException bindException)
			throws Exception {
		
		//Command의 cast
		User user = (User)command;
		try{
			this.shopService.entryUser(user);
			//회원 가입 완료시, 셋션에 회원 정보를 보유
			WebUtils.setSessionAttribute(request, WebConstants.USER_KEY, user);
			ModelAndView modelAndView = new ModelAndView(getSuccessView()); 
			modelAndView.addObject(getCommandName(), user);
			return modelAndView;
		
		}catch(DataIntegrityViolationException e){
			//회원 ID의 중복 시, 폼 송신원으로 이동
			bindException.reject("error.duplicate");
			return showForm(request, response, bindException);
		}
	}
}