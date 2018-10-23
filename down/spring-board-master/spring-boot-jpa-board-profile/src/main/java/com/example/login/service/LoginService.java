package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.dto.Login;
import com.example.user.model.User;
import com.example.user.service.UserService;

@Service
public class LoginService {
	@Autowired
	private UserService userService;

	public void authenticate(Login login) {
		User user = userService.selectByEmail(login.getEmail());
		if (user == null) {
			login.setError("Email does not exist.");
		} else {
			if (!user.getPassword().equals(login.getPassword())) {
				login.setError("Password is not correct.");
			} else {
				login.setError(null);
			}
		}
	}
}
