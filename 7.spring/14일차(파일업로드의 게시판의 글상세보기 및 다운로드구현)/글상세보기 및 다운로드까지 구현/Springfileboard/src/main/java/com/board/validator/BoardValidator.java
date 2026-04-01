package com.board.validator;

import org.springframework.validation.*;

import com.board.domain.BoardCommand;

public class BoardValidator implements Validator {

	//1.유효성 검사를 할 클래스명을 지정해주는다.
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BoardCommand.class.isAssignableFrom(clazz);
	}
	//WriteController에서 호출한다.
	//유효성 검사(1.입력받을 대상자(DTO객체(=커맨드객체) 2.에러정보를 담을객체명)
	//1.required.pwd=암호는 필수입력입니다
	//1.required.command.pwd->required.pwd->required.java.lang.String
	//required순으로 찾는다.
	public void validate(Object target, Errors errors) {//필수 입력체크
		// TODO Auto-generated method stub
		//입력하지 않았거나 공백을 체크해주는 메서드->에러정보를 저장(에러객체)
		//1.에러객체명 2.적용시킬 필드명 3.적용시킬 에러코드명
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}
}









