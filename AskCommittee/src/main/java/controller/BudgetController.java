package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class BudgetController {

@RequestMapping(value="/budget", method = RequestMethod.GET)
private String budgetview(){
return "budget";
}

@RequestMapping(value="/budget/change", method = RequestMethod.GET)
private String change(){
return "budgetchange";
}

@RequestMapping(value="/budget/confirm", method = RequestMethod.GET)
private String confirm(){
return "budgetconfirm";
}

@RequestMapping(value="/budget/comple", method = RequestMethod.GET)
private String comple(){
return "budgetcomple";
}
}