package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String process(){
		return "index"; //이동할페이지명->
		//<definition name="index"-->definition이름을 지정
	}
}
