package com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.Board;
import com.board.service.BoardService;
import com.user.User;

@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			model.addAttribute("userId", user.getUserId());
			model.addAttribute("userName", user.getUserName());
		}
		
		List<Board> boardList = boardService.getBoardTitleList(0);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageNum", 1);
		model.addAttribute("startNum", 1);
		
		return "home"; //home.jsp 반환
	}
}
