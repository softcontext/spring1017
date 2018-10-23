package com.example.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
//	"INSERT INTO user(email, password) VALUES(#{email}, #{password})"
	@Override
	public int insert(User user) {
		user = userRepository.save(user);
		return 1;
	}

//	"UPDATE user SET password = #{password} WHERE email = #{email}"
	@Override
	public int update(User user) {
		user = userRepository.save(user);
		return 1;
	}

//	"DELETE FROM user WHERE email = #{email}"
	@Override
	public int delete(String email) {
		User user = userRepository.findByEmail(email);
		userRepository.delete(user);
		return 1;
	}

//	"SELECT COUNT(*) FROM user"
	@Override
	public long count() {
		return userRepository.count();
	}

//	"SELECT * FROM user ORDER BY email ASC"
	@Override
	public List<User> selectAll() {
		return userRepository.findAll();
	}

//	"SELECT * FROM user WHERE email = #{email}"
	@Override
	public User selectByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
