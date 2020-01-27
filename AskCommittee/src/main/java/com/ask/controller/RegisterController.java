package com.ask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ask.entity.LoginUser;

@EnableAutoConfiguration
@Controller
public class RegisterController {
	
	@Autowired
    private JdbcUserDetailsManager userManager;
	
	/*
	 * 会員情報入力画面
	*/
	@RequestMapping(value="/register", method = RequestMethod.GET)
	private String registerview(){
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@RequestParam("id") String id,
			               @RequestParam("password") String name,
			               @RequestParam("email") String email,
						   @RequestParam("password") String password) {
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//       userManager.createUser(users.username(id).password(password).email(email).roles("USER").build());
		
        return"";
		
	}	
	
	
	
	
	
	
	//確認画面
	@RequestMapping(value="/registerconfirm", method = RequestMethod.GET)
	private String registerconfirmview(){
		LoginUser entity = new LoginUser();
		
//		entity.setId(id);
		
		return "registerconfirm";
	}
	

	
	@RequestMapping(value="/registercomple", method = RequestMethod.GET)
	private String registercompleview(){
		return "registercomple";
	}
	
	
	
}
