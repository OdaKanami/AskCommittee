package com.ask.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class RegisterController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	private String registerview(){
		return "register";
	}
	
	@RequestMapping(value="/registerconfirm", method = RequestMethod.GET)
	private String registerconfirmview(){
		return "registerconfirm";
	}
	
	@RequestMapping(value="/registercomple", method = RequestMethod.GET)
	private String registercompleview(){
		return "registercomple";
	}
	
	
	
}
