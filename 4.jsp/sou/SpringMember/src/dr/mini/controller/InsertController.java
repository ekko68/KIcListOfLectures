package dr.mini.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dr.mini.dao.MemberDao;
import dr.mini.domain.MemberCommand;
import dr.mini.validator.MemberValidator;

//글쓰기(회원가입)->수정

@Controller
public class InsertController {

	//로그객체->매개변수값,객체값을 출력용도,에러메세지확용
	private Logger log=Logger.getLogger(this.getClass());
	
	//DB연동->멤버변수에 @Autowired부여->Setter Method작성no
	@Autowired
	private MemberDao memberDao;

	/*public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	
	//  /insert.do=insertForm.jsp(Get방식)
	//@RequestMapping("요청명령어")
	//@RequestMapping(value="요청명령어",
	//                          method="GET방식 or POST방식")
	
	@RequestMapping(value="/insert.do",
			                   method=RequestMethod.GET)
	public String form(){
		return "insertForm"; //return "이동할 페이지명"
		                             //확장자는 생략(.jsp)
	}
	
	//입력받은값을 초기화->다시 입력을 받을 수 있도록 처리
	/*@ModelAttribute
	 *public DTO자료형(MemberCommand) formBacking(){
	 *  return new DTO자료형();
	 *} 
	 * 
	 */
	@ModelAttribute
	public MemberCommand formBacking(){
		return new MemberCommand();
	}
	
	//  /insert.do=action.WriteProAction(Post방식)->전송클릭
	//반환값->ModelAndView->이동할 페이지에게 전달할값이 있을때
	//String->/list.do로 가라고 설정(문자열)
	//params="매개변수를 받은경우"
	@RequestMapping(value="insert.do",
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
			return form();//"insertForm"->insertForm.jsp이동
		}
		
		//정상적으로 입력을 했다면
		memberDao.insertMember(memberCommand);
		
		//글목록으로 이동-> /list.do->SelectList.jsp
		return "redirect:/list.do"; //SelectListController->~
	}
}
