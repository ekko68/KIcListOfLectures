package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {  //index.do

	@RequestMapping("/index.do")
	public String process() { //ModelAndView을 하지 않은 이유->tiles(이미 설정)
		//return "문자열(index)"--><definition name="index" 이름과 일치해야 찾아감
		return "index";//<definition name="index" template="/WEB-INF/tiles-view/template/layout.jsp">
	}
}
