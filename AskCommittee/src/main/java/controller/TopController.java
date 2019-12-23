package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

@RequestMapping(value="/top")
private String hello(){
return "/top.html";
}
}