package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.Member;
import com.example.demo.validator.MemberValidator;

@Controller
// 모델어트리뷰 객체의 아이디를 설정하면
// 자동으로 세션객체의 백업하는 행동을 수행합니다.
@SessionAttributes("member")
public class ExampleController2 {
	// 자동으로 모든 뷰에게 전달됩니다.
	@ModelAttribute("member")
	public Member member() {
		return new Member("이름을 입력하세요", "주소를 입력하세요");
	}
	
	@RequestMapping("/step1")
	public String step1() {
		return "step1";
	}
	
	@RequestMapping("/step2")
	public String step2(@ModelAttribute Member member, HttpSession session) { // name
		System.out.println("step2: " + member);
		System.out.println(session.getAttribute("member"));
		// Member(name=tom, address=주소를 입력하세요)
		System.out.println(session.getAttribute("member") == member);
		// true
		return "step2";
	}
	
	@RequestMapping("/step3")
	public String step3(@ModelAttribute Member member, BindingResult result, 
			HttpSession session, SessionStatus sessionStatus, 
			RedirectAttributes redirectAttributes, Model model) { // address
		
		System.out.println("step3: " + member);
		System.out.println(session.getAttribute("member"));
		// Member(name=tom, address=seoul)
		System.out.println(session.getAttribute("member") == member);
		// true
		
		//유효성 검사: 에러가 있다면 bindingResult 객체에 결과가 담겨있다.
		MemberValidator valid = new MemberValidator();
		valid.validate(member, result);
		
		if (result.hasErrors()) {
			model.addAttribute("fail", "데이터가 부적합합니다.");
			return "step2";
		}
		
		// ************************************
		// 사용자로부터 받은 name, address 정보가 있는 
		// Member 객체를 DAO 에게 보내어 디비에 저장하는 코드를 
		// 여기에 배치합니다.
		// ************************************
		
		sessionStatus.setComplete();
//		System.out.println(session.getAttribute("member"));
		
		// 처리결과를 사용자에게 안내합니다.
		// 처리결과 데이터를 step4.jsp 에게 전달할 방법이 필요합니다.
		redirectAttributes.addFlashAttribute("result", "회원가입성공");
		
		// Post - Redirect - Get Pattern
		// https://en.wikipedia.org/wiki/Post/Redirect/Get
		return "redirect:step4";
	}
	
	@RequestMapping("/step4")
	public String step4() {
		return "step4";
	}
}
