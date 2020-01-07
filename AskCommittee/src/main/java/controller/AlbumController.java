package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class AlbumController {

@RequestMapping(value="/album", method = RequestMethod.GET)
private String albumview(){
return "album";
}

@RequestMapping(value="/albumregister", method = RequestMethod.GET)
private String register(){
return "albumregister";
}
}