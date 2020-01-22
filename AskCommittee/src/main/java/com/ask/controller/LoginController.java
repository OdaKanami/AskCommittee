/*
package com.ask.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.form.LoginForm;
import com.ask.form.ShopForm;

@EnableAutoConfiguration
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginview(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@RequestMapping(value = "/logout")
	private String logout(Model model) {
		return "/logout.html";
	}
}
*/