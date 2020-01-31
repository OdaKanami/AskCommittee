package com.ask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ask.dto.UserRequest;
import com.ask.entity.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{
	
	/**
	 * 新規登録
	 */
	public default void create(UserRequest userRequest) {
		this.save(CreateUser(userRequest));
	}

	/**
	 * entity
	 */
	public default LoginUser CreateUser(UserRequest userRequest) {

		LoginUser user = new LoginUser();
		user.setId(userRequest.getId());		
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());

		return user;
	}
}
