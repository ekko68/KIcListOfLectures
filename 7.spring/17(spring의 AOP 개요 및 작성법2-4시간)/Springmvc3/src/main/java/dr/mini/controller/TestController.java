package dr.mini.controller;

import java.util.Calendar;//시간

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// /hello.do->TestController->출력문자열을 출력

@Controller
public class TestController {  //POJO클래스=>상속X ->단독으로 독립적으로 사용
	                                         //클래스->메서드명,매개변수를 변화줄 수있다.
	@RequestMapping("/hello.do")
	public ModelAndView hello() { //접근 가능->public
		System.out.println("TestController 호출");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello"); //hello파일
		mav.addObject("greeting",getGreeting());
		return mav;
	}
	//시간에 따라서 출력메세지를 다르게 설정
	private String getGreeting() { //내부에서만 사용하도록=>private
		System.out.println("greeting에서 호출");
		int hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//현재시간이 6~10
		if(hour >=6 && hour <=10) {
			return "좋은 아침입니다.";
		}else if(hour >=12 && hour <=15) {
			return "점심 식사는 하셨나요?";
		}else if(hour >=18 && hour <=22) {
			return "좋은 밤 되세요";
		}
		return "주말 잘 보내세요~~";
	}
}






