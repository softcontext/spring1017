package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private List<User> emps = new ArrayList<>();
	{
		emps.add(new User("Tom", "123"));
		emps.add(new User("David", "123"));
		emps.add(new User("Iaan", "123"));
	}

	@GetMapping
	public Object getEmps() {
		return emps;
	}
	
	@PostMapping
	public Object postEmp(@RequestBody User user) {
		emps.add(user);
		return user;
	}
}
