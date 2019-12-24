package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import form.ShopForm;

@Controller
public class ShopController {

	@RequestMapping(value = "/shop")
	private String shopview() {
		return "/shop.html";
	}

	@RequestMapping(value = "/shop/register", method = { RequestMethod.POST, RequestMethod.GET})
	private String register() {
		return "/shopregister.html";
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

	@RequestMapping(value = "/shop/comple")
	private String comple() {
		return "/shopcomple.html";
	}
}
