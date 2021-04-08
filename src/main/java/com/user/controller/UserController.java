package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.Session;
import com.user.User;
import com.user.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@RequestMapping("/join")
	public String join(Model model) {
		
		return "join";
	}
	
	@RequestMapping(value="/userJoin", method=RequestMethod.POST)
	public String userJoin(Model model, HttpServletRequest request) {

		User user = new User();
		int result;
		user.setUserInfo(request.getParameter("userName"), 
				request.getParameter("userId"), 
				request.getParameter("userPassword"));
		
		result = service.userRegister(user);
		if(result==0) {
			System.out.println("가입 실패");
			return "home";
		}
		
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("userName", user.getUserName());
		
		return "userJoinOK";
	}
	
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	public String userLogin(Model model, HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPassword");
		
		User user = service.userSearch(userId, userPw);
		if(user==null) {
			System.out.println("로그인 실패");
			return "home";
		}
		
		try {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//세션 유지
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(600);
		
		return "userLoginOK";
	}
	
	@RequestMapping(value="/userLogout", method=RequestMethod.GET)
	public String userLogout(Model model, HttpServletRequest request) {

		//세션 종료
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "home";
	}
}
