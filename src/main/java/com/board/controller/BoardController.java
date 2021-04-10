package com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.service.BoardService;
import com.user.User;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/page/{pageNum}")
	public String homeBoard(Model model, @PathVariable int pageNum, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
		}
		if(pageNum==0) {
			pageNum = 1;
		}
		List<String> boardList = boardService.getBoardTitleList(pageNum-1);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageNum", pageNum);
		int startNum = (pageNum-1)/5;
		startNum = startNum*5+1;
		model.addAttribute("startNum", startNum);
		
		return "home";
	}
	
	@RequestMapping("/board/create")
	public String createBoard(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
		} else {
			return homeBoard(model, 0, request);
		}
		
		return "createBoard";
	}
	
	@RequestMapping("/board/save")
	public String boardSave(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return homeBoard(model, 0, request);
		}
		
		boardService.insertBoard(request.getParameter("title"), request.getParameter("content"), user);
		

		return homeBoard(model, 0, request);
	}

}
