package dr.mini.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dr.mini.domain.MemberCommand;
//유효성검사->어느 특정한값을 입력을 받을때 유효한값(올바른값)
//을 입력받았는지 체크해주는 검사->Validater인터페이스 상속

public class MemberValidator implements Validator {

	//1.유효성검사를 할것인지 말것인지를 결정해주는 메서드작성
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//형식)return 유효성검사를 할클래스명(DTO).class.
		//                    isAssignableFrom(매개변수명)
		return MemberCommand.class.isAssignableFrom(clazz);
	}

	//유효성검사를 할때 호출되는 메서드
	//1.Object target->target객체에 대한 검증을 실행하겠다.
	//2.errors객체->어떤문제가 발생됐는지에 대한 에러정보를 담을객체
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
      //유효성검사 규칙->공백이 있는지 체크
		//1.에러객체명 2.적용키(웹상의 적용부분),3적용코드값(저장된값)
	   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "error.required");
	   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "error.required");
	   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.required");
	}
}


