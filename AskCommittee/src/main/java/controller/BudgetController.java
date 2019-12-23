package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetController {

@RequestMapping(value="/budget")
private String budget(){
return "/budget.html";
}

@RequestMapping(value="/budget/change")
private String change(){
return "/budgetchange.html";
}

@RequestMapping(value="/budget/confirm")
private String confirm(){
return "/budgetconfirm.html";
}

@RequestMapping(value="/budget/comple")
private String comple(){
return "/budgetcomple.html";
}
}