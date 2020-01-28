package com.ask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.dto.UserRequest;
import com.ask.service.UserService;


@EnableAutoConfiguration
@Controller
public class RegisterController {
	
	@Autowired
    UserService userService;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	/**
	 * 会員情報入力画面
	*/
	@RequestMapping(value="/register", method = RequestMethod.GET)
	private String register(Model model){
		model.addAttribute("userRequest",new UserRequest());
		return "register";
	}
	
	/**
	 * 確認画面
	*/
	@RequestMapping(value="/registerconfirm", method = RequestMethod.POST)
	private String registerconfirm1(@ModelAttribute("userRequest") UserRequest userRequest, Model model){
		return "registerconfirm";
	}
	
	@RequestMapping(value="/registerconfirm", method = RequestMethod.GET)
	private String registerconfirm2(Model model){
		return "registerconfirm";
	}
	
	/**
	  * 登録完了
	 */
	@RequestMapping(value="/registercomple", method = RequestMethod.POST)
	private String registercomple(@ModelAttribute("userRequest") UserRequest userRequest, Model model){
		
		userService.create(userRequest);
		return "registercomple";
	}	
	
}
