package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.User;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
		}
		return "home"; //home.jsp 반환
	}
	
}
