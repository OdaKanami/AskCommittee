package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

@RequestMapping(value="/login")
private String hello(){
return "/login.html";
}
}