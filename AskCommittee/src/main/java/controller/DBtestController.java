package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DBtestController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/dbtest")
	public String index(Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from ask_member where id = '2019000'");
		model.addAttribute("ask_member", list);
		return "dbtest";
	}
}