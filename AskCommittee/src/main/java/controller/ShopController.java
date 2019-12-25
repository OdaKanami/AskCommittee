package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import form.ShopForm;

@EnableAutoConfiguration
@Controller
public class ShopController {

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopview(Model model) {
		return "shop";
	}

	@RequestMapping(value = "/shop/register", method = { RequestMethod.POST, RequestMethod.GET})
	public String register(Model model) {
		return "shopregister";
	}

	@RequestMapping(value = "/shop/confirm", method = { RequestMethod.POST, RequestMethod.GET})
	public ModelAndView confirm(ModelAndView mav, ShopForm ShopForm) {
		ShopForm.setName("name");
		ShopForm.setUrl("url");
		ShopForm.setPhoneNumber("phoneNumber");
		ShopForm.setRemark("remark");
		mav.addObject("ShopForm", ShopForm);
		mav.setViewName("/shop/comple");
		return mav;
	}

	@RequestMapping(value = "/shop/comple", method = RequestMethod.GET)
	public String comple(Model model) {
		return "shopcomple";
	}
}
