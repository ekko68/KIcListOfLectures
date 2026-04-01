package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu1Controller {  //menu1.do
	@RequestMapping("/menu1.do")
	public String process() { //ModelAndView을 하지 않은 이유->tiles(이미 설정)
		return "menu1";
	}
}
