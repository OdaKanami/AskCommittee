package com.ask.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@EnableAutoConfiguration
@Controller
public class WithdrawController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/withdraw", method = RequestMethod.GET)
	private String withdrawview(){

		return "withdraw";
	}

	@RequestMapping(value="/withdrawconfirm", method = RequestMethod.GET)
	private String withdrawconfirmview(){
		return "withdrawconfirm";
	}

	@RequestMapping(value="/withdrawcomple", method = RequestMethod.GET)
	private String withdrawcompleview(){
		return "withdrawcomple";
	}	
}
