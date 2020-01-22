package com.ask.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ask.dto.ShopRequest;
import com.ask.service.ShopService;

@EnableAutoConfiguration
@Controller
@ComponentScan
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopview(Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from ask_shop");
		model.addAttribute("ask_shop", list);
		return "shop";
	}

	@RequestMapping(value = { "/shopregister" }, method = { RequestMethod.GET })
	public String index(Model model) {
		model.addAttribute("shopRequest", new ShopRequest());
		return "shopregister";
	}

	@RequestMapping(value = { "/add" }, method = { RequestMethod.POST })
	public String create(@Validated @ModelAttribute ShopRequest shopRequest, BindingResult result,
			Model model) {

		shopService.create(shopRequest);
		
		
		return "redirect:/shop";
	}

//	@RequestMapping(value = { "/shopconfirm" }, method = { RequestMethod.GET })
//	public String shopconfirm2(Model model) {
//		return "shopconfirm";
//	}
//
//	@RequestMapping(value = "/shopcomple", method = RequestMethod.GET)
//	public String comple(Model model) {
//		return "shopcomple";
//	}
//
//	@RequestMapping(value = "/shopdelete", method = RequestMethod.GET)
//	public String delete(Model model) {
//		List<Map<String,Object>> list;
//		list = jdbcTemplate.queryForList("select * from ask_shop");
//		model.addAttribute("ask_shop", list);
//		return "shopdelete";
//	}
//	
//	@RequestMapping(value = "/shopdelete", method = RequestMethod.POST)
//	public String deleteselect(@Validated @ModelAttribute("shopModel") ShopModel shopModel, BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			return "shopdelete";
//		}
//		
//		
//		return "redirect:/shopdeleteconfirm";
//	}
//
//	@RequestMapping(value = "/shopdeleteconfirm", method = RequestMethod.GET)
//	public String confirm(Model model) {
//		return "shopdeleteconfirm";
//	}
//	
//	@RequestMapping(value = { "/shopdeleteconfirm" }, method = { RequestMethod.POST })
//	public String shopdeleteconfirm(@Validated @ModelAttribute("shopModel") ShopModel shopModel, BindingResult result,
//			Model model) {
//
//		if (result.hasErrors()) {
//			return "shopdelete";
//		}
//
//		return "shopdeleteconfirm";
//	}
//
//	@RequestMapping(value = "/shopdeletecomple", method = RequestMethod.GET)
//	public String deletecomple(Model model) {
//		return "shopdeletecomple";
//	}
}