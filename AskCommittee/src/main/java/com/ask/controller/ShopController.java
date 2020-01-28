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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ask.dto.ShopRequest;
import com.ask.service.ShopService;

@EnableAutoConfiguration
@Controller
@ComponentScan
@SessionAttributes({"shopRequest"})
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//お店トップ表示
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopview(Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from ask_shop");
		model.addAttribute("ask_shop", list);
		return "shop";
	}

	//登録画面表示
	@RequestMapping(value = { "/shopregister" }, method = RequestMethod.GET)
	public String shopregister(Model model) {
		model.addAttribute("shopRequest", new ShopRequest());
		return "shopregister";
	}

	//確認画面に値渡す
	@RequestMapping(value = { "/shopconfirm" }, method = RequestMethod.POST)
	public String shopconfirm(@Validated @ModelAttribute("shopRequest") ShopRequest shopRequest, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "shopregister";
            }
		
		return "shopconfirm";
	}
	
	@RequestMapping(value = {"/shopconfirm"}, method = {RequestMethod.GET})
	public String shopconfirm2(Model model) {
		return "shopconfirm";
	}
	
	//登録処理
		@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
		public String regist(@Validated @ModelAttribute("shopRequest") ShopRequest shopRequest, BindingResult result,
				Model model) {
			
			if (result.hasErrors()) {
				return "shopregister";
			}

			shopService.create(shopRequest);
			
			
			return "redirect:/shop";
		}

//	@RequestMapping(value = "/shopcomple", method = RequestMethod.GET)
//	public String comple(Model model) {
//		return "shopcomple";
//	}

	@RequestMapping(value = "/shopdelete", method = RequestMethod.GET)
	public String shopdelete(Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from ask_shop");
		model.addAttribute("ask_shop", list);
		
		model.addAttribute("shopRequest", new ShopRequest());
		return "shopdelete";
	}
	
	@RequestMapping(value = "/shopdeleteconfirm", method = RequestMethod.GET)
	public String confirm(Model model) {
		
		return "shopdeleteconfirm";
	}
	
	@RequestMapping(value = { "/shopdeleteconfirm" }, method = { RequestMethod.POST })
	public String shopdeleteconfirm(@Validated @ModelAttribute("shopRequest") ShopRequest shopRequest, Model model) {
		
	//削除ボタン押下でID取得
				
	//IDに紐づいた店名~備考を取得

		return "shopdeleteconfirm";
	}
	
	@RequestMapping(value = { "/delete" }, method = { RequestMethod.POST })
	public String delete(@Validated @ModelAttribute ShopRequest shopRequest, BindingResult result,
			Model model) {

		shopService.delete(shopRequest);
		
		return "redirect:/shop";
	}

//	@RequestMapping(value = "/shopdeletecomple", method = RequestMethod.GET)
//	public String deletecomple(Model model) {
//		return "shopdeletecomple";
//	}
}