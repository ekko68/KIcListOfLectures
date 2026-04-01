package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu2Controller {

	@RequestMapping("/menu2.do")
	public String process(){
		return "menu2"; //이동할페이지명->
		//<definition name="menu2"-->definition이름을 지정
	}
}
