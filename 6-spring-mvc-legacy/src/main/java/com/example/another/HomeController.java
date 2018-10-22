package com.example.another;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home.nhn")
	public String home() {
		return "main";
	}
}
