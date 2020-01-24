package com.ask.controller;

import java.awt.AWTException;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.dto.BudgetRequest;

@EnableAutoConfiguration
@Controller
public class BudgetController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/budget", method = RequestMethod.GET)
	private String budgetview(Model model) {
		List<Map<String,Object>> contentList;
		contentList = jdbcTemplate.queryForList("select * from ask_budget_content");
		List<Map<String,Object>> detailList;
		detailList = jdbcTemplate.queryForList("select * from ask_budget_detail");
		int total = jdbcTemplate.queryForObject("select sum(amount) from ask_budget_detail", Integer.class);
		int balance = jdbcTemplate.queryForObject("SELECT bc.budget - SUM(bd.amount) AS calk\r\n" + 
				"FROM askdb.ask_budget_content bc ,askdb.ask_budget_detail bd\r\n" + 
				"WHERE bc.id = bd.detail_id", Integer.class);
		model.addAttribute("total", total);
		model.addAttribute("balance", balance);
		model.addAttribute("ask_budget_content", contentList);
		model.addAttribute("ask_budget_detail", detailList);		
		return "budget";
	}

	@RequestMapping(value = "/budgetchange", method = RequestMethod.GET)
	public String change(Model model) {
		List<Map<String,Object>> contentList;
		contentList = jdbcTemplate.queryForList("select * from ask_budget_content");
		List<Map<String,Object>> detailList;
		detailList = jdbcTemplate.queryForList("select * from ask_budget_detail");
		int total = jdbcTemplate.queryForObject("select sum(amount) from ask_budget_detail", Integer.class);
		int balance = jdbcTemplate.queryForObject("SELECT bc.budget - SUM(bd.amount) AS calk\r\n" + 
				"FROM askdb.ask_budget_content bc ,askdb.ask_budget_detail bd\r\n" + 
				"WHERE bc.id = bd.detail_id", Integer.class);
		model.addAttribute("total", total);
		model.addAttribute("balance", balance);
		model.addAttribute("ask_budget_content", contentList);
		model.addAttribute("ask_budget_detail", detailList);
		model.addAttribute("budgetRequest", new BudgetRequest());
		return "budgetchange";		
	}

	@RequestMapping(value = "/budgetconfirm", method = RequestMethod.POST)
	public String confirm(@ModelAttribute("budgetRequest") BudgetRequest budgetRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "budgetchange";
		}
		
		return "budgetconfirm";
	}
	
	@RequestMapping(value = "/budgetconfirm", method = RequestMethod.GET)
	public String budgetconfirm(Model model) {
		model.addAttribute("budgetRequest", new BudgetRequest());
		return "budgetconfirm";
	}

	@RequestMapping(value = "/budgetcomple", method = RequestMethod.GET)
	public String comple() {
		return "budgetcomple";
	}
}