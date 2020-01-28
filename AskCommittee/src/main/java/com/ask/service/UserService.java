package com.ask.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dto.UserRequest;
import com.ask.entity.LoginUser;
import com.ask.repository.UserRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	/**
	　* 新規登録
	 */
	public void create(UserRequest userRequest) {
		LoginUser user = new LoginUser();
		user.setId(userRequest.getId());	
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());		
		
		userRepository.save(user);	
	}
}
