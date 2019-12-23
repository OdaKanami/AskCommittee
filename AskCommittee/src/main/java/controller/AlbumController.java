package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

@RequestMapping(value="/album")
private String hello(){
return "/album.html";
}
}