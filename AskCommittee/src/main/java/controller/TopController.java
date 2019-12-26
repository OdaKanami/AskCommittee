package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Ask_member;
import entity.Ask_memberRepository;

@AutoConfigureOrder
@Controller
public class TopController {
	//@Autowired
	private Ask_memberRepository memberRepository;
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String topview(Model model) {
		List<Ask_member> memberlist = memberRepository.findAll();
		model.addAttribute("memberlist", memberlist);
		
		return "top";
	}
}