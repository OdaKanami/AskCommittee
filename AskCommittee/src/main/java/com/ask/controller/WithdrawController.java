package com.ask.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class WithdrawController {
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
