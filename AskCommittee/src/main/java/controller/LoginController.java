package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

@RequestMapping(value="/login")
private String login(){
return "/login.html";
}

@RequestMapping(value="/logout")
private String logout(){
return "/logout.html";
}
}