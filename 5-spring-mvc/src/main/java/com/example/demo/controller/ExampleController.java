package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.User;

@Controller
//@ResponseBody // 클래스 내에 모든 리턴값이 그대로 브라우저에게 전달됩니다.
public class ExampleController {

	// 설정 조건이 모두 만족하면 메소드가 기동합니다. (AND 연산)
	@RequestMapping(value = {"/example1", "/ex1"}, method = RequestMethod.GET, 
			consumes = { "text/plain", "application/*", "text/html" })
	@ResponseBody // 리턴값이 그대로 브라우저에게 전달됩니다.
	public String example1() {
		return "example1";
	}
	
	// URI만 일치하면 메소드가 기동합니다.
	@GetMapping("/example2")
	public String example2(
			HttpServletRequest req, Model model,
			HttpSession session, Locale locale) {
		
		req.setAttribute("value1", 100);
		// DS 에서 모델객체에 담긴 데이터를 HttpServletRequest로 옮겨 싫는다.
		model.addAttribute("value2", 200);
		
		// Session:
		// 브라우저가 접속하면 자동으로 SESSIONID를 쿠키로 발급한다.
		// 쿠키로 SESSIONID를 신고하면 발급하지 않고 그대로 사용한다.
		// 세션 객체는 사용할 때 만들어집니다. req.getSession() 할때 있으면 그대로 사용하고
		// 없으면 새로 만들어서 리턴합니다.
		System.out.println(session == req.getSession());
		System.out.println(locale.getCountry() + "," + locale.getLanguage());
		
		return "example2";
	}
	
	@PostMapping("/example3")
	public ModelAndView example3(
			Map<String, String> map,
			User user) {
		// HTML에서 name="id" 설정으로 사용되는 키 값 "id"과 일치하는
		// 멤버변수가 User 클래스안에 존재해야 자동으로 값이 주입됩니다.
		System.out.println(map);
		System.out.println(user);
		
		// 연동할 뷰와 전달할 데이터를 한 번에 취급하는 객체
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example3");
		mav.addObject("map", map);
		mav.addObject("user", user);
		
		return mav;
	}
	
	@GetMapping("/example4")
	@ResponseBody
	public String example4(
			HttpServletRequest req,
//			http://localhost:8080/example4?id=xx
			@RequestParam(required=true) String id,
//			http://localhost:8080/example4?id=xx&a=21
			@RequestParam(name="a", required=false, defaultValue="100") int age) {
		
		System.out.println(id);
		System.out.println(age);
		
		return req.getRequestURI();
	}
	
	@GetMapping("/example5/{id}/devices/{no}")
	@ResponseBody
	public String example5(
			@PathVariable String id,
			@PathVariable int no) {
		
		System.out.println(id);
		System.out.println(no);
		
		return id + "," + no;
	}
}
