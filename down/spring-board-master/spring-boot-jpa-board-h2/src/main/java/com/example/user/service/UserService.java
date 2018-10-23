package com.example.user.service;

import java.util.List;

import com.example.user.model.User;

public interface UserService {
	public int insert(User user);
	public int update(User user);
	public int delete(String email);
	
	public long count();
	public List<User> selectAll();
	public User selectByEmail(String email);
}
