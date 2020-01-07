package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class BudgetController {

@RequestMapping(value="/budget", method = RequestMethod.GET)
private String budgetview(){
return "budget";
}

@RequestMapping(value="/budgetchange", method = RequestMethod.GET)
private String change(Model model){
return "budgetchange";
}

@RequestMapping(value="/budgetconfirm", method = RequestMethod.GET)
private String confirm(){
return "budgetconfirm";
}

@RequestMapping(value="/budgetcomple", method = RequestMethod.GET)
private String comple(){
return "budgetcomple";
}
}