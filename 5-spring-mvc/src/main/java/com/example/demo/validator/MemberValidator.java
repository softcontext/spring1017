package com.example.demo.validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.dto.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}
	
//	Member member, BindingResult result
//	valid.validate(member, result);

	@Override
	public void validate(
			Object target, // 사용자가 작성한 데이터를 보관하는 객체
			Errors errors) { // 데이터를 검증한 결과(에러정보)를 보관하는 객체
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(
//				errors, "name", "required.name", "이름이 필요합니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "address", "required.address", "주소가 필요합니다.");
		
//		Member member = (Member) target;
//		System.out.println("-----------------------");
//		System.out.println(member);
//		System.out.println("=======================");
	}

}
