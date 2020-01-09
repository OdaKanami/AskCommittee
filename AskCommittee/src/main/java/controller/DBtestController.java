package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Ask_member;
import entity.Ask_memberRepository;

@RestController
public class DBtestController {
	//@Autowired 自動でbeanを生成してくれるアノテーションなのだが、こいつのせいでプロジェクト自体起動しなくなってしまう
	private Ask_memberRepository memRepository;
	
	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public String dbtest(Model model) {
		List<Ask_member> memlist = memRepository.findAll();
		model.addAttribute("memlist", memlist);
		return "dbtest";
	}
}