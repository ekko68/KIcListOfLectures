package dr.mini.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dr.mini.dao.MemberDao;
import dr.mini.domain.MemberCommand;
import dr.mini.validator.MemberValidator;

//수정

@Controller
public class UpdateController {

	//로그객체->매개변수값,객체값을 출력용도,에러메세지확용
	private Logger log=Logger.getLogger(this.getClass());
	
	//DB연동->멤버변수에 @Autowired부여->Setter Method작성no
	@Autowired
	private MemberDao memberDao;
	
	//수정폼으로 이동
	@RequestMapping(value="/update.do",
			                   method=RequestMethod.GET)
	public ModelAndView form
	                               (@RequestParam("id") String id){
		MemberCommand memberCommand=
				                 memberDao.getMember(id);
		return new ModelAndView
		("updateForm","memberCommand",memberCommand);
	}
	
	@RequestMapping(value="/update.do",
			                  method=RequestMethod.POST)
	//validate()를 호출하기위해서->BindingResult의 객체필요
	//(1.입력받은값 2.유효성검사할 결과값)
	public String submit
	  (MemberCommand memberCommand,
			                                     BindingResult result ){
	    //로그객체로 출력
		if(log.isDebugEnabled()){
			log.debug("memberCommand="+memberCommand);
		}
		//유효성 검사를 실행
		new MemberValidator().validate
		                                  (memberCommand, result );
		//에러가 발생이 되었다면->처음부터 다시 입력하라
		//history.back() 대용
		if(result.hasErrors()){
			return "updateForm";//비밀번호가 틀리면 다시 수정폼
		}
		
		//정상적으로 수정을 했다면
		memberDao.updateMember(memberCommand);
		
		//글목록으로 이동-> /list.do->SelectList.jsp
		return "redirect:/list.do"; //SelectListController->~
	}
}
