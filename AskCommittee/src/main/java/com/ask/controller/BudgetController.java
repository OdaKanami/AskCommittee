package com.ask.controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.ask.form.BudgetForm;

@EnableAutoConfiguration
@Controller
public class BudgetController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	@RequestMapping(value = "/budget", method = RequestMethod.GET)
//	private String budgetview(Model model) {
//		List<Map<String,Object>> contentList;
//		contentList = jdbcTemplate.queryForList("select * from ask_budget_content");
//		List<Map<String,Object>> detailList;
//		detailList = jdbcTemplate.queryForList("select * from ask_budget_detail");
//		int total = jdbcTemplate.queryForObject("select sum(amount) from ask_budget_detail", Integer.class);
//		int balance = jdbcTemplate.queryForObject("SELECT bc.budget - SUM(bd.amount) AS calk\r\n" + 
//				"FROM askdb.ask_budget_content bc ,askdb.ask_budget_detail bd\r\n" + 
//				"WHERE bc.id = bd.detail_id", Integer.class);
//		model.addAttribute("total", total);
//		model.addAttribute("balance", balance);
//		model.addAttribute("ask_budget_content", contentList);
//		model.addAttribute("ask_budget_detail", detailList);
//		return "budget";
//	}
	
	@RequestMapping(value = "/budget", method = {RequestMethod.POST, RequestMethod.GET})
	private String capture(Model model) {
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
		
		System.setProperty("java.awt.headless", "false");
		
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyyMMdd_HHmm");
		
		try {
			// キャプチャの範囲
			Rectangle bounds = new Rectangle(0, 0, 1280, 800);

			// これで画面キャプチャ
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(bounds);

			// 以下、出力処理
			String dirName = "G:\\Project\\AskCommittee\\AskCommittee\\AskCommittee\\src\\main\\resources\\static\\img";
			String fileName = "test_" + format.format(new Date()) + ".jpg";
			ImageIO.write(image, "jpg", new File(dirName, fileName));

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		model.addAttribute("budgetForm", new BudgetForm());
		return "budgetchange";
	}

	@RequestMapping(value = "/budgetconfirm", method = RequestMethod.POST)
	public String confirm(@ModelAttribute("budgetForm") BudgetForm budgetForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "budgetchange";
		}
		
		return "budgetconfirm";
	}

	@RequestMapping(value = "/budgetconfirm", method = RequestMethod.GET)
	public String budgetconfirm(Model model) {
		model.addAttribute("budgetForm", new BudgetForm());
		return "budgetconfirm";
	}

	@RequestMapping(value = "/budgetcomple", method = RequestMethod.GET)
	public String comple() {
		return "budgetcomple";
	}
}