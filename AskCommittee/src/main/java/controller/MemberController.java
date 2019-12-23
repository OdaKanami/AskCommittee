package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

@RequestMapping(value="/member")
private String memberview(){
return "/member.html";
}
}