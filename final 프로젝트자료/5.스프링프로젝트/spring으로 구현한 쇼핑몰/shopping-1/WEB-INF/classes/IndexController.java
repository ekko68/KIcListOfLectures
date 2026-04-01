package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//자동으로 추가된 부분
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//추가
import logic.Shop;

public class IndexController implements Controller {

	private Shop shopService;
	public void setShopService(Shop shopService){
		this.shopService = shopService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//상품 리스트 정보 취득
		List itemList = this.shopService.getItemList();
		
		//모델작성
		Map model = new HashMap();
		model.put("itemList", itemList);
		
		//반환값이 되는 ModelAndView인스턴스 작성
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
