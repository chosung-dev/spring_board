package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return "home"; //home.jsp 반환
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
}
