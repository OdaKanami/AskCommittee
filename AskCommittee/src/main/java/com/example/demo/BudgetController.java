package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BudgetController {

@RequestMapping(value="/budget")
private String hello(){
return "/budget.html";
}
}