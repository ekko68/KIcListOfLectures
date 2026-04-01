package com.apik.person.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;


@Controller
public class PersonController {
	

	// 1) Log객체 생성
	//private Logger log=Logger.getLogger(ListController.class);
	private Logger log=Logger.getLogger(this.getClass());
	
	
	// Autowired 인젝트 :  Setter, Getter 호출 안함->소스코드를 줄임
	@Autowired // 자동으로 객체를 구해와 불러옴
	private PersonDAO personDao;
	
	
	// 회원등록 페이지로 이동
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "member/member"; // return "이동할 페이지명"; 확장자 생략
	}
	
	// 입력받은값을 초기화->다시 입력을 받을 수 있도록 처리
		@ModelAttribute
		public PersonCommand formBacking() {
			return new PersonCommand();
		}

		// 1) /insert.do = action.WriteProAction(post) 전송클릭
		// 2) 반환값 ModelAndView : 이동할 페이지에게 전달할 값이 있을 경우
		// 3) String -> intro.do로 이동 서렂ㅇ
		// 4) params = "매개변수를 받은 경우"

		// 데이터 입력->유효성검사->에러발생체크->DB저장->intro.jsp로 이동
		@RequestMapping(value="/join.do", method=RequestMethod.POST)
		// 입력받은 값, 유효성검서 결과값
		public String submit(@Valid PersonCommand personCommand, 
										BindingResult result) {
			
			// 로그객체로 출력
			if (log.isDebugEnabled()) {
				log.debug("personCommand=" + personCommand);
			}
			
			
			// 에러가 발생하여 처음부터 다시 입력
			if (result.hasErrors()) {
				return join();// .jsp이동
			}

			if (result.hasErrors()) {
				log.debug("Binding Result has error!");
				List<ObjectError> errors = result.getAllErrors();
				for (ObjectError error : errors) {
					log.debug(error.getDefaultMessage());
				}
				return join();
			}


			
			
			//정상적으로 입력한 경우
			personDao.insertperson(personCommand);
			
			System.out.println("personCommand : " +personCommand);
			
			//페이지 이동
			return "redirect:/index.do";
		}
		
		

		// 중복아이디 검사
		 @ResponseBody
		    @RequestMapping(value = "/join/checked.do", method = RequestMethod.POST)
		    public String checkID(HttpServletRequest request, Model model) {
		        String id = request.getParameter("id");
		        System.out.println("입력된 id : "+id);
		        int rowcount = personDao.checkId(id);	  
		        System.out.println("rowcount : "+rowcount);
		        return String.valueOf(rowcount);
		    }

		
	
	
	

}
