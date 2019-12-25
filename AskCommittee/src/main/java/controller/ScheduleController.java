package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class ScheduleController {

@RequestMapping(value="/schedule", method = RequestMethod.GET)
private String scheduleview(Model model){
return "schedule";
}

@RequestMapping(value="/schedule/register", method = RequestMethod.GET)
private String register(Model model){
return "scheduleregister";
}

@RequestMapping(value="/schedule/confirm", method = RequestMethod.GET)
private String confirm(Model model){
return "scheduleconfirm";
}

@RequestMapping(value="/schedule/comple", method = RequestMethod.GET)
private String comple(Model model){
return "schedulecomple";
}
}