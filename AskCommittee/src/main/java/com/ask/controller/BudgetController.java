package com.ask.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.form.BudgetForm;
import com.ask.form.ShopForm;

@EnableAutoConfiguration
@Controller
public class BudgetController {

	@RequestMapping(value = "/budget", method = RequestMethod.GET)
	private String budgetview(Model model) {
		return "budget";
	}

	@RequestMapping(value = "/budgetchange", method = RequestMethod.GET)
	public String change(Model model) {
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
