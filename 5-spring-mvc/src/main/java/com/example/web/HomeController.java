package com.example.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	@ResponseBody // 리턴값을 바로 브라우저에게 전달합니다.
	public String home() {
		return "I am HomeController!";
	}
	
	@RequestMapping("/a")
	public String a(HttpServletRequest req) {
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		return "a";
	}
}
