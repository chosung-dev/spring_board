package com.board.service;

import java.util.LinkedList;
import java.util.List;

import com.board.dao.BoardDao;
import com.user.User;

public class BoardService {
	BoardDao dao;
	
	public BoardService(BoardDao dao) {
		this.dao = dao;
	}
	
	public List<String> getBoardTitleList(int pageNum) {
		List<String> boardList = dao.selectBoardTittle(pageNum);
		
		return boardList;
	}
	
	public void insertBoard(String tittle, String content, User user) {
		int result = dao.insertBoard(tittle, content, user);
	}
}