package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

@RequestMapping(value="/shop")
private String shopview(){
return "/shop.html";
}

@RequestMapping(value="/shop/register")
private String register(){
return "/shopRegister.html";
}

@RequestMapping(value="/shop/confirm")
private String confirm(){
return "/shopConfirm.html";
}

@RequestMapping(value="/shop/comple")
private String comple(){
return "/shopComple.html";
}
}
