package action;

import javax.servlet.http.*;


// 요청명령어에 따라서 처리해주는 모든 클래스의 공통 메서드
public interface CommandAction {
	// 이동할 페이지의 경로와 페이지명이 필요 -> 반환 => ModelAndView(스프링과 동일)
	public String requestPro(HttpServletRequest request,
									  HttpServletResponse response) 
									  throws Throwable;		

}
