package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import form.ShopForm;

@EnableAutoConfiguration
@Controller
public class ShopController {

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopview(Model model) {
		return "shop";
	}

	@RequestMapping(value = {"/shop/register"}, method = {RequestMethod.GET})
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("shopregister");
		return mv;
	}
	
	// POST用のパラメータを受け取る
	@RequestMapping(value = {"/shop/confirm"}, method = {RequestMethod.POST})
	public ModelAndView postTest1(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="url", required = true) String url) {
		
		// 生成
		ModelAndView mv = new ModelAndView();
		
		// テンプレートを指定
		mv.setViewName("shopconfirm");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("name", name);
		mv.addObject("url", url);
		
		// 返却
		return mv;
	}
	
	// GET用のパラメータを受け取る
	@RequestMapping(value = {"/shop/confirm"}, method = {RequestMethod.GET})
	public ModelAndView getTest1(
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="url", required = true) String url) {
		
		// 生成
		ModelAndView mv = new ModelAndView();
		
		// テンプレートを指定
		mv.setViewName("shopconfirm");
		
		// modelに設定して画面に表示するようにする
		mv.addObject("name", name);
		mv.addObject("url", url);
		
		// 返却
		return mv;
	}

	@RequestMapping(value = "/shop/comple", method = RequestMethod.GET)
	public String comple(Model model) {
		return "shopcomple";
	}
}
