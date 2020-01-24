package com.ask.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class WithdrawController {
	@RequestMapping("/withdraw")
	private String withdrawview(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		model.addAttribute("userName", userName);
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
