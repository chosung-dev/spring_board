package com.board.service;

import java.util.LinkedList;
import java.util.List;

import com.board.Board;
import com.board.Comment;
import com.board.dao.BoardDao;
import com.board.dao.CommentDao;
import com.user.User;

public class BoardService {
	BoardDao bdao;
	CommentDao cdao;
	
	public BoardService(BoardDao dao, CommentDao cdao) {
		this.bdao = dao;
		this.cdao = cdao;
	}
	
	public List<Board> getBoardTitleList(int pageNum) {
		List<Board> boardList = bdao.selectBoardTittle(pageNum);
		
		return boardList;
	}
	
	public void insertBoard(String tittle, String content, User user) {
		int result = bdao.insertBoard(tittle, content, user);
	}
	
	public Board getBoardInfo(String boardId) {
		Board board = bdao.getBoard(boardId);
		List<Comment> comment = cdao.getBoardComment(boardId);
		board.setComments(comment);
		
		return board;
	}
	
	public void insertBoardComment(String boardId, String content, String userId) {
		int result = cdao.insertContent(boardId, content, userId);
	}
	
}
