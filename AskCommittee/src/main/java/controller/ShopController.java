package controller;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import form.ShopForm;

@EnableAutoConfiguration
@Controller
public class ShopController {

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopview(Model model) {
		return "shop";
	}

	@RequestMapping(value = {"/shopregister"}, method = {RequestMethod.GET})
	public String index(Model model) {
		model.addAttribute("shopForm", new ShopForm());
		return "shopregister";
	}
	
	// POST用のパラメータを受け取る
	@RequestMapping(value = {"/shopconfirm"}, method = {RequestMethod.POST})
	public String shopconfirm(@Validated @ModelAttribute("shopForm") ShopForm shopForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "shopregister";
            }
		
		return "shopconfirm";
	}
	
	@RequestMapping(value = {"/shopconfirm"}, method = {RequestMethod.GET})
	public String shopconfirm2(Model model) {
		return "shopconfirm";
	}

	@RequestMapping(value = "/shopcomple", method = RequestMethod.GET)
	public String comple(Model model) {
		return "shopcomple";
	}
	
	@RequestMapping(value = "/shopdelete", method = RequestMethod.GET)
	public String delete(Model model) {
		return "shopdelete";
	}
	
	@RequestMapping(value = "/shopdeleteconfirm", method = RequestMethod.GET)
	public String confirm(Model model) {
		return "shopdeleteconfirm";
	}
	
	@RequestMapping(value = "/shopdeletecomple", method = RequestMethod.GET)
	public String deletecomple(Model model) {
		return "shopdeletecomple";
	}
}


