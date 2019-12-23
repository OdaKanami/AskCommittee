package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScheduleController {

@RequestMapping(value="/schedule")
private String schedule(){
return "/schedule.html";
}

@RequestMapping(value="/schedule/register")
private String register(){
return "/scheduleregister.html";
}

@RequestMapping(value="/schedule/confirm")
private String confirm(){
return "/scheduleconfirm.html";
}

@RequestMapping(value="/schedule/comple")
private String comple(){
return "/schedulecomple.html";
}
}